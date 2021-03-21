package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.List;
import java.util.regex.Pattern;

public class Rule12 extends Rule {
    public Rule12(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "A Feature is not allowed to start with comments";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        final int begin = ctx.getStart().getTokenIndex();
        final int end = ctx.feature().FEATURE().getSymbol().getTokenIndex();
        for (int i = begin; i <= end; i++) {
            final List<Token> hiddenTokens = tokens.getHiddenTokensToLeft(i);
            if (hiddenTokens != null) {
                for (Token token : hiddenTokens) {
                    final String text = token.getText();
                    // check whether it concerns a comment, (?s) is needed to match \n for multiline comments
                    if (Pattern.matches("(?s)(^\\s*#.*)|(^\\s*\"\"\".*)|(^\\s*```.*)", text)) {
                        addViolation(12, token.getLine(), token.getCharPositionInLine());
                    }
                }
            }
        }
    }
}
