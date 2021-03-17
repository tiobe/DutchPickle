package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class Rule9 extends Rule {
    public Rule9(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "There should be no empty cells in tables";
    }

    public void check(final GherkinParser.DatatableContext ctx) {
        // Rule Gherkin-NoEmptyCell: There should not be empty cells in tables
        boolean violations = false;
        for (TerminalNode cell : ctx.DATATABLE()) {
            // last cell is always empty according to the parse tree, so that one should not be reported (i.e. the first occurrence is skipped)
            if (cell.getText().replaceAll("[|\\s]", "").isEmpty()) {
                if (violations) {
                    addViolation(9, ctx);
                }
                violations = true;
            }
        }
    }
}
