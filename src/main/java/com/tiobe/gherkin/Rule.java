package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public abstract class Rule {
    private final List<Violation> violations;

    public Rule(final List<Violation> violations) {
        this.violations = violations;
    }

    public String getRuleId() {
        return this.getClass().getSimpleName();
    }

    public abstract String getSynopsis();

    protected void addViolation(final int ruleID, final ParserRuleContext ctx) {
        addViolation(new Violation(this, ctx));
    }

    protected void addViolation(final int ruleID, final ParserRuleContext ctx, final String extraMessage) {
        addViolation(new Violation(this, ctx, extraMessage));
    }

    protected void addViolation(final int ruleID, final TerminalNode node, final String extraMessage) {
        addViolation(new Violation(this, node, extraMessage));
    }

    protected void addViolation(final int ruleID, final int lineNumber, final int columnNumber) {
        addViolation(new Violation(this, lineNumber, columnNumber));
    }

    protected void addViolation(final int ruleID, final int lineNumber, final int columnNumber, final String extraMessage) {
        addViolation(new Violation(this, lineNumber, columnNumber, extraMessage));
    }

    protected void addViolation(final Violation violation) {
        violations.add(violation);
    }


    public void check(final BufferedTokenStream tokens) {
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
    }

    public void check(final GherkinParser.InstructionLineContext ctx, final BufferedTokenStream tokens) {
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
    }

    public void check(final GherkinParser.DatatableContext ctx, final BufferedTokenStream tokens) {
    }

    public void check(final GherkinParser.StepContext ctx, final BufferedTokenStream tokens) {
    }

    public void check(final GherkinParser.InstructionDescriptionContext ctx, final BufferedTokenStream tokens) {
    }

    public void check(final GherkinParser.StepDescriptionContext ctx, final BufferedTokenStream tokens) {
    }

    public void check(final GherkinParser.DescriptionContext ctx, final BufferedTokenStream tokens) {
    }

}
