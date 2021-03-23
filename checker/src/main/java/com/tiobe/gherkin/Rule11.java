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
        final List<Token> commentBeforeTag = new ArrayList<Token>(); // we should also check whether there is a comment before the tag

        if (ctx.instructionLine() != null && ctx.instructionLine().size() > 1) {
            for (GherkinParser.InstructionLineContext instruction : ctx.instructionLine()) {
                if (instruction.instruction() != null) {
                    if (instruction.instruction().stepInstruction() != null) {
                        if (!commentBeforeTag.isEmpty()) {
                            for (Token token : commentBeforeTag) {
                                addViolation(11, token.getLine(), token.getCharPositionInLine());
                            }
                        }
                        final List<Token> commentTokens = getCommentTokens(instruction, getEndIndex(instruction.instruction().stepInstruction()), tokens);
                        if (commentTokens != null) {
                            for (Token token : commentTokens) {
                                addViolation(11, token.getLine(), token.getCharPositionInLine());
                            }
                        }
                        commentBeforeTag.clear();
                    } else if (instruction.instruction().tagline() != null) {
                        final List<Token> commentTokens = getCommentTokens(instruction, getEndIndex(instruction.instruction().tagline().TAG()), tokens);
                        if (commentTokens != null) {
                            for (Token token : commentTokens) {
                                commentBeforeTag.add(token);
                            }
                        }
                    } else if (instruction.instruction().rulex() != null) {
                        commentBeforeTag.clear();
                    }
                }
            }
        }
    }

    private List<Token> getCommentTokens(final GherkinParser.InstructionLineContext instruction, final int end, final BufferedTokenStream tokens) {
        final List<Token> commentTokens = new ArrayList<>();
        final int begin = instruction.getStart().getTokenIndex();

        if (begin < end) {
            for (int i = begin; i <= end; i++) {
                final List<Token> hiddenTokens = tokens.getHiddenTokensToLeft(i);
                if (hiddenTokens != null) {
                    for (Token token : hiddenTokens) {
                        final String text = token.getText();
                        // check whether it concerns a comment, (?s) is needed to match \n for multiline comments
                        if (Pattern.matches("(?s)(^\\s*#.*)|(^\\s*\"\"\".*)|(^\\s*```.*)", text)) {
                            commentTokens.add(token);
                        }
                    }
                }
            }
        }

        return commentTokens;
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
