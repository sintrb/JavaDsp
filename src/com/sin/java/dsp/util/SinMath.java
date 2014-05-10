package com.sin.java.dsp.util;

/**
 * 常用数学函数簇
 * 
 * @author RobinTang
 * 
 */
public final class SinMath {

	/**
	 * 求平均值
	 * 
	 * @param array
	 *            输入的数组
	 * @return 平均值
	 */
	public static double mean(double[] array) {
		return mean(array, 0, array.length);
	}

	/**
	 * 求平均值
	 * 
	 * @param array
	 *            输入的数组
	 * @param offset
	 *            数组下标偏移
	 * @param length
	 *            长度
	 * @return 平均值
	 */
	public static double mean(double[] array, int offset, int length) {
		int end = array.length > (offset + length) ? offset + length : array.length;
		double sum = 0;
		for (int i = offset; i < end; ++i) {
			sum += array[i];
		}
		return sum / (end - offset);
	}

	/**
	 * 求最大值
	 * 
	 * @param array
	 *            输入的数组
	 * @return 最大值
	 */
	public static double max(double[] array) {
		return max(array, 0, array.length);
	}

	/**
	 * 求最大值
	 * 
	 * @param array
	 *            输入的数组
	 * @param offset
	 *            数组下标偏移
	 * @param length
	 *            长度
	 * @return 最大值
	 */
	public static double max(double[] array, int offset, int length) {
		int end = array.length > (offset + length) ? offset + length : array.length;
		double max = array[offset];
		for (int i = offset; i < end; ++i) {
			if (array[i] > max)
				max = array[i];
		}
		return max;
	}

	/**
	 * 求最小值
	 * 
	 * @param array
	 *            输入的数组
	 * @return 最小值
	 */
	public static double min(double[] array) {
		return min(array, 0, array.length);
	}

	/**
	 * 求最小值
	 * 
	 * @param array
	 *            输入的数组
	 * @param offset
	 *            数组下标偏移
	 * @param length
	 *            长度
	 * @return 最小值
	 */
	public static double min(double[] array, int offset, int length) {
		int end = array.length > (offset + length) ? offset + length : array.length;
		double min = array[offset];
		for (int i = offset; i < end; ++i) {
			if (array[i] < min)
				min = array[i]; 
		}
		return min;
	}
}
