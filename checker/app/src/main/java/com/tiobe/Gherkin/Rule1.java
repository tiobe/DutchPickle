package com.tiobe.Gherkin;

import com.tiobe.antlr.GherkinParser;

public class Rule1 {
    static void check(GherkinParser.InstructionContext ctx) {
        if (!App.RULES.contains("1")) {
            return;
        }

        // Rule Gherkin-ScenarioOutlineShouldHaveMoreThanOneScenario: a Scenario Outline should contain more than one Scenario
        if (ctx.stepInstruction() != null && ctx.stepInstruction().scenarioOutline() != null) {
            int numberOfScenarios = 0;
            boolean examplesContext = false;

            for (GherkinParser.StepContext step : ctx.step()) {
                GherkinParser.StepItemContext item = step.stepItem();
                if (item.examples() != null) {
                    examplesContext = true;
                } else if (examplesContext && item.datatable() != null) {
                    numberOfScenarios++;
                } else if (examplesContext) {
                    // Data table is done, remove table header count
                    numberOfScenarios--;
                    examplesContext = false;
                }
            }

            // Examples is last of the Scenario
            if (examplesContext) {
                numberOfScenarios--;
            }

            if (numberOfScenarios == 1) {
                new Violation(1, ctx, "Scenario Outline contains only 1 Scenario");
            }
        }
    }
}
