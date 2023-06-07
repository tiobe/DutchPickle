package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class Rule23 extends Rule {
    public Rule23(final List<Violation> violations) {
            super(violations);
        }

    public String getSynopsis() {
        return "Backgrounds should only contain Given steps";
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
        if (ctx != null && ctx.stepInstruction() != null && ctx.stepInstruction().background() != null) {  // then check whether every Scenario has a prefix that corresponds to a Background
            for (GherkinParser.StepContext step : ctx.step()) {
                if (step.stepItem() != null && !(Utils.isGivenStep(step.stepItem())) && step.stepItem().datatable() == null) {
                    addViolation(23, step, "The Step  '" + getText(step, tokens) + "' should not be part of the Background");
                }
            }
        }
    }

    private String getText(final GherkinParser.StepContext step, final BufferedTokenStream tokens) {
        return tokens.getText(step.start, step.stop);
    }
}
