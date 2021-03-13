package com.tiobe.Gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Violation {
    final private ArrayList<String> synopsis = new ArrayList<>(Arrays.asList(
            /*  1 */ "A Scenario Outline should have more than one Scenario",
            /*  2 */ "After a When a Then should follow",
            /*  3 */ "A Given should not follow a When or a Then",
            /*  4 */ "All data table headers should be used in the Scenario Outline",
            /*  5 */ "After a Given a When should follow",
            /*  6 */ "Subsequent Givens, Whens, and/or Thens are not allowed",
            /*  7 */ "Features files should not contain ToDo",
            /*  8 */ "Scenarios should be short (less than 100 steps)",
            /*  9 */ "There should be no empty cells in tables"
    ));

    Violation(int ruleID, ParserRuleContext ctx) {
        this(ruleID, ctx, "");
    }

    Violation(int ruleID, ParserRuleContext ctx, String extraMessage) {
        this(ruleID, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), extraMessage);
    }

    Violation(int ruleID, int lineNumber, int columnNumber) {
        this(ruleID, lineNumber, columnNumber, "");
    }
    Violation(int ruleID, int lineNumber, int columnNumber, String extraMessage) {
        System.out.println();
        System.out.println(App.FILENAME + "(" + lineNumber + ":" + columnNumber + "):");
        System.out.println("  Synopsis: " + synopsis.get(ruleID-1));
        System.out.println("  Rule ID: " + ruleID);
        if (!extraMessage.isEmpty()) {
            System.out.println("  " + extraMessage);
        }
    }
}
