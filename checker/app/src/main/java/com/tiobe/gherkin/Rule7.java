package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinLexer;
import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Rule7 {
    static void check(GherkinParser.InstructionDescriptionContext ctx) {
        if (!App.RULES.contains("7")) {
            return;
        }

        // Rule Gherkin-NoToDo: Features files should not contain ToDo
        if (isToDo(ctx.TEXT())) {
            new Violation(7, ctx);
        }
    }
    static void check(GherkinParser.StepDescriptionContext ctx) {
        if (!App.RULES.contains("7")) {
            return;
        }

        // Rule Gherkin-NoToDo: Features files should not contain ToDo
        if (isToDo(ctx.TEXT())) {
            new Violation(7, ctx);
        }
    }
    static void check(GherkinParser.DescriptionContext ctx) {
        if (!App.RULES.contains("7")) {
            return;
        }

        // Rule Gherkin-NoToDo: Features files should not contain ToDo
        if (isToDo(ctx.TEXT())) {
            new Violation(7, ctx);
        }
    }

    private static boolean isToDo(TerminalNode text) {
        return text != null ? text.getText().trim().equalsIgnoreCase("todo") : false;
    }

    static void check(BufferedTokenStream tokens) {
        if (!App.RULES.contains("7")) {
            return;
        }

        for (Token token : tokens.getTokens()) {
            if (token.getType() == GherkinLexer.COMMENT || token.getType() == GherkinLexer.DOCSTRING1 || token.getType() == GherkinLexer.DOCSTRING2) {
                for (String part : token.getText().split("\\s")) {
                    if (part.equalsIgnoreCase("todo")) {
                        new Violation(7, token.getLine(), token.getCharPositionInLine());
                    }
                }
            }
        }
    }


}
