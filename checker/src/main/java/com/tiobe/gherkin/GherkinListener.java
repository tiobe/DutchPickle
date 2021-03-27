package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinBaseListener;
import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class GherkinListener extends GherkinBaseListener {
    private final List<Rule> rules;
    private BufferedTokenStream tokens;

    public GherkinListener(final BufferedTokenStream tokens, final List<Rule> rules) {
        this.rules = rules;
        for (final Rule rule : this.rules) {
            rule.check(tokens);
        }
        this.tokens = tokens;
    }

    @Override public void enterMain(final GherkinParser.MainContext ctx) {
        for (final Rule rule : rules) {
            rule.check(ctx, tokens);
        }
    }

    @Override public void enterInstructionLine(final GherkinParser.InstructionLineContext ctx) {
        for (final Rule rule : rules) {
            rule.check(ctx, tokens);
        }
    }

    @Override public void enterInstruction(final GherkinParser.InstructionContext ctx) {
        for (final Rule rule : rules) {
            rule.check(ctx, tokens);
        }
    }

    @Override public void enterDatatable(final GherkinParser.DatatableContext ctx) {
        for (final Rule rule : rules) {
            rule.check(ctx, tokens);
        }
    }

    @Override public void enterStep(final GherkinParser.StepContext ctx) {
        for (final Rule rule : rules) {
            rule.check(ctx, tokens);
        }
    }

    @Override public void enterInstructionDescription(final GherkinParser.InstructionDescriptionContext ctx) {
        for (final Rule rule : rules) {
            rule.check(ctx, tokens);
        }
    }

    @Override public void enterStepDescription(final GherkinParser.StepDescriptionContext ctx) {
        for (final Rule rule : rules) {
            rule.check(ctx, tokens);
        }
    }

    @Override public void enterDescription(final GherkinParser.DescriptionContext ctx) {
        for (final Rule rule : rules) {
            rule.check(ctx, tokens);
        }
    }
}

