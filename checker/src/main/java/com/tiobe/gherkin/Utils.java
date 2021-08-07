package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;
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

    public static List<Token> getHiddenTokens(final int begin, final int end, final BufferedTokenStream tokens) {
        final List<Token> result = new ArrayList<>();

        if (begin <= end) {
            for (int i = begin; i <= end; i++) {
                final List<Token> hidden = tokens.getHiddenTokensToLeft(i);
                if (hidden != null) {
                    result.addAll(hidden);
                }
            }
        }

        return result;
    }
}
