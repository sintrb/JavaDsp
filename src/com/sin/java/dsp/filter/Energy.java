package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;

/**
 * 计算信号能量
 * 
 * @author RobinTang
 * 
 */
public class Energy extends BaseFilter {
	private int[] segments;

	/**
	 * Double数组归一化（两侧归一化）
	 * 
	 * @param segments
	 *            信号分段依据，即下标的分段，应该是升序排列，最后的信号能量个数和分段个数相等，最后一个一般为Integer.MAX
	 */
	public Energy(int[] segments) {
		super("Double数组归一化", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.doubleArray("返回归一化Double数组"));
		this.segments = segments;
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		int len = ins.length;
		int slen = segments.length;
		double[] ret = new double[slen];
		int ix = 0;
		for (int i = 0; i < slen; ++i) {
			double sum = 0;
			for (; ix < segments[i] && ix < len; ++ix) {
				sum += ins[ix];
			}
			ret[i] = sum;
		}
		return ret;
	}
}
