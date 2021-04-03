package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

import java.util.List;

public class Rule17 extends Rule {
    public Rule17(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Tables should be outlined correctly";
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
        List<Integer> columns = new ArrayList<>();
        if (ctx.step() != null) {
            for (GherkinParser.StepContext step : ctx.step()) {
               if (step.stepItem() != null && step.stepItem().datatable() != null) {
                    final GherkinParser.DatatableContext datatable = step.stepItem().datatable();
                    if (columns == null) {
                        columns = getColumns(datatable);
                    } else {
                        if (!columns.equals(getColumns(datatable))) {
                            addViolation(17, datatable, "Cells not aligned correctly");
                        }
                    }
               } else {
                   columns = null;
               }
            }
        }
    }

    public void check(final GherkinParser.DatatableContext ctx, final BufferedTokenStream tokens) {
        final String cells = tokens.getText(ctx.start, ctx.stop);
        if (cells.matches(".*\\|\\S.*") || cells.matches(".*\\S\\|.*")) {
            addViolation(17, ctx, "Missing margin for cells");
        }
    }

    private List<Integer> getColumns(final GherkinParser.DatatableContext ctx) {
        final List<Integer> columns = new ArrayList<>();
        if (ctx.DATATABLE() != null) {
            for (TerminalNode node : ctx.DATATABLE()) {
                if (node.getText().matches("^\\|.*")) {
                    columns.add(node.getSymbol().getCharPositionInLine());
                }
            }
        }
        return columns;
    }
}
