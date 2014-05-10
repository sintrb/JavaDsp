package com.sin.java.dsp.base;

import com.sin.java.dsp.util.XLog;

/**
 * 基本管道 其他的全部管道都是该管道的子类
 * 
 * @author RobinTang
 * 
 */
public class BasePipe {

	protected String name; // 管道名称
	protected String explain; // 管道说明
	protected PipeType type; // 管道类型
	protected ArgumentDescribe inputDescribe; // 输入参数描述
	protected ArgumentDescribe outputDescribe; // 输出参数描述

	public BasePipe() {

	}

	public BasePipe(String name, String explain, PipeType type, ArgumentDescribe inputDescribe, ArgumentDescribe outputDescribe) {
		super();
		this.name = name;
		this.explain = explain;
		this.type = type;
		this.inputDescribe = inputDescribe;
		this.outputDescribe = outputDescribe;
	}

	public PipeType getType() {
		return type;
	}

	public void setType(PipeType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public ArgumentDescribe getInputDescribe() {
		return inputDescribe;
	}

	public void setInputDescribe(ArgumentDescribe inputDescribe) {
		this.inputDescribe = inputDescribe;
	}

	public ArgumentDescribe getOutputDescribe() {
		return outputDescribe;
	}

	public void setOutputDescribe(ArgumentDescribe outputDescribe) {
		this.outputDescribe = outputDescribe;
	}

	@Override
	public String toString() {
		return "BasePipe [name=" + name + ", explain=" + explain + ", type=" + type + ", inputDescribe=" + inputDescribe + ", outputDescribe=" + outputDescribe + "]";
	}

	/**
	 * 管道的计算
	 * 
	 * @param input
	 *            输入参数
	 * @return 输出参数
	 */
	public Object calculate(Object input) {
		XLog.i("管道%s并没有实现calculate方法", name);
		return null;
	}

	/**
	 * 直接强转对应类型的返回
	 * 
	 * @param input
	 * @return
	 */
	public double[] calDoubles(Object input) {
		return (double[]) calculate(input);
	}

	public double[][] calDoubless(Object input) {
		return (double[][]) calculate(input);
	}

	// 静态方法簇

	/**
	 * 管道调用(管道以不定参数形式传入)
	 * 
	 * @param input
	 *            输入
	 * @param pipes
	 *            管道数组
	 * @return 管道结果
	 */
	public static Object pipesCal(Object input, BasePipe... pipes) {
		return pipesCalByArray(input, pipes);
	}

	/**
	 * 管道调用(管道以数组形式传入)
	 * 
	 * @param input
	 *            输入
	 * @param pipes
	 *            管道数组
	 * @return 管道结果
	 */
	public static Object pipesCalByArray(Object input, BasePipe[] pipes) {
		if(pipes.length == 0)
			return input;
		ArgumentType outtype = pipes[0].inputDescribe.getType();
		for (int i = 0; i < pipes.length; ++i) {
			BasePipe pipe = pipes[i];
			ArgumentType intype = pipe.inputDescribe.getType();
			if (outtype != intype) {
				XLog.e("管道(%s)输出类型%s与管道(%s)输入类型%s不匹配!", pipes[i - 1].name, outtype, pipe.name, intype);
			}
			input = pipe.calculate(input);
			outtype = pipe.outputDescribe.getType();
		}
		return input;
	}
}
