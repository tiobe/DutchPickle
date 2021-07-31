package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Rule12 extends Rule {
    public Rule12(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "A Feature is not allowed to start with comments";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        for (Token token : Utils.getHiddenTokens(ctx.getStart().getTokenIndex(), getEndIndex(ctx), tokens)) {
            final String text = token.getText();
            // check whether it concerns a comment, (?s) is needed to match \n for multiline comments
            if (text.matches("(?s)(^\\s*#.*)|(^\\s*\"\"\".*)|(^\\s*```.*)") &&
                    !text.toLowerCase().matches(".*copyright.*") &&
                    !text.toLowerCase().matches(".*\\(c\\).*") &&
                    !token.getText().matches("^\\s*#//TICS.*$")) { // don't report TiCS suppressions
                addViolation(12, token.getLine(), token.getCharPositionInLine());
            }
        }
    }

    private int getEndIndex(final GherkinParser.MainContext ctx) {
        int index = 0;

        if (!ctx.instructionLine().isEmpty()) {
            index = ctx.instructionLine().get(0).getStart().getTokenIndex();
            for (GherkinParser.InstructionLineContext instruction : ctx.instructionLine()) {
                if (instruction.instruction().instructionDescription() != null) {
                    index = instruction.instruction().instructionDescription().getStop().getTokenIndex();
                } else { // no description
                    return index;
                }
            }
            index = 0;
        } else if (!ctx.description().isEmpty()) {
           index = ctx.description().get(ctx.description().size() - 1).getStop().getTokenIndex();
        } else {
            index = ctx.feature().FEATURE().getSymbol().getTokenIndex();
        }
        return index;
    }
}
