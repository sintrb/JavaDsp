package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;

/**
 * 线性插值器
 * 
 * @author RobinTang
 * 
 */
public class LinearInterpolater extends BaseFilter {
	/**
	 * 线性差值器
	 */
	public LinearInterpolater() {
		super("Double数组线性插值", "", ArgumentDescribe.doubleArrayArray("输入二维Double数组，double[2][]，double[0]为indexs，double[1]为values"), ArgumentDescribe.doubleArrayArray("插值后的二维Double数组"));
	}

	@Override
	public Object calculate(Object input) {
		double[][] ins = (double[][]) input;
		double[][] ret = new double[2][];
		double[] inxs = ins[0];
		double[] vals = ins[1];
		int len = vals.length;
		int retlen = (int) (inxs[len - 1] - inxs[0] + 1);
		int offx = (int) inxs[0];
		ret[0] = new double[retlen];
		ret[1] = new double[retlen];
		for (int i = 0; i < len - 1; i++) {
			int ix = (int) inxs[i];
			int nix = (int) inxs[i + 1];
			double vl = vals[i];
			double nvl = vals[i + 1];
			double k = (nvl - vl) / (nix - ix);
			ret[0][ix - offx] = ix;
			ret[1][ix - offx] = vl;
			for (int n = 1; n < (nix - ix); ++n) {
				ret[0][ix + n - offx] = ix + n;
				ret[1][ix + n - offx] = vl + k * n;
			}
		}
		ret[0][retlen - 1] = (int) inxs[len - 1];
		ret[1][retlen - 1] = vals[len - 1];
		return ret;
	}
}
