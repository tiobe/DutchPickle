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
        return "Repeating setup steps of every Scenario should be part of the Background";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        int numberOfCommonPrefixes = 0;
        int numberOfScenarios = 0;
        List<GherkinParser.StepContext> previousScenario = new ArrayList<>();
        for (GherkinParser.InstructionLineContext instructionLine : ctx.instructionLine()) {
            final GherkinParser.InstructionContext instruction = instructionLine.instruction();
            if (instruction.stepInstruction() != null && instruction.stepInstruction().scenario() != null) {
                if (previousScenario.isEmpty()) {
                    numberOfCommonPrefixes = instruction.step().size();
                } else {
                    final int prefixes = getNumberOfPrefixes(previousScenario, instruction.step());
                    numberOfCommonPrefixes = Math.min(prefixes, numberOfCommonPrefixes);
                    if (numberOfCommonPrefixes == 0) {
                        break; // no need to continue, there is no prefix
                    }
                }
                previousScenario = instruction.step();
                numberOfScenarios++;
            }
        }

        if (numberOfScenarios > 1 && numberOfCommonPrefixes > 0) {
            addViolation(14, ctx, "All Scenarios in this Feature share " + numberOfCommonPrefixes + " setup Steps that could be put in a Background");
        }
    }

    int getNumberOfPrefixes(final List<GherkinParser.StepContext> scenario1, final List<GherkinParser.StepContext> scenario2) {
        int prefixes = 0;
        for (; prefixes < Math.min(scenario1.size(), scenario2.size()); prefixes++) {
            if (!scenario1.get(prefixes).getText().equals(scenario2.get(prefixes).getText())) {
                break;
            }
        }

        return prefixes;
    }
}
