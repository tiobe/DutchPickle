package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class Rule3 extends Rule {
    public Rule3(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "A Given should not follow a When or a Then";
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
        if (ctx.stepInstruction() != null && (ctx.stepInstruction().scenario() != null || ctx.stepInstruction().scenarioOutline() != null)) {
            boolean whenOrThenFound = false;
            for (GherkinParser.StepContext step : ctx.step()) {
                final GherkinParser.StepItemContext item = step.stepItem();
                if (item.when() != null || item.then() != null) {
                    whenOrThenFound = true;
                } else if (whenOrThenFound && item.given() != null) {
                    addViolation(3, item);
                }
            }
        }
    }
}
