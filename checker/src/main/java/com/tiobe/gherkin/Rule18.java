package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Rule18 extends Rule {
    public Rule18(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Words within a step should be separated by a single space";
    }

    public void check(final GherkinParser.StepContext ctx, final BufferedTokenStream tokens) {
        if (ctx.description() != null) {
            for (final GherkinParser.DescriptionContext description : ctx.description()) {
                final List<Token> doubleSpaceTokens = getDoubleSpaceTokens(description, tokens);
                for (final Token token : doubleSpaceTokens) {
                    addViolation(18, token.getLine(), token.getCharPositionInLine()+1, "Double space encountered");
                }
            }
        }
        checkDataTableCells(ctx);
    }

    private void checkDataTableCells(final GherkinParser.StepContext ctx) {
        if (ctx.stepItem() != null && ctx.stepItem().datatable() != null) {
            for (final TerminalNode node : ctx.stepItem().datatable().DATATABLE()) {
                if (node.getText().matches("\\|\\s\\s.*")) {
                    addViolation(18, node.getSymbol().getLine(), node.getSymbol().getCharPositionInLine(), "Double space encountered at the beginning of a data table cell");
                }
            }
        }
    }

    private List<Token> getDoubleSpaceTokens(final GherkinParser.DescriptionContext instruction, final BufferedTokenStream tokens) {
        final List<Token> spaceTokens = new ArrayList<>();
        final int begin = instruction.getStart().getTokenIndex();
        final int end = instruction.getStop().getTokenIndex();

        for (int i = begin; i <= end; i++) {
            final List<Token> hiddenTokens = tokens.getHiddenTokensToLeft(i);
            if (hiddenTokens != null) {
                for (final Token token : hiddenTokens) {
                    final String text = token.getText();
                    // check whether it concerns a double space
                    if (Pattern.matches(".*\\s\\s.*", text)) {
                        spaceTokens.add(token);
                    }
                }
            }
        }

        return spaceTokens;
    }
}
