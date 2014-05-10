package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;
import com.sin.java.dsp.util.SinMath;

/**
 * 形态学提取器 只是获取形态关键点 之后需要进行插值
 * 
 * @author RobinTang
 * 
 */
public class ShapeTransform extends BaseFilter {
	public int windowWidth; // 窗长（即平滑的点数）

	/**
	 * 形态学提取器
	 */
	public ShapeTransform() {
		this(150);
	}

	/**
	 * 形态学提取器
	 * 
	 * @param windowWidth
	 *            窗长
	 */
	public ShapeTransform(int windowWidth) {
		super("形态学提取", "", ArgumentDescribe.doubleArray("输入Double数组"), ArgumentDescribe.doubleArrayArray("返回二维Double数组，double[2][]，double[0]为indexs，double[1]为values"));
		this.windowWidth = windowWidth;
	}

	@Override
	public Object calculate(Object input) {
		double[] ins = (double[]) input;
		int len = ins.length;
		double[][] ret = new double[2][(len + windowWidth - 1) / windowWidth];
		for (int i = 0; i < len; i += windowWidth) {
			ret[0][i / windowWidth] = i;
			ret[1][i / windowWidth] = SinMath.mean(ins, i, windowWidth);
		}
		ret[0][ret[0].length - 1] = len - 1;
		ret[1][ret[0].length - 1] = ins[len - 1];
		return ret;
	}
}
