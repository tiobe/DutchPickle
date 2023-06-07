package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class Rule25 extends Rule {
    public Rule25(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Limit the maximum length of each Step";
    }

    public void check(final GherkinParser.StepContext ctx, final BufferedTokenStream tokens) {
        final int length = ctx.getStop().getCharPositionInLine() + ctx.getStop().getText().length();
        // exclude data tables from this check
        if (length > 200 && ctx.stepItem().datatable() == null) {
            addViolation(25, ctx, "Line is too long: " + length + " > 200 characters.");
        }
    }
}
