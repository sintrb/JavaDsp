package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;
import com.sin.java.dsp.base.Complex;
import com.sin.java.dsp.trans.SignalTransfor;

/**
 * 快速傅立叶变换器(只能对2的N次幂个数据进行变换)
 * 
 * @author RobinTang
 * 
 */
public class FFT extends BaseFilter {
	/**
	 * 快速傅立叶变换器
	 */
	public FFT() {
		super("复数数组快速傅里叶变换", "", ArgumentDescribe.complexArray("输入复数数组"), ArgumentDescribe.complexArray("输出复数数组"));
	}

	@Override
	public Object calculate(Object input) {
		return SignalTransfor.fft((Complex[]) input);
	}
}
