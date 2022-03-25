package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class Rule12 extends Rule {
    public Rule12(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "A Feature is not allowed to start with comments";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        final List<Token> commentBeforeTag = new ArrayList<>(); // we should also check whether there is a comment before the tag
        final List<String> allTags = new ArrayList<>(); // we should also check whether there is an existing tag used at the start of a comment

        if (ctx.STARTCOMMENT() != null) {
            createViolation(ctx.STARTCOMMENT().getSymbol(), null);
        }
        if (!ctx.feature().isEmpty()) {
            boolean ignore = false;
            int previousTagIndex = 0;
            List<String> tags;
            for (final GherkinParser.TaglineContext tag : ctx.feature().tagline()) {
                tags = Utils.getTags(tag);
                allTags.addAll(tags);
                if (!ignore && previousTagIndex != 0) {
                    final List<Token> commentTokens = Utils.getCommentTokens(previousTagIndex, Utils.getEndIndex(tag.TAG()), tokens);
                    createViolation(commentBeforeTag, commentTokens, allTags);
                }
                ignore = tags.get(tags.size() - 1).equals("ignore");
                previousTagIndex = tag.getStart().getTokenIndex();
            }
            // also check the code between the last tag and the feature
            if (!ignore && previousTagIndex != 0) {
                final List<Token> commentTokens = Utils.getCommentTokens(previousTagIndex, Utils.getEndIndex(ctx), tokens);
                createViolation(commentBeforeTag, commentTokens, allTags);
            }
        }
    }

    private void createViolation(final List<Token> commentBeforeTag, final List<Token> commentTokens, final List<String> allTags) {
        commentBeforeTag.addAll(commentTokens);
        if (!commentBeforeTag.isEmpty()) {
            commentBeforeTag.forEach(token -> createViolation(token, allTags));
        }
        commentBeforeTag.clear();
    }

    private void createViolation(final Token token, final List<String> tags) {
        final String text = token.getText();
        // check whether it concerns a comment, (?s) is needed to match \n for multiline comments,
        // ^(\r?\n)? is needed to match both normal comments (starting with newline) and the start comment (not starting with newline)
        if (text.matches("(?s)(^(\\r?\\n)?\\s*#.*)|(^\\s*\"\"\".*)|(^\\s*```.*)") &&
                !text.toLowerCase().matches("(\\r?\\n)?.*copyright.*") &&
                !text.toLowerCase().matches("(\\r?\\n)?.*\\(c\\).*") &&
                !Utils.startsWithTag(token.getText(), tags) &&
                !token.getText().matches("^(\\r?\\n)?\\s*#//TICS.*$")) { // don't report TiCS suppressions
            addViolation(12, Utils.getCommentLineNumber(token), token.getCharPositionInLine());
        }
    }
}
