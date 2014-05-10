package com.sin.java.dsp.filter;

import com.sin.java.dsp.base.ArgumentDescribe;
import com.sin.java.dsp.base.BasePipe;
import com.sin.java.dsp.base.Complex;
import com.sin.java.dsp.base.PipeType;

/**
 * 滤波器基类,所有的滤波器均继承自该类,广义上的滤波器对信号进行处理（包括狭义滤波、信号变换等等）
 * 
 * @author RobinTang
 * 
 */
public class BaseFilter extends BasePipe {
	public BaseFilter(String name, String explain, ArgumentDescribe inputDescribe, ArgumentDescribe outputDescribe) {
		super();
		this.name = name;
		this.explain = explain;
		this.type = PipeType.Filter; // 滤波器
		this.inputDescribe = inputDescribe;
		this.outputDescribe = outputDescribe;
	}

	/**
	 * 直接强转对应类型的返回
	 * 
	 * @param input
	 * @return
	 */
	public Complex[] calComplexs(Object input) {
		return (Complex[]) calculate(input);
	}
}
