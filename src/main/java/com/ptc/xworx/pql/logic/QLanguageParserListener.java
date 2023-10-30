// Generated from D:\SourceSpace\SpaceJPQL\JPQL-1.1.3\src\main\java\com\ptc\xworx\pql\g4\QLanguageParser.g4 by ANTLR 4.5.3

package com.ptc.xworx.pql.logic;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLanguageParser}.
 */
public interface QLanguageParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#startPQLStatement}.
	 * @param ctx the parse tree
	 */
	void enterStartPQLStatement(QLanguageParser.StartPQLStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#startPQLStatement}.
	 * @param ctx the parse tree
	 */
	void exitStartPQLStatement(QLanguageParser.StartPQLStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectStatement(QLanguageParser.SelectStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#selectStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectStatement(QLanguageParser.SelectStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeleteStatement(QLanguageParser.DeleteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#deleteStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeleteStatement(QLanguageParser.DeleteStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(QLanguageParser.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(QLanguageParser.UpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsertStatement(QLanguageParser.InsertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#insertStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsertStatement(QLanguageParser.InsertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void enterSelectClause(QLanguageParser.SelectClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#selectClause}.
	 * @param ctx the parse tree
	 */
	void exitSelectClause(QLanguageParser.SelectClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#insertClause}.
	 * @param ctx the parse tree
	 */
	void enterInsertClause(QLanguageParser.InsertClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#insertClause}.
	 * @param ctx the parse tree
	 */
	void exitInsertClause(QLanguageParser.InsertClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#updateClause}.
	 * @param ctx the parse tree
	 */
	void enterUpdateClause(QLanguageParser.UpdateClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#updateClause}.
	 * @param ctx the parse tree
	 */
	void exitUpdateClause(QLanguageParser.UpdateClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#deleteClause}.
	 * @param ctx the parse tree
	 */
	void enterDeleteClause(QLanguageParser.DeleteClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#deleteClause}.
	 * @param ctx the parse tree
	 */
	void exitDeleteClause(QLanguageParser.DeleteClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#valuesClause}.
	 * @param ctx the parse tree
	 */
	void enterValuesClause(QLanguageParser.ValuesClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#valuesClause}.
	 * @param ctx the parse tree
	 */
	void exitValuesClause(QLanguageParser.ValuesClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(QLanguageParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(QLanguageParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(QLanguageParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(QLanguageParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#setClause}.
	 * @param ctx the parse tree
	 */
	void enterSetClause(QLanguageParser.SetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#setClause}.
	 * @param ctx the parse tree
	 */
	void exitSetClause(QLanguageParser.SetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#groupClause}.
	 * @param ctx the parse tree
	 */
	void enterGroupClause(QLanguageParser.GroupClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#groupClause}.
	 * @param ctx the parse tree
	 */
	void exitGroupClause(QLanguageParser.GroupClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void enterHavingClause(QLanguageParser.HavingClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#havingClause}.
	 * @param ctx the parse tree
	 */
	void exitHavingClause(QLanguageParser.HavingClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#orderClause}.
	 * @param ctx the parse tree
	 */
	void enterOrderClause(QLanguageParser.OrderClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#orderClause}.
	 * @param ctx the parse tree
	 */
	void exitOrderClause(QLanguageParser.OrderClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#partitionClause}.
	 * @param ctx the parse tree
	 */
	void enterPartitionClause(QLanguageParser.PartitionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#partitionClause}.
	 * @param ctx the parse tree
	 */
	void exitPartitionClause(QLanguageParser.PartitionClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#fieldItem}.
	 * @param ctx the parse tree
	 */
	void enterFieldItem(QLanguageParser.FieldItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#fieldItem}.
	 * @param ctx the parse tree
	 */
	void exitFieldItem(QLanguageParser.FieldItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#constItem}.
	 * @param ctx the parse tree
	 */
	void enterConstItem(QLanguageParser.ConstItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#constItem}.
	 * @param ctx the parse tree
	 */
	void exitConstItem(QLanguageParser.ConstItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#objectItem}.
	 * @param ctx the parse tree
	 */
	void enterObjectItem(QLanguageParser.ObjectItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#objectItem}.
	 * @param ctx the parse tree
	 */
	void exitObjectItem(QLanguageParser.ObjectItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#funcItem}.
	 * @param ctx the parse tree
	 */
	void enterFuncItem(QLanguageParser.FuncItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#funcItem}.
	 * @param ctx the parse tree
	 */
	void exitFuncItem(QLanguageParser.FuncItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#overItem}.
	 * @param ctx the parse tree
	 */
	void enterOverItem(QLanguageParser.OverItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#overItem}.
	 * @param ctx the parse tree
	 */
	void exitOverItem(QLanguageParser.OverItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#orderItem}.
	 * @param ctx the parse tree
	 */
	void enterOrderItem(QLanguageParser.OrderItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#orderItem}.
	 * @param ctx the parse tree
	 */
	void exitOrderItem(QLanguageParser.OrderItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#tableFrom}.
	 * @param ctx the parse tree
	 */
	void enterTableFrom(QLanguageParser.TableFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#tableFrom}.
	 * @param ctx the parse tree
	 */
	void exitTableFrom(QLanguageParser.TableFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#viewFrom}.
	 * @param ctx the parse tree
	 */
	void enterViewFrom(QLanguageParser.ViewFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#viewFrom}.
	 * @param ctx the parse tree
	 */
	void exitViewFrom(QLanguageParser.ViewFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#classFrom}.
	 * @param ctx the parse tree
	 */
	void enterClassFrom(QLanguageParser.ClassFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#classFrom}.
	 * @param ctx the parse tree
	 */
	void exitClassFrom(QLanguageParser.ClassFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#queryFrom}.
	 * @param ctx the parse tree
	 */
	void enterQueryFrom(QLanguageParser.QueryFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#queryFrom}.
	 * @param ctx the parse tree
	 */
	void exitQueryFrom(QLanguageParser.QueryFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#subQuery}.
	 * @param ctx the parse tree
	 */
	void enterSubQuery(QLanguageParser.SubQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#subQuery}.
	 * @param ctx the parse tree
	 */
	void exitSubQuery(QLanguageParser.SubQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#xCondition}.
	 * @param ctx the parse tree
	 */
	void enterXCondition(QLanguageParser.XConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#xCondition}.
	 * @param ctx the parse tree
	 */
	void exitXCondition(QLanguageParser.XConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(QLanguageParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(QLanguageParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#xComplex}.
	 * @param ctx the parse tree
	 */
	void enterXComplex(QLanguageParser.XComplexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#xComplex}.
	 * @param ctx the parse tree
	 */
	void exitXComplex(QLanguageParser.XComplexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#complex}.
	 * @param ctx the parse tree
	 */
	void enterComplex(QLanguageParser.ComplexContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#complex}.
	 * @param ctx the parse tree
	 */
	void exitComplex(QLanguageParser.ComplexContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(QLanguageParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(QLanguageParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(QLanguageParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(QLanguageParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(QLanguageParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(QLanguageParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#xField}.
	 * @param ctx the parse tree
	 */
	void enterXField(QLanguageParser.XFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#xField}.
	 * @param ctx the parse tree
	 */
	void exitXField(QLanguageParser.XFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(QLanguageParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(QLanguageParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#xParameter}.
	 * @param ctx the parse tree
	 */
	void enterXParameter(QLanguageParser.XParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#xParameter}.
	 * @param ctx the parse tree
	 */
	void exitXParameter(QLanguageParser.XParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(QLanguageParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(QLanguageParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#rParameter}.
	 * @param ctx the parse tree
	 */
	void enterRParameter(QLanguageParser.RParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#rParameter}.
	 * @param ctx the parse tree
	 */
	void exitRParameter(QLanguageParser.RParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#masterAtt}.
	 * @param ctx the parse tree
	 */
	void enterMasterAtt(QLanguageParser.MasterAttContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#masterAtt}.
	 * @param ctx the parse tree
	 */
	void exitMasterAtt(QLanguageParser.MasterAttContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(QLanguageParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(QLanguageParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(QLanguageParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(QLanguageParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(QLanguageParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(QLanguageParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#pack}.
	 * @param ctx the parse tree
	 */
	void enterPack(QLanguageParser.PackContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#pack}.
	 * @param ctx the parse tree
	 */
	void exitPack(QLanguageParser.PackContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(QLanguageParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(QLanguageParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#mathOp}.
	 * @param ctx the parse tree
	 */
	void enterMathOp(QLanguageParser.MathOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#mathOp}.
	 * @param ctx the parse tree
	 */
	void exitMathOp(QLanguageParser.MathOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void enterLogicOp(QLanguageParser.LogicOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#logicOp}.
	 * @param ctx the parse tree
	 */
	void exitLogicOp(QLanguageParser.LogicOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(QLanguageParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(QLanguageParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(QLanguageParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(QLanguageParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#sorts}.
	 * @param ctx the parse tree
	 */
	void enterSorts(QLanguageParser.SortsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#sorts}.
	 * @param ctx the parse tree
	 */
	void exitSorts(QLanguageParser.SortsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(QLanguageParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(QLanguageParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#like}.
	 * @param ctx the parse tree
	 */
	void enterLike(QLanguageParser.LikeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#like}.
	 * @param ctx the parse tree
	 */
	void exitLike(QLanguageParser.LikeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#in}.
	 * @param ctx the parse tree
	 */
	void enterIn(QLanguageParser.InContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#in}.
	 * @param ctx the parse tree
	 */
	void exitIn(QLanguageParser.InContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#insert}.
	 * @param ctx the parse tree
	 */
	void enterInsert(QLanguageParser.InsertContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#insert}.
	 * @param ctx the parse tree
	 */
	void exitInsert(QLanguageParser.InsertContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#partitionBy}.
	 * @param ctx the parse tree
	 */
	void enterPartitionBy(QLanguageParser.PartitionByContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#partitionBy}.
	 * @param ctx the parse tree
	 */
	void exitPartitionBy(QLanguageParser.PartitionByContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#groupBy}.
	 * @param ctx the parse tree
	 */
	void enterGroupBy(QLanguageParser.GroupByContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#groupBy}.
	 * @param ctx the parse tree
	 */
	void exitGroupBy(QLanguageParser.GroupByContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#orderBy}.
	 * @param ctx the parse tree
	 */
	void enterOrderBy(QLanguageParser.OrderByContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#orderBy}.
	 * @param ctx the parse tree
	 */
	void exitOrderBy(QLanguageParser.OrderByContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#select}.
	 * @param ctx the parse tree
	 */
	void enterSelect(QLanguageParser.SelectContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#select}.
	 * @param ctx the parse tree
	 */
	void exitSelect(QLanguageParser.SelectContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#update}.
	 * @param ctx the parse tree
	 */
	void enterUpdate(QLanguageParser.UpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#update}.
	 * @param ctx the parse tree
	 */
	void exitUpdate(QLanguageParser.UpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#delete}.
	 * @param ctx the parse tree
	 */
	void enterDelete(QLanguageParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#delete}.
	 * @param ctx the parse tree
	 */
	void exitDelete(QLanguageParser.DeleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#from}.
	 * @param ctx the parse tree
	 */
	void enterFrom(QLanguageParser.FromContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#from}.
	 * @param ctx the parse tree
	 */
	void exitFrom(QLanguageParser.FromContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#where}.
	 * @param ctx the parse tree
	 */
	void enterWhere(QLanguageParser.WhereContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#where}.
	 * @param ctx the parse tree
	 */
	void exitWhere(QLanguageParser.WhereContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(QLanguageParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(QLanguageParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#distinct}.
	 * @param ctx the parse tree
	 */
	void enterDistinct(QLanguageParser.DistinctContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#distinct}.
	 * @param ctx the parse tree
	 */
	void exitDistinct(QLanguageParser.DistinctContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#over}.
	 * @param ctx the parse tree
	 */
	void enterOver(QLanguageParser.OverContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#over}.
	 * @param ctx the parse tree
	 */
	void exitOver(QLanguageParser.OverContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#view}.
	 * @param ctx the parse tree
	 */
	void enterView(QLanguageParser.ViewContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#view}.
	 * @param ctx the parse tree
	 */
	void exitView(QLanguageParser.ViewContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#nil}.
	 * @param ctx the parse tree
	 */
	void enterNil(QLanguageParser.NilContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#nil}.
	 * @param ctx the parse tree
	 */
	void exitNil(QLanguageParser.NilContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#dot}.
	 * @param ctx the parse tree
	 */
	void enterDot(QLanguageParser.DotContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#dot}.
	 * @param ctx the parse tree
	 */
	void exitDot(QLanguageParser.DotContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#rowNum}.
	 * @param ctx the parse tree
	 */
	void enterRowNum(QLanguageParser.RowNumContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#rowNum}.
	 * @param ctx the parse tree
	 */
	void exitRowNum(QLanguageParser.RowNumContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#qMark}.
	 * @param ctx the parse tree
	 */
	void enterQMark(QLanguageParser.QMarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#qMark}.
	 * @param ctx the parse tree
	 */
	void exitQMark(QLanguageParser.QMarkContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#colon}.
	 * @param ctx the parse tree
	 */
	void enterColon(QLanguageParser.ColonContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#colon}.
	 * @param ctx the parse tree
	 */
	void exitColon(QLanguageParser.ColonContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#comma}.
	 * @param ctx the parse tree
	 */
	void enterComma(QLanguageParser.CommaContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#comma}.
	 * @param ctx the parse tree
	 */
	void exitComma(QLanguageParser.CommaContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#funcName}.
	 * @param ctx the parse tree
	 */
	void enterFuncName(QLanguageParser.FuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#funcName}.
	 * @param ctx the parse tree
	 */
	void exitFuncName(QLanguageParser.FuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(QLanguageParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(QLanguageParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#having}.
	 * @param ctx the parse tree
	 */
	void enterHaving(QLanguageParser.HavingContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#having}.
	 * @param ctx the parse tree
	 */
	void exitHaving(QLanguageParser.HavingContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(QLanguageParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(QLanguageParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLanguageParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(QLanguageParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLanguageParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(QLanguageParser.AliasContext ctx);
}