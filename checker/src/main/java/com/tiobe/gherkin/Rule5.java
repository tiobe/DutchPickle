package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;

import java.util.List;

public class Rule5 extends Rule {
    public Rule5(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "After a Given a When should follow";
    }

    public void check(final GherkinParser.InstructionContext ctx) {
        // Rule Gherkin-WhenAfterGiven: if a "Given" is not immediately followed by "Then" then fire the rule
        if (ctx.stepInstruction() != null && (ctx.stepInstruction().scenario() != null || ctx.stepInstruction().scenarioOutline() != null)) {
            boolean givenFound = false;
            int lineNumber = 0;
            int columnNumber = 0;
            for (GherkinParser.StepContext step : ctx.step()) {
                final GherkinParser.StepItemContext item = step.stepItem();
                if (item.given() != null) {
                    givenFound = true;
                    lineNumber = item.getStart().getLine();
                    columnNumber = item.getStart().getCharPositionInLine();
                } else if (item.and() != null || item.anystep() != null || item.but() != null || item.datatable() != null) {
                    // do nothing because this is just syntactic sugar
                } else if (givenFound && item.when() == null) {
                    addViolation(5, lineNumber, columnNumber);
                    givenFound = false;
                } else {
                    givenFound = false;
                }
            }
            if (givenFound) {
                addViolation(5, lineNumber, columnNumber);
            }
        }
    }
}
