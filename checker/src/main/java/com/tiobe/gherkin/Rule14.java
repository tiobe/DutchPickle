package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.ArrayList;
import java.util.List;

public class Rule14 extends Rule {
    public Rule14(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Repeating setup Steps of every Scenario should be part of the Background";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        // first collect all Steps
        for (GherkinParser.InstructionLineContext instructionLine : ctx.instructionLine()) {
            final GherkinParser.InstructionContext instruction = instructionLine.instruction();
            if (instruction != null && instruction.stepInstruction() != null
                    && (instruction.stepInstruction().scenario() != null || instruction.stepInstruction().scenarioOutline() != null)) {
                commonSteps.add(instruction.step());
            }
        }

        // then determine the number of common prefixes and loop over the Steps to trigger a violation
        if (commonSteps.size() > 1) {
            for (List<GherkinParser.StepContext> steps : commonSteps) {
                for (int index = 0; index < numberOfCommonPrefixes(); index++) {
                    addViolation(14, steps.get(index), "Step '" + getText(steps.get(index), tokens) + "' is the same Step as used in all other Scenarios, so it could be put in a Background");
                }
            }
        }
    }

    private int numberOfCommonPrefixes() {
        for (int numberOfCommonPrefixes = 0; ; numberOfCommonPrefixes++) {
            String commonStep = "";
            for (List<GherkinParser.StepContext> steps : commonSteps) {

                // running out of Steps
                if (steps.size() == numberOfCommonPrefixes) {
                    return numberOfCommonPrefixes;

                // first Scenario
                } else if (commonStep.isEmpty()) {
                    commonStep = steps.get(numberOfCommonPrefixes).getText();

                // no common prefix
                } else if (!steps.get(numberOfCommonPrefixes).getText().equals(commonStep)) {
                    return numberOfCommonPrefixes;
                }
            }
        }
    }

    private String getText(final GherkinParser.StepContext step, final BufferedTokenStream tokens) {
        return tokens.getText(step.start, step.stop);
    }

    // repeatedSteps keeps track of the list of common Steps *per Scenario*
    private final List<List<GherkinParser.StepContext>> commonSteps = new ArrayList<>();
}
