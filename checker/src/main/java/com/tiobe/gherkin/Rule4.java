package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule4 extends Rule {
    public Rule4(final List<Violation> violations) {
        super(violations);
    }

    public String getSynopsis() {
        return "All data table headers should be used in the Scenario Outline";
    }

    public void check(final GherkinParser.InstructionContext ctx, final BufferedTokenStream tokens) {
        // Rule Gherkin-UnusedTableHeader: All data table headers should be used in the Scenario Outline
        if (ctx.stepInstruction() != null && ctx.stepInstruction().scenarioOutline() != null) {
            // first we will collect all parameters
            final List<String> parameters = new ArrayList<>();
            for (GherkinParser.StepContext step : ctx.step()) {
                for (GherkinParser.DescriptionContext item : step.description()) {
                    if (item.PARAMETER() != null) {
                        parameters.add(item.PARAMETER().getText().replaceAll("<|>|\"|\'", ""));
                    }
                }
                // parameters can be hidden in data tables
                if (step.stepItem().datatable() != null) {
                    for (TerminalNode element : step.stepItem().datatable().DATATABLE()) {
                        final Pattern p = Pattern.compile("<([^>]+)>");
                        final Matcher m = p.matcher(element.getText());
                        while (m.find()) {
                            final String parameter = m.group(1);
                            parameters.add(parameter);
                        }
                    }
                }
            }

            // then we check whether there are table headers that are not used (missing in parameter list)
            boolean tableHeader = false;
            for (GherkinParser.StepContext step : ctx.step()) {
                final GherkinParser.StepItemContext item = step.stepItem();
                if (item.examples() != null) {
                    tableHeader = true;
                }
                if (tableHeader && item.datatable() != null) {
                    for (TerminalNode element : item.datatable().DATATABLE()) {
                        final String header = element.getText().substring(1).trim();
                        // check whether header is empty because last table entry "| " could match as well
                        if (!header.isEmpty() && !parameters.contains(header)) {
                            addViolation(4, item,"Table header '" + element.getText().substring(1).trim() + "' is not used in this Scenario Outline");
                          }
                    }
                    tableHeader = false;
                }
            }
        }
    }
}
