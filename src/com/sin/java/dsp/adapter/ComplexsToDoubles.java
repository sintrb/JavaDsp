package com.sin.java.dsp.adapter;

import com.sin.java.dsp.base.ArgumentDescribe;
import com.sin.java.dsp.base.Complex;
import com.sin.java.dsp.base.ComplexPart;

/**
 * 复数数组转Double数组适配器
 * 
 * @author RobinTang
 * 
 */
public class ComplexsToDoubles extends BaseAdapter {
	private ComplexPart type;

	/**
	 * 复数数组转Double数组适配器
	 */
	public ComplexsToDoubles() {
		this(ComplexPart.Model, 0, -1);
	}

	/**
	 * 复数数组转Double数组适配器
	 * 
	 * @param offset
	 *            起始位置
	 * @param length
	 *            长度
	 */
	public ComplexsToDoubles(ComplexPart type, int offset, int length) {
		super("复数数组转Double数组", "", ArgumentDescribe.complexArray("输入复数数组"), ArgumentDescribe.doubleArray("返回Double数组"), offset, length);
		this.type = type;
	}

	@Override
	public Object calculate(Object input) {
		Complex[] ins = (Complex[]) input;
		int len = this.lenght < 0 ? ins.length : this.lenght;
		double[] ret = new double[len];
		for (int i = 0; i < len; ++i) {
			switch (type) {
			case Real:
				ret[i] = ins[i + offset].re();
				break;
			case Image:
				ret[i] = ins[i + offset].im();
				break;
			case Model:
				ret[i] = ins[i + offset].abs();
				break;
			default:
				break;
			}
		}
		return ret;
	}

}
