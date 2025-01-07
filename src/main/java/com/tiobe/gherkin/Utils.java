package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Utils {
    private Utils() {} // prevent instantiation of this utility class

    public static boolean isGivenStep(final GherkinParser.StepItemContext stepItem) {
        return stepItem.and() != null || stepItem.anystep() != null || stepItem.but() != null || stepItem.given() != null;
    }

    public static boolean containsParameter(final GherkinParser.StepContext step) {
        return step.description().stream().anyMatch(x -> x.PARAMETER() != null) || containsParameter(step.stepItem());
    }

    private static boolean containsParameter(final GherkinParser.StepItemContext stepItem) {
        return stepItem.datatable() != null
                && (stepItem.datatable().DATATABLE().stream().anyMatch(x -> (x.getText().contains("<") && x.getText().contains(">"))));
    }

    public static List<String> getCells(final GherkinParser.DatatableContext datatable) {
        return datatable.DATATABLE().stream().map(cell -> cell.getText().replaceAll("^\\|\\s*(?:(.*[^\\s])\\s*)?$", "$1")).collect(Collectors.toList());
    }

    // single line comments (starting with #) contain a preceding newline which causes line numbers to be one too low, this should be compensated.
    public static int getCommentLineNumber(final Token token) {
        final int line = token.getLine();
        return token.getText().startsWith("\n") || token.getText().startsWith("\r") ? line + 1 : line;
    }

    public static List<Token> getCommentTokens(final int begin, final int end, final BufferedTokenStream tokens) {
        final List<Token> commentTokens = new ArrayList<>();
        for (Token token : Utils.getHiddenTokens(begin, end, tokens)) {
            final String text = token.getText();
            // check whether it concerns a comment, (?s) is needed to match \n for multiline comments
            if (Pattern.matches("(?s)(^\\r?\\n\\s*#.*)|(^\\s*\"\"\".*)|(^\\s*```.*)", text)) {
                commentTokens.add(token);
            }
        }

        return commentTokens;
    }

    public static List<String> getTags(final GherkinParser.TaglineContext ctx) {
        return ctx.TAG().stream().map(x -> x.getText().substring(1)).collect(Collectors.toList()); // remove prefix '@' of a tag
    }

    public static boolean startsWithTag(final String comment, final List<String> tags) {
        // for instance:
        // @sometag:11123
        // # sometag:11123 - this is OK because it starts with a tag name
        return tags != null ? tags.stream().anyMatch(tag -> comment.matches("\\r?\\n\\s*#\\s*" + Pattern.quote(tag) + "\\s+.*")) : false;
    }

    public static Set<Token> getHiddenTokens(final int begin, final int end, final BufferedTokenStream tokens) {
        final List<Token> result = new ArrayList<>();

        if (begin <= end) {
            for (int i = begin; i <= end; i++) {
                final List<Token> hidden = tokens.getHiddenTokensToLeft(i);
                if (hidden != null) {
                    result.addAll(hidden);
                }
            }
        }

        return Set.copyOf(result);
    }

    public static int getEndIndex(final GherkinParser.MainContext ctx) {
        int index = 0;

        if (!ctx.instructionLine().isEmpty()) {
            index = ctx.instructionLine().get(0).getStart().getTokenIndex();
            for (GherkinParser.InstructionLineContext instruction : ctx.instructionLine()) {
                if (instruction != null && instruction.instruction() != null && instruction.instruction().instructionDescription() != null) {
                    index = instruction.instruction().instructionDescription().getStop().getTokenIndex();
                } else { // no description
                    return index;
                }
            }
            index = 0;
        } else if (!ctx.description().isEmpty()) {
            index = ctx.description().get(ctx.description().size() - 1).getStop().getTokenIndex();
        } else {
            index = ctx.feature().FEATURE() != null ? ctx.feature().FEATURE().getSymbol().getTokenIndex() : 0;
        }
        return index;
    }

    public static int getEndIndex(final List<TerminalNode> nodes) {
        return nodes.get(nodes.size() - 1).getSymbol().getTokenIndex();
    }

    // This function returns all indexes of a string, instead of only the first one, generalization of indexOf
    public static List<Integer> indexesOf(String str, String match) {
        List<Integer> result = new ArrayList<>();
        int index = str.indexOf(match);
        while(index >= 0) {
            result.add(index);
            index = str.indexOf(match, index+1);
        }
        return result;
    }

}
