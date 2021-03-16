package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Rule9 {
    static void check(GherkinParser.DatatableContext ctx) {
        if (!App.RULES.contains("9")) {
            return;
        }

        // Rule Gherkin-NoEmptyCell: There should not be empty cells in tables
        boolean violations = false;
        for (TerminalNode cell : ctx.DATATABLE()) {
            // last cell is always empty according to the parse tree, so that one should not be reported (i.e. the first occurrence is skipped)
            if (cell.getText().replaceAll("[|\\s]", "").isEmpty()) {
                if (violations) {
                    new Violation(9, ctx);
                }
                violations = true;
            }
        }
    }
}
