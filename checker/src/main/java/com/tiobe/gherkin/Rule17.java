package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
/*import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
 */
import java.util.List;

public class Rule17 extends Rule {
    public Rule17(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Tables should be outlined correctly";
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
/*        boolean datatable = false;
        final List<Integer> columns = new ArrayList<>();
        if (ctx.step() != null) {
            for (GherkinParser.StepContext step : ctx.step()) {
               if (step.stepItem() != null && step.stepItem().datatable() != null && !datatable) {
                    datatable = true;
                    for (Integer column : getColumns(step.stepItem().datatable(), tokens)) {
                        System.out.println("PAUL column = " + column);
                    }
               } else {
                   datatable = false;
               }
            }
        } */
    }
/*
    private List<Integer> getColumns(final GherkinParser.DatatableContext ctx, final BufferedTokenStream tokens) {
        final List<Integer> columns = new ArrayList<>();
        if (ctx.DATATABLE() != null) {
            for (TerminalNode datatable : ctx.DATATABLE()) {
                final List<Token> hiddenTokens = tokens.getHiddenTokensToLeft(datatable.getSymbol().getStartIndex());
                if (hiddenTokens != null) {
                    for (Token token : hiddenTokens) {
                        if (token.getText().equals("|")) {
                            columns.add(token.getCharPositionInLine());
                        }
                    }
                }
            }
        }
        return columns;
    }
 */

}
