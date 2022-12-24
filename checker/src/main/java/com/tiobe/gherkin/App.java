// Copyright 2022, TIOBE Software B.V.
package com.tiobe.gherkin;

import com.tiobe.antlr.GherkinLexer;
import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    private static String FILENAME;


    public static List<Rule> getRules(final Set<String> ruleNames, final List<Violation> violations) {
        return ruleNames.stream()
                .map(App::getRuleByName)
                .map(x -> instantiateRule(x, violations))
                .collect(Collectors.toUnmodifiableList());
    }

    public static Class<? extends Rule> getRuleByName(final String ruleName) {
        try {
            return Class.forName(App.class.getPackageName() + ".Rule" + ruleName).asSubclass(Rule.class);
        } catch (final ClassNotFoundException e) {
            System.out.println("Rule '" + ruleName + "' doesn't exist, please choose another rule ID");
            System.exit(1);
            return null;
        }
    }

    public static Rule instantiateRule(final Class<? extends Rule> ruleClass, final List<Violation> violations) {
        try {
            return ruleClass.getDeclaredConstructor(List.class).newInstance(violations);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static String getVersion() throws IOException {
        final Properties prop = new Properties();
        try (InputStream in = App.class.getClassLoader().getResourceAsStream("build.properties")) {
            prop.load(in);
            return (String) prop.get("version");
        }
    }

    public static void main(final String... args) throws IOException {
        final Set<String> ruleNames = new LinkedHashSet<>();
        String filename = "";

        if (args.length == 0) {
            System.out.println("No argument provided, use 'DutchPickle (--version | --rules <digits>+ | --rulesfile <rulesfile>) <inputfile>.feature)'");
            System.exit(1);
        }

        boolean rules = false; // --rules
        boolean rulesfile = false; // --rulesfile

        for (String arg : args) {
            if (rules && arg.matches("\\d+")) {
                ruleNames.add(arg);
                continue;
            } else {
                rules = false;
            }

            if (arg.equals("--rules")) {
                rules = true;
            } else if (arg.equals("--rulesfile")) {
                rulesfile = true;
            } else if (arg.toLowerCase().endsWith(".feature")) {
                if (new File(arg).exists()) {
                    filename = arg;
                } else {
                    System.out.println("Input file '" + arg + "' doesn't exist");
                    System.exit(1);
                }
            } else if (arg.equals("--version")) {
                final String version = getVersion();
                System.out.println("DutchPickle version " + version + ", Copyright 2022, TIOBE Software B.V.");
                System.exit(0);
            } else if (rulesfile) {
                ruleNames.addAll(readRulesFile(arg));
                rulesfile = false;
            } else {
                System.out.println("Unknown option '" + arg + "' encountered, please run without arguments for help");
                System.exit(1);
            }
        }

        if (ruleNames.isEmpty()) {
            ruleNames.addAll(readRulesFile()); // check for default rule file
        }

        if (filename.isEmpty()) {
            System.out.println("No input file name specified");
            System.exit(1);
        }

        checkViolations(filename, ruleNames);

        System.exit(0);
    }

    private static List<String> readRulesFile() {
        return readRulesFile("rules.ini");
    }

    private static List<String> readRulesFile(final String fileName) {
        List<String> contents = new ArrayList<>();

        try {
            contents = Files.readAllLines(Paths.get(fileName));
        } catch (final IOException e) {
            System.out.println("Rules file '" + fileName + "' doesn't exist");
            System.exit(1);
        }
        return contents;
    }

    private static void checkViolations(final String filename, final Set<String> ruleNames) throws IOException {
        List<Violation> violations = getViolations(filename, ruleNames);

        // sort the violations
        violations = violations.stream().sorted(Comparator.comparingInt(Violation::getLineNumber)).collect(Collectors.toList());

        if (violations.isEmpty()) {
            System.out.println("No violations found");
        }

        for (Violation violation : violations) {
            violation.printToStdout(FILENAME);
        }
    }

    public static List<Violation> getViolations(final String filename, final Set<String> ruleNames) throws IOException {
        final CharStream charStream = CharStreams.fromFileName(filename);
        final GherkinLexer lexer = new GherkinLexer(charStream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final GherkinParser parser = new GherkinParser(tokens);
        final ParseTree tree = parser.main();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final List<Violation> violations = new ArrayList<>(); // TODO: rewrite so that violations are printed while running (stream)
        final List<Rule> rules = getRules(ruleNames, violations);

        FILENAME = tokens.getSourceName();
        walker.walk(new GherkinListener(tokens, rules), tree);

        return violations;
    }
}
