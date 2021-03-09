// Generated from Gherkin.g4 by ANTLR 4.9.1
package com.tiobe.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GherkinParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOMUTF8=1, BOMUTF16=2, WHITESPACE=3, COMMENT=4, DOCSTRING1=5, DOCSTRING2=6, 
		BACKGROUND=7, EXAMPLES=8, FEATURE=9, RULEX=10, SCENARIO=11, SCENARIOOUTLINE=12, 
		AND=13, ANYSTEP=14, BUT=15, DATATABLE=16, GIVEN=17, THEN=18, WHEN=19, 
		TAG=20, PARAMETER=21, NL=22, TEXT=23;
	public static final int
		RULE_main = 0, RULE_feature = 1, RULE_instruction = 2, RULE_stepInstruction = 3, 
		RULE_background = 4, RULE_rulex = 5, RULE_scenario = 6, RULE_scenarioOutline = 7, 
		RULE_step = 8, RULE_stepItem = 9, RULE_tagline = 10, RULE_and = 11, RULE_anystep = 12, 
		RULE_but = 13, RULE_datatable = 14, RULE_given = 15, RULE_then = 16, RULE_when = 17, 
		RULE_examples = 18, RULE_instructionDescription = 19, RULE_stepDescription = 20, 
		RULE_description = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "feature", "instruction", "stepInstruction", "background", "rulex", 
			"scenario", "scenarioOutline", "step", "stepItem", "tagline", "and", 
			"anystep", "but", "datatable", "given", "then", "when", "examples", "instructionDescription", 
			"stepDescription", "description"
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

	@Override
	public String getGrammarFileName() { return "Gherkin.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GherkinParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MainContext extends ParserRuleContext {
		public FeatureContext feature() {
			return getRuleContext(FeatureContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GherkinParser.EOF, 0); }
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(GherkinParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(GherkinParser.NL, i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public List<DatatableContext> datatable() {
			return getRuleContexts(DatatableContext.class);
		}
		public DatatableContext datatable(int i) {
			return getRuleContext(DatatableContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitMain(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			feature();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCENARIO) | (1L << SCENARIOOUTLINE) | (1L << AND) | (1L << ANYSTEP) | (1L << BUT) | (1L << DATATABLE) | (1L << GIVEN) | (1L << THEN) | (1L << WHEN) | (1L << TAG) | (1L << PARAMETER) | (1L << TEXT))) != 0)) {
				{
				{
				setState(45);
				description();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(52); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(51);
						match(NL);
						}
						}
						setState(54); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NL );
					setState(58);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case BACKGROUND:
					case RULEX:
					case SCENARIO:
					case SCENARIOOUTLINE:
					case AND:
					case ANYSTEP:
					case BUT:
					case GIVEN:
					case THEN:
					case WHEN:
					case TAG:
					case PARAMETER:
					case TEXT:
						{
						setState(56);
						instruction();
						}
						break;
					case DATATABLE:
						{
						setState(57);
						datatable();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(65);
				match(NL);
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureContext extends ParserRuleContext {
		public TerminalNode FEATURE() { return getToken(GherkinParser.FEATURE, 0); }
		public List<TaglineContext> tagline() {
			return getRuleContexts(TaglineContext.class);
		}
		public TaglineContext tagline(int i) {
			return getRuleContext(TaglineContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(GherkinParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(GherkinParser.NL, i);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitFeature(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_feature);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(73);
						match(NL);
						}
						}
						setState(78);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(79);
					tagline();
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(85);
				match(NL);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
			match(FEATURE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public RulexContext rulex() {
			return getRuleContext(RulexContext.class,0);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public StepInstructionContext stepInstruction() {
			return getRuleContext(StepInstructionContext.class,0);
		}
		public List<StepDescriptionContext> stepDescription() {
			return getRuleContexts(StepDescriptionContext.class);
		}
		public StepDescriptionContext stepDescription(int i) {
			return getRuleContext(StepDescriptionContext.class,i);
		}
		public List<StepContext> step() {
			return getRuleContexts(StepContext.class);
		}
		public StepContext step(int i) {
			return getRuleContext(StepContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(GherkinParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(GherkinParser.NL, i);
		}
		public TaglineContext tagline() {
			return getRuleContext(TaglineContext.class,0);
		}
		public InstructionDescriptionContext instructionDescription() {
			return getRuleContext(InstructionDescriptionContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruction);
		int _la;
		try {
			int _alt;
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				rulex();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCENARIO) | (1L << SCENARIOOUTLINE) | (1L << AND) | (1L << ANYSTEP) | (1L << BUT) | (1L << DATATABLE) | (1L << GIVEN) | (1L << THEN) | (1L << WHEN) | (1L << TAG) | (1L << PARAMETER) | (1L << TEXT))) != 0)) {
					{
					{
					setState(94);
					description();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				stepInstruction();
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCENARIO) | (1L << SCENARIOOUTLINE) | (1L << AND) | (1L << ANYSTEP) | (1L << BUT) | (1L << DATATABLE) | (1L << GIVEN) | (1L << THEN) | (1L << WHEN) | (1L << TAG) | (1L << PARAMETER) | (1L << TEXT))) != 0)) {
					{
					{
					setState(101);
					description();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(108); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(107);
							match(NL);
							}
							}
							setState(110); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NL );
						setState(112);
						stepDescription();
						setState(116);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCENARIO) | (1L << SCENARIOOUTLINE) | (1L << AND) | (1L << ANYSTEP) | (1L << BUT) | (1L << DATATABLE) | (1L << GIVEN) | (1L << THEN) | (1L << WHEN) | (1L << TAG) | (1L << PARAMETER) | (1L << TEXT))) != 0)) {
							{
							{
							setState(113);
							description();
							}
							}
							setState(118);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						} 
					}
					setState(123);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(125); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(124);
								match(NL);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(127); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(129);
						step();
						}
						} 
					}
					setState(134);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				tagline();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				instructionDescription();
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCENARIO) | (1L << SCENARIOOUTLINE) | (1L << AND) | (1L << ANYSTEP) | (1L << BUT) | (1L << DATATABLE) | (1L << GIVEN) | (1L << THEN) | (1L << WHEN) | (1L << TAG) | (1L << PARAMETER) | (1L << TEXT))) != 0)) {
					{
					{
					setState(137);
					description();
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepInstructionContext extends ParserRuleContext {
		public BackgroundContext background() {
			return getRuleContext(BackgroundContext.class,0);
		}
		public ScenarioContext scenario() {
			return getRuleContext(ScenarioContext.class,0);
		}
		public ScenarioOutlineContext scenarioOutline() {
			return getRuleContext(ScenarioOutlineContext.class,0);
		}
		public StepInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepInstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterStepInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitStepInstruction(this);
		}
	}

	public final StepInstructionContext stepInstruction() throws RecognitionException {
		StepInstructionContext _localctx = new StepInstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stepInstruction);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BACKGROUND:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				background();
				}
				break;
			case SCENARIO:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				scenario();
				}
				break;
			case SCENARIOOUTLINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				scenarioOutline();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BackgroundContext extends ParserRuleContext {
		public TerminalNode BACKGROUND() { return getToken(GherkinParser.BACKGROUND, 0); }
		public BackgroundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_background; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterBackground(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitBackground(this);
		}
	}

	public final BackgroundContext background() throws RecognitionException {
		BackgroundContext _localctx = new BackgroundContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_background);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(BACKGROUND);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RulexContext extends ParserRuleContext {
		public TerminalNode RULEX() { return getToken(GherkinParser.RULEX, 0); }
		public RulexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterRulex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitRulex(this);
		}
	}

	public final RulexContext rulex() throws RecognitionException {
		RulexContext _localctx = new RulexContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rulex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(RULEX);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScenarioContext extends ParserRuleContext {
		public TerminalNode SCENARIO() { return getToken(GherkinParser.SCENARIO, 0); }
		public ScenarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterScenario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitScenario(this);
		}
	}

	public final ScenarioContext scenario() throws RecognitionException {
		ScenarioContext _localctx = new ScenarioContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_scenario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(SCENARIO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScenarioOutlineContext extends ParserRuleContext {
		public TerminalNode SCENARIOOUTLINE() { return getToken(GherkinParser.SCENARIOOUTLINE, 0); }
		public ScenarioOutlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scenarioOutline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterScenarioOutline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitScenarioOutline(this);
		}
	}

	public final ScenarioOutlineContext scenarioOutline() throws RecognitionException {
		ScenarioOutlineContext _localctx = new ScenarioOutlineContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_scenarioOutline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(SCENARIOOUTLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepContext extends ParserRuleContext {
		public StepItemContext stepItem() {
			return getRuleContext(StepItemContext.class,0);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitStep(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_step);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			stepItem();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCENARIO) | (1L << SCENARIOOUTLINE) | (1L << AND) | (1L << ANYSTEP) | (1L << BUT) | (1L << DATATABLE) | (1L << GIVEN) | (1L << THEN) | (1L << WHEN) | (1L << TAG) | (1L << PARAMETER) | (1L << TEXT))) != 0)) {
				{
				{
				setState(159);
				description();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepItemContext extends ParserRuleContext {
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public AnystepContext anystep() {
			return getRuleContext(AnystepContext.class,0);
		}
		public ButContext but() {
			return getRuleContext(ButContext.class,0);
		}
		public DatatableContext datatable() {
			return getRuleContext(DatatableContext.class,0);
		}
		public GivenContext given() {
			return getRuleContext(GivenContext.class,0);
		}
		public ThenContext then() {
			return getRuleContext(ThenContext.class,0);
		}
		public WhenContext when() {
			return getRuleContext(WhenContext.class,0);
		}
		public ExamplesContext examples() {
			return getRuleContext(ExamplesContext.class,0);
		}
		public List<TaglineContext> tagline() {
			return getRuleContexts(TaglineContext.class);
		}
		public TaglineContext tagline(int i) {
			return getRuleContext(TaglineContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(GherkinParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(GherkinParser.NL, i);
		}
		public StepItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterStepItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitStepItem(this);
		}
	}

	public final StepItemContext stepItem() throws RecognitionException {
		StepItemContext _localctx = new StepItemContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stepItem);
		int _la;
		try {
			int _alt;
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				and();
				}
				break;
			case ANYSTEP:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				anystep();
				}
				break;
			case BUT:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				but();
				}
				break;
			case DATATABLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				datatable();
				}
				break;
			case GIVEN:
				enterOuterAlt(_localctx, 5);
				{
				setState(169);
				given();
				}
				break;
			case THEN:
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				then();
				}
				break;
			case WHEN:
				enterOuterAlt(_localctx, 7);
				{
				setState(171);
				when();
				}
				break;
			case EXAMPLES:
			case TAG:
			case NL:
				enterOuterAlt(_localctx, 8);
				{
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(175);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(172);
							match(NL);
							}
							}
							setState(177);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(178);
						tagline();
						}
						} 
					}
					setState(183);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(184);
					match(NL);
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(190);
				examples();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TaglineContext extends ParserRuleContext {
		public List<TerminalNode> TAG() { return getTokens(GherkinParser.TAG); }
		public TerminalNode TAG(int i) {
			return getToken(GherkinParser.TAG, i);
		}
		public TaglineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterTagline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitTagline(this);
		}
	}

	public final TaglineContext tagline() throws RecognitionException {
		TaglineContext _localctx = new TaglineContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tagline);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(193);
					match(TAG);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(196); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(GherkinParser.AND, 0); }
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitAnd(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(AND);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnystepContext extends ParserRuleContext {
		public TerminalNode ANYSTEP() { return getToken(GherkinParser.ANYSTEP, 0); }
		public AnystepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anystep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterAnystep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitAnystep(this);
		}
	}

	public final AnystepContext anystep() throws RecognitionException {
		AnystepContext _localctx = new AnystepContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_anystep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(ANYSTEP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ButContext extends ParserRuleContext {
		public TerminalNode BUT() { return getToken(GherkinParser.BUT, 0); }
		public ButContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_but; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterBut(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitBut(this);
		}
	}

	public final ButContext but() throws RecognitionException {
		ButContext _localctx = new ButContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_but);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(BUT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatatableContext extends ParserRuleContext {
		public List<TerminalNode> DATATABLE() { return getTokens(GherkinParser.DATATABLE); }
		public TerminalNode DATATABLE(int i) {
			return getToken(GherkinParser.DATATABLE, i);
		}
		public DatatableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterDatatable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitDatatable(this);
		}
	}

	public final DatatableContext datatable() throws RecognitionException {
		DatatableContext _localctx = new DatatableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_datatable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(205); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(204);
					match(DATATABLE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(207); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GivenContext extends ParserRuleContext {
		public TerminalNode GIVEN() { return getToken(GherkinParser.GIVEN, 0); }
		public GivenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_given; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterGiven(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitGiven(this);
		}
	}

	public final GivenContext given() throws RecognitionException {
		GivenContext _localctx = new GivenContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_given);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(GIVEN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThenContext extends ParserRuleContext {
		public TerminalNode THEN() { return getToken(GherkinParser.THEN, 0); }
		public ThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitThen(this);
		}
	}

	public final ThenContext then() throws RecognitionException {
		ThenContext _localctx = new ThenContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_then);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(THEN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(GherkinParser.WHEN, 0); }
		public WhenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_when; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitWhen(this);
		}
	}

	public final WhenContext when() throws RecognitionException {
		WhenContext _localctx = new WhenContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_when);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(WHEN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExamplesContext extends ParserRuleContext {
		public TerminalNode EXAMPLES() { return getToken(GherkinParser.EXAMPLES, 0); }
		public ExamplesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_examples; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterExamples(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitExamples(this);
		}
	}

	public final ExamplesContext examples() throws RecognitionException {
		ExamplesContext _localctx = new ExamplesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_examples);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(EXAMPLES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionDescriptionContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(GherkinParser.TEXT, 0); }
		public TerminalNode PARAMETER() { return getToken(GherkinParser.PARAMETER, 0); }
		public TerminalNode AND() { return getToken(GherkinParser.AND, 0); }
		public TerminalNode ANYSTEP() { return getToken(GherkinParser.ANYSTEP, 0); }
		public TerminalNode BUT() { return getToken(GherkinParser.BUT, 0); }
		public TerminalNode GIVEN() { return getToken(GherkinParser.GIVEN, 0); }
		public TerminalNode THEN() { return getToken(GherkinParser.THEN, 0); }
		public TerminalNode WHEN() { return getToken(GherkinParser.WHEN, 0); }
		public TerminalNode SCENARIO() { return getToken(GherkinParser.SCENARIO, 0); }
		public InstructionDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterInstructionDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitInstructionDescription(this);
		}
	}

	public final InstructionDescriptionContext instructionDescription() throws RecognitionException {
		InstructionDescriptionContext _localctx = new InstructionDescriptionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_instructionDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCENARIO) | (1L << AND) | (1L << ANYSTEP) | (1L << BUT) | (1L << GIVEN) | (1L << THEN) | (1L << WHEN) | (1L << PARAMETER) | (1L << TEXT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepDescriptionContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(GherkinParser.TEXT, 0); }
		public TerminalNode PARAMETER() { return getToken(GherkinParser.PARAMETER, 0); }
		public StepDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stepDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterStepDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitStepDescription(this);
		}
	}

	public final StepDescriptionContext stepDescription() throws RecognitionException {
		StepDescriptionContext _localctx = new StepDescriptionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stepDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_la = _input.LA(1);
			if ( !(_la==PARAMETER || _la==TEXT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(GherkinParser.TEXT, 0); }
		public TerminalNode PARAMETER() { return getToken(GherkinParser.PARAMETER, 0); }
		public TerminalNode TAG() { return getToken(GherkinParser.TAG, 0); }
		public TerminalNode AND() { return getToken(GherkinParser.AND, 0); }
		public TerminalNode ANYSTEP() { return getToken(GherkinParser.ANYSTEP, 0); }
		public TerminalNode BUT() { return getToken(GherkinParser.BUT, 0); }
		public TerminalNode DATATABLE() { return getToken(GherkinParser.DATATABLE, 0); }
		public TerminalNode GIVEN() { return getToken(GherkinParser.GIVEN, 0); }
		public TerminalNode THEN() { return getToken(GherkinParser.THEN, 0); }
		public TerminalNode WHEN() { return getToken(GherkinParser.WHEN, 0); }
		public TerminalNode SCENARIO() { return getToken(GherkinParser.SCENARIO, 0); }
		public TerminalNode SCENARIOOUTLINE() { return getToken(GherkinParser.SCENARIOOUTLINE, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GherkinListener ) ((GherkinListener)listener).exitDescription(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCENARIO) | (1L << SCENARIOOUTLINE) | (1L << AND) | (1L << ANYSTEP) | (1L << BUT) | (1L << DATATABLE) | (1L << GIVEN) | (1L << THEN) | (1L << WHEN) | (1L << TAG) | (1L << PARAMETER) | (1L << TEXT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00e2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\7\2\61\n\2"+
		"\f\2\16\2\64\13\2\3\2\6\2\67\n\2\r\2\16\28\3\2\3\2\5\2=\n\2\7\2?\n\2\f"+
		"\2\16\2B\13\2\3\2\7\2E\n\2\f\2\16\2H\13\2\3\2\3\2\3\3\7\3M\n\3\f\3\16"+
		"\3P\13\3\3\3\7\3S\n\3\f\3\16\3V\13\3\3\3\7\3Y\n\3\f\3\16\3\\\13\3\3\3"+
		"\3\3\3\4\3\4\7\4b\n\4\f\4\16\4e\13\4\3\4\3\4\7\4i\n\4\f\4\16\4l\13\4\3"+
		"\4\6\4o\n\4\r\4\16\4p\3\4\3\4\7\4u\n\4\f\4\16\4x\13\4\7\4z\n\4\f\4\16"+
		"\4}\13\4\3\4\6\4\u0080\n\4\r\4\16\4\u0081\3\4\7\4\u0085\n\4\f\4\16\4\u0088"+
		"\13\4\3\4\3\4\3\4\7\4\u008d\n\4\f\4\16\4\u0090\13\4\5\4\u0092\n\4\3\5"+
		"\3\5\3\5\5\5\u0097\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\7\n\u00a3"+
		"\n\n\f\n\16\n\u00a6\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u00b0\n\13\f\13\16\13\u00b3\13\13\3\13\7\13\u00b6\n\13\f\13\16\13\u00b9"+
		"\13\13\3\13\7\13\u00bc\n\13\f\13\16\13\u00bf\13\13\3\13\5\13\u00c2\n\13"+
		"\3\f\6\f\u00c5\n\f\r\f\16\f\u00c6\3\r\3\r\3\16\3\16\3\17\3\17\3\20\6\20"+
		"\u00d0\n\20\r\20\16\20\u00d1\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,\2\5\7\2\r\r\17\21\23\25\27\27\31\31\4\2\27\27\31\31"+
		"\4\2\r\27\31\31\2\u00ed\2.\3\2\2\2\4T\3\2\2\2\6\u0091\3\2\2\2\b\u0096"+
		"\3\2\2\2\n\u0098\3\2\2\2\f\u009a\3\2\2\2\16\u009c\3\2\2\2\20\u009e\3\2"+
		"\2\2\22\u00a0\3\2\2\2\24\u00c1\3\2\2\2\26\u00c4\3\2\2\2\30\u00c8\3\2\2"+
		"\2\32\u00ca\3\2\2\2\34\u00cc\3\2\2\2\36\u00cf\3\2\2\2 \u00d3\3\2\2\2\""+
		"\u00d5\3\2\2\2$\u00d7\3\2\2\2&\u00d9\3\2\2\2(\u00db\3\2\2\2*\u00dd\3\2"+
		"\2\2,\u00df\3\2\2\2.\62\5\4\3\2/\61\5,\27\2\60/\3\2\2\2\61\64\3\2\2\2"+
		"\62\60\3\2\2\2\62\63\3\2\2\2\63@\3\2\2\2\64\62\3\2\2\2\65\67\7\30\2\2"+
		"\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29<\3\2\2\2:=\5\6\4\2;"+
		"=\5\36\20\2<:\3\2\2\2<;\3\2\2\2=?\3\2\2\2>\66\3\2\2\2?B\3\2\2\2@>\3\2"+
		"\2\2@A\3\2\2\2AF\3\2\2\2B@\3\2\2\2CE\7\30\2\2DC\3\2\2\2EH\3\2\2\2FD\3"+
		"\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7\2\2\3J\3\3\2\2\2KM\7\30\2\2L"+
		"K\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QS\5\26\f\2"+
		"RN\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UZ\3\2\2\2VT\3\2\2\2WY\7\30\2"+
		"\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\13"+
		"\2\2^\5\3\2\2\2_c\5\f\7\2`b\5,\27\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3"+
		"\2\2\2d\u0092\3\2\2\2ec\3\2\2\2fj\5\b\5\2gi\5,\27\2hg\3\2\2\2il\3\2\2"+
		"\2jh\3\2\2\2jk\3\2\2\2k{\3\2\2\2lj\3\2\2\2mo\7\30\2\2nm\3\2\2\2op\3\2"+
		"\2\2pn\3\2\2\2pq\3\2\2\2qr\3\2\2\2rv\5*\26\2su\5,\27\2ts\3\2\2\2ux\3\2"+
		"\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2\2\2xv\3\2\2\2yn\3\2\2\2z}\3\2\2\2{y\3\2"+
		"\2\2{|\3\2\2\2|\u0086\3\2\2\2}{\3\2\2\2~\u0080\7\30\2\2\177~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0085\5\22\n\2\u0084\177\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0092\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u0092\5\26\f\2\u008a\u008e\5(\25\2\u008b\u008d\5,\27\2\u008c\u008b\3"+
		"\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091_\3\2\2\2\u0091f\3\2\2\2\u0091"+
		"\u0089\3\2\2\2\u0091\u008a\3\2\2\2\u0092\7\3\2\2\2\u0093\u0097\5\n\6\2"+
		"\u0094\u0097\5\16\b\2\u0095\u0097\5\20\t\2\u0096\u0093\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0096\u0095\3\2\2\2\u0097\t\3\2\2\2\u0098\u0099\7\t\2\2\u0099"+
		"\13\3\2\2\2\u009a\u009b\7\f\2\2\u009b\r\3\2\2\2\u009c\u009d\7\r\2\2\u009d"+
		"\17\3\2\2\2\u009e\u009f\7\16\2\2\u009f\21\3\2\2\2\u00a0\u00a4\5\24\13"+
		"\2\u00a1\u00a3\5,\27\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\23\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00c2\5\30\r\2\u00a8\u00c2\5\32\16\2\u00a9\u00c2\5\34\17\2\u00aa\u00c2"+
		"\5\36\20\2\u00ab\u00c2\5 \21\2\u00ac\u00c2\5\"\22\2\u00ad\u00c2\5$\23"+
		"\2\u00ae\u00b0\7\30\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2"+
		"\2\2\u00b4\u00b6\5\26\f\2\u00b5\u00b1\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bd\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00ba\u00bc\7\30\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c2\5&\24\2\u00c1\u00a7\3\2\2\2\u00c1\u00a8\3\2\2\2\u00c1"+
		"\u00a9\3\2\2\2\u00c1\u00aa\3\2\2\2\u00c1\u00ab\3\2\2\2\u00c1\u00ac\3\2"+
		"\2\2\u00c1\u00ad\3\2\2\2\u00c1\u00b7\3\2\2\2\u00c2\25\3\2\2\2\u00c3\u00c5"+
		"\7\26\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2"+
		"\u00c6\u00c7\3\2\2\2\u00c7\27\3\2\2\2\u00c8\u00c9\7\17\2\2\u00c9\31\3"+
		"\2\2\2\u00ca\u00cb\7\20\2\2\u00cb\33\3\2\2\2\u00cc\u00cd\7\21\2\2\u00cd"+
		"\35\3\2\2\2\u00ce\u00d0\7\22\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2"+
		"\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\37\3\2\2\2\u00d3\u00d4"+
		"\7\23\2\2\u00d4!\3\2\2\2\u00d5\u00d6\7\24\2\2\u00d6#\3\2\2\2\u00d7\u00d8"+
		"\7\25\2\2\u00d8%\3\2\2\2\u00d9\u00da\7\n\2\2\u00da\'\3\2\2\2\u00db\u00dc"+
		"\t\2\2\2\u00dc)\3\2\2\2\u00dd\u00de\t\3\2\2\u00de+\3\2\2\2\u00df\u00e0"+
		"\t\4\2\2\u00e0-\3\2\2\2\33\628<@FNTZcjpv{\u0081\u0086\u008e\u0091\u0096"+
		"\u00a4\u00b1\u00b7\u00bd\u00c1\u00c6\u00d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}