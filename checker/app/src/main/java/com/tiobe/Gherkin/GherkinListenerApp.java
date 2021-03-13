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
    }
}

