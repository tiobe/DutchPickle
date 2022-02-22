package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Rule12 extends Rule {
    public Rule12(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "A Feature is not allowed to start with comments";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        if (ctx.STARTCOMMENT() != null) {
            createViolation(ctx.STARTCOMMENT().getSymbol());
        }
        Utils.getHiddenTokens(ctx.getStart().getTokenIndex(), Utils.getEndIndex(ctx), tokens).forEach(this::createViolation);
    }

    private void createViolation(final Token token) {
        final String text = token.getText();
        // check whether it concerns a comment, (?s) is needed to match \n for multiline comments,
        // ^(\r?\n)? is needed to match both normal comments (starting with newline) and the start comment (not starting with newline)
        if (text.matches("(?s)(^(\\r?\\n)?\\s*#.*)|(^\\s*\"\"\".*)|(^\\s*```.*)") &&
                !text.toLowerCase().matches("(\\r?\\n)?.*copyright.*") &&
                !text.toLowerCase().matches("(\\r?\\n)?.*\\(c\\).*") &&
                !token.getText().matches("^(\\r?\\n)?\\s*#//TICS.*$")) { // don't report TiCS suppressions
            addViolation(12, Utils.getCommentLineNumber(token), token.getCharPositionInLine());
        }
    }
}
