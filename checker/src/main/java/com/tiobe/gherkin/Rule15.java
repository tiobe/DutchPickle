package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class Rule15 extends Rule {
    public Rule15(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Don't use punctuation in Steps";
    }

    public void check(final GherkinParser.StepContext ctx, final BufferedTokenStream tokens) {
        if (ctx.description() != null) {
            for (GherkinParser.DescriptionContext description : ctx.description()) {
                if (description.getText().matches(".*[.,].*")) {
                    addViolation(15, description, "Step Description '" + description.getText() + "' contains a punctuation character");
                }
            }
        }
        if (ctx.stepItem() != null && ctx.stepItem().datatable() != null && ctx.stepItem().datatable().DATATABLE() != null) {
            for (TerminalNode node : ctx.stepItem().datatable().DATATABLE()) {
                if (node.getText().matches(".*[.,].*")) {
                    addViolation(15, node, "Datatable cell '" + node.getText() + "' contains a punctuation character");
                }
            }
        }
    }
}
