package com.tiobe.Gherkin;

import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule4 {
    static void check(GherkinParser.InstructionContext ctx) {
        if (!App.RULES.contains("4")) {
            return;
        }

        // Rule Gherkin-UnusedTableHeader: All data table headers should be used in the Scenario Outline
        if (ctx.stepInstruction() != null && ctx.stepInstruction().scenarioOutline() != null) {
            // first we will collect all parameters
            List<String> parameters = new ArrayList<>();
            for (GherkinParser.StepContext step : ctx.step()) {
                for (GherkinParser.DescriptionContext item : step.description()) {
                    if (item.PARAMETER() != null) {
                        parameters.add(item.PARAMETER().getText().replaceAll("<|>|\"|\'", ""));
                    }
                }
                // parameters can be hidden in data tables
                if (step.stepItem().datatable() != null) {
                    for (TerminalNode element : step.stepItem().datatable().DATATABLE()) {
                        Pattern p = Pattern.compile("<([^>]+)>");
                        Matcher m = p.matcher(element.getText());
                        while(m.find()) {
                            String parameter = m.group(1);
                            parameters.add(parameter);
                        }
                    }
                }
            }

            // then we check whether there are table headers that are not used (missing in parameter list)
            boolean tableHeader = false;
            for (GherkinParser.StepContext step : ctx.step()) {
                GherkinParser.StepItemContext item = step.stepItem();
                if (item.examples() != null) {
                    tableHeader = true;
                }
                if (tableHeader && item.datatable() != null) {
                    for (TerminalNode element : item.datatable().DATATABLE()) {
                        String header = element.getText().substring(1).trim();
                        // check whether header is empty because last table entry "| " could match as well
                        if (!header.isEmpty() && !parameters.contains(header)) {
                            new Violation(4, item,"Table header '" + element.getText().substring(1).trim() + "' is not used in this Scenario Outline");
                          }
                    }
                    tableHeader = false;
                }
            }
        }
    }
}
