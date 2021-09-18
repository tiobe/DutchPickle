package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class Rule16 extends Rule {
    public Rule16(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Don't use camelCasing nor PascalCasing";
    }

    public void check(final GherkinParser.InstructionDescriptionContext ctx, final BufferedTokenStream tokens) {
        if (containsCapital(ctx.text())) {
            addViolation(16, ctx, extraMessage(ctx.text()));
        }
    }

    public void check(final GherkinParser.StepDescriptionContext ctx, final BufferedTokenStream tokens) {
        if (containsCapital(ctx.text())) {
            addViolation(16, ctx, extraMessage(ctx.text()));
        }
    }

    public void check(final GherkinParser.DescriptionContext ctx, final BufferedTokenStream tokens) {
        if (containsCapital(ctx.text())) {
            addViolation(16, ctx, extraMessage(ctx.text()));
        }
    }

    private static boolean containsCapital(final GherkinParser.TextContext text) {
        return text != null ? containsCapital(text.getText()) : false;
    }

    private static boolean containsCapital(final String text) {
        return text.matches(".*\\w[A-Z].*");
    }

    private String extraMessage(final GherkinParser.TextContext node) {
        return "'" + node.getText() + "' contains a capital letter";
    }
}
