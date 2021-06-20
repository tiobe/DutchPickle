package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.RuleContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        final int commonGivens = numberOfCommonGivens();
        for (List<GherkinParser.StepContext> steps : allSteps) {
            for (int index = 0; index < commonGivens; index++) {
                addViolation(14, steps.get(index), "Step '" + getText(steps.get(index), tokens) + "' is the same Step as used in all other Scenarios, so it could be put in a Background");
            }
        }
    }

    private int numberOfCommonGivens() {
        // if there is no or only one scenario, there are no common steps
        if (allSteps == null || allSteps.size() <= 1) {
            return 0;
        }

        // take the first scenario as a candidate
        List<String> commonSteps = allSteps.get(0).stream().map(RuleContext::getText).collect(Collectors.toList());

        for (final List<GherkinParser.StepContext> steps : allSteps) {
            int index = 0;
            int realIndex = 0; // previous Given excluding Data Tables
            boolean isPreviousGiven = false;
            for (final GherkinParser.StepContext step : steps) {
                if (isGivenStep(step.stepItem())) {
                    realIndex = index;
                    isPreviousGiven = true;
                } else if (step.stepItem().datatable() != null) {
                    isPreviousGiven = false;
                } else {
                    // no givens found any more, then we have to stop
                    break;
                }

                if (index == commonSteps.size() || !step.getText().equals(commonSteps.get(index)) || containsParameter(step)) {
                    // the max is reached, there is a mismatch or there is a parameter found, then we have to stop
                    break;
                }
                index++;
            }

            index = isPreviousGiven ? index : realIndex;
            // the list is shorter than the candidate, then we have to cut off the candidate
            if (index < commonSteps.size()) {
                commonSteps = commonSteps.stream().limit(index).collect(Collectors.toList());
            }
        }
        return commonSteps.size();
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
