package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinBaseListener;
import com.tiobe.antlr.GherkinLexer;
import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class GherkinListenerApp extends GherkinBaseListener {

    public GherkinListenerApp(BufferedTokenStream tokens) {
        Rule7.check(tokens);
    }

    @Override public void exitInstruction(GherkinParser.InstructionContext ctx) {
        Rule1.check(ctx);
        Rule2.check(ctx);
        Rule3.check(ctx);
        Rule4.check(ctx);
        Rule5.check(ctx);
        Rule6.check(ctx);
        Rule8.check(ctx);
    }

    @Override public void enterDatatable(GherkinParser.DatatableContext ctx) {
        Rule9.check(ctx);
    }

    @Override public void enterInstructionDescription(GherkinParser.InstructionDescriptionContext ctx) {
        Rule7.check(ctx);
    }

    @Override public void enterStepDescription(GherkinParser.StepDescriptionContext ctx) {
        Rule7.check(ctx);
    }

    @Override public void enterDescription(GherkinParser.DescriptionContext ctx) {
        Rule7.check(ctx);
    }
}

