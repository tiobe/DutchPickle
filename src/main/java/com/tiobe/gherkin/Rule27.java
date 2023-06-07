package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class Rule27 extends Rule {
    public Rule27(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Every Feature should have a description";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        if (ctx.feature() != null && ctx.instructionLine() == null ||
                ctx.instructionLine(0) == null ||
                ctx.instructionLine(0).instruction() == null ||
                ctx.instructionLine(0).instruction().instructionDescription() == null ||
                !ctx.instructionLine(0).instruction().instructionDescription().getText().matches("(.*)[a-zA-Z0-9](.*)")) {
            addViolation(27, ctx);
        }
    }
}
