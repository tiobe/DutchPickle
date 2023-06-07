package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class Rule20 extends Rule {
    public Rule20(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Backgrounds should only contain Given steps and no parameters";
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
        if (ctx.stepInstruction() != null && ctx.stepInstruction().background() != null) {
            for (final GherkinParser.StepContext step : ctx.step()) {
                if (!Utils.isGivenStep(step.stepItem()) && step.stepItem().datatable() == null) {
                    addViolation(20, step, "Background contains a step that is not a Given step");
                }
                if (Utils.containsParameter(step)) {
                    addViolation(20, step, "Background contains a parameter");
                }
            }
        }
    }
}
