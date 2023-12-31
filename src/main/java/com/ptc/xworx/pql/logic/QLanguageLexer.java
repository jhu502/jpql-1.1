// Generated from D:\SourceSpace\SpaceJPQL\JPQL-1.1.3\src\main\java\com\ptc\xworx\pql\g4\QLanguageLexer.g4 by ANTLR 4.5.3

package com.ptc.xworx.pql.logic;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, DELETE=2, UPDATE=3, INSERT=4, FROM=5, WHERE=6, GROUP=7, HAVING=8, 
		UNION=9, ALL=10, VIEW=11, VALUES=12, INTO=13, DISTINCT=14, OVER=15, PARTITION=16, 
		ORDER=17, ROWNUM=18, SET=19, BY=20, LIKE=21, IN=22, IS=23, NOT=24, NULL=25, 
		EXISTS=26, ASC=27, DESC=28, AND=29, OR=30, COMMA=31, PL=32, PR=33, BL=34, 
		BR=35, COLON=36, DOT=37, POW=38, QUOTE=39, QMARK=40, PLUS=41, MINUS=42, 
		MUL=43, DIV=44, PER=45, TRUE=46, FALSE=47, EQ=48, NE=49, GT=50, LT=51, 
		GE=52, LE=53, PARAM=54, DIGITS=55, NAMING=56, STRING=57, WS=58;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "DELETE", "UPDATE", "INSERT", "FROM", "WHERE", "GROUP", "HAVING", 
		"UNION", "ALL", "VIEW", "VALUES", "INTO", "DISTINCT", "OVER", "PARTITION", 
		"ORDER", "ROWNUM", "SET", "BY", "LIKE", "IN", "IS", "NOT", "NULL", "EXISTS", 
		"ASC", "DESC", "AND", "OR", "COMMA", "PL", "PR", "BL", "BR", "COLON", 
		"DOT", "POW", "QUOTE", "QMARK", "PLUS", "MINUS", "MUL", "DIV", "PER", 
		"TRUE", "FALSE", "EQ", "NE", "GT", "LT", "GE", "LE", "PARAM", "DIGITS", 
		"NAMING", "STRING", "ESC", "CHAR", "DIGIT", "WS", "A", "B", "C", "D", 
		"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", 
		"S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "','", "'('", "')'", "'['", 
		"']'", "':'", "'.'", "'^'", "'''", "'?'", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'true'", "'false'", "'='", "'!='", "'>'", "'<'", "'>='", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "DELETE", "UPDATE", "INSERT", "FROM", "WHERE", "GROUP", 
		"HAVING", "UNION", "ALL", "VIEW", "VALUES", "INTO", "DISTINCT", "OVER", 
		"PARTITION", "ORDER", "ROWNUM", "SET", "BY", "LIKE", "IN", "IS", "NOT", 
		"NULL", "EXISTS", "ASC", "DESC", "AND", "OR", "COMMA", "PL", "PR", "BL", 
		"BR", "COLON", "DOT", "POW", "QUOTE", "QMARK", "PLUS", "MINUS", "MUL", 
		"DIV", "PER", "TRUE", "FALSE", "EQ", "NE", "GT", "LT", "GE", "LE", "PARAM", 
		"DIGITS", "NAMING", "STRING", "WS"
	};
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


	public QLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QLanguageLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u01f7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\58\u0194\n8\38\68\u0197\n8\r8\16"+
		"8\u0198\38\38\68\u019d\n8\r8\168\u019e\58\u01a1\n8\39\39\39\39\79\u01a7"+
		"\n9\f9\169\u01aa\139\3:\3:\3:\7:\u01af\n:\f:\16:\u01b2\13:\3:\3:\3;\3"+
		";\3;\3<\3<\3=\3=\3>\6>\u01be\n>\r>\16>\u01bf\3>\3>\3?\3?\3@\3@\3A\3A\3"+
		"B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3"+
		"M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3"+
		"\u01b0\2Y\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u\2w\2y\2{<}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089"+
		"\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b"+
		"\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\u00ab\2\u00ad"+
		"\2\u00af\2\3\2 \b\2$$^^ddppttvv\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\4"+
		"\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKk"+
		"k\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2"+
		"TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\|"+
		"|\u01e3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2"+
		"m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2{\3\2\2\2\3\u00b1\3\2\2\2"+
		"\5\u00b8\3\2\2\2\7\u00bf\3\2\2\2\t\u00c6\3\2\2\2\13\u00cd\3\2\2\2\r\u00d2"+
		"\3\2\2\2\17\u00d8\3\2\2\2\21\u00de\3\2\2\2\23\u00e5\3\2\2\2\25\u00eb\3"+
		"\2\2\2\27\u00ef\3\2\2\2\31\u00f4\3\2\2\2\33\u00fb\3\2\2\2\35\u0100\3\2"+
		"\2\2\37\u0109\3\2\2\2!\u010e\3\2\2\2#\u0118\3\2\2\2%\u011e\3\2\2\2\'\u0125"+
		"\3\2\2\2)\u0129\3\2\2\2+\u012c\3\2\2\2-\u0131\3\2\2\2/\u0134\3\2\2\2\61"+
		"\u0137\3\2\2\2\63\u013b\3\2\2\2\65\u0140\3\2\2\2\67\u0147\3\2\2\29\u014b"+
		"\3\2\2\2;\u0150\3\2\2\2=\u0154\3\2\2\2?\u0157\3\2\2\2A\u0159\3\2\2\2C"+
		"\u015b\3\2\2\2E\u015d\3\2\2\2G\u015f\3\2\2\2I\u0161\3\2\2\2K\u0163\3\2"+
		"\2\2M\u0165\3\2\2\2O\u0167\3\2\2\2Q\u0169\3\2\2\2S\u016b\3\2\2\2U\u016d"+
		"\3\2\2\2W\u016f\3\2\2\2Y\u0171\3\2\2\2[\u0173\3\2\2\2]\u0175\3\2\2\2_"+
		"\u017a\3\2\2\2a\u0180\3\2\2\2c\u0182\3\2\2\2e\u0185\3\2\2\2g\u0187\3\2"+
		"\2\2i\u0189\3\2\2\2k\u018c\3\2\2\2m\u018f\3\2\2\2o\u0193\3\2\2\2q\u01a2"+
		"\3\2\2\2s\u01ab\3\2\2\2u\u01b5\3\2\2\2w\u01b8\3\2\2\2y\u01ba\3\2\2\2{"+
		"\u01bd\3\2\2\2}\u01c3\3\2\2\2\177\u01c5\3\2\2\2\u0081\u01c7\3\2\2\2\u0083"+
		"\u01c9\3\2\2\2\u0085\u01cb\3\2\2\2\u0087\u01cd\3\2\2\2\u0089\u01cf\3\2"+
		"\2\2\u008b\u01d1\3\2\2\2\u008d\u01d3\3\2\2\2\u008f\u01d5\3\2\2\2\u0091"+
		"\u01d7\3\2\2\2\u0093\u01d9\3\2\2\2\u0095\u01db\3\2\2\2\u0097\u01dd\3\2"+
		"\2\2\u0099\u01df\3\2\2\2\u009b\u01e1\3\2\2\2\u009d\u01e3\3\2\2\2\u009f"+
		"\u01e5\3\2\2\2\u00a1\u01e7\3\2\2\2\u00a3\u01e9\3\2\2\2\u00a5\u01eb\3\2"+
		"\2\2\u00a7\u01ed\3\2\2\2\u00a9\u01ef\3\2\2\2\u00ab\u01f1\3\2\2\2\u00ad"+
		"\u01f3\3\2\2\2\u00af\u01f5\3\2\2\2\u00b1\u00b2\5\u00a1Q\2\u00b2\u00b3"+
		"\5\u0085C\2\u00b3\u00b4\5\u0093J\2\u00b4\u00b5\5\u0085C\2\u00b5\u00b6"+
		"\5\u0081A\2\u00b6\u00b7\5\u00a3R\2\u00b7\4\3\2\2\2\u00b8\u00b9\5\u0083"+
		"B\2\u00b9\u00ba\5\u0085C\2\u00ba\u00bb\5\u0093J\2\u00bb\u00bc\5\u0085"+
		"C\2\u00bc\u00bd\5\u00a3R\2\u00bd\u00be\5\u0085C\2\u00be\6\3\2\2\2\u00bf"+
		"\u00c0\5\u00a5S\2\u00c0\u00c1\5\u009bN\2\u00c1\u00c2\5\u0083B\2\u00c2"+
		"\u00c3\5}?\2\u00c3\u00c4\5\u00a3R\2\u00c4\u00c5\5\u0085C\2\u00c5\b\3\2"+
		"\2\2\u00c6\u00c7\5\u008dG\2\u00c7\u00c8\5\u0097L\2\u00c8\u00c9\5\u00a1"+
		"Q\2\u00c9\u00ca\5\u0085C\2\u00ca\u00cb\5\u009fP\2\u00cb\u00cc\5\u00a3"+
		"R\2\u00cc\n\3\2\2\2\u00cd\u00ce\5\u0087D\2\u00ce\u00cf\5\u009fP\2\u00cf"+
		"\u00d0\5\u0099M\2\u00d0\u00d1\5\u0095K\2\u00d1\f\3\2\2\2\u00d2\u00d3\5"+
		"\u00a9U\2\u00d3\u00d4\5\u008bF\2\u00d4\u00d5\5\u0085C\2\u00d5\u00d6\5"+
		"\u009fP\2\u00d6\u00d7\5\u0085C\2\u00d7\16\3\2\2\2\u00d8\u00d9\5\u0089"+
		"E\2\u00d9\u00da\5\u009fP\2\u00da\u00db\5\u0099M\2\u00db\u00dc\5\u00a5"+
		"S\2\u00dc\u00dd\5\u009bN\2\u00dd\20\3\2\2\2\u00de\u00df\5\u008bF\2\u00df"+
		"\u00e0\5}?\2\u00e0\u00e1\5\u00a7T\2\u00e1\u00e2\5\u008dG\2\u00e2\u00e3"+
		"\5\u0097L\2\u00e3\u00e4\5\u0089E\2\u00e4\22\3\2\2\2\u00e5\u00e6\5\u00a5"+
		"S\2\u00e6\u00e7\5\u0097L\2\u00e7\u00e8\5\u008dG\2\u00e8\u00e9\5\u0099"+
		"M\2\u00e9\u00ea\5\u0097L\2\u00ea\24\3\2\2\2\u00eb\u00ec\5}?\2\u00ec\u00ed"+
		"\5\u0093J\2\u00ed\u00ee\5\u0093J\2\u00ee\26\3\2\2\2\u00ef\u00f0\5\u00a7"+
		"T\2\u00f0\u00f1\5\u008dG\2\u00f1\u00f2\5\u0085C\2\u00f2\u00f3\5\u00a9"+
		"U\2\u00f3\30\3\2\2\2\u00f4\u00f5\5\u00a7T\2\u00f5\u00f6\5}?\2\u00f6\u00f7"+
		"\5\u0093J\2\u00f7\u00f8\5\u00a5S\2\u00f8\u00f9\5\u0085C\2\u00f9\u00fa"+
		"\5\u00a1Q\2\u00fa\32\3\2\2\2\u00fb\u00fc\5\u008dG\2\u00fc\u00fd\5\u0097"+
		"L\2\u00fd\u00fe\5\u00a3R\2\u00fe\u00ff\5\u0099M\2\u00ff\34\3\2\2\2\u0100"+
		"\u0101\5\u0083B\2\u0101\u0102\5\u008dG\2\u0102\u0103\5\u00a1Q\2\u0103"+
		"\u0104\5\u00a3R\2\u0104\u0105\5\u008dG\2\u0105\u0106\5\u0097L\2\u0106"+
		"\u0107\5\u0081A\2\u0107\u0108\5\u00a3R\2\u0108\36\3\2\2\2\u0109\u010a"+
		"\5\u0099M\2\u010a\u010b\5\u00a7T\2\u010b\u010c\5\u0085C\2\u010c\u010d"+
		"\5\u009fP\2\u010d \3\2\2\2\u010e\u010f\5\u009bN\2\u010f\u0110\5}?\2\u0110"+
		"\u0111\5\u009fP\2\u0111\u0112\5\u00a3R\2\u0112\u0113\5\u008dG\2\u0113"+
		"\u0114\5\u00a3R\2\u0114\u0115\5\u008dG\2\u0115\u0116\5\u0099M\2\u0116"+
		"\u0117\5\u0097L\2\u0117\"\3\2\2\2\u0118\u0119\5\u0099M\2\u0119\u011a\5"+
		"\u009fP\2\u011a\u011b\5\u0083B\2\u011b\u011c\5\u0085C\2\u011c\u011d\5"+
		"\u009fP\2\u011d$\3\2\2\2\u011e\u011f\5\u009fP\2\u011f\u0120\5\u0099M\2"+
		"\u0120\u0121\5\u00a9U\2\u0121\u0122\5\u0097L\2\u0122\u0123\5\u00a5S\2"+
		"\u0123\u0124\5\u0095K\2\u0124&\3\2\2\2\u0125\u0126\5\u00a1Q\2\u0126\u0127"+
		"\5\u0085C\2\u0127\u0128\5\u00a3R\2\u0128(\3\2\2\2\u0129\u012a\5\177@\2"+
		"\u012a\u012b\5\u00adW\2\u012b*\3\2\2\2\u012c\u012d\5\u0093J\2\u012d\u012e"+
		"\5\u008dG\2\u012e\u012f\5\u0091I\2\u012f\u0130\5\u0085C\2\u0130,\3\2\2"+
		"\2\u0131\u0132\5\u008dG\2\u0132\u0133\5\u0097L\2\u0133.\3\2\2\2\u0134"+
		"\u0135\5\u008dG\2\u0135\u0136\5\u00a1Q\2\u0136\60\3\2\2\2\u0137\u0138"+
		"\5\u0097L\2\u0138\u0139\5\u0099M\2\u0139\u013a\5\u00a3R\2\u013a\62\3\2"+
		"\2\2\u013b\u013c\5\u0097L\2\u013c\u013d\5\u00a5S\2\u013d\u013e\5\u0093"+
		"J\2\u013e\u013f\5\u0093J\2\u013f\64\3\2\2\2\u0140\u0141\5\u0085C\2\u0141"+
		"\u0142\5\u00abV\2\u0142\u0143\5\u008dG\2\u0143\u0144\5\u00a1Q\2\u0144"+
		"\u0145\5\u00a3R\2\u0145\u0146\5\u00a1Q\2\u0146\66\3\2\2\2\u0147\u0148"+
		"\5}?\2\u0148\u0149\5\u00a1Q\2\u0149\u014a\5\u0081A\2\u014a8\3\2\2\2\u014b"+
		"\u014c\5\u0083B\2\u014c\u014d\5\u0085C\2\u014d\u014e\5\u00a1Q\2\u014e"+
		"\u014f\5\u0081A\2\u014f:\3\2\2\2\u0150\u0151\5}?\2\u0151\u0152\5\u0097"+
		"L\2\u0152\u0153\5\u0083B\2\u0153<\3\2\2\2\u0154\u0155\5\u0099M\2\u0155"+
		"\u0156\5\u009fP\2\u0156>\3\2\2\2\u0157\u0158\7.\2\2\u0158@\3\2\2\2\u0159"+
		"\u015a\7*\2\2\u015aB\3\2\2\2\u015b\u015c\7+\2\2\u015cD\3\2\2\2\u015d\u015e"+
		"\7]\2\2\u015eF\3\2\2\2\u015f\u0160\7_\2\2\u0160H\3\2\2\2\u0161\u0162\7"+
		"<\2\2\u0162J\3\2\2\2\u0163\u0164\7\60\2\2\u0164L\3\2\2\2\u0165\u0166\7"+
		"`\2\2\u0166N\3\2\2\2\u0167\u0168\7)\2\2\u0168P\3\2\2\2\u0169\u016a\7A"+
		"\2\2\u016aR\3\2\2\2\u016b\u016c\7-\2\2\u016cT\3\2\2\2\u016d\u016e\7/\2"+
		"\2\u016eV\3\2\2\2\u016f\u0170\7,\2\2\u0170X\3\2\2\2\u0171\u0172\7\61\2"+
		"\2\u0172Z\3\2\2\2\u0173\u0174\7\'\2\2\u0174\\\3\2\2\2\u0175\u0176\7v\2"+
		"\2\u0176\u0177\7t\2\2\u0177\u0178\7w\2\2\u0178\u0179\7g\2\2\u0179^\3\2"+
		"\2\2\u017a\u017b\7h\2\2\u017b\u017c\7c\2\2\u017c\u017d\7n\2\2\u017d\u017e"+
		"\7u\2\2\u017e\u017f\7g\2\2\u017f`\3\2\2\2\u0180\u0181\7?\2\2\u0181b\3"+
		"\2\2\2\u0182\u0183\7#\2\2\u0183\u0184\7?\2\2\u0184d\3\2\2\2\u0185\u0186"+
		"\7@\2\2\u0186f\3\2\2\2\u0187\u0188\7>\2\2\u0188h\3\2\2\2\u0189\u018a\7"+
		"@\2\2\u018a\u018b\7?\2\2\u018bj\3\2\2\2\u018c\u018d\7>\2\2\u018d\u018e"+
		"\7?\2\2\u018el\3\2\2\2\u018f\u0190\7&\2\2\u0190\u0191\5q9\2\u0191n\3\2"+
		"\2\2\u0192\u0194\7/\2\2\u0193\u0192\3\2\2\2\u0193\u0194\3\2\2\2\u0194"+
		"\u0196\3\2\2\2\u0195\u0197\5y=\2\u0196\u0195\3\2\2\2\u0197\u0198\3\2\2"+
		"\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u01a0\3\2\2\2\u019a\u019c"+
		"\7\60\2\2\u019b\u019d\5y=\2\u019c\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a1\3\2\2\2\u01a0\u019a\3\2"+
		"\2\2\u01a0\u01a1\3\2\2\2\u01a1p\3\2\2\2\u01a2\u01a8\5w<\2\u01a3\u01a7"+
		"\5w<\2\u01a4\u01a7\5y=\2\u01a5\u01a7\7a\2\2\u01a6\u01a3\3\2\2\2\u01a6"+
		"\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8\u01a6\3\2"+
		"\2\2\u01a8\u01a9\3\2\2\2\u01a9r\3\2\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01b0"+
		"\7)\2\2\u01ac\u01af\5u;\2\u01ad\u01af\13\2\2\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01ad\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b0\u01ae\3\2"+
		"\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4\7)\2\2\u01b4"+
		"t\3\2\2\2\u01b5\u01b6\7^\2\2\u01b6\u01b7\t\2\2\2\u01b7v\3\2\2\2\u01b8"+
		"\u01b9\t\3\2\2\u01b9x\3\2\2\2\u01ba\u01bb\t\4\2\2\u01bbz\3\2\2\2\u01bc"+
		"\u01be\t\5\2\2\u01bd\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01bd\3\2"+
		"\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\b>\2\2\u01c2"+
		"|\3\2\2\2\u01c3\u01c4\t\6\2\2\u01c4~\3\2\2\2\u01c5\u01c6\t\7\2\2\u01c6"+
		"\u0080\3\2\2\2\u01c7\u01c8\t\b\2\2\u01c8\u0082\3\2\2\2\u01c9\u01ca\t\t"+
		"\2\2\u01ca\u0084\3\2\2\2\u01cb\u01cc\t\n\2\2\u01cc\u0086\3\2\2\2\u01cd"+
		"\u01ce\t\13\2\2\u01ce\u0088\3\2\2\2\u01cf\u01d0\t\f\2\2\u01d0\u008a\3"+
		"\2\2\2\u01d1\u01d2\t\r\2\2\u01d2\u008c\3\2\2\2\u01d3\u01d4\t\16\2\2\u01d4"+
		"\u008e\3\2\2\2\u01d5\u01d6\t\17\2\2\u01d6\u0090\3\2\2\2\u01d7\u01d8\t"+
		"\20\2\2\u01d8\u0092\3\2\2\2\u01d9\u01da\t\21\2\2\u01da\u0094\3\2\2\2\u01db"+
		"\u01dc\t\22\2\2\u01dc\u0096\3\2\2\2\u01dd\u01de\t\23\2\2\u01de\u0098\3"+
		"\2\2\2\u01df\u01e0\t\24\2\2\u01e0\u009a\3\2\2\2\u01e1\u01e2\t\25\2\2\u01e2"+
		"\u009c\3\2\2\2\u01e3\u01e4\t\26\2\2\u01e4\u009e\3\2\2\2\u01e5\u01e6\t"+
		"\27\2\2\u01e6\u00a0\3\2\2\2\u01e7\u01e8\t\30\2\2\u01e8\u00a2\3\2\2\2\u01e9"+
		"\u01ea\t\31\2\2\u01ea\u00a4\3\2\2\2\u01eb\u01ec\t\32\2\2\u01ec\u00a6\3"+
		"\2\2\2\u01ed\u01ee\t\33\2\2\u01ee\u00a8\3\2\2\2\u01ef\u01f0\t\34\2\2\u01f0"+
		"\u00aa\3\2\2\2\u01f1\u01f2\t\35\2\2\u01f2\u00ac\3\2\2\2\u01f3\u01f4\t"+
		"\36\2\2\u01f4\u00ae\3\2\2\2\u01f5\u01f6\t\37\2\2\u01f6\u00b0\3\2\2\2\f"+
		"\2\u0193\u0198\u019e\u01a0\u01a6\u01a8\u01ae\u01b0\u01bf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}