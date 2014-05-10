package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;

/**
 * 信号提取器
 * 
 * @author RobinTang
 * 
 */
public class SignalPicker extends BaseFilter {
	private int offset; // 起始位置
	private int lenght; // 长度
	private boolean positive;

	/**
	 * 信号提取器，默认提取全部（复制）
	 */
	public SignalPicker() {
		this(0, -1, true);
	}

	/**
	 * 信号提取器，默认提取全部正信号
	 * 
	 * @param positive
	 *            true获取正信号,false获取负信号
	 */
	public SignalPicker(boolean positive) {
		this(0, -1, positive);
	}

	/**
	 * 信号提取器
	 * 
	 * @param offset
	 *            起始位置
	 * @param length
	 *            长度
	 * @param positive
	 *            true获取正信号,false获取负信号
	 */
	public SignalPicker(int offset, int length, boolean positive) {
		super("Double数组信号提取", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.doubleArray("返回提取Double数组"));
		this.offset = offset;
		this.lenght = length;
		this.positive = positive;
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		int len = this.lenght < 0 ? ins.length : this.lenght;
		double[] ret = new double[len];
		for (int i = 0; i < len; ++i) {
			double v = ins[i + offset];
			if (positive && v >= 0 || !positive && v <= 0)
				ret[i] = v;
			else
				ret[i] = 0;
		}
		return ret;
	}
}
