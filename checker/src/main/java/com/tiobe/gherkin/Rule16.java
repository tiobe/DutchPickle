package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class Rule16 extends Rule {
    public Rule16(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Don't use camelCasing nor PascalCasing";
    }

    public void check(final GherkinParser.InstructionDescriptionContext ctx, final BufferedTokenStream tokens) {
        if (containsCapital(ctx.TEXT())) {
            addViolation(16, ctx, extraMessage(ctx.TEXT()));
        }
    }

    public void check(final GherkinParser.StepDescriptionContext ctx, final BufferedTokenStream tokens) {
        if (containsCapital(ctx.TEXT())) {
            addViolation(16, ctx, extraMessage(ctx.TEXT()));
        }
    }

    public void check(final GherkinParser.DescriptionContext ctx, final BufferedTokenStream tokens) {
        if (containsCapital(ctx.TEXT())) {
            addViolation(16, ctx, extraMessage(ctx.TEXT()));
        }
    }

    private static boolean containsCapital(final TerminalNode text) {
        return text != null ? containsCapital(text.getText()) : false;
    }

    private static boolean containsCapital(final String text) {
        return text.matches(".*\\w[A-Z].*");
    }

    private String extraMessage(final TerminalNode node) {
        return "'" + node.getText() + "' contains a capital letter";
    }
}
