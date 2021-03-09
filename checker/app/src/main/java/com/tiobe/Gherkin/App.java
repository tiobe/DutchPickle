package com.tiobe.Gherkin;

import com.tiobe.antlr.GherkinLexer;
import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class App {
    public static String FILENAME;
    public static ArrayList<String> RULES;

    public static void main(String... args) throws IOException  {
        RULES = new ArrayList<>();
        for (String arg : args) {
            if (arg.startsWith("--rule")) {
                RULES.add(arg.substring(arg.lastIndexOf('e') + 1));
            } else if (!arg.toLowerCase().endsWith(".feature")) {
                System.out.println("Please specify a .feature file as input parameter");
                System.exit(1);
            }
        }

        final String filename = args[0];
        final CharStream charStream = CharStreams.fromFileName(filename);
        final GherkinLexer lexer = new GherkinLexer(charStream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        FILENAME = tokens.getSourceName();
        final GherkinParser parser = new GherkinParser(tokens);
        final ParseTree tree = parser.main();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new GherkinListenerApp(), tree);
        System.exit(0);
    }
}
