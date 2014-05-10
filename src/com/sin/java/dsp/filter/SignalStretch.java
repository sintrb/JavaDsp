package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;

/**
 * 信号拉伸
 * 
 * @author RobinTang
 * 
 */
public class SignalStretch extends BaseFilter {
	private int outlen = 1;

	/**
	 * 信号拉伸
	 * 
	 * @param multiple
	 *            拉伸倍数
	 */
	public SignalStretch(int outlen) {
		super("信号拉伸", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.doubleArray("返回拉伸后的Double数组"));
		this.outlen = outlen;
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		double[] ix = new double[ins.length];
		double k = (double)this.outlen/(double)ix.length;
		for(int i=0; i<ix.length; ++i){
			ix[i] = (int)(k*i);
		}
		ix[ix.length-1] = this.outlen-1;
		LinearInterpolater li = new LinearInterpolater();
		double[][] dss = li.calDoubless(new double[][]{ix, ins});
		return dss[1];
	}
}
