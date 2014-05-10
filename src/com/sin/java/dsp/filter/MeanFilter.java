package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;

/**
 * 均值滤波器 对输入信号进行均值滤波，窗长为windowWidth，滤波后信号长度保持不变
 * 
 * @author RobinTang
 * 
 */
public class MeanFilter extends BaseFilter {
	public int windowWidth; // 窗长

	/**
	 * 均值滤波器，默认窗长为150
	 */
	public MeanFilter() {
		this(150);
	}

	/**
	 * 均值滤波器
	 * 
	 * @param windowWidth
	 *            窗长
	 */
	public MeanFilter(int windowWidth) {
		super("Double均值滤波", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.doubleArray("返回滤波后Double数组"));
		this.windowWidth = windowWidth;
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		int len = ins.length;
		double[] ret = new double[len];
		double sum = 0;
		for (int i = 0; i < len; ++i) {
			if (i < windowWidth) {
				// 前windowWidth个
				sum += ins[i];
				ret[i] = sum / (i + 1);
			} else if (i > (len - windowWidth)) {
				// 后windowWidth个
				sum -= ins[i - windowWidth];
				ret[i] = sum / (len - i);
			} else {
				// 中间部分
				sum -= ins[i - windowWidth];
				sum += ins[i];
				ret[i] = sum / windowWidth;
			}
		}
		return ret;
	}
}
