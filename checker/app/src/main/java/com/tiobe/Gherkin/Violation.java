package com.tiobe.Gherkin;

import java.util.ArrayList;
import java.util.Arrays;

public class Violation {
    Violation(int ruleID, int lineNumber, int columnNumber, String extraMessage) {
        System.out.println();
        System.out.println(App.FILENAME + "(" + lineNumber + ":" + columnNumber + "):");
        System.out.println("  Synopsis: " + synopsis.get(ruleID-1));
        System.out.println("  Rule ID: " + ruleID);
        if (!extraMessage.isEmpty()) {
            System.out.println("  " + extraMessage);
        }
    }

    final private ArrayList<String> synopsis = new ArrayList<>(Arrays.asList(
            /*  1 */ "A Scenario Outline should have more than one Scenario",
            /*  2 */ "After a When a Then should follow",
            /*  3 */ "A Given should not follow a When or a Then",
            /*  4 */ "All data table headers should be used in the Scenario Outline",
            /*  5 */ "After a Given a When should follow"
    ));
}
