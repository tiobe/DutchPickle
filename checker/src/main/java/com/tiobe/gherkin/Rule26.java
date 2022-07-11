package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;

import java.util.List;

public class Rule26 extends Rule {
    public Rule26(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "Don't use 'and' or 'but' in Steps";
    }

    public void check(final GherkinParser.StepContext ctx, final BufferedTokenStream tokens) {
        final String violationText = "Step should be split up because it contains ";
        for (final GherkinParser.DescriptionContext description : ctx.description()) {
            if (description.AND() != null) {
                addViolation(26, description, violationText + "'And'");
            }
            else if (description.BUT() != null) {
                addViolation(26, description, violationText + "'But'");
            }
            else if (description.text() != null) {
                final List<String> keywords = List.of("and", "but");
                // filter out keywords that are used in quotes, e.g. "When the user presses the pedal to 'Prepare and perform exposure'"
                final String text = tokens.getText(description.getStart(), description.getStop()).replaceAll("\\'.*?\\'", "");
                for (final String word : text.split("\\s")) {
                    for (final String keyword: keywords) {
                        if (word.equalsIgnoreCase(keyword)) {
                            addViolation(26, description, violationText + "'" + word + "'");
                        }
                    }
                }
            }
        }
    }
}
