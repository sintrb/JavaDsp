package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;
import com.sin.java.dsp.util.SinMath;

/**
 * Double数组归一化（两侧归一化）
 * 
 * @author RobinTang
 * 
 */
public class ToOne2 extends BaseFilter {
	/**
	 * Double数组归一化（两侧归一化）
	 */
	public ToOne2() {
		super("Double数组归一化", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.doubleArray("返回归一化Double数组"));
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		int len = ins.length;
		double[] ret = new double[len];
		double min = SinMath.min(ins);
		double max = SinMath.max(ins);
		min = -min;
		for (int i = 0; i < len; ++i) {
			ret[i] = ins[i] / (ins[i] > 0 ? max : min);
		}
		return ret;
	}
}
