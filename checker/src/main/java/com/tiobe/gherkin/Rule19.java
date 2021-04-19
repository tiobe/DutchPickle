package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinLexer;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Rule19 extends Rule {
    public Rule19(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "A comment should not start with a Step keyword";
    }

    public void check(final BufferedTokenStream tokens) {
        for (Token token : tokens.getTokens()) {
            if (token.getType() == GherkinLexer.COMMENT || token.getType() == GherkinLexer.DOCSTRING1 || token.getType() == GherkinLexer.DOCSTRING2) {
                if (token.getText().matches("^#\\s*(Given|When|Then|And|But|\\*).*")
                        || token.getText().matches("(?s)```\\s*(Given|When|Then|And|But|\\*).*")
                        || token.getText().matches("(?s)\"\"\"\\s*(Given|When|Then|And|But|\\*).*")) {
                    addViolation(19, token.getLine(), token.getCharPositionInLine());
                }
            }
        }
    }
}
