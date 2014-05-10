package com.sin.java.dsp.util;

import com.sin.java.dsp.base.Complex;

public class DataMapIn {
	static public int[] mapIn(double[] x, int offset, int len, int floor, int upper){
		double min = x[offset];
		double max = x[offset];
		int[] res = new int[len];
		for(int i=0; i<len; ++i){
			if(x[i]>max)
				max = x[offset+i];
			if(x[i]<min)
				min = x[offset+i];
		}
		
		if(max==min){
			int v = (upper-floor)/2;
			for(int i=0; i<len; ++i){
				res[i] = v;
			}
		}
		else{
			double k = (upper-floor)/(max-min);
			for(int i=0; i<len; ++i){
				res[i] = (int)((x[offset+i]-min)*k+floor);
			}
		}
		
		return res;
	}
	
	static public int[] mapIn(int[] x, int offset, int len, int floor, int upper){
		double min = x[offset];
		double max = x[offset];
		int[] res = new int[len];
		for(int i=0; i<len; ++i){
			if(x[i]>max)
				max = x[offset+i];
			if(x[i]<min)
				min = x[offset+i];
		}
		
		if(max==min){
			int v = (upper-floor)/2;
			for(int i=0; i<len; ++i){
				res[i] = v;
			}
		}
		else{
			double k = (upper-floor)/(max-min);
			for(int i=0; i<len; ++i){
				res[i] = (int)((x[offset+i]-min)*k+floor);
			}
		}
		
		return res;
	}
	
	static public int[] mapIn(Complex[] x, int offset, int len, int floor, int upper){
		return mapIn(Complex.getAbs(x), offset, len, floor, upper);
	}
	
	static public int[][] mapIn(Complex[][] x, int floor, int upper){
		double max = Complex.getMax(x);
		double min = Complex.getMin(x);
		int h = x.length;
		int w = x[0].length;
		int[][] res = new int[h][w];
		double k = (upper-floor)/(max-min);
		for(int j=0; j<h; ++j){
			for(int i=0; i<w; ++i){
				res[j][i] = (int)((x[j][i].abs()-min)*k+floor);
			}
		}
		
		return res;
	}
	
	static public int mapIn(int data, int omin, int omax, int dmin, int dmax){
    	int res = 0;
    	if(data<=omin)
    		res = dmin;
    	else if(data>=omax)
    		res = dmax;
    	else{
	    	double k = (double)(dmax-dmin)/(double)(omax-omin);
	    	res = (int)((data-omin)*k+dmin);
    	}
    	return res;
    }
}


