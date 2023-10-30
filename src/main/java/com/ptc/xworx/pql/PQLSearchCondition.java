package com.ptc.xworx.pql;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.ptc.xworx.util.XException;

import wt.query.ArrayExpression;
import wt.query.QueryException;
import wt.query.RelationalExpression;
import wt.query.SearchCondition;

public class PQLSearchCondition extends SearchCondition {
	public static final ThreadLocal<Map<String, Object>> ARGUMENTS = new ThreadLocal<>();
	/**
	 * 记录传入的pql参数名, 例如：@Param("roleKey")
	 */
	private String paramName = "";

	public PQLSearchCondition() {
		super();
	}

	public PQLSearchCondition(RelationalExpression leftSide, String operator, RelationalExpression rightSide) throws QueryException {
		super(leftSide, operator, rightSide);
	}

	public PQLSearchCondition(RelationalExpression leftSide, String operator) throws QueryException {
		super(leftSide, operator);
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * 查询条件SearchCondition中包含有常量时，QuerySpec构建的查询自动将常量转换成参数绑定，以提高数据库对SQL脚本的重用；
	 * QuerySpec也提供了再次去绑定参数值的功能，以提高QuerySpec的重用率，但是in语句的参数就存在一个问题，当in语句中的常数
	 * 少于5个时，QuerySpec自动为in语句设置5个绑定占位，这就存在一个问题，当重用这个QuerySpec时，通过ArrayExpression的
	 * 长度超过5个时，sql执行就会出现异常：“java.sql.SQLException: 无效的列索引”
	 */
	public Object clone() {
		Object cloneObject = super.clone();

		Map<String, Object> arguments = ARGUMENTS.get();
		String name = this.getParamName();
		if (arguments != null && StringUtils.isNotBlank(name)) {
			Object value = null;
			if (arguments.containsKey(name)) {
				value = arguments.get(name);
			} else if (name.indexOf(".") > -1) {
				try {
					value = BeanUtils.getProperty(arguments, name);
				} catch (Exception e) {
					throw new XException(e);
				}
			} else {
				throw new XException("missing argument:" + name);
			}
			/**
			 * 解决传入的参数中的数组长度大于5, 并且大于QuerySpec中的对应条件表达式中的ArrayExpression长度
			 */
			if (value instanceof Object[] && cloneObject instanceof SearchCondition) {
				SearchCondition condition = (SearchCondition) cloneObject;
				RelationalExpression rightExpression = condition.getRightHandSide();
				
				if (rightExpression instanceof ArrayExpression) {
					ArrayExpression protoExpression = (ArrayExpression) rightExpression;
					ArrayExpression arrayExpression = new ArrayExpression((Object[]) value);
					int arraySize = arrayExpression.getSize();
					if (arraySize > 5 && protoExpression.getSize() < arraySize) {
						try {
							Field rightHandSide = condition.getClass().getDeclaredField("rightHandSide");
							rightHandSide.setAccessible(true);
							rightHandSide.set(condition, arrayExpression);
						} catch (Exception e) {
							throw new XException(e);
						}
					}
				}
			}
		}
		return cloneObject;
	}
}
