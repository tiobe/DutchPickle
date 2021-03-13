package com.tiobe.Gherkin;

import com.tiobe.antlr.GherkinBaseListener;
import com.tiobe.antlr.GherkinParser;

public class GherkinListenerApp extends GherkinBaseListener {
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

