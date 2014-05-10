package com.sin.java.dsp.adapter;

import com.sin.java.dsp.base.ArgumentDescribe;

/**
 * Double数组转Int数组适配器
 * 
 * @author RobinTang
 * 
 */
public class DoublesToInts extends BaseAdapter {
	/**
	 * Double数组转Int数组适配器
	 */
	public DoublesToInts() {
		this(0, -1);
	}

	/**
	 * Double数组转Int数组适配器
	 * 
	 * @param offset
	 *            起始位置
	 * @param length
	 *            长度
	 */
	public DoublesToInts(int offset, int length) {
		super("Double数组转Int数组", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.intArray("返回Int数组"), offset, length);
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		int len = this.lenght < 0 ? ins.length : this.lenght;
		int[] ret = new int[len];
		for (int i = 0; i < len; i++) {
			ret[i] = (int) ins[i + offset];
		}
		return ret;
	}
}
