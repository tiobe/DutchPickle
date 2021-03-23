package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinLexer;
import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class Rule7 extends Rule {
    public Rule7(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Features files should not contain ToDo";
    }

    public void check(final GherkinParser.InstructionDescriptionContext ctx, final BufferedTokenStream tokens) {
        // Rule Gherkin-NoToDo: Features files should not contain ToDo
        if (isToDo(ctx.TEXT())) {
            addViolation(7, ctx);
        }
    }

    public void check(final GherkinParser.StepDescriptionContext ctx, final BufferedTokenStream tokens) {
        // Rule Gherkin-NoToDo: Features files should not contain ToDo
        if (isToDo(ctx.TEXT())) {
            addViolation(7, ctx);
        }
    }

    public void check(final GherkinParser.DescriptionContext ctx, final BufferedTokenStream tokens) {
        // Rule Gherkin-NoToDo: Features files should not contain ToDo
        if (isToDo(ctx.TEXT())) {
            addViolation(7, ctx);
        }
    }

    private static boolean isToDo(final TerminalNode text) {
        return text != null ? text.getText().trim().equalsIgnoreCase("todo") : false;
    }

    public void check(final BufferedTokenStream tokens) {
        for (Token token : tokens.getTokens()) {
            if (token.getType() == GherkinLexer.COMMENT || token.getType() == GherkinLexer.DOCSTRING1 || token.getType() == GherkinLexer.DOCSTRING2) {
                for (String part : token.getText().split("\\W")) {
                    if (part.equalsIgnoreCase("todo")) {
                        addViolation(7, token.getLine(), token.getCharPositionInLine());
                    }
                }
            }
        }
    }
}
