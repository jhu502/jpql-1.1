// Generated from D:\SourceSpace\SpaceJPQL\JPQL-1.1.3\src\main\java\com\ptc\xworx\pql\g4\QLanguageParser.g4 by ANTLR 4.5.3

package com.ptc.xworx.pql.logic;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QLanguageParser extends Parser {
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
	public static final int
		RULE_startPQLStatement = 0, RULE_selectStatement = 1, RULE_deleteStatement = 2, 
		RULE_updateStatement = 3, RULE_insertStatement = 4, RULE_selectClause = 5, 
		RULE_insertClause = 6, RULE_updateClause = 7, RULE_deleteClause = 8, RULE_valuesClause = 9, 
		RULE_fromClause = 10, RULE_whereClause = 11, RULE_setClause = 12, RULE_groupClause = 13, 
		RULE_havingClause = 14, RULE_orderClause = 15, RULE_partitionClause = 16, 
		RULE_fieldItem = 17, RULE_constItem = 18, RULE_objectItem = 19, RULE_funcItem = 20, 
		RULE_overItem = 21, RULE_orderItem = 22, RULE_tableFrom = 23, RULE_viewFrom = 24, 
		RULE_classFrom = 25, RULE_queryFrom = 26, RULE_subQuery = 27, RULE_xCondition = 28, 
		RULE_condition = 29, RULE_xComplex = 30, RULE_complex = 31, RULE_argument = 32, 
		RULE_function = 33, RULE_field = 34, RULE_xField = 35, RULE_parameter = 36, 
		RULE_xParameter = 37, RULE_param = 38, RULE_rParameter = 39, RULE_masterAtt = 40, 
		RULE_className = 41, RULE_property = 42, RULE_array = 43, RULE_pack = 44, 
		RULE_compOp = 45, RULE_mathOp = 46, RULE_logicOp = 47, RULE_constant = 48, 
		RULE_bool = 49, RULE_sorts = 50, RULE_union = 51, RULE_like = 52, RULE_in = 53, 
		RULE_insert = 54, RULE_partitionBy = 55, RULE_groupBy = 56, RULE_orderBy = 57, 
		RULE_select = 58, RULE_update = 59, RULE_delete = 60, RULE_from = 61, 
		RULE_where = 62, RULE_values = 63, RULE_distinct = 64, RULE_over = 65, 
		RULE_view = 66, RULE_nil = 67, RULE_dot = 68, RULE_rowNum = 69, RULE_qMark = 70, 
		RULE_colon = 71, RULE_comma = 72, RULE_funcName = 73, RULE_tableName = 74, 
		RULE_having = 75, RULE_column = 76, RULE_alias = 77;
	public static final String[] ruleNames = {
		"startPQLStatement", "selectStatement", "deleteStatement", "updateStatement", 
		"insertStatement", "selectClause", "insertClause", "updateClause", "deleteClause", 
		"valuesClause", "fromClause", "whereClause", "setClause", "groupClause", 
		"havingClause", "orderClause", "partitionClause", "fieldItem", "constItem", 
		"objectItem", "funcItem", "overItem", "orderItem", "tableFrom", "viewFrom", 
		"classFrom", "queryFrom", "subQuery", "xCondition", "condition", "xComplex", 
		"complex", "argument", "function", "field", "xField", "parameter", "xParameter", 
		"param", "rParameter", "masterAtt", "className", "property", "array", 
		"pack", "compOp", "mathOp", "logicOp", "constant", "bool", "sorts", "union", 
		"like", "in", "insert", "partitionBy", "groupBy", "orderBy", "select", 
		"update", "delete", "from", "where", "values", "distinct", "over", "view", 
		"nil", "dot", "rowNum", "qMark", "colon", "comma", "funcName", "tableName", 
		"having", "column", "alias"
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

	@Override
	public String getGrammarFileName() { return "QLanguageParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartPQLStatementContext extends ParserRuleContext {
		public List<SelectStatementContext> selectStatement() {
			return getRuleContexts(SelectStatementContext.class);
		}
		public SelectStatementContext selectStatement(int i) {
			return getRuleContext(SelectStatementContext.class,i);
		}
		public List<UnionContext> union() {
			return getRuleContexts(UnionContext.class);
		}
		public UnionContext union(int i) {
			return getRuleContext(UnionContext.class,i);
		}
		public DeleteStatementContext deleteStatement() {
			return getRuleContext(DeleteStatementContext.class,0);
		}
		public UpdateStatementContext updateStatement() {
			return getRuleContext(UpdateStatementContext.class,0);
		}
		public InsertStatementContext insertStatement() {
			return getRuleContext(InsertStatementContext.class,0);
		}
		public StartPQLStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startPQLStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterStartPQLStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitStartPQLStatement(this);
		}
	}

	public final StartPQLStatementContext startPQLStatement() throws RecognitionException {
		StartPQLStatementContext _localctx = new StartPQLStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_startPQLStatement);
		int _la;
		try {
			setState(168);
			switch (_input.LA(1)) {
			case SELECT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(156);
				selectStatement();
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==UNION) {
					{
					{
					setState(157);
					union();
					setState(158);
					selectStatement();
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case DELETE:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				deleteStatement();
				}
				break;
			case UPDATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				updateStatement();
				}
				break;
			case INSERT:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				insertStatement();
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

	public static class SelectStatementContext extends ParserRuleContext {
		public SelectClauseContext selectClause() {
			return getRuleContext(SelectClauseContext.class,0);
		}
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public GroupClauseContext groupClause() {
			return getRuleContext(GroupClauseContext.class,0);
		}
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public HavingClauseContext havingClause() {
			return getRuleContext(HavingClauseContext.class,0);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitSelectStatement(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			selectClause();
			setState(171);
			fromClause();
			setState(173);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(172);
				whereClause();
				}
			}

			setState(179);
			_la = _input.LA(1);
			if (_la==GROUP) {
				{
				setState(175);
				groupClause();
				setState(177);
				_la = _input.LA(1);
				if (_la==HAVING) {
					{
					setState(176);
					havingClause();
					}
				}

				}
			}

			setState(182);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(181);
				orderClause();
				}
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

	public static class DeleteStatementContext extends ParserRuleContext {
		public DeleteClauseContext deleteClause() {
			return getRuleContext(DeleteClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public DeleteStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterDeleteStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitDeleteStatement(this);
		}
	}

	public final DeleteStatementContext deleteStatement() throws RecognitionException {
		DeleteStatementContext _localctx = new DeleteStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_deleteStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			deleteClause();
			setState(186);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(185);
				whereClause();
				}
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

	public static class UpdateStatementContext extends ParserRuleContext {
		public UpdateClauseContext updateClause() {
			return getRuleContext(UpdateClauseContext.class,0);
		}
		public SetClauseContext setClause() {
			return getRuleContext(SetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public UpdateStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterUpdateStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitUpdateStatement(this);
		}
	}

	public final UpdateStatementContext updateStatement() throws RecognitionException {
		UpdateStatementContext _localctx = new UpdateStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_updateStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			updateClause();
			setState(189);
			setClause();
			setState(191);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(190);
				whereClause();
				}
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

	public static class InsertStatementContext extends ParserRuleContext {
		public InsertClauseContext insertClause() {
			return getRuleContext(InsertClauseContext.class,0);
		}
		public ValuesClauseContext valuesClause() {
			return getRuleContext(ValuesClauseContext.class,0);
		}
		public InsertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterInsertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitInsertStatement(this);
		}
	}

	public final InsertStatementContext insertStatement() throws RecognitionException {
		InsertStatementContext _localctx = new InsertStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_insertStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			insertClause();
			setState(194);
			valuesClause();
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

	public static class SelectClauseContext extends ParserRuleContext {
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public List<FieldItemContext> fieldItem() {
			return getRuleContexts(FieldItemContext.class);
		}
		public FieldItemContext fieldItem(int i) {
			return getRuleContext(FieldItemContext.class,i);
		}
		public List<ConstItemContext> constItem() {
			return getRuleContexts(ConstItemContext.class);
		}
		public ConstItemContext constItem(int i) {
			return getRuleContext(ConstItemContext.class,i);
		}
		public List<ObjectItemContext> objectItem() {
			return getRuleContexts(ObjectItemContext.class);
		}
		public ObjectItemContext objectItem(int i) {
			return getRuleContext(ObjectItemContext.class,i);
		}
		public List<FuncItemContext> funcItem() {
			return getRuleContexts(FuncItemContext.class);
		}
		public FuncItemContext funcItem(int i) {
			return getRuleContext(FuncItemContext.class,i);
		}
		public List<OverItemContext> overItem() {
			return getRuleContexts(OverItemContext.class);
		}
		public OverItemContext overItem(int i) {
			return getRuleContext(OverItemContext.class,i);
		}
		public DistinctContext distinct() {
			return getRuleContext(DistinctContext.class,0);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public SelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitSelectClause(this);
		}
	}

	public final SelectClauseContext selectClause() throws RecognitionException {
		SelectClauseContext _localctx = new SelectClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selectClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			select();
			setState(198);
			_la = _input.LA(1);
			if (_la==DISTINCT) {
				{
				setState(197);
				distinct();
				}
			}

			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(200);
				fieldItem();
				}
				break;
			case 2:
				{
				setState(201);
				constItem();
				}
				break;
			case 3:
				{
				setState(202);
				objectItem();
				}
				break;
			case 4:
				{
				setState(203);
				funcItem();
				}
				break;
			case 5:
				{
				setState(204);
				overItem();
				}
				break;
			}
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(207);
				comma();
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(208);
					fieldItem();
					}
					break;
				case 2:
					{
					setState(209);
					constItem();
					}
					break;
				case 3:
					{
					setState(210);
					objectItem();
					}
					break;
				case 4:
					{
					setState(211);
					funcItem();
					}
					break;
				case 5:
					{
					setState(212);
					overItem();
					}
					break;
				}
				}
				}
				setState(219);
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

	public static class InsertClauseContext extends ParserRuleContext {
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode PL() { return getToken(QLanguageParser.PL, 0); }
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public TerminalNode PR() { return getToken(QLanguageParser.PR, 0); }
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public InsertClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterInsertClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitInsertClause(this);
		}
	}

	public final InsertClauseContext insertClause() throws RecognitionException {
		InsertClauseContext _localctx = new InsertClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_insertClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			insert();
			setState(221);
			tableName();
			setState(234);
			_la = _input.LA(1);
			if (_la==PL) {
				{
				setState(222);
				match(PL);
				setState(223);
				column();
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(224);
					comma();
					setState(225);
					column();
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(232);
				match(PR);
				}
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

	public static class UpdateClauseContext extends ParserRuleContext {
		public UpdateContext update() {
			return getRuleContext(UpdateContext.class,0);
		}
		public TableFromContext tableFrom() {
			return getRuleContext(TableFromContext.class,0);
		}
		public UpdateClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterUpdateClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitUpdateClause(this);
		}
	}

	public final UpdateClauseContext updateClause() throws RecognitionException {
		UpdateClauseContext _localctx = new UpdateClauseContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_updateClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			update();
			setState(237);
			tableFrom();
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

	public static class DeleteClauseContext extends ParserRuleContext {
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public TableFromContext tableFrom() {
			return getRuleContext(TableFromContext.class,0);
		}
		public DeleteClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterDeleteClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitDeleteClause(this);
		}
	}

	public final DeleteClauseContext deleteClause() throws RecognitionException {
		DeleteClauseContext _localctx = new DeleteClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_deleteClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			delete();
			setState(240);
			tableFrom();
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

	public static class ValuesClauseContext extends ParserRuleContext {
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public TerminalNode PL() { return getToken(QLanguageParser.PL, 0); }
		public TerminalNode PR() { return getToken(QLanguageParser.PR, 0); }
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public ValuesClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuesClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterValuesClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitValuesClause(this);
		}
	}

	public final ValuesClauseContext valuesClause() throws RecognitionException {
		ValuesClauseContext _localctx = new ValuesClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_valuesClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			values();
			{
			setState(243);
			match(PL);
			setState(246);
			switch (_input.LA(1)) {
			case DIGITS:
			case STRING:
				{
				setState(244);
				constant();
				}
				break;
			case NAMING:
				{
				setState(245);
				function();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(248);
				comma();
				setState(251);
				switch (_input.LA(1)) {
				case DIGITS:
				case STRING:
					{
					setState(249);
					constant();
					}
					break;
				case NAMING:
					{
					setState(250);
					function();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
			match(PR);
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

	public static class FromClauseContext extends ParserRuleContext {
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public List<TableFromContext> tableFrom() {
			return getRuleContexts(TableFromContext.class);
		}
		public TableFromContext tableFrom(int i) {
			return getRuleContext(TableFromContext.class,i);
		}
		public List<ClassFromContext> classFrom() {
			return getRuleContexts(ClassFromContext.class);
		}
		public ClassFromContext classFrom(int i) {
			return getRuleContext(ClassFromContext.class,i);
		}
		public List<QueryFromContext> queryFrom() {
			return getRuleContexts(QueryFromContext.class);
		}
		public QueryFromContext queryFrom(int i) {
			return getRuleContext(QueryFromContext.class,i);
		}
		public List<ViewFromContext> viewFrom() {
			return getRuleContexts(ViewFromContext.class);
		}
		public ViewFromContext viewFrom(int i) {
			return getRuleContext(ViewFromContext.class,i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitFromClause(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			from();
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(261);
				tableFrom();
				}
				break;
			case 2:
				{
				setState(262);
				classFrom();
				}
				break;
			case 3:
				{
				setState(263);
				queryFrom();
				}
				break;
			case 4:
				{
				setState(264);
				viewFrom();
				}
				break;
			}
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(267);
				comma();
				setState(272);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(268);
					tableFrom();
					}
					break;
				case 2:
					{
					setState(269);
					classFrom();
					}
					break;
				case 3:
					{
					setState(270);
					queryFrom();
					}
					break;
				case 4:
					{
					setState(271);
					viewFrom();
					}
					break;
				}
				}
				}
				setState(278);
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

	public static class WhereClauseContext extends ParserRuleContext {
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ComplexContext complex() {
			return getRuleContext(ComplexContext.class,0);
		}
		public List<XParameterContext> xParameter() {
			return getRuleContexts(XParameterContext.class);
		}
		public XParameterContext xParameter(int i) {
			return getRuleContext(XParameterContext.class,i);
		}
		public List<XConditionContext> xCondition() {
			return getRuleContexts(XConditionContext.class);
		}
		public XConditionContext xCondition(int i) {
			return getRuleContext(XConditionContext.class,i);
		}
		public List<XComplexContext> xComplex() {
			return getRuleContexts(XComplexContext.class);
		}
		public XComplexContext xComplex(int i) {
			return getRuleContext(XComplexContext.class,i);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whereClause);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			where();
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				{
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PARAM) {
					{
					{
					setState(280);
					xParameter();
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(286);
				condition();
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(287);
						xCondition();
						}
						} 
					}
					setState(292);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND || _la==OR) {
					{
					{
					setState(293);
					xComplex();
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 2:
				{
				{
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PARAM) {
					{
					{
					setState(299);
					xParameter();
					}
					}
					setState(304);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(305);
				condition();
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(306);
						xComplex();
						}
						} 
					}
					setState(311);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND || _la==OR) {
					{
					{
					setState(312);
					xCondition();
					}
					}
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 3:
				{
				{
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PARAM) {
					{
					{
					setState(318);
					xParameter();
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(324);
				complex();
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(325);
						xCondition();
						}
						} 
					}
					setState(330);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND || _la==OR) {
					{
					{
					setState(331);
					xComplex();
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 4:
				{
				{
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PARAM) {
					{
					{
					setState(337);
					xParameter();
					}
					}
					setState(342);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(343);
				complex();
				setState(347);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(344);
						xComplex();
						}
						} 
					}
					setState(349);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND || _la==OR) {
					{
					{
					setState(350);
					xCondition();
					}
					}
					setState(355);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 5:
				{
				setState(356);
				parameter();
				}
				break;
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

	public static class SetClauseContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(QLanguageParser.SET, 0); }
		public SetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterSetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitSetClause(this);
		}
	}

	public final SetClauseContext setClause() throws RecognitionException {
		SetClauseContext _localctx = new SetClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_setClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(SET);
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

	public static class GroupClauseContext extends ParserRuleContext {
		public GroupByContext groupBy() {
			return getRuleContext(GroupByContext.class,0);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public GroupClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterGroupClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitGroupClause(this);
		}
	}

	public final GroupClauseContext groupClause() throws RecognitionException {
		GroupClauseContext _localctx = new GroupClauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_groupClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			groupBy();
			setState(362);
			field();
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(363);
				comma();
				setState(364);
				field();
				}
				}
				setState(370);
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

	public static class HavingClauseContext extends ParserRuleContext {
		public HavingContext having() {
			return getRuleContext(HavingContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public HavingClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_havingClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterHavingClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitHavingClause(this);
		}
	}

	public final HavingClauseContext havingClause() throws RecognitionException {
		HavingClauseContext _localctx = new HavingClauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_havingClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			having();
			setState(380);
			switch (_input.LA(1)) {
			case NAMING:
				{
				{
				setState(372);
				function();
				setState(373);
				compOp();
				setState(374);
				constant();
				}
				}
				break;
			case DIGITS:
			case STRING:
				{
				{
				setState(376);
				constant();
				setState(377);
				compOp();
				setState(378);
				function();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class OrderClauseContext extends ParserRuleContext {
		public OrderByContext orderBy() {
			return getRuleContext(OrderByContext.class,0);
		}
		public List<OrderItemContext> orderItem() {
			return getRuleContexts(OrderItemContext.class);
		}
		public OrderItemContext orderItem(int i) {
			return getRuleContext(OrderItemContext.class,i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public OrderClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterOrderClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitOrderClause(this);
		}
	}

	public final OrderClauseContext orderClause() throws RecognitionException {
		OrderClauseContext _localctx = new OrderClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_orderClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			orderBy();
			setState(383);
			orderItem();
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(384);
				comma();
				setState(385);
				orderItem();
				}
				}
				setState(391);
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

	public static class PartitionClauseContext extends ParserRuleContext {
		public PartitionByContext partitionBy() {
			return getRuleContext(PartitionByContext.class,0);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public PartitionClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterPartitionClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitPartitionClause(this);
		}
	}

	public final PartitionClauseContext partitionClause() throws RecognitionException {
		PartitionClauseContext _localctx = new PartitionClauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_partitionClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			partitionBy();
			setState(393);
			field();
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(394);
				comma();
				setState(395);
				field();
				}
				}
				setState(401);
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

	public static class FieldItemContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public FieldItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterFieldItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitFieldItem(this);
		}
	}

	public final FieldItemContext fieldItem() throws RecognitionException {
		FieldItemContext _localctx = new FieldItemContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_fieldItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			field();
			setState(404);
			_la = _input.LA(1);
			if (_la==NAMING) {
				{
				setState(403);
				alias();
				}
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

	public static class ConstItemContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public ConstItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterConstItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitConstItem(this);
		}
	}

	public final ConstItemContext constItem() throws RecognitionException {
		ConstItemContext _localctx = new ConstItemContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			constant();
			setState(408);
			_la = _input.LA(1);
			if (_la==NAMING) {
				{
				setState(407);
				alias();
				}
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

	public static class ObjectItemContext extends ParserRuleContext {
		public TerminalNode NAMING() { return getToken(QLanguageParser.NAMING, 0); }
		public ObjectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterObjectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitObjectItem(this);
		}
	}

	public final ObjectItemContext objectItem() throws RecognitionException {
		ObjectItemContext _localctx = new ObjectItemContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_objectItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(NAMING);
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

	public static class FuncItemContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public FuncItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterFuncItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitFuncItem(this);
		}
	}

	public final FuncItemContext funcItem() throws RecognitionException {
		FuncItemContext _localctx = new FuncItemContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funcItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			function();
			setState(414);
			_la = _input.LA(1);
			if (_la==NAMING) {
				{
				setState(413);
				alias();
				}
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

	public static class OverItemContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public OverContext over() {
			return getRuleContext(OverContext.class,0);
		}
		public TerminalNode PL() { return getToken(QLanguageParser.PL, 0); }
		public TerminalNode PR() { return getToken(QLanguageParser.PR, 0); }
		public PartitionClauseContext partitionClause() {
			return getRuleContext(PartitionClauseContext.class,0);
		}
		public OrderClauseContext orderClause() {
			return getRuleContext(OrderClauseContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public OverItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_overItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterOverItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitOverItem(this);
		}
	}

	public final OverItemContext overItem() throws RecognitionException {
		OverItemContext _localctx = new OverItemContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_overItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			function();
			setState(417);
			over();
			setState(418);
			match(PL);
			setState(424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(419);
				partitionClause();
				}
				break;
			case 2:
				{
				setState(420);
				orderClause();
				}
				break;
			case 3:
				{
				{
				setState(421);
				partitionClause();
				setState(422);
				orderClause();
				}
				}
				break;
			}
			setState(426);
			match(PR);
			setState(428);
			_la = _input.LA(1);
			if (_la==NAMING) {
				{
				setState(427);
				alias();
				}
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

	public static class OrderItemContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public SortsContext sorts() {
			return getRuleContext(SortsContext.class,0);
		}
		public OrderItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterOrderItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitOrderItem(this);
		}
	}

	public final OrderItemContext orderItem() throws RecognitionException {
		OrderItemContext _localctx = new OrderItemContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_orderItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			field();
			setState(432);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(431);
				sorts();
				}
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

	public static class TableFromContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public TableFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableFrom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterTableFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitTableFrom(this);
		}
	}

	public final TableFromContext tableFrom() throws RecognitionException {
		TableFromContext _localctx = new TableFromContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_tableFrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			tableName();
			setState(435);
			alias();
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

	public static class ViewFromContext extends ParserRuleContext {
		public ViewContext view() {
			return getRuleContext(ViewContext.class,0);
		}
		public ColonContext colon() {
			return getRuleContext(ColonContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public ViewFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewFrom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterViewFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitViewFrom(this);
		}
	}

	public final ViewFromContext viewFrom() throws RecognitionException {
		ViewFromContext _localctx = new ViewFromContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_viewFrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			view();
			setState(438);
			colon();
			setState(439);
			tableName();
			setState(440);
			alias();
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

	public static class ClassFromContext extends ParserRuleContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public ClassFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classFrom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterClassFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitClassFrom(this);
		}
	}

	public final ClassFromContext classFrom() throws RecognitionException {
		ClassFromContext _localctx = new ClassFromContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_classFrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			className();
			setState(443);
			alias();
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

	public static class QueryFromContext extends ParserRuleContext {
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public TerminalNode PL() { return getToken(QLanguageParser.PL, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode PR() { return getToken(QLanguageParser.PR, 0); }
		public QueryFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryFrom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterQueryFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitQueryFrom(this);
		}
	}

	public final QueryFromContext queryFrom() throws RecognitionException {
		QueryFromContext _localctx = new QueryFromContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_queryFrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(445);
			match(PL);
			setState(446);
			selectStatement();
			setState(447);
			match(PR);
			}
			setState(449);
			alias();
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

	public static class SubQueryContext extends ParserRuleContext {
		public TerminalNode PL() { return getToken(QLanguageParser.PL, 0); }
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public TerminalNode PR() { return getToken(QLanguageParser.PR, 0); }
		public SubQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterSubQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitSubQuery(this);
		}
	}

	public final SubQueryContext subQuery() throws RecognitionException {
		SubQueryContext _localctx = new SubQueryContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_subQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(451);
			match(PL);
			setState(452);
			selectStatement();
			setState(453);
			match(PR);
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

	public static class XConditionContext extends ParserRuleContext {
		public LogicOpContext logicOp() {
			return getRuleContext(LogicOpContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public XConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterXCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitXCondition(this);
		}
	}

	public final XConditionContext xCondition() throws RecognitionException {
		XConditionContext _localctx = new XConditionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_xCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			logicOp();
			setState(456);
			condition();
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

	public static class ConditionContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public QMarkContext qMark() {
			return getRuleContext(QMarkContext.class,0);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public InContext in() {
			return getRuleContext(InContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public LikeContext like() {
			return getRuleContext(LikeContext.class,0);
		}
		public NilContext nil() {
			return getRuleContext(NilContext.class,0);
		}
		public TerminalNode EQ() { return getToken(QLanguageParser.EQ, 0); }
		public TerminalNode NE() { return getToken(QLanguageParser.NE, 0); }
		public XFieldContext xField() {
			return getRuleContext(XFieldContext.class,0);
		}
		public RowNumContext rowNum() {
			return getRuleContext(RowNumContext.class,0);
		}
		public SubQueryContext subQuery() {
			return getRuleContext(SubQueryContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_condition);
		int _la;
		try {
			setState(558);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(458);
				field();
				setState(459);
				compOp();
				setState(460);
				field();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(462);
				field();
				setState(463);
				compOp();
				setState(464);
				constant();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(466);
				field();
				setState(467);
				compOp();
				setState(468);
				function();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(470);
				field();
				setState(471);
				compOp();
				setState(472);
				qMark();
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(474);
				field();
				setState(475);
				compOp();
				setState(476);
				argument();
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(478);
				field();
				setState(479);
				in();
				setState(480);
				array();
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(482);
				field();
				setState(483);
				in();
				setState(484);
				argument();
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				{
				setState(486);
				field();
				setState(487);
				like();
				setState(488);
				constant();
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(490);
				field();
				setState(491);
				like();
				setState(492);
				argument();
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				{
				setState(494);
				field();
				setState(495);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(496);
				nil();
				}
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				{
				setState(498);
				field();
				setState(499);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(500);
				argument();
				}
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				{
				setState(502);
				function();
				setState(503);
				compOp();
				setState(504);
				field();
				}
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				{
				setState(506);
				function();
				setState(507);
				compOp();
				setState(508);
				constant();
				}
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				{
				setState(510);
				function();
				setState(511);
				compOp();
				setState(512);
				function();
				}
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				{
				setState(514);
				function();
				setState(515);
				in();
				setState(516);
				array();
				}
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				{
				setState(518);
				function();
				setState(519);
				in();
				setState(520);
				argument();
				}
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				{
				setState(522);
				xField();
				setState(523);
				compOp();
				setState(524);
				field();
				}
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				{
				setState(526);
				field();
				setState(527);
				compOp();
				setState(528);
				xField();
				}
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				{
				setState(530);
				xField();
				setState(531);
				compOp();
				setState(532);
				argument();
				}
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				{
				setState(534);
				constant();
				setState(535);
				compOp();
				setState(536);
				field();
				}
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				{
				setState(538);
				constant();
				setState(539);
				compOp();
				setState(540);
				function();
				}
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				{
				setState(542);
				rowNum();
				setState(543);
				compOp();
				setState(544);
				constant();
				}
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				{
				setState(546);
				rowNum();
				setState(547);
				compOp();
				setState(548);
				argument();
				}
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				{
				setState(550);
				field();
				setState(551);
				in();
				setState(552);
				subQuery();
				}
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				{
				setState(554);
				function();
				setState(555);
				in();
				setState(556);
				subQuery();
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

	public static class XComplexContext extends ParserRuleContext {
		public LogicOpContext logicOp() {
			return getRuleContext(LogicOpContext.class,0);
		}
		public ComplexContext complex() {
			return getRuleContext(ComplexContext.class,0);
		}
		public XComplexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xComplex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterXComplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitXComplex(this);
		}
	}

	public final XComplexContext xComplex() throws RecognitionException {
		XComplexContext _localctx = new XComplexContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_xComplex);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			logicOp();
			setState(561);
			complex();
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

	public static class ComplexContext extends ParserRuleContext {
		public TerminalNode PL() { return getToken(QLanguageParser.PL, 0); }
		public TerminalNode PR() { return getToken(QLanguageParser.PR, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<XConditionContext> xCondition() {
			return getRuleContexts(XConditionContext.class);
		}
		public XConditionContext xCondition(int i) {
			return getRuleContext(XConditionContext.class,i);
		}
		public List<XComplexContext> xComplex() {
			return getRuleContexts(XComplexContext.class);
		}
		public XComplexContext xComplex(int i) {
			return getRuleContext(XComplexContext.class,i);
		}
		public ComplexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterComplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitComplex(this);
		}
	}

	public final ComplexContext complex() throws RecognitionException {
		ComplexContext _localctx = new ComplexContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_complex);
		int _la;
		try {
			setState(591);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(563);
				match(PL);
				setState(571); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(564);
					condition();
					setState(568);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AND || _la==OR) {
						{
						{
						setState(565);
						xCondition();
						}
						}
						setState(570);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(573); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ROWNUM) | (1L << DIGITS) | (1L << NAMING) | (1L << STRING))) != 0) );
				setState(575);
				match(PR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(577);
				match(PL);
				setState(585); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(578);
					condition();
					setState(582);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AND || _la==OR) {
						{
						{
						setState(579);
						xComplex();
						}
						}
						setState(584);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(587); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ROWNUM) | (1L << DIGITS) | (1L << NAMING) | (1L << STRING))) != 0) );
				setState(589);
				match(PR);
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

	public static class ArgumentContext extends ParserRuleContext {
		public ColonContext colon() {
			return getRuleContext(ColonContext.class,0);
		}
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			colon();
			setState(594);
			property();
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

	public static class FunctionContext extends ParserRuleContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public TerminalNode PL() { return getToken(QLanguageParser.PL, 0); }
		public TerminalNode PR() { return getToken(QLanguageParser.PR, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public List<CommaContext> comma() {
			return getRuleContexts(CommaContext.class);
		}
		public CommaContext comma(int i) {
			return getRuleContext(CommaContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_function);
		int _la;
		try {
			setState(618);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(596);
				funcName();
				setState(597);
				match(PL);
				setState(598);
				match(PR);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(600);
				funcName();
				setState(601);
				match(PL);
				setState(604);
				switch (_input.LA(1)) {
				case NAMING:
					{
					setState(602);
					field();
					}
					break;
				case DIGITS:
				case STRING:
					{
					setState(603);
					constant();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(606);
					comma();
					setState(609);
					switch (_input.LA(1)) {
					case NAMING:
						{
						setState(607);
						field();
						}
						break;
					case DIGITS:
					case STRING:
						{
						setState(608);
						constant();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(615);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(616);
				match(PR);
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

	public static class FieldContext extends ParserRuleContext {
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public DotContext dot() {
			return getRuleContext(DotContext.class,0);
		}
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public MasterAttContext masterAtt() {
			return getRuleContext(MasterAttContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_field);
		try {
			setState(632);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(620);
				alias();
				setState(621);
				dot();
				setState(622);
				column();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(624);
				alias();
				setState(625);
				dot();
				setState(626);
				property();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(628);
				alias();
				setState(629);
				dot();
				setState(630);
				masterAtt();
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

	public static class XFieldContext extends ParserRuleContext {
		public TerminalNode PL() { return getToken(QLanguageParser.PL, 0); }
		public TerminalNode PLUS() { return getToken(QLanguageParser.PLUS, 0); }
		public TerminalNode PR() { return getToken(QLanguageParser.PR, 0); }
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public DotContext dot() {
			return getRuleContext(DotContext.class,0);
		}
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public XFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterXField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitXField(this);
		}
	}

	public final XFieldContext xField() throws RecognitionException {
		XFieldContext _localctx = new XFieldContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_xField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(634);
			alias();
			setState(635);
			dot();
			setState(636);
			column();
			}
			setState(638);
			match(PL);
			setState(639);
			match(PLUS);
			setState(640);
			match(PR);
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

	public static class ParameterContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode EQ() { return getToken(QLanguageParser.EQ, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_parameter);
		try {
			setState(650);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(642);
				param();
				setState(643);
				match(EQ);
				setState(644);
				bool();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(646);
				param();
				setState(647);
				match(EQ);
				setState(648);
				constant();
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

	public static class XParameterContext extends ParserRuleContext {
		public LogicOpContext logicOp() {
			return getRuleContext(LogicOpContext.class,0);
		}
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode EQ() { return getToken(QLanguageParser.EQ, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public XParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterXParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitXParameter(this);
		}
	}

	public final XParameterContext xParameter() throws RecognitionException {
		XParameterContext _localctx = new XParameterContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_xParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				{
				setState(652);
				param();
				setState(653);
				match(EQ);
				setState(654);
				bool();
				}
				}
				break;
			case 2:
				{
				{
				setState(656);
				param();
				setState(657);
				match(EQ);
				setState(658);
				constant();
				}
				}
				break;
			}
			setState(662);
			logicOp();
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

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode PARAM() { return getToken(QLanguageParser.PARAM, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			match(PARAM);
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

	public static class RParameterContext extends ParserRuleContext {
		public LogicOpContext logicOp() {
			return getRuleContext(LogicOpContext.class,0);
		}
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode EQ() { return getToken(QLanguageParser.EQ, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public RParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterRParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitRParameter(this);
		}
	}

	public final RParameterContext rParameter() throws RecognitionException {
		RParameterContext _localctx = new RParameterContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_rParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				{
				setState(666);
				param();
				setState(667);
				match(EQ);
				setState(668);
				bool();
				}
				}
				break;
			case 2:
				{
				{
				setState(670);
				param();
				setState(671);
				match(EQ);
				setState(672);
				constant();
				}
				}
				break;
			}
			setState(676);
			logicOp();
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

	public static class MasterAttContext extends ParserRuleContext {
		public TerminalNode BL() { return getToken(QLanguageParser.BL, 0); }
		public List<PackContext> pack() {
			return getRuleContexts(PackContext.class);
		}
		public PackContext pack(int i) {
			return getRuleContext(PackContext.class,i);
		}
		public TerminalNode BR() { return getToken(QLanguageParser.BR, 0); }
		public List<TerminalNode> GT() { return getTokens(QLanguageParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(QLanguageParser.GT, i);
		}
		public MasterAttContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_masterAtt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterMasterAtt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitMasterAtt(this);
		}
	}

	public final MasterAttContext masterAtt() throws RecognitionException {
		MasterAttContext _localctx = new MasterAttContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_masterAtt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678);
			match(BL);
			setState(679);
			pack();
			setState(684);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GT) {
				{
				{
				setState(680);
				match(GT);
				setState(681);
				pack();
				}
				}
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(687);
			match(BR);
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

	public static class ClassNameContext extends ParserRuleContext {
		public List<PackContext> pack() {
			return getRuleContexts(PackContext.class);
		}
		public PackContext pack(int i) {
			return getRuleContext(PackContext.class,i);
		}
		public List<DotContext> dot() {
			return getRuleContexts(DotContext.class);
		}
		public DotContext dot(int i) {
			return getRuleContext(DotContext.class,i);
		}
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitClassName(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_className);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			pack();
			setState(695);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(690);
				dot();
				setState(691);
				pack();
				}
				}
				setState(697);
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

	public static class PropertyContext extends ParserRuleContext {
		public List<PackContext> pack() {
			return getRuleContexts(PackContext.class);
		}
		public PackContext pack(int i) {
			return getRuleContext(PackContext.class,i);
		}
		public List<DotContext> dot() {
			return getRuleContexts(DotContext.class);
		}
		public DotContext dot(int i) {
			return getRuleContext(DotContext.class,i);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitProperty(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_property);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			pack();
			setState(704);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(699);
				dot();
				setState(700);
				pack();
				}
				}
				setState(706);
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

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode PL() { return getToken(QLanguageParser.PL, 0); }
		public List<TerminalNode> STRING() { return getTokens(QLanguageParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(QLanguageParser.STRING, i);
		}
		public TerminalNode PR() { return getToken(QLanguageParser.PR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(QLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(QLanguageParser.COMMA, i);
		}
		public List<TerminalNode> DIGITS() { return getTokens(QLanguageParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(QLanguageParser.DIGITS, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_array);
		int _la;
		try {
			setState(727);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(707);
				match(PL);
				setState(708);
				match(STRING);
				setState(713);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(709);
					match(COMMA);
					setState(710);
					match(STRING);
					}
					}
					setState(715);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(716);
				match(PR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(717);
				match(PL);
				setState(718);
				match(DIGITS);
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(719);
					match(COMMA);
					setState(720);
					match(DIGITS);
					}
					}
					setState(725);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(726);
				match(PR);
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

	public static class PackContext extends ParserRuleContext {
		public TerminalNode NAMING() { return getToken(QLanguageParser.NAMING, 0); }
		public TerminalNode SELECT() { return getToken(QLanguageParser.SELECT, 0); }
		public TerminalNode UPDATE() { return getToken(QLanguageParser.UPDATE, 0); }
		public TerminalNode INSERT() { return getToken(QLanguageParser.INSERT, 0); }
		public TerminalNode DELETE() { return getToken(QLanguageParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(QLanguageParser.FROM, 0); }
		public TerminalNode WHERE() { return getToken(QLanguageParser.WHERE, 0); }
		public TerminalNode GROUP() { return getToken(QLanguageParser.GROUP, 0); }
		public TerminalNode HAVING() { return getToken(QLanguageParser.HAVING, 0); }
		public TerminalNode UNION() { return getToken(QLanguageParser.UNION, 0); }
		public TerminalNode ALL() { return getToken(QLanguageParser.ALL, 0); }
		public TerminalNode VIEW() { return getToken(QLanguageParser.VIEW, 0); }
		public TerminalNode VALUES() { return getToken(QLanguageParser.VALUES, 0); }
		public TerminalNode DISTINCT() { return getToken(QLanguageParser.DISTINCT, 0); }
		public TerminalNode OVER() { return getToken(QLanguageParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(QLanguageParser.PARTITION, 0); }
		public TerminalNode ORDER() { return getToken(QLanguageParser.ORDER, 0); }
		public TerminalNode ROWNUM() { return getToken(QLanguageParser.ROWNUM, 0); }
		public TerminalNode SET() { return getToken(QLanguageParser.SET, 0); }
		public TerminalNode BY() { return getToken(QLanguageParser.BY, 0); }
		public TerminalNode LIKE() { return getToken(QLanguageParser.LIKE, 0); }
		public TerminalNode IN() { return getToken(QLanguageParser.IN, 0); }
		public TerminalNode IS() { return getToken(QLanguageParser.IS, 0); }
		public TerminalNode NOT() { return getToken(QLanguageParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(QLanguageParser.NULL, 0); }
		public TerminalNode EXISTS() { return getToken(QLanguageParser.EXISTS, 0); }
		public TerminalNode ASC() { return getToken(QLanguageParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(QLanguageParser.DESC, 0); }
		public PackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pack; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterPack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitPack(this);
		}
	}

	public final PackContext pack() throws RecognitionException {
		PackContext _localctx = new PackContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_pack);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELECT) | (1L << DELETE) | (1L << UPDATE) | (1L << INSERT) | (1L << FROM) | (1L << WHERE) | (1L << GROUP) | (1L << HAVING) | (1L << UNION) | (1L << ALL) | (1L << VIEW) | (1L << VALUES) | (1L << DISTINCT) | (1L << OVER) | (1L << PARTITION) | (1L << ORDER) | (1L << ROWNUM) | (1L << SET) | (1L << BY) | (1L << LIKE) | (1L << IN) | (1L << IS) | (1L << NOT) | (1L << NULL) | (1L << EXISTS) | (1L << ASC) | (1L << DESC) | (1L << NAMING))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(QLanguageParser.EQ, 0); }
		public TerminalNode NE() { return getToken(QLanguageParser.NE, 0); }
		public TerminalNode GT() { return getToken(QLanguageParser.GT, 0); }
		public TerminalNode LT() { return getToken(QLanguageParser.LT, 0); }
		public TerminalNode GE() { return getToken(QLanguageParser.GE, 0); }
		public TerminalNode LE() { return getToken(QLanguageParser.LE, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitCompOp(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NE) | (1L << GT) | (1L << LT) | (1L << GE) | (1L << LE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class MathOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(QLanguageParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(QLanguageParser.MINUS, 0); }
		public TerminalNode MUL() { return getToken(QLanguageParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(QLanguageParser.DIV, 0); }
		public TerminalNode PER() { return getToken(QLanguageParser.PER, 0); }
		public MathOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterMathOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitMathOp(this);
		}
	}

	public final MathOpContext mathOp() throws RecognitionException {
		MathOpContext _localctx = new MathOpContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_mathOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(733);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MUL) | (1L << DIV) | (1L << PER))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class LogicOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(QLanguageParser.AND, 0); }
		public TerminalNode OR() { return getToken(QLanguageParser.OR, 0); }
		public LogicOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterLogicOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitLogicOp(this);
		}
	}

	public final LogicOpContext logicOp() throws RecognitionException {
		LogicOpContext _localctx = new LogicOpContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_logicOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QLanguageParser.STRING, 0); }
		public TerminalNode DIGITS() { return getToken(QLanguageParser.DIGITS, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			_la = _input.LA(1);
			if ( !(_la==DIGITS || _la==STRING) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(QLanguageParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(QLanguageParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class SortsContext extends ParserRuleContext {
		public TerminalNode ASC() { return getToken(QLanguageParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(QLanguageParser.DESC, 0); }
		public SortsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sorts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterSorts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitSorts(this);
		}
	}

	public final SortsContext sorts() throws RecognitionException {
		SortsContext _localctx = new SortsContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_sorts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(741);
			_la = _input.LA(1);
			if ( !(_la==ASC || _la==DESC) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class UnionContext extends ParserRuleContext {
		public TerminalNode UNION() { return getToken(QLanguageParser.UNION, 0); }
		public TerminalNode ALL() { return getToken(QLanguageParser.ALL, 0); }
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitUnion(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_union);
		try {
			setState(746);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(743);
				match(UNION);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(744);
				match(UNION);
				setState(745);
				match(ALL);
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

	public static class LikeContext extends ParserRuleContext {
		public TerminalNode LIKE() { return getToken(QLanguageParser.LIKE, 0); }
		public TerminalNode NOT() { return getToken(QLanguageParser.NOT, 0); }
		public LikeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_like; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterLike(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitLike(this);
		}
	}

	public final LikeContext like() throws RecognitionException {
		LikeContext _localctx = new LikeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_like);
		try {
			setState(751);
			switch (_input.LA(1)) {
			case LIKE:
				enterOuterAlt(_localctx, 1);
				{
				setState(748);
				match(LIKE);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(749);
				match(NOT);
				setState(750);
				match(LIKE);
				}
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

	public static class InContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(QLanguageParser.IN, 0); }
		public TerminalNode NOT() { return getToken(QLanguageParser.NOT, 0); }
		public InContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitIn(this);
		}
	}

	public final InContext in() throws RecognitionException {
		InContext _localctx = new InContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_in);
		try {
			setState(756);
			switch (_input.LA(1)) {
			case IN:
				enterOuterAlt(_localctx, 1);
				{
				setState(753);
				match(IN);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(754);
				match(NOT);
				setState(755);
				match(IN);
				}
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

	public static class InsertContext extends ParserRuleContext {
		public TerminalNode INSERT() { return getToken(QLanguageParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(QLanguageParser.INTO, 0); }
		public InsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterInsert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitInsert(this);
		}
	}

	public final InsertContext insert() throws RecognitionException {
		InsertContext _localctx = new InsertContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_insert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			match(INSERT);
			setState(759);
			match(INTO);
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

	public static class PartitionByContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(QLanguageParser.PARTITION, 0); }
		public TerminalNode BY() { return getToken(QLanguageParser.BY, 0); }
		public PartitionByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterPartitionBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitPartitionBy(this);
		}
	}

	public final PartitionByContext partitionBy() throws RecognitionException {
		PartitionByContext _localctx = new PartitionByContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_partitionBy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			match(PARTITION);
			setState(762);
			match(BY);
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

	public static class GroupByContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(QLanguageParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(QLanguageParser.BY, 0); }
		public GroupByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterGroupBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitGroupBy(this);
		}
	}

	public final GroupByContext groupBy() throws RecognitionException {
		GroupByContext _localctx = new GroupByContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_groupBy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(764);
			match(GROUP);
			setState(765);
			match(BY);
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

	public static class OrderByContext extends ParserRuleContext {
		public TerminalNode ORDER() { return getToken(QLanguageParser.ORDER, 0); }
		public TerminalNode BY() { return getToken(QLanguageParser.BY, 0); }
		public OrderByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterOrderBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitOrderBy(this);
		}
	}

	public final OrderByContext orderBy() throws RecognitionException {
		OrderByContext _localctx = new OrderByContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_orderBy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(ORDER);
			setState(768);
			match(BY);
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

	public static class SelectContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(QLanguageParser.SELECT, 0); }
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitSelect(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_select);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770);
			match(SELECT);
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

	public static class UpdateContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(QLanguageParser.UPDATE, 0); }
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitUpdate(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			match(UPDATE);
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

	public static class DeleteContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(QLanguageParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(QLanguageParser.FROM, 0); }
		public DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitDelete(this);
		}
	}

	public final DeleteContext delete() throws RecognitionException {
		DeleteContext _localctx = new DeleteContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_delete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
			match(DELETE);
			setState(775);
			match(FROM);
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

	public static class FromContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(QLanguageParser.FROM, 0); }
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitFrom(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(777);
			match(FROM);
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

	public static class WhereContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(QLanguageParser.WHERE, 0); }
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitWhere(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(779);
			match(WHERE);
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

	public static class ValuesContext extends ParserRuleContext {
		public TerminalNode VALUES() { return getToken(QLanguageParser.VALUES, 0); }
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitValues(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_values);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(781);
			match(VALUES);
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

	public static class DistinctContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(QLanguageParser.DISTINCT, 0); }
		public DistinctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distinct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterDistinct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitDistinct(this);
		}
	}

	public final DistinctContext distinct() throws RecognitionException {
		DistinctContext _localctx = new DistinctContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_distinct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			match(DISTINCT);
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

	public static class OverContext extends ParserRuleContext {
		public TerminalNode OVER() { return getToken(QLanguageParser.OVER, 0); }
		public OverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_over; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterOver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitOver(this);
		}
	}

	public final OverContext over() throws RecognitionException {
		OverContext _localctx = new OverContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_over);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
			match(OVER);
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

	public static class ViewContext extends ParserRuleContext {
		public TerminalNode VIEW() { return getToken(QLanguageParser.VIEW, 0); }
		public ViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterView(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitView(this);
		}
	}

	public final ViewContext view() throws RecognitionException {
		ViewContext _localctx = new ViewContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_view);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			match(VIEW);
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

	public static class NilContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(QLanguageParser.NULL, 0); }
		public NilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nil; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterNil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitNil(this);
		}
	}

	public final NilContext nil() throws RecognitionException {
		NilContext _localctx = new NilContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_nil);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(789);
			match(NULL);
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

	public static class DotContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(QLanguageParser.DOT, 0); }
		public DotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitDot(this);
		}
	}

	public final DotContext dot() throws RecognitionException {
		DotContext _localctx = new DotContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_dot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			match(DOT);
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

	public static class RowNumContext extends ParserRuleContext {
		public TerminalNode ROWNUM() { return getToken(QLanguageParser.ROWNUM, 0); }
		public RowNumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowNum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterRowNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitRowNum(this);
		}
	}

	public final RowNumContext rowNum() throws RecognitionException {
		RowNumContext _localctx = new RowNumContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_rowNum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(793);
			match(ROWNUM);
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

	public static class QMarkContext extends ParserRuleContext {
		public TerminalNode QMARK() { return getToken(QLanguageParser.QMARK, 0); }
		public QMarkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qMark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterQMark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitQMark(this);
		}
	}

	public final QMarkContext qMark() throws RecognitionException {
		QMarkContext _localctx = new QMarkContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_qMark);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			match(QMARK);
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

	public static class ColonContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(QLanguageParser.COLON, 0); }
		public ColonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterColon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitColon(this);
		}
	}

	public final ColonContext colon() throws RecognitionException {
		ColonContext _localctx = new ColonContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_colon);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(797);
			match(COLON);
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

	public static class CommaContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(QLanguageParser.COMMA, 0); }
		public CommaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitComma(this);
		}
	}

	public final CommaContext comma() throws RecognitionException {
		CommaContext _localctx = new CommaContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_comma);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(799);
			match(COMMA);
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

	public static class FuncNameContext extends ParserRuleContext {
		public TerminalNode NAMING() { return getToken(QLanguageParser.NAMING, 0); }
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitFuncName(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_funcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(801);
			match(NAMING);
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

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode NAMING() { return getToken(QLanguageParser.NAMING, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitTableName(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(803);
			match(NAMING);
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

	public static class HavingContext extends ParserRuleContext {
		public TerminalNode HAVING() { return getToken(QLanguageParser.HAVING, 0); }
		public HavingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_having; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterHaving(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitHaving(this);
		}
	}

	public final HavingContext having() throws RecognitionException {
		HavingContext _localctx = new HavingContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_having);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			match(HAVING);
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

	public static class ColumnContext extends ParserRuleContext {
		public TerminalNode NAMING() { return getToken(QLanguageParser.NAMING, 0); }
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitColumn(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(807);
			match(NAMING);
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

	public static class AliasContext extends ParserRuleContext {
		public TerminalNode NAMING() { return getToken(QLanguageParser.NAMING, 0); }
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QLanguageParserListener ) ((QLanguageParserListener)listener).exitAlias(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			match(NAMING);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u032e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\3\2\3\2\3\2\3\2\7\2\u00a3\n\2"+
		"\f\2\16\2\u00a6\13\2\3\2\3\2\3\2\5\2\u00ab\n\2\3\3\3\3\3\3\5\3\u00b0\n"+
		"\3\3\3\3\3\5\3\u00b4\n\3\5\3\u00b6\n\3\3\3\5\3\u00b9\n\3\3\4\3\4\5\4\u00bd"+
		"\n\4\3\5\3\5\3\5\5\5\u00c2\n\5\3\6\3\6\3\6\3\7\3\7\5\7\u00c9\n\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7\u00d0\n\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d8\n\7\7\7"+
		"\u00da\n\7\f\7\16\7\u00dd\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00e6\n"+
		"\b\f\b\16\b\u00e9\13\b\3\b\3\b\5\b\u00ed\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\5\13\u00f9\n\13\3\13\3\13\3\13\5\13\u00fe\n\13\7\13"+
		"\u0100\n\13\f\13\16\13\u0103\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u010c"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u0113\n\f\7\f\u0115\n\f\f\f\16\f\u0118\13"+
		"\f\3\r\3\r\7\r\u011c\n\r\f\r\16\r\u011f\13\r\3\r\3\r\7\r\u0123\n\r\f\r"+
		"\16\r\u0126\13\r\3\r\7\r\u0129\n\r\f\r\16\r\u012c\13\r\3\r\7\r\u012f\n"+
		"\r\f\r\16\r\u0132\13\r\3\r\3\r\7\r\u0136\n\r\f\r\16\r\u0139\13\r\3\r\7"+
		"\r\u013c\n\r\f\r\16\r\u013f\13\r\3\r\7\r\u0142\n\r\f\r\16\r\u0145\13\r"+
		"\3\r\3\r\7\r\u0149\n\r\f\r\16\r\u014c\13\r\3\r\7\r\u014f\n\r\f\r\16\r"+
		"\u0152\13\r\3\r\7\r\u0155\n\r\f\r\16\r\u0158\13\r\3\r\3\r\7\r\u015c\n"+
		"\r\f\r\16\r\u015f\13\r\3\r\7\r\u0162\n\r\f\r\16\r\u0165\13\r\3\r\5\r\u0168"+
		"\n\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7\17\u0171\n\17\f\17\16\17\u0174"+
		"\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u017f\n\20\3"+
		"\21\3\21\3\21\3\21\3\21\7\21\u0186\n\21\f\21\16\21\u0189\13\21\3\22\3"+
		"\22\3\22\3\22\3\22\7\22\u0190\n\22\f\22\16\22\u0193\13\22\3\23\3\23\5"+
		"\23\u0197\n\23\3\24\3\24\5\24\u019b\n\24\3\25\3\25\3\26\3\26\5\26\u01a1"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u01ab\n\27\3\27\3\27"+
		"\5\27\u01af\n\27\3\30\3\30\5\30\u01b3\n\30\3\31\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0231\n\37\3 \3 \3 \3!\3!\3!\7"+
		"!\u0239\n!\f!\16!\u023c\13!\6!\u023e\n!\r!\16!\u023f\3!\3!\3!\3!\3!\7"+
		"!\u0247\n!\f!\16!\u024a\13!\6!\u024c\n!\r!\16!\u024d\3!\3!\5!\u0252\n"+
		"!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\5#\u025f\n#\3#\3#\3#\5#\u0264\n"+
		"#\7#\u0266\n#\f#\16#\u0269\13#\3#\3#\5#\u026d\n#\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3$\5$\u027b\n$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\5&\u028d\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0297\n\'\3\'\3"+
		"\'\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\5)\u02a5\n)\3)\3)\3*\3*\3*\3*\7*\u02ad"+
		"\n*\f*\16*\u02b0\13*\3*\3*\3+\3+\3+\3+\7+\u02b8\n+\f+\16+\u02bb\13+\3"+
		",\3,\3,\3,\7,\u02c1\n,\f,\16,\u02c4\13,\3-\3-\3-\3-\7-\u02ca\n-\f-\16"+
		"-\u02cd\13-\3-\3-\3-\3-\3-\7-\u02d4\n-\f-\16-\u02d7\13-\3-\5-\u02da\n"+
		"-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3"+
		"\65\3\65\5\65\u02ed\n\65\3\66\3\66\3\66\5\66\u02f2\n\66\3\67\3\67\3\67"+
		"\5\67\u02f7\n\67\38\38\38\39\39\39\3:\3:\3:\3;\3;\3;\3<\3<\3=\3=\3>\3"+
		">\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3"+
		"I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3O\2\2P\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv"+
		"xz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\2\n\3\2\62\63\5\2\3\16\20\36::\3\2\62\67\3\2"+
		"+/\3\2\37 \4\299;;\3\2\60\61\3\2\35\36\u0349\2\u00aa\3\2\2\2\4\u00ac\3"+
		"\2\2\2\6\u00ba\3\2\2\2\b\u00be\3\2\2\2\n\u00c3\3\2\2\2\f\u00c6\3\2\2\2"+
		"\16\u00de\3\2\2\2\20\u00ee\3\2\2\2\22\u00f1\3\2\2\2\24\u00f4\3\2\2\2\26"+
		"\u0106\3\2\2\2\30\u0119\3\2\2\2\32\u0169\3\2\2\2\34\u016b\3\2\2\2\36\u0175"+
		"\3\2\2\2 \u0180\3\2\2\2\"\u018a\3\2\2\2$\u0194\3\2\2\2&\u0198\3\2\2\2"+
		"(\u019c\3\2\2\2*\u019e\3\2\2\2,\u01a2\3\2\2\2.\u01b0\3\2\2\2\60\u01b4"+
		"\3\2\2\2\62\u01b7\3\2\2\2\64\u01bc\3\2\2\2\66\u01bf\3\2\2\28\u01c5\3\2"+
		"\2\2:\u01c9\3\2\2\2<\u0230\3\2\2\2>\u0232\3\2\2\2@\u0251\3\2\2\2B\u0253"+
		"\3\2\2\2D\u026c\3\2\2\2F\u027a\3\2\2\2H\u027c\3\2\2\2J\u028c\3\2\2\2L"+
		"\u0296\3\2\2\2N\u029a\3\2\2\2P\u02a4\3\2\2\2R\u02a8\3\2\2\2T\u02b3\3\2"+
		"\2\2V\u02bc\3\2\2\2X\u02d9\3\2\2\2Z\u02db\3\2\2\2\\\u02dd\3\2\2\2^\u02df"+
		"\3\2\2\2`\u02e1\3\2\2\2b\u02e3\3\2\2\2d\u02e5\3\2\2\2f\u02e7\3\2\2\2h"+
		"\u02ec\3\2\2\2j\u02f1\3\2\2\2l\u02f6\3\2\2\2n\u02f8\3\2\2\2p\u02fb\3\2"+
		"\2\2r\u02fe\3\2\2\2t\u0301\3\2\2\2v\u0304\3\2\2\2x\u0306\3\2\2\2z\u0308"+
		"\3\2\2\2|\u030b\3\2\2\2~\u030d\3\2\2\2\u0080\u030f\3\2\2\2\u0082\u0311"+
		"\3\2\2\2\u0084\u0313\3\2\2\2\u0086\u0315\3\2\2\2\u0088\u0317\3\2\2\2\u008a"+
		"\u0319\3\2\2\2\u008c\u031b\3\2\2\2\u008e\u031d\3\2\2\2\u0090\u031f\3\2"+
		"\2\2\u0092\u0321\3\2\2\2\u0094\u0323\3\2\2\2\u0096\u0325\3\2\2\2\u0098"+
		"\u0327\3\2\2\2\u009a\u0329\3\2\2\2\u009c\u032b\3\2\2\2\u009e\u00a4\5\4"+
		"\3\2\u009f\u00a0\5h\65\2\u00a0\u00a1\5\4\3\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u009f\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00ab\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00ab\5\6\4\2\u00a8"+
		"\u00ab\5\b\5\2\u00a9\u00ab\5\n\6\2\u00aa\u009e\3\2\2\2\u00aa\u00a7\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\3\3\2\2\2\u00ac\u00ad"+
		"\5\f\7\2\u00ad\u00af\5\26\f\2\u00ae\u00b0\5\30\r\2\u00af\u00ae\3\2\2\2"+
		"\u00af\u00b0\3\2\2\2\u00b0\u00b5\3\2\2\2\u00b1\u00b3\5\34\17\2\u00b2\u00b4"+
		"\5\36\20\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2"+
		"\u00b5\u00b1\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b9"+
		"\5 \21\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\5\3\2\2\2\u00ba"+
		"\u00bc\5\22\n\2\u00bb\u00bd\5\30\r\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3"+
		"\2\2\2\u00bd\7\3\2\2\2\u00be\u00bf\5\20\t\2\u00bf\u00c1\5\32\16\2\u00c0"+
		"\u00c2\5\30\r\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\t\3\2\2"+
		"\2\u00c3\u00c4\5\16\b\2\u00c4\u00c5\5\24\13\2\u00c5\13\3\2\2\2\u00c6\u00c8"+
		"\5v<\2\u00c7\u00c9\5\u0082B\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2"+
		"\u00c9\u00cf\3\2\2\2\u00ca\u00d0\5$\23\2\u00cb\u00d0\5&\24\2\u00cc\u00d0"+
		"\5(\25\2\u00cd\u00d0\5*\26\2\u00ce\u00d0\5,\27\2\u00cf\u00ca\3\2\2\2\u00cf"+
		"\u00cb\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2"+
		"\2\2\u00d0\u00db\3\2\2\2\u00d1\u00d7\5\u0092J\2\u00d2\u00d8\5$\23\2\u00d3"+
		"\u00d8\5&\24\2\u00d4\u00d8\5(\25\2\u00d5\u00d8\5*\26\2\u00d6\u00d8\5,"+
		"\27\2\u00d7\u00d2\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d1\3\2"+
		"\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\r\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\5n8\2\u00df\u00ec\5\u0096L"+
		"\2\u00e0\u00e1\7\"\2\2\u00e1\u00e7\5\u009aN\2\u00e2\u00e3\5\u0092J\2\u00e3"+
		"\u00e4\5\u009aN\2\u00e4\u00e6\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6\u00e9"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00ea\u00eb\7#\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00e0\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\17\3\2\2\2\u00ee\u00ef\5x=\2\u00ef\u00f0"+
		"\5\60\31\2\u00f0\21\3\2\2\2\u00f1\u00f2\5z>\2\u00f2\u00f3\5\60\31\2\u00f3"+
		"\23\3\2\2\2\u00f4\u00f5\5\u0080A\2\u00f5\u00f8\7\"\2\2\u00f6\u00f9\5b"+
		"\62\2\u00f7\u00f9\5D#\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"\u0101\3\2\2\2\u00fa\u00fd\5\u0092J\2\u00fb\u00fe\5b\62\2\u00fc\u00fe"+
		"\5D#\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00fa\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7#\2\2\u0105"+
		"\25\3\2\2\2\u0106\u010b\5|?\2\u0107\u010c\5\60\31\2\u0108\u010c\5\64\33"+
		"\2\u0109\u010c\5\66\34\2\u010a\u010c\5\62\32\2\u010b\u0107\3\2\2\2\u010b"+
		"\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\u0116\3\2"+
		"\2\2\u010d\u0112\5\u0092J\2\u010e\u0113\5\60\31\2\u010f\u0113\5\64\33"+
		"\2\u0110\u0113\5\66\34\2\u0111\u0113\5\62\32\2\u0112\u010e\3\2\2\2\u0112"+
		"\u010f\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0113\u0115\3\2"+
		"\2\2\u0114\u010d\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\27\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u0167\5~@\2"+
		"\u011a\u011c\5L\'\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0124\5<\37\2\u0121\u0123\5:\36\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2"+
		"\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u012a\3\2\2\2\u0126"+
		"\u0124\3\2\2\2\u0127\u0129\5> \2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2"+
		"\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0168\3\2\2\2\u012c\u012a"+
		"\3\2\2\2\u012d\u012f\5L\'\2\u012e\u012d\3\2\2\2\u012f\u0132\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133\3\2\2\2\u0132\u0130\3\2"+
		"\2\2\u0133\u0137\5<\37\2\u0134\u0136\5> \2\u0135\u0134\3\2\2\2\u0136\u0139"+
		"\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013d\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u013a\u013c\5:\36\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2"+
		"\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0168\3\2\2\2\u013f"+
		"\u013d\3\2\2\2\u0140\u0142\5L\'\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2"+
		"\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\u014a\5@!\2\u0147\u0149\5:\36\2\u0148\u0147\3\2\2"+
		"\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0150"+
		"\3\2\2\2\u014c\u014a\3\2\2\2\u014d\u014f\5> \2\u014e\u014d\3\2\2\2\u014f"+
		"\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0168\3\2"+
		"\2\2\u0152\u0150\3\2\2\2\u0153\u0155\5L\'\2\u0154\u0153\3\2\2\2\u0155"+
		"\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159\3\2"+
		"\2\2\u0158\u0156\3\2\2\2\u0159\u015d\5@!\2\u015a\u015c\5> \2\u015b\u015a"+
		"\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u0163\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0162\5:\36\2\u0161\u0160\3\2"+
		"\2\2\u0162\u0165\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164"+
		"\u0168\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0168\5J&\2\u0167\u011d\3\2\2"+
		"\2\u0167\u0130\3\2\2\2\u0167\u0143\3\2\2\2\u0167\u0156\3\2\2\2\u0167\u0166"+
		"\3\2\2\2\u0168\31\3\2\2\2\u0169\u016a\7\25\2\2\u016a\33\3\2\2\2\u016b"+
		"\u016c\5r:\2\u016c\u0172\5F$\2\u016d\u016e\5\u0092J\2\u016e\u016f\5F$"+
		"\2\u016f\u0171\3\2\2\2\u0170\u016d\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0173\35\3\2\2\2\u0174\u0172\3\2\2\2\u0175"+
		"\u017e\5\u0098M\2\u0176\u0177\5D#\2\u0177\u0178\5\\/\2\u0178\u0179\5b"+
		"\62\2\u0179\u017f\3\2\2\2\u017a\u017b\5b\62\2\u017b\u017c\5\\/\2\u017c"+
		"\u017d\5D#\2\u017d\u017f\3\2\2\2\u017e\u0176\3\2\2\2\u017e\u017a\3\2\2"+
		"\2\u017f\37\3\2\2\2\u0180\u0181\5t;\2\u0181\u0187\5.\30\2\u0182\u0183"+
		"\5\u0092J\2\u0183\u0184\5.\30\2\u0184\u0186\3\2\2\2\u0185\u0182\3\2\2"+
		"\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188!"+
		"\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\5p9\2\u018b\u0191\5F$\2\u018c"+
		"\u018d\5\u0092J\2\u018d\u018e\5F$\2\u018e\u0190\3\2\2\2\u018f\u018c\3"+
		"\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"#\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u0196\5F$\2\u0195\u0197\5\u009cO\2"+
		"\u0196\u0195\3\2\2\2\u0196\u0197\3\2\2\2\u0197%\3\2\2\2\u0198\u019a\5"+
		"b\62\2\u0199\u019b\5\u009cO\2\u019a\u0199\3\2\2\2\u019a\u019b\3\2\2\2"+
		"\u019b\'\3\2\2\2\u019c\u019d\7:\2\2\u019d)\3\2\2\2\u019e\u01a0\5D#\2\u019f"+
		"\u01a1\5\u009cO\2\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1+\3\2\2"+
		"\2\u01a2\u01a3\5D#\2\u01a3\u01a4\5\u0084C\2\u01a4\u01aa\7\"\2\2\u01a5"+
		"\u01ab\5\"\22\2\u01a6\u01ab\5 \21\2\u01a7\u01a8\5\"\22\2\u01a8\u01a9\5"+
		" \21\2\u01a9\u01ab\3\2\2\2\u01aa\u01a5\3\2\2\2\u01aa\u01a6\3\2\2\2\u01aa"+
		"\u01a7\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ae\7#\2\2\u01ad\u01af\5\u009c"+
		"O\2\u01ae\u01ad\3\2\2\2\u01ae\u01af\3\2\2\2\u01af-\3\2\2\2\u01b0\u01b2"+
		"\5F$\2\u01b1\u01b3\5f\64\2\u01b2\u01b1\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"/\3\2\2\2\u01b4\u01b5\5\u0096L\2\u01b5\u01b6\5\u009cO\2\u01b6\61\3\2\2"+
		"\2\u01b7\u01b8\5\u0086D\2\u01b8\u01b9\5\u0090I\2\u01b9\u01ba\5\u0096L"+
		"\2\u01ba\u01bb\5\u009cO\2\u01bb\63\3\2\2\2\u01bc\u01bd\5T+\2\u01bd\u01be"+
		"\5\u009cO\2\u01be\65\3\2\2\2\u01bf\u01c0\7\"\2\2\u01c0\u01c1\5\4\3\2\u01c1"+
		"\u01c2\7#\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c4\5\u009cO\2\u01c4\67\3\2"+
		"\2\2\u01c5\u01c6\7\"\2\2\u01c6\u01c7\5\4\3\2\u01c7\u01c8\7#\2\2\u01c8"+
		"9\3\2\2\2\u01c9\u01ca\5`\61\2\u01ca\u01cb\5<\37\2\u01cb;\3\2\2\2\u01cc"+
		"\u01cd\5F$\2\u01cd\u01ce\5\\/\2\u01ce\u01cf\5F$\2\u01cf\u0231\3\2\2\2"+
		"\u01d0\u01d1\5F$\2\u01d1\u01d2\5\\/\2\u01d2\u01d3\5b\62\2\u01d3\u0231"+
		"\3\2\2\2\u01d4\u01d5\5F$\2\u01d5\u01d6\5\\/\2\u01d6\u01d7\5D#\2\u01d7"+
		"\u0231\3\2\2\2\u01d8\u01d9\5F$\2\u01d9\u01da\5\\/\2\u01da\u01db\5\u008e"+
		"H\2\u01db\u0231\3\2\2\2\u01dc\u01dd\5F$\2\u01dd\u01de\5\\/\2\u01de\u01df"+
		"\5B\"\2\u01df\u0231\3\2\2\2\u01e0\u01e1\5F$\2\u01e1\u01e2\5l\67\2\u01e2"+
		"\u01e3\5X-\2\u01e3\u0231\3\2\2\2\u01e4\u01e5\5F$\2\u01e5\u01e6\5l\67\2"+
		"\u01e6\u01e7\5B\"\2\u01e7\u0231\3\2\2\2\u01e8\u01e9\5F$\2\u01e9\u01ea"+
		"\5j\66\2\u01ea\u01eb\5b\62\2\u01eb\u0231\3\2\2\2\u01ec\u01ed\5F$\2\u01ed"+
		"\u01ee\5j\66\2\u01ee\u01ef\5B\"\2\u01ef\u0231\3\2\2\2\u01f0\u01f1\5F$"+
		"\2\u01f1\u01f2\t\2\2\2\u01f2\u01f3\5\u0088E\2\u01f3\u0231\3\2\2\2\u01f4"+
		"\u01f5\5F$\2\u01f5\u01f6\t\2\2\2\u01f6\u01f7\5B\"\2\u01f7\u0231\3\2\2"+
		"\2\u01f8\u01f9\5D#\2\u01f9\u01fa\5\\/\2\u01fa\u01fb\5F$\2\u01fb\u0231"+
		"\3\2\2\2\u01fc\u01fd\5D#\2\u01fd\u01fe\5\\/\2\u01fe\u01ff\5b\62\2\u01ff"+
		"\u0231\3\2\2\2\u0200\u0201\5D#\2\u0201\u0202\5\\/\2\u0202\u0203\5D#\2"+
		"\u0203\u0231\3\2\2\2\u0204\u0205\5D#\2\u0205\u0206\5l\67\2\u0206\u0207"+
		"\5X-\2\u0207\u0231\3\2\2\2\u0208\u0209\5D#\2\u0209\u020a\5l\67\2\u020a"+
		"\u020b\5B\"\2\u020b\u0231\3\2\2\2\u020c\u020d\5H%\2\u020d\u020e\5\\/\2"+
		"\u020e\u020f\5F$\2\u020f\u0231\3\2\2\2\u0210\u0211\5F$\2\u0211\u0212\5"+
		"\\/\2\u0212\u0213\5H%\2\u0213\u0231\3\2\2\2\u0214\u0215\5H%\2\u0215\u0216"+
		"\5\\/\2\u0216\u0217\5B\"\2\u0217\u0231\3\2\2\2\u0218\u0219\5b\62\2\u0219"+
		"\u021a\5\\/\2\u021a\u021b\5F$\2\u021b\u0231\3\2\2\2\u021c\u021d\5b\62"+
		"\2\u021d\u021e\5\\/\2\u021e\u021f\5D#\2\u021f\u0231\3\2\2\2\u0220\u0221"+
		"\5\u008cG\2\u0221\u0222\5\\/\2\u0222\u0223\5b\62\2\u0223\u0231\3\2\2\2"+
		"\u0224\u0225\5\u008cG\2\u0225\u0226\5\\/\2\u0226\u0227\5B\"\2\u0227\u0231"+
		"\3\2\2\2\u0228\u0229\5F$\2\u0229\u022a\5l\67\2\u022a\u022b\58\35\2\u022b"+
		"\u0231\3\2\2\2\u022c\u022d\5D#\2\u022d\u022e\5l\67\2\u022e\u022f\58\35"+
		"\2\u022f\u0231\3\2\2\2\u0230\u01cc\3\2\2\2\u0230\u01d0\3\2\2\2\u0230\u01d4"+
		"\3\2\2\2\u0230\u01d8\3\2\2\2\u0230\u01dc\3\2\2\2\u0230\u01e0\3\2\2\2\u0230"+
		"\u01e4\3\2\2\2\u0230\u01e8\3\2\2\2\u0230\u01ec\3\2\2\2\u0230\u01f0\3\2"+
		"\2\2\u0230\u01f4\3\2\2\2\u0230\u01f8\3\2\2\2\u0230\u01fc\3\2\2\2\u0230"+
		"\u0200\3\2\2\2\u0230\u0204\3\2\2\2\u0230\u0208\3\2\2\2\u0230\u020c\3\2"+
		"\2\2\u0230\u0210\3\2\2\2\u0230\u0214\3\2\2\2\u0230\u0218\3\2\2\2\u0230"+
		"\u021c\3\2\2\2\u0230\u0220\3\2\2\2\u0230\u0224\3\2\2\2\u0230\u0228\3\2"+
		"\2\2\u0230\u022c\3\2\2\2\u0231=\3\2\2\2\u0232\u0233\5`\61\2\u0233\u0234"+
		"\5@!\2\u0234?\3\2\2\2\u0235\u023d\7\"\2\2\u0236\u023a\5<\37\2\u0237\u0239"+
		"\5:\36\2\u0238\u0237\3\2\2\2\u0239\u023c\3\2\2\2\u023a\u0238\3\2\2\2\u023a"+
		"\u023b\3\2\2\2\u023b\u023e\3\2\2\2\u023c\u023a\3\2\2\2\u023d\u0236\3\2"+
		"\2\2\u023e\u023f\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240"+
		"\u0241\3\2\2\2\u0241\u0242\7#\2\2\u0242\u0252\3\2\2\2\u0243\u024b\7\""+
		"\2\2\u0244\u0248\5<\37\2\u0245\u0247\5> \2\u0246\u0245\3\2\2\2\u0247\u024a"+
		"\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024c\3\2\2\2\u024a"+
		"\u0248\3\2\2\2\u024b\u0244\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024b\3\2"+
		"\2\2\u024d\u024e\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0250\7#\2\2\u0250"+
		"\u0252\3\2\2\2\u0251\u0235\3\2\2\2\u0251\u0243\3\2\2\2\u0252A\3\2\2\2"+
		"\u0253\u0254\5\u0090I\2\u0254\u0255\5V,\2\u0255C\3\2\2\2\u0256\u0257\5"+
		"\u0094K\2\u0257\u0258\7\"\2\2\u0258\u0259\7#\2\2\u0259\u026d\3\2\2\2\u025a"+
		"\u025b\5\u0094K\2\u025b\u025e\7\"\2\2\u025c\u025f\5F$\2\u025d\u025f\5"+
		"b\62\2\u025e\u025c\3\2\2\2\u025e\u025d\3\2\2\2\u025f\u0267\3\2\2\2\u0260"+
		"\u0263\5\u0092J\2\u0261\u0264\5F$\2\u0262\u0264\5b\62\2\u0263\u0261\3"+
		"\2\2\2\u0263\u0262\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0260\3\2\2\2\u0266"+
		"\u0269\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u026a\3\2"+
		"\2\2\u0269\u0267\3\2\2\2\u026a\u026b\7#\2\2\u026b\u026d\3\2\2\2\u026c"+
		"\u0256\3\2\2\2\u026c\u025a\3\2\2\2\u026dE\3\2\2\2\u026e\u026f\5\u009c"+
		"O\2\u026f\u0270\5\u008aF\2\u0270\u0271\5\u009aN\2\u0271\u027b\3\2\2\2"+
		"\u0272\u0273\5\u009cO\2\u0273\u0274\5\u008aF\2\u0274\u0275\5V,\2\u0275"+
		"\u027b\3\2\2\2\u0276\u0277\5\u009cO\2\u0277\u0278\5\u008aF\2\u0278\u0279"+
		"\5R*\2\u0279\u027b\3\2\2\2\u027a\u026e\3\2\2\2\u027a\u0272\3\2\2\2\u027a"+
		"\u0276\3\2\2\2\u027bG\3\2\2\2\u027c\u027d\5\u009cO\2\u027d\u027e\5\u008a"+
		"F\2\u027e\u027f\5\u009aN\2\u027f\u0280\3\2\2\2\u0280\u0281\7\"\2\2\u0281"+
		"\u0282\7+\2\2\u0282\u0283\7#\2\2\u0283I\3\2\2\2\u0284\u0285\5N(\2\u0285"+
		"\u0286\7\62\2\2\u0286\u0287\5d\63\2\u0287\u028d\3\2\2\2\u0288\u0289\5"+
		"N(\2\u0289\u028a\7\62\2\2\u028a\u028b\5b\62\2\u028b\u028d\3\2\2\2\u028c"+
		"\u0284\3\2\2\2\u028c\u0288\3\2\2\2\u028dK\3\2\2\2\u028e\u028f\5N(\2\u028f"+
		"\u0290\7\62\2\2\u0290\u0291\5d\63\2\u0291\u0297\3\2\2\2\u0292\u0293\5"+
		"N(\2\u0293\u0294\7\62\2\2\u0294\u0295\5b\62\2\u0295\u0297\3\2\2\2\u0296"+
		"\u028e\3\2\2\2\u0296\u0292\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0299\5`"+
		"\61\2\u0299M\3\2\2\2\u029a\u029b\78\2\2\u029bO\3\2\2\2\u029c\u029d\5N"+
		"(\2\u029d\u029e\7\62\2\2\u029e\u029f\5d\63\2\u029f\u02a5\3\2\2\2\u02a0"+
		"\u02a1\5N(\2\u02a1\u02a2\7\62\2\2\u02a2\u02a3\5b\62\2\u02a3\u02a5\3\2"+
		"\2\2\u02a4\u029c\3\2\2\2\u02a4\u02a0\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6"+
		"\u02a7\5`\61\2\u02a7Q\3\2\2\2\u02a8\u02a9\7$\2\2\u02a9\u02ae\5Z.\2\u02aa"+
		"\u02ab\7\64\2\2\u02ab\u02ad\5Z.\2\u02ac\u02aa\3\2\2\2\u02ad\u02b0\3\2"+
		"\2\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b1\3\2\2\2\u02b0"+
		"\u02ae\3\2\2\2\u02b1\u02b2\7%\2\2\u02b2S\3\2\2\2\u02b3\u02b9\5Z.\2\u02b4"+
		"\u02b5\5\u008aF\2\u02b5\u02b6\5Z.\2\u02b6\u02b8\3\2\2\2\u02b7\u02b4\3"+
		"\2\2\2\u02b8\u02bb\3\2\2\2\u02b9\u02b7\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba"+
		"U\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bc\u02c2\5Z.\2\u02bd\u02be\5\u008aF\2"+
		"\u02be\u02bf\5Z.\2\u02bf\u02c1\3\2\2\2\u02c0\u02bd\3\2\2\2\u02c1\u02c4"+
		"\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3W\3\2\2\2\u02c4"+
		"\u02c2\3\2\2\2\u02c5\u02c6\7\"\2\2\u02c6\u02cb\7;\2\2\u02c7\u02c8\7!\2"+
		"\2\u02c8\u02ca\7;\2\2\u02c9\u02c7\3\2\2\2\u02ca\u02cd\3\2\2\2\u02cb\u02c9"+
		"\3\2\2\2\u02cb\u02cc\3\2\2\2\u02cc\u02ce\3\2\2\2\u02cd\u02cb\3\2\2\2\u02ce"+
		"\u02da\7#\2\2\u02cf\u02d0\7\"\2\2\u02d0\u02d5\79\2\2\u02d1\u02d2\7!\2"+
		"\2\u02d2\u02d4\79\2\2\u02d3\u02d1\3\2\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d3"+
		"\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6\u02d8\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d8"+
		"\u02da\7#\2\2\u02d9\u02c5\3\2\2\2\u02d9\u02cf\3\2\2\2\u02daY\3\2\2\2\u02db"+
		"\u02dc\t\3\2\2\u02dc[\3\2\2\2\u02dd\u02de\t\4\2\2\u02de]\3\2\2\2\u02df"+
		"\u02e0\t\5\2\2\u02e0_\3\2\2\2\u02e1\u02e2\t\6\2\2\u02e2a\3\2\2\2\u02e3"+
		"\u02e4\t\7\2\2\u02e4c\3\2\2\2\u02e5\u02e6\t\b\2\2\u02e6e\3\2\2\2\u02e7"+
		"\u02e8\t\t\2\2\u02e8g\3\2\2\2\u02e9\u02ed\7\13\2\2\u02ea\u02eb\7\13\2"+
		"\2\u02eb\u02ed\7\f\2\2\u02ec\u02e9\3\2\2\2\u02ec\u02ea\3\2\2\2\u02edi"+
		"\3\2\2\2\u02ee\u02f2\7\27\2\2\u02ef\u02f0\7\32\2\2\u02f0\u02f2\7\27\2"+
		"\2\u02f1\u02ee\3\2\2\2\u02f1\u02ef\3\2\2\2\u02f2k\3\2\2\2\u02f3\u02f7"+
		"\7\30\2\2\u02f4\u02f5\7\32\2\2\u02f5\u02f7\7\30\2\2\u02f6\u02f3\3\2\2"+
		"\2\u02f6\u02f4\3\2\2\2\u02f7m\3\2\2\2\u02f8\u02f9\7\6\2\2\u02f9\u02fa"+
		"\7\17\2\2\u02fao\3\2\2\2\u02fb\u02fc\7\22\2\2\u02fc\u02fd\7\26\2\2\u02fd"+
		"q\3\2\2\2\u02fe\u02ff\7\t\2\2\u02ff\u0300\7\26\2\2\u0300s\3\2\2\2\u0301"+
		"\u0302\7\23\2\2\u0302\u0303\7\26\2\2\u0303u\3\2\2\2\u0304\u0305\7\3\2"+
		"\2\u0305w\3\2\2\2\u0306\u0307\7\5\2\2\u0307y\3\2\2\2\u0308\u0309\7\4\2"+
		"\2\u0309\u030a\7\7\2\2\u030a{\3\2\2\2\u030b\u030c\7\7\2\2\u030c}\3\2\2"+
		"\2\u030d\u030e\7\b\2\2\u030e\177\3\2\2\2\u030f\u0310\7\16\2\2\u0310\u0081"+
		"\3\2\2\2\u0311\u0312\7\20\2\2\u0312\u0083\3\2\2\2\u0313\u0314\7\21\2\2"+
		"\u0314\u0085\3\2\2\2\u0315\u0316\7\r\2\2\u0316\u0087\3\2\2\2\u0317\u0318"+
		"\7\33\2\2\u0318\u0089\3\2\2\2\u0319\u031a\7\'\2\2\u031a\u008b\3\2\2\2"+
		"\u031b\u031c\7\24\2\2\u031c\u008d\3\2\2\2\u031d\u031e\7*\2\2\u031e\u008f"+
		"\3\2\2\2\u031f\u0320\7&\2\2\u0320\u0091\3\2\2\2\u0321\u0322\7!\2\2\u0322"+
		"\u0093\3\2\2\2\u0323\u0324\7:\2\2\u0324\u0095\3\2\2\2\u0325\u0326\7:\2"+
		"\2\u0326\u0097\3\2\2\2\u0327\u0328\7\n\2\2\u0328\u0099\3\2\2\2\u0329\u032a"+
		"\7:\2\2\u032a\u009b\3\2\2\2\u032b\u032c\7:\2\2\u032c\u009d\3\2\2\2D\u00a4"+
		"\u00aa\u00af\u00b3\u00b5\u00b8\u00bc\u00c1\u00c8\u00cf\u00d7\u00db\u00e7"+
		"\u00ec\u00f8\u00fd\u0101\u010b\u0112\u0116\u011d\u0124\u012a\u0130\u0137"+
		"\u013d\u0143\u014a\u0150\u0156\u015d\u0163\u0167\u0172\u017e\u0187\u0191"+
		"\u0196\u019a\u01a0\u01aa\u01ae\u01b2\u0230\u023a\u023f\u0248\u024d\u0251"+
		"\u025e\u0263\u0267\u026c\u027a\u028c\u0296\u02a4\u02ae\u02b9\u02c2\u02cb"+
		"\u02d5\u02d9\u02ec\u02f1\u02f6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}