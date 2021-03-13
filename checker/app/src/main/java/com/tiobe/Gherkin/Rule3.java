package com.tiobe.Gherkin;

import com.tiobe.antlr.GherkinParser;

public class Rule3 {
    static void check(GherkinParser.InstructionContext ctx) {
        if (!App.RULES.contains("3")) {
            return;
        }

        // Rule Gherkin-NoGivenAfterWhenThen: if a "Given" is after a "When" or "Then" then fire the rule
        if (ctx.stepInstruction() != null && (ctx.stepInstruction().scenario() != null || ctx.stepInstruction().scenarioOutline() != null)) {
            boolean whenOrThenFound = false;
            for (GherkinParser.StepContext step : ctx.step()) {
                GherkinParser.StepItemContext item = step.stepItem();
                if (item.when() != null || item.then() != null) {
                    whenOrThenFound = true;
                } else if (whenOrThenFound && item.given() != null) {
                    new Violation(3, item);
                }
            }
        }
    }
}
