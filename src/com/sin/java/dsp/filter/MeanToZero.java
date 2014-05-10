package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;
import com.sin.java.dsp.util.SinMath;

/**
 * 平均值归零（即数组中所有元素均减去平均值）
 * 
 * @author RobinTang
 * 
 */
public class MeanToZero extends BaseFilter {
	/**
	 * 平均值归零（即数组中所有元素均减去平均值）
	 */
	public MeanToZero() {
		super("Double数组平均值归零", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.doubleArray("输出减去平均值之后的Double数组"));
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		int len = ins.length;
		double[] ret = new double[len];
		double mean = SinMath.mean(ins);
		for (int i = 0; i < len; ++i) {
			ret[i] = ins[i] - mean;
		}
		return ret;
	}

}
