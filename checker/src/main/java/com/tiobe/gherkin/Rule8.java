package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;

import java.util.List;

public class Rule8 extends Rule {
    public Rule8(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Scenarios should be short (less than 100 steps)";
    }

    public void check(final GherkinParser.InstructionContext ctx) {
        // Rule Gherkin-ScenariosShouldNotBeLong: Scenario Outlines may only contain 100 steps (excluding datatables)
        if (ctx.stepInstruction() != null && (ctx.stepInstruction().scenario() != null || ctx.stepInstruction().scenarioOutline() != null)) {
            int steps = 0;
            for (GherkinParser.StepContext step : ctx.step()) {
                final GherkinParser.StepItemContext item = step.stepItem();
                if (item.datatable() == null) {
                    steps++;
                }
            }
            if (steps > 100) {
                addViolation(8, ctx, "This Scenario Outline contains " + steps + " steps");
            }
        }
    }
}
