package com.ssm.connector;

public class Condition {
	public final static String OP_EQ = "=";
	public final static String OP_NE = "<>";
	public final static String OP_GE = ">=";
	public final static String OP_GT = ">";
	public final static String OP_LE = "<=";
	public final static String OP_LT = "<";
	public final static String OP_StartsWith = "StartsWith";

	
	public Condition(String name, String operator, String value) {
		this.name = name; this.operator = operator;
		this.value = value;
	}
	public String name;
	public String operator;
	public String value;
}
