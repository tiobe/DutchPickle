// Generated from Gherkin.g4 by ANTLR 4.9.1
package com.tiobe.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GherkinLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOMUTF8=1, BOMUTF16=2, WHITESPACE=3, COMMENT=4, DOCSTRING1=5, DOCSTRING2=6, 
		BACKGROUND=7, EXAMPLES=8, FEATURE=9, RULEX=10, SCENARIO=11, SCENARIOOUTLINE=12, 
		AND=13, ANYSTEP=14, BUT=15, DATATABLE=16, GIVEN=17, THEN=18, WHEN=19, 
		TAG=20, PARAMETER=21, NL=22, TEXT=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BOMUTF8", "BOMUTF16", "WHITESPACE", "COMMENT", "DOCSTRING1", "DOCSTRING2", 
			"BACKGROUND", "EXAMPLES", "FEATURE", "RULEX", "SCENARIO", "SCENARIOOUTLINE", 
			"AND", "ANYSTEP", "BUT", "DATATABLE", "GIVEN", "THEN", "WHEN", "TAG", 
			"PARAMETER", "ID", "DATATABLEID", "NL", "TEXT", "TOKEN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\u00EF\u00BB\u00BF'", "'\uFEFF'", null, null, null, null, "'Background:'", 
			null, "'Feature:'", "'Rule:'", null, null, "'And'", "'*'", "'But'", null, 
			"'Given'", "'Then'", "'When'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BOMUTF8", "BOMUTF16", "WHITESPACE", "COMMENT", "DOCSTRING1", "DOCSTRING2", 
			"BACKGROUND", "EXAMPLES", "FEATURE", "RULEX", "SCENARIO", "SCENARIOOUTLINE", 
			"AND", "ANYSTEP", "BUT", "DATATABLE", "GIVEN", "THEN", "WHEN", "TAG", 
			"PARAMETER", "NL", "TEXT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GherkinLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Gherkin.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0124\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\7\6T\n\6\f\6\16\6W\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\7\7d\n\7\f\7\16\7g\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008e\n\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b0\n\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u00cd\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\5\21\u00db\n\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0100\n\26\3\27\7\27\u0103\n\27\f\27\16\27\u0106\13\27\3\27"+
		"\3\27\7\27\u010a\n\27\f\27\16\27\u010d\13\27\3\30\7\30\u0110\n\30\f\30"+
		"\16\30\u0113\13\30\3\30\3\30\7\30\u0117\n\30\f\30\16\30\u011a\13\30\3"+
		"\31\3\31\3\32\6\32\u011f\n\32\r\32\16\32\u0120\3\33\3\33\4Ue\2\34\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\2/\2\61\30\63\31\65\2\3\2\t\4\2\13\13\"\"\4"+
		"\2\f\f\16\17\13\2\"\"\'(*+-=??A_aac}\177\177\n\2\'(*+-=??A_aac}\177\177"+
		"\t\2\"\"\'(*+-_aac}\177\177\b\2\'(*+-_aac}\177\177\6\2#=?}\177\u0080\u00a2"+
		"\u0101\2\u012e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\3\67\3\2\2\2\5=\3\2\2\2\7A\3\2\2\2\tE\3\2\2\2\13N"+
		"\3\2\2\2\r^\3\2\2\2\17n\3\2\2\2\21\u008d\3\2\2\2\23\u008f\3\2\2\2\25\u0098"+
		"\3\2\2\2\27\u00af\3\2\2\2\31\u00b1\3\2\2\2\33\u00ce\3\2\2\2\35\u00d2\3"+
		"\2\2\2\37\u00d4\3\2\2\2!\u00d8\3\2\2\2#\u00dc\3\2\2\2%\u00e2\3\2\2\2\'"+
		"\u00e7\3\2\2\2)\u00ec\3\2\2\2+\u00ff\3\2\2\2-\u0104\3\2\2\2/\u0111\3\2"+
		"\2\2\61\u011b\3\2\2\2\63\u011e\3\2\2\2\65\u0122\3\2\2\2\678\7\u00f1\2"+
		"\289\7\u00bd\2\29:\7\u00c1\2\2:;\3\2\2\2;<\b\2\2\2<\4\3\2\2\2=>\7\uff01"+
		"\2\2>?\3\2\2\2?@\b\3\2\2@\6\3\2\2\2AB\t\2\2\2BC\3\2\2\2CD\b\4\2\2D\b\3"+
		"\2\2\2EI\7%\2\2FH\n\3\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3"+
		"\2\2\2KI\3\2\2\2LM\b\5\2\2M\n\3\2\2\2NO\7$\2\2OP\7$\2\2PQ\7$\2\2QU\3\2"+
		"\2\2RT\13\2\2\2SR\3\2\2\2TW\3\2\2\2UV\3\2\2\2US\3\2\2\2VX\3\2\2\2WU\3"+
		"\2\2\2XY\7$\2\2YZ\7$\2\2Z[\7$\2\2[\\\3\2\2\2\\]\b\6\2\2]\f\3\2\2\2^_\7"+
		"b\2\2_`\7b\2\2`a\7b\2\2ae\3\2\2\2bd\13\2\2\2cb\3\2\2\2dg\3\2\2\2ef\3\2"+
		"\2\2ec\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7b\2\2ij\7b\2\2jk\7b\2\2kl\3\2\2"+
		"\2lm\b\7\2\2m\16\3\2\2\2no\7D\2\2op\7c\2\2pq\7e\2\2qr\7m\2\2rs\7i\2\2"+
		"st\7t\2\2tu\7q\2\2uv\7w\2\2vw\7p\2\2wx\7f\2\2xy\7<\2\2y\20\3\2\2\2z{\7"+
		"G\2\2{|\7z\2\2|}\7c\2\2}~\7o\2\2~\177\7r\2\2\177\u0080\7n\2\2\u0080\u0081"+
		"\7g\2\2\u0081\u0082\7u\2\2\u0082\u008e\7<\2\2\u0083\u0084\7U\2\2\u0084"+
		"\u0085\7e\2\2\u0085\u0086\7g\2\2\u0086\u0087\7p\2\2\u0087\u0088\7c\2\2"+
		"\u0088\u0089\7t\2\2\u0089\u008a\7k\2\2\u008a\u008b\7q\2\2\u008b\u008c"+
		"\7u\2\2\u008c\u008e\7<\2\2\u008dz\3\2\2\2\u008d\u0083\3\2\2\2\u008e\22"+
		"\3\2\2\2\u008f\u0090\7H\2\2\u0090\u0091\7g\2\2\u0091\u0092\7c\2\2\u0092"+
		"\u0093\7v\2\2\u0093\u0094\7w\2\2\u0094\u0095\7t\2\2\u0095\u0096\7g\2\2"+
		"\u0096\u0097\7<\2\2\u0097\24\3\2\2\2\u0098\u0099\7T\2\2\u0099\u009a\7"+
		"w\2\2\u009a\u009b\7n\2\2\u009b\u009c\7g\2\2\u009c\u009d\7<\2\2\u009d\26"+
		"\3\2\2\2\u009e\u009f\7G\2\2\u009f\u00a0\7z\2\2\u00a0\u00a1\7c\2\2\u00a1"+
		"\u00a2\7o\2\2\u00a2\u00a3\7r\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7g\2\2"+
		"\u00a5\u00b0\7<\2\2\u00a6\u00a7\7U\2\2\u00a7\u00a8\7e\2\2\u00a8\u00a9"+
		"\7g\2\2\u00a9\u00aa\7p\2\2\u00aa\u00ab\7c\2\2\u00ab\u00ac\7t\2\2\u00ac"+
		"\u00ad\7k\2\2\u00ad\u00ae\7q\2\2\u00ae\u00b0\7<\2\2\u00af\u009e\3\2\2"+
		"\2\u00af\u00a6\3\2\2\2\u00b0\30\3\2\2\2\u00b1\u00b2\7U\2\2\u00b2\u00b3"+
		"\7e\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6\7c\2\2\u00b6"+
		"\u00b7\7t\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7\"\2"+
		"\2\u00ba\u00cc\3\2\2\2\u00bb\u00bc\7Q\2\2\u00bc\u00bd\7w\2\2\u00bd\u00be"+
		"\7v\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7p\2\2\u00c1"+
		"\u00c2\7g\2\2\u00c2\u00cd\7<\2\2\u00c3\u00c4\7V\2\2\u00c4\u00c5\7g\2\2"+
		"\u00c5\u00c6\7o\2\2\u00c6\u00c7\7r\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9"+
		"\7c\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cd\7<\2\2\u00cc"+
		"\u00bb\3\2\2\2\u00cc\u00c3\3\2\2\2\u00cd\32\3\2\2\2\u00ce\u00cf\7C\2\2"+
		"\u00cf\u00d0\7p\2\2\u00d0\u00d1\7f\2\2\u00d1\34\3\2\2\2\u00d2\u00d3\7"+
		",\2\2\u00d3\36\3\2\2\2\u00d4\u00d5\7D\2\2\u00d5\u00d6\7w\2\2\u00d6\u00d7"+
		"\7v\2\2\u00d7 \3\2\2\2\u00d8\u00da\7~\2\2\u00d9\u00db\5/\30\2\u00da\u00d9"+
		"\3\2\2\2\u00da\u00db\3\2\2\2\u00db\"\3\2\2\2\u00dc\u00dd\7I\2\2\u00dd"+
		"\u00de\7k\2\2\u00de\u00df\7x\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7p\2\2"+
		"\u00e1$\3\2\2\2\u00e2\u00e3\7V\2\2\u00e3\u00e4\7j\2\2\u00e4\u00e5\7g\2"+
		"\2\u00e5\u00e6\7p\2\2\u00e6&\3\2\2\2\u00e7\u00e8\7Y\2\2\u00e8\u00e9\7"+
		"j\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7p\2\2\u00eb(\3\2\2\2\u00ec\u00ed"+
		"\7B\2\2\u00ed\u00ee\5\63\32\2\u00ee*\3\2\2\2\u00ef\u00f0\7>\2\2\u00f0"+
		"\u00f1\5-\27\2\u00f1\u00f2\7@\2\2\u00f2\u0100\3\2\2\2\u00f3\u00f4\7$\2"+
		"\2\u00f4\u00f5\7>\2\2\u00f5\u00f6\5-\27\2\u00f6\u00f7\7@\2\2\u00f7\u00f8"+
		"\7$\2\2\u00f8\u0100\3\2\2\2\u00f9\u00fa\7)\2\2\u00fa\u00fb\7>\2\2\u00fb"+
		"\u00fc\5-\27\2\u00fc\u00fd\7@\2\2\u00fd\u00fe\7)\2\2\u00fe\u0100\3\2\2"+
		"\2\u00ff\u00ef\3\2\2\2\u00ff\u00f3\3\2\2\2\u00ff\u00f9\3\2\2\2\u0100,"+
		"\3\2\2\2\u0101\u0103\t\4\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0107\u010b\t\5\2\2\u0108\u010a\t\4\2\2\u0109\u0108\3\2\2\2\u010a"+
		"\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c.\3\2\2\2"+
		"\u010d\u010b\3\2\2\2\u010e\u0110\t\6\2\2\u010f\u010e\3\2\2\2\u0110\u0113"+
		"\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0118\t\7\2\2\u0115\u0117\t\6\2\2\u0116\u0115\3\2"+
		"\2\2\u0117\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\60\3\2\2\2\u011a\u0118\3\2\2\2\u011b\u011c\t\3\2\2\u011c\62\3\2\2\2\u011d"+
		"\u011f\5\65\33\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e\3"+
		"\2\2\2\u0120\u0121\3\2\2\2\u0121\64\3\2\2\2\u0122\u0123\t\b\2\2\u0123"+
		"\66\3\2\2\2\20\2IUe\u008d\u00af\u00cc\u00da\u00ff\u0104\u010b\u0111\u0118"+
		"\u0120\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}