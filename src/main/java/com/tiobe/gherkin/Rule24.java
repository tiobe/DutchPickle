package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Rule24 extends Rule {
    public Rule24(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Every Feature should contain a copyright comment";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        if (ctx.STARTCOMMENT() != null) {
            check(ctx.STARTCOMMENT().getSymbol());
        }
        Utils.getHiddenTokens(ctx.getStart().getTokenIndex(), Utils.getEndIndex(ctx), tokens).forEach(this::check);
        if (!containsCopyright) {
            addViolation(24, ctx, "There is no copyright in this file");
        }
    }

    private void check(final Token token) {
        final String text = token.getText();
        // check whether it concerns a comment, (?s) is needed to match \n for multiline comments,
        // ^(\r?\n)? is needed to match both normal comments (starting with newline) and the start comment (not starting with newline)
        if (text.toLowerCase().matches("(\\r?\\n)?.*copyright.*") || text.toLowerCase().matches("(\\r?\\n)?.*\\(c\\).*")) {
            containsCopyright = true;
        }
    }

    private boolean containsCopyright = false;
}
