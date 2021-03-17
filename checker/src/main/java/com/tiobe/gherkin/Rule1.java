package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;

import java.util.List;

public class Rule1 extends Rule {
    public Rule1(final List<Violation> violations) {
        super(violations);
    }

    @Override
    public String getSynopsis() {
        return "A Scenario Outline should have more than one Scenario";
    }

    public void check(final GherkinParser.InstructionContext ctx) {
        // Rule Gherkin-ScenarioOutlineShouldHaveMoreThanOneScenario: a Scenario Outline should contain more than one Scenario
        if (ctx.stepInstruction() != null && ctx.stepInstruction().scenarioOutline() != null) {
            int numberOfScenarios = 0;
            boolean examplesContext = false;

            for (GherkinParser.StepContext step : ctx.step()) {
                final GherkinParser.StepItemContext item = step.stepItem();
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
                addViolation(1, ctx, "Scenario Outline contains only 1 Scenario");
            }
        }
    }
}
