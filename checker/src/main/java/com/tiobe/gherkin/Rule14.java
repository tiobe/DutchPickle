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
                allSteps.add(instruction.step());
            }
        }

        // then determine the number of common prefixes and loop over the Steps to trigger a violation
        if (allSteps.size() > 1) {
            for (List<GherkinParser.StepContext> steps : allSteps) {
                for (int index = 0; index < numberOfCommonGivens(); index++) {
                    addViolation(14, steps.get(index), "Step '" + getText(steps.get(index), tokens) + "' is the same Step as used in all other Scenarios, so it could be put in a Background");
                }
            }
        }
    }

    private int numberOfCommonGivens() {
        for (int numberOfCommonGivens = 0; ; numberOfCommonGivens++) {
            String commonStep = "";
            for (final List<GherkinParser.StepContext> steps : allSteps) {
                final GherkinParser.StepContext currentStep = steps.get(numberOfCommonGivens);

                // running out of Given steps without parameters
                if (steps.size() == numberOfCommonGivens || !isGivenStep(currentStep.stepItem()) || containsParameter(currentStep)) {
                    return numberOfCommonGivens;

                // first Scenario
                } else if (commonStep.isEmpty()) {
                    commonStep = currentStep.getText();

                // no common prefix
                } else if (!currentStep.getText().equals(commonStep)) {
                    return numberOfCommonGivens;
                }
            }
        }
    }

    private boolean isGivenStep(final GherkinParser.StepItemContext stepItem) {
        return stepItem.and() != null || stepItem.anystep() != null || stepItem.but() != null || stepItem.given() != null;
    }

    private boolean containsParameter(final GherkinParser.StepContext step) {
        return step.description().stream().anyMatch(x -> x.PARAMETER() != null);
    }

    private String getText(final GherkinParser.StepContext step, final BufferedTokenStream tokens) {
        return tokens.getText(step.start, step.stop);
    }

    // allSteps contains the list of Steps *per Scenario*
    private final List<List<GherkinParser.StepContext>> allSteps = new ArrayList<>();
}
