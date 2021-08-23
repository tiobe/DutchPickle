package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.ArrayList;
import java.util.List;

public class Rule22 extends Rule {
    public Rule22(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "A variable should have more than 1 different value in the Example tables";
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
        if (!ctx.step().isEmpty()) {
            final List<List<String>> rows = new ArrayList<>();
            GherkinParser.DatatableContext dbContext = null; // needed for line number info
            for (final GherkinParser.StepContext step : ctx.step()) {
                final GherkinParser.DatatableContext datatable = step.stepItem().datatable();
                if (datatable != null) {
                    rows.add(Utils.getCells(datatable));
                    if (dbContext == null) {
                        dbContext = datatable;
                    }
                }
            }
            if (!rows.isEmpty()) {
                checkIdenticalColumns(rows, dbContext);
            }
        }
    }

    private void checkIdenticalColumns(final List<List<String>> rows, final GherkinParser.DatatableContext datatable) {
        for (int index = 0; index < getNumberOfColumns(rows); index++) {
            final int finalIndex = index;
            // skip(1) is needed to ignore column headers
            if (rows.stream().skip(1).map(x -> x.get(finalIndex)).distinct().count() == 1 && !rows.get(0).get(index).isEmpty()) {
                addViolation(22, datatable, "Column '" + rows.get(0).get(index) + "' contains the same value: '" + rows.get(1).get(index) + "'");
            }
        }
    }

    private int getNumberOfColumns(final List<List<String>> rows) {
        // take the minimum number of columns, usually all rows have same number of columns but just in case
        int columns = 0;
        try {
            columns = rows.stream().map(List::size).reduce(Integer::min).orElseThrow(Exception::new);
        } catch (final Exception e) {
            e.printStackTrace();
        }

        return columns;
    }
}
