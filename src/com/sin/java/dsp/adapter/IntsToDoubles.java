package com.sin.java.dsp.adapter;

import com.sin.java.dsp.base.ArgumentDescribe;

/**
 * Int数组转Double数组适配器
 * 
 * @author RobinTang
 * 
 */
public class IntsToDoubles extends BaseAdapter {
	/**
	 * Int数组转Double数组适配器
	 */
	public IntsToDoubles() {
		this(0, -1);
	}

	/**
	 * Int数组转Double数组适配器
	 * 
	 * @param offset
	 *            起始位置
	 * @param length
	 *            长度
	 */
	public IntsToDoubles(int offset, int length) {
		super("Int数组转Double数组", "", ArgumentDescribe.intArray("输入Int数组"), ArgumentDescribe.doubleArray("返回Double数组"), offset, length);
	}

	@Override
	public Object calculate(Object input) {
		int[] ins = (int[]) input;
		int len = this.lenght < 0 ? ins.length : this.lenght;
		double[] ret = new double[len];
		for (int i = 0; i < len; i++) {
			ret[i] = (double) ins[i + offset];
		}
		return ret;
	}
}
