package com.sin.java.dsp.adapter;

import com.sin.java.dsp.base.ArgumentDescribe;
import com.sin.java.dsp.base.Complex;

/**
 * Double数组转复数数组适配器
 * 
 * @author RobinTang
 * 
 */
public class DoublesToComplexs extends BaseAdapter {
	/**
	 * Double数组转复数数组适配器
	 */
	public DoublesToComplexs() {
		this(0, -1);
	}

	/**
	 * Double数组转复数数组适配器
	 * 
	 * @param offset
	 *            起始位置
	 * @param length
	 *            长度
	 */
	public DoublesToComplexs(int offset, int length) {
		super("Double数组转复数数组", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.complexArray("返回复数数组"), offset, length);
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		int len = this.lenght < 0 ? ins.length : this.lenght;
		Complex[] ret = new Complex[len];
		for (int i = 0; i < ins.length; i++) {
			ret[i] = new Complex(ins[i + offset], 0);
		}
		return ret;
	}
}
