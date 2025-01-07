package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.List;
import java.util.stream.Collectors;

public class Rule28 extends Rule {
    public Rule28(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Do not allow tabs";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        for (Token token : tokens.getTokens()) {
            // tabs in doc strings are allowed
            if (!token.getText().startsWith("\"\"\"") && !token.getText().startsWith("```")) {
                List<Integer> newlines = Utils.indexesOf(token.getText(), "\n");
                for (int index : Utils.indexesOf(token.getText(), "\t")) {
                    int prevNewlines = newlines.stream().filter(i -> i < index).collect(Collectors.toList()).size();
                    int lineNumber = token.getLine() + prevNewlines;
                    addViolation(28, lineNumber, token.getCharPositionInLine());
                }
            }
        }
    }
}
