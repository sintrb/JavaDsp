package com.sin.java.dsp.base;

/**
 * 参数描述
 * 
 * @author RobinTang
 * 
 */
public class ArgumentDescribe {
	private ArgumentType type;
	private String describe;

	public ArgumentDescribe(ArgumentType type, String describe) {
		super();
		this.type = type;
		this.describe = describe;
	}

	public ArgumentType getType() {
		return type;
	}

	public void setType(ArgumentType type) {
		this.type = type;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public static ArgumentDescribe intArray(String desc) {
		return new ArgumentDescribe(ArgumentType.TypeIntArray, desc);
	}
	public static ArgumentDescribe doubleArray(String desc) {
		return new ArgumentDescribe(ArgumentType.TypeDoubleArray, desc);
	}
	public static ArgumentDescribe complexArray(String desc) {
		return new ArgumentDescribe(ArgumentType.TypeComplexArray, desc);
	}
	public static ArgumentDescribe doubleArrayArray(String desc){
		return new ArgumentDescribe(ArgumentType.TypeDoubleArrayArray, desc);
	}
	public static ArgumentDescribe objectDictionary(String desc){
		return new ArgumentDescribe(ArgumentType.TypeDictionary, desc);
	}
	public static ArgumentDescribe string(String desc){
		return new ArgumentDescribe(ArgumentType.TypeString, desc);
	}
	public static ArgumentDescribe objectList(String desc){
		return new ArgumentDescribe(ArgumentType.TypeList, desc);
	}
	public static ArgumentDescribe object(String desc){
		return new ArgumentDescribe(ArgumentType.TypeObject, desc);
	}
}
