package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.ArrayList;
import java.util.List;

public class Rule21 extends Rule {
    public Rule21(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Scenario outline should not contain multiple instances of same Scenarios";
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
        if (!ctx.step().isEmpty()) {
            final List<List<String>> rows = new ArrayList<>();
            for (final GherkinParser.StepContext step : ctx.step()) {
                final GherkinParser.DatatableContext datatable = step.stepItem().datatable();
                if (datatable != null) {
                    final List<String> cells = Utils.getCells(datatable);
                    for (final List<String> row : rows) {
                        if (row.equals(cells)) {
                            addViolation(21, datatable);
                            break; // if 3 rows are equal, you only want to print the violation once, not twice
                        }
                    }
                    rows.add(cells);
                } else { // not a datatable
                    rows.clear();
                }
            }
        }
    }
}
