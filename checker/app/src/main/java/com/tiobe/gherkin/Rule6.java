package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;

public class Rule6 {
    static void check(GherkinParser.InstructionContext ctx) {
        if (!App.RULES.contains("6")) {
            return;
        }

        // Rule Gherkin-NoSubsequentGivenWhenThen: Subsequent Givens, Whens, and/or Thens are not allowed (use And or But)
        if (ctx.stepInstruction() != null && (ctx.stepInstruction().scenario() != null || ctx.stepInstruction().scenarioOutline() != null)) {
            boolean givenFound = false;
            boolean whenFound = false;
            boolean thenFound = false;
            for (GherkinParser.StepContext step : ctx.step()) {
                GherkinParser.StepItemContext item = step.stepItem();
                if (item.given() != null) {
                    if (givenFound) {
                        new Violation(6, item, "Consecutive Given found");
                    }
                    givenFound = true;
                    whenFound = false;
                    thenFound = false;
                } else if (item.when() != null) {
                    if (whenFound) {
                        new Violation(6, item, "Consecutive When found");
                    }
                    whenFound = true;
                    givenFound = false;
                    thenFound = false;
                } else if (item.then() != null) {
                    if (thenFound) {
                        new Violation(6, item, "Consecutive Then found");
                    }
                    thenFound = true;
                    givenFound = false;
                    whenFound = false;
                }
            }
        }
    }
}

