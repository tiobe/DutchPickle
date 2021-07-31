package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Rule11 extends Rule {
    public Rule11(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "A Scenario is not allowed to start with comments";
    }

    public void check(final GherkinParser.MainContext ctx, final BufferedTokenStream tokens) {
        final List<Token> commentBeforeTag = new ArrayList<>(); // we should also check whether there is a comment before the tag
        boolean ignore = false;

        for (GherkinParser.InstructionLineContext instruction : ctx.instructionLine()) {
            if (instruction.instruction() != null) {
                if (instruction.instruction().stepInstruction() != null) {
                    if (!commentBeforeTag.isEmpty()) {
                        commentBeforeTag.forEach(this::createViolation);
                    }
                    if (!ignore) {
                        final List<Token> commentTokens = getCommentTokens(instruction, getEndIndex(instruction.instruction()), tokens);
                        commentTokens.forEach(this::createViolation);
                        commentBeforeTag.clear();
                    }
                    ignore = false;
                } else if (instruction.instruction().tagline() != null) {
                    final List<TerminalNode> nodes = instruction.instruction().tagline().TAG();
                    ignore = ignore || nodes.get(nodes.size() - 1).getText().equals("@ignore"); // ignore, if the last tag of the line is "@ignore"
                    if (!ignore) {
                        final List<Token> commentTokens = getCommentTokens(instruction, getEndIndex(instruction.instruction().tagline().TAG()), tokens);
                        commentBeforeTag.addAll(commentTokens);
                    }
                } else if (instruction.instruction().rulex() != null) {
                    commentBeforeTag.clear();
                    ignore = false;
                }
            }
        }
    }

    private void createViolation(final Token token) {
        // ignore TiCS suppression comments
        if (!token.getText().matches("^\\s*#//TICS.*$")) {
            addViolation(11, token.getLine(), token.getCharPositionInLine());
        }
    }

    private List<Token> getCommentTokens(final GherkinParser.InstructionLineContext instruction, final int end, final BufferedTokenStream tokens) {
        final List<Token> commentTokens = new ArrayList<>();

        for (Token token : Utils.getHiddenTokens(instruction.getStart().getTokenIndex(), end, tokens)) {
            final String text = token.getText();
            // check whether it concerns a comment, (?s) is needed to match \n for multiline comments
            if (Pattern.matches("(?s)(^\\s*#.*)|(^\\s*\"\"\".*)|(^\\s*```.*)", text)) {
                commentTokens.add(token);
            }
        }

        return commentTokens;
    }

    private int getEndIndex(final GherkinParser.InstructionContext instruction) {
        // select the token before the first step/first step description/first description
        if (!instruction.step().isEmpty()) {
            return instruction.step(0).start.getTokenIndex() - 1;
        } else if (!instruction.stepDescription().isEmpty()) {
            return instruction.stepDescription(0).start.getTokenIndex() - 1;
        } else if (!instruction.description().isEmpty()){
            return instruction.description(0).start.getTokenIndex() - 1;
        } else {
            return getEndIndex(instruction.stepInstruction());
        }
    }

    private int getEndIndex(final GherkinParser.StepInstructionContext step) {
        TerminalNode node = null;

        if (step.scenario() != null) {
            node = step.scenario().SCENARIO();
        } else if (step.scenarioOutline() != null) {
            node = step.scenarioOutline().SCENARIOOUTLINE();
        } else if (step.background() != null) {
            node = step.background().BACKGROUND();
        }

        return node != null? node.getSymbol().getTokenIndex() : -1;
    }

    private int getEndIndex(final List<TerminalNode> nodes) {
        return nodes.get(nodes.size() - 1).getSymbol().getTokenIndex();
    }
}
