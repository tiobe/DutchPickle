package com.tiobe.Gherkin;

import com.tiobe.antlr.GherkinParser;

public class Rule5 {
    static void check(GherkinParser.InstructionContext ctx) {
        if (!App.RULES.contains("5")) {
            return;
        }

        // Rule Gherkin-WhenAfterGiven: if a "Given" is not immediately followed by "Then" then fire the rule
        if (ctx.stepInstruction() != null && (ctx.stepInstruction().scenario() != null || ctx.stepInstruction().scenarioOutline() != null)) {
            boolean givenFound = false;
            int lineNumber = 0;
            int columnNumber = 0;
            for (GherkinParser.StepContext step : ctx.step()) {
                GherkinParser.StepItemContext item = step.stepItem();
                if (item.given() != null) {
                    givenFound = true;
                    lineNumber = item.getStart().getLine();
                    columnNumber = item.getStart().getCharPositionInLine();
                } else if (item.and() != null || item.anystep() != null || item.but() != null || item.datatable() != null) {
                    // do nothing because this is just syntactic sugar
                } else if (givenFound && item.when() == null) {
                    new Violation(5, lineNumber, columnNumber);
                    givenFound = false;
                } else {
                    givenFound = false;
                }
            }
            if (givenFound) {
                new Violation(5, lineNumber, columnNumber);
            }
        }
    }
}
