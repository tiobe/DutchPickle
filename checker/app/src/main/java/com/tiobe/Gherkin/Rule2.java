package com.tiobe.Gherkin;

import com.tiobe.antlr.GherkinParser;

public class Rule2 {
    static void check(GherkinParser.InstructionContext ctx) {
        if (!App.RULES.contains("2")) {
            return;
        }

        // Rule Gherkin-ThenAfterWhen: if a "When" is not immediately followed by "Then" then fire the rule
        if (ctx.stepInstruction() != null && (ctx.stepInstruction().scenario() != null || ctx.stepInstruction().scenarioOutline() != null)) {
            boolean whenFound = false;
            int lineNumber = 0;
            int columnNumber = 0;
            for (GherkinParser.StepContext step : ctx.step()) {
                GherkinParser.StepItemContext item = step.stepItem();
                if (item.when() != null) {
                    whenFound = true;
                    lineNumber = item.getStart().getLine();
                    columnNumber = item.getStart().getCharPositionInLine();
                } else if (item.and() != null || item.anystep() != null || item.but() != null || item.datatable() != null) {
                    // do nothing because this is just syntactic sugar
                } else if (whenFound && item.then() == null) {
                    new Violation(2, lineNumber, columnNumber);
                    whenFound = false;
                } else {
                    whenFound = false;
                }
            }
            if (whenFound) {
                new Violation(2, lineNumber, columnNumber);
            }
        }
    }
}
