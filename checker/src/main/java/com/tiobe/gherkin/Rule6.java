package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;

import java.util.List;

public class Rule6 extends Rule {
    public Rule6(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Subsequent Givens, Whens, and/or Thens are not allowed";
    }

    public void check(final GherkinParser.InstructionContext ctx) {
        // Rule Gherkin-NoSubsequentGivenWhenThen: Subsequent Givens, Whens, and/or Thens are not allowed (use And or But)
        if (ctx.stepInstruction() != null && (ctx.stepInstruction().scenario() != null || ctx.stepInstruction().scenarioOutline() != null)) {
            boolean givenFound = false;
            boolean whenFound = false;
            boolean thenFound = false;
            for (GherkinParser.StepContext step : ctx.step()) {
                final GherkinParser.StepItemContext item = step.stepItem();
                if (item.given() != null) {
                    if (givenFound) {
                        addViolation(6, item, "Consecutive Given found");
                    }
                    givenFound = true;
                    whenFound = false;
                    thenFound = false;
                } else if (item.when() != null) {
                    if (whenFound) {
                        addViolation(6, item, "Consecutive When found");
                    }
                    whenFound = true;
                    givenFound = false;
                    thenFound = false;
                } else if (item.then() != null) {
                    if (thenFound) {
                        addViolation(6, item, "Consecutive Then found");
                    }
                    thenFound = true;
                    givenFound = false;
                    whenFound = false;
                }
            }
        }
    }
}

