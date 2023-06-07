package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class Rule2 extends Rule {
    public Rule2(final List<Violation> violations) {
        super(violations);
    }

    @Override
    public String getSynopsis() {
        return "After a When a Then should follow";
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
        if (ctx.stepInstruction() != null && (ctx.stepInstruction().scenario() != null || ctx.stepInstruction().scenarioOutline() != null)) {
            boolean whenFound = false;
            int lineNumber = 0;
            int columnNumber = 0;
            for (GherkinParser.StepContext step : ctx.step()) {
                final GherkinParser.StepItemContext item = step.stepItem();
                if (item.when() != null) {
                    whenFound = true;
                    lineNumber = item.getStart().getLine();
                    columnNumber = item.getStart().getCharPositionInLine();
                } else if (item.and() != null || item.anystep() != null || item.but() != null || item.datatable() != null) {
                    // do nothing because this is just syntactic sugar
                } else if (whenFound && item.then() == null) {
                    addViolation(2, lineNumber, columnNumber);
                    whenFound = false;
                } else {
                    whenFound = false;
                }
            }
            if (whenFound) {
                addViolation(2, lineNumber, columnNumber);
            }
        }
    }
}
