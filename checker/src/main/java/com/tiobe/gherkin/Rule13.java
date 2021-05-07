package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.ArrayList;
import java.util.List;

public class Rule13 extends Rule {
    public Rule13(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Don't repeat steps in Scenarios that are also part of the Background";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        // first collect all Background Steps in a Feature
        final List<List<GherkinParser.StepContext>> backgroundSteps = collectAllBackGroundSteps(ctx);
        // then check whether every Scenario has a prefix that corresponds to a Background
        for (GherkinParser.InstructionLineContext instructionLine : ctx.instructionLine()) {
            final GherkinParser.InstructionContext instruction = instructionLine.instruction();
            if (instruction != null && instruction.stepInstruction() != null && instruction.stepInstruction().scenario() != null) {
                for (List<GherkinParser.StepContext> bSteps : backgroundSteps) {
                    int index = 0;
                    for (GherkinParser.StepContext bStep : bSteps) {
                        if (index < instruction.step().size() && instruction.step().get(index).getText().equals(bStep.getText())) {
                            index++;
                        } else {
                            break; // nothing to do any more because there is no common prefix
                        }
                    }
                    if (index == bSteps.size()) {
                        for (GherkinParser.StepContext step : instruction.step().subList(0, index)) {
                            addViolation(13, step, "The Step '" + getText(step, tokens) + "' is already executed by the Background");
                        }
                    }
                }
            }
        }
    }

    private List<List<GherkinParser.StepContext>> collectAllBackGroundSteps(final GherkinParser.MainContext ctx) {
        final List<List<GherkinParser.StepContext>> backgroundSteps = new ArrayList<>();
        for (GherkinParser.InstructionLineContext instructionLine : ctx.instructionLine()) {
            final GherkinParser.InstructionContext instruction = instructionLine.instruction();
            if (instruction != null && instruction.stepInstruction() != null && instruction.stepInstruction().background() != null) {
                backgroundSteps.add(instruction.step());
            }
        }
        return backgroundSteps;
    }

    private String getText(final GherkinParser.StepContext step, final BufferedTokenStream tokens) {
        return tokens.getText(step.start, step.stop);
    }

}
