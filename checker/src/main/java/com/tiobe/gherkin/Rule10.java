package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class Rule10 extends Rule {
    public Rule10(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "There should always at least one empty line between Scenarios";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        if (ctx.instructionLine() != null && ctx.instructionLine().size() > 1) {
            check(ctx.instructionLine());
        }
    }

    private void check(final List<GherkinParser.InstructionLineContext> instructions) {
        // skip first Scenario
        boolean first = true;
        boolean emptyLineBeforeTag = false; // we should also check whether there is an empty line before the tag
        for (GherkinParser.InstructionLineContext instruction : instructions) {
            if (instruction.instruction() != null) {
                if (instruction.instruction().stepInstruction() != null) {
                    if (!first && !emptyLineBeforeTag && instruction.NL().size() < 2) {
                        addViolation(10, instruction.instruction().stepInstruction());
                    }
                    first = false;
                    emptyLineBeforeTag = false;
                } else if (instruction.instruction().tagline() != null) {
                    emptyLineBeforeTag = emptyLineBeforeTag || instruction.NL().size() > 1;
                } else if (instruction.instruction().rulex() != null) {
                    emptyLineBeforeTag = false;
                }
            }
        }
    }
}
