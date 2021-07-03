package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;

public class Utils {
    public static boolean isGivenStep(final GherkinParser.StepItemContext stepItem) {
        return stepItem.and() != null || stepItem.anystep() != null || stepItem.but() != null || stepItem.given() != null;
    }

    public static boolean containsParameter(final GherkinParser.StepContext step) {
        return step.description().stream().anyMatch(x -> x.PARAMETER() != null);
    }

}
