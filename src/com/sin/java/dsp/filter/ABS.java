package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;

/**
 * 绝对值
 * 
 * @author RobinTang
 * 
 */
public class ABS extends BaseFilter {
	private boolean positive = true;

	/**
	 * 绝对值
	 */
	public ABS() {
		this(true);
	}

	/**
	 * 绝对值
	 * 
	 * @param positive
	 *            true为绝对值,false为反绝对值
	 */
	public ABS(boolean positive) {
		super("Double数组绝对值", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.doubleArray("返回绝对值数组"));
		this.positive = positive;
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		int len = ins.length;
		double[] ret = new double[len];
		for (int i = 0; i < len; ++i) {
			if (positive)
				ret[i] = ins[i] >= 0 ? ins[i] : -ins[i];
			else
				ret[i] = ins[i] <= 0 ? ins[i] : -ins[i];
		}
		return ret;
	}
}
