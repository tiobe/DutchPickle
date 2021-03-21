package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rule13 extends Rule {
    public Rule13(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Don't repeat steps in Scenarios that are also part of the Background";
    }

    public void check(final GherkinParser.MainContext ctx) {
        // first collect all Background Steps in a Feature
        final List<List<GherkinParser.StepContext>> backgroundSteps = new ArrayList<>();
        for (GherkinParser.InstructionContext instruction : ctx.instruction()) {
            if (instruction.stepInstruction() != null && instruction.stepInstruction().background() != null) {
                backgroundSteps.add(instruction.step());
            }
        }

        // then check whether every Scenario has a prefix that corresponds to a Background
        for (GherkinParser.InstructionContext instruction : ctx.instruction()) {
            if (instruction.stepInstruction() != null && instruction.stepInstruction().scenario() != null) {
                for (List<GherkinParser.StepContext> steps : backgroundSteps) {
                    if (Collections.indexOfSubList(instruction.step().stream().map(x->x.getText()).collect(Collectors.toList()),
                            steps.stream().map(x->x.getText()).collect(Collectors.toList())) == 0) {
                        addViolation(13, instruction.stepInstruction().scenario());
                    }
                }
            }
        }
    }
}
