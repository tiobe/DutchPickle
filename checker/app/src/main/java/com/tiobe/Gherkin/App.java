package com.tiobe.Gherkin;

import com.tiobe.antlr.GherkinLexer;
import com.tiobe.antlr.GherkinParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static String FILENAME;
    public static ArrayList<String> RULES;

    public static void main(String... args) throws IOException  {
        RULES = new ArrayList<>();
        String filename = "";

        if (args.length == 0) {
            System.out.println("No argument provided, use 'app { --rule<digits> }* <inputfile>.feature'");
            System.exit(1);
        }
        for (String arg : args) {
            if (arg.startsWith("--rule")) {
                RULES.add(arg.substring(arg.lastIndexOf('e') + 1));
            } else if (arg.toLowerCase().endsWith(".feature")) {
                filename = arg;
            } else {
                System.out.println("Unknown option '" + arg + "' encountered, please run without arguments for help");
                System.exit(1);
            }
        }

        if (filename.isEmpty()) {
            System.out.println("No input file name specified");
            System.exit(1);
        }

        final CharStream charStream = CharStreams.fromFileName(filename);
        final GherkinLexer lexer = new GherkinLexer(charStream);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        FILENAME = tokens.getSourceName();
        final GherkinParser parser = new GherkinParser(tokens);
        final ParseTree tree = parser.main();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new GherkinListenerApp(tokens), tree);
        System.exit(0);
    }
}
