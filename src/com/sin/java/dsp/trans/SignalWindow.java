package com.sin.java.dsp.trans;

public class SignalWindow {
	// 矩形窗
	static public double[] retangular(int length){
		double[] w = new double[length];
		for(int i=0; i<length; ++i){
			w[i] = 1.0; 
		}
		return w;
	}
	
	// 汉明窗
	static public double[] hamming(int length){
		double[] w = new double[length];
		for(int i=0; i<length; ++i){
			w[i] = 0.54-0.46*Math.cos(2*Math.PI*i/length); 
		}
		return w;
	}
	// blackman窗
	static public double[] blackman(int length){
		double[] w = new double[length];
		for(int i=0; i<length; ++i){
			w[i] = 0.42-0.5*Math.cos(2.0*Math.PI*i/(length-1))+0.8*Math.cos(4.0*Math.PI*i/(length-1));
		}
		return w;
	}	
	
}
