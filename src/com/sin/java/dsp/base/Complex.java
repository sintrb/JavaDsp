package com.sin.java.dsp.base;
/*************************************************************************
 *  Compilation:  javac Complex.java
 *  Execution:    java Complex
 *
 *  Data type for complex numbers.
 *
 *  The data type is "immutable" so once you create and initialize
 *  a Complex object, you cannot change it. The "final" keyword
 *  when declaring re and im enforces this rule, making it a
 *  compile-time error to change the .re or .im fields after
 *  they've been initialized.
 *
 *  % java Complex
 *  a            = 5.0 + 6.0i
 *  b            = -3.0 + 4.0i
 *  Re(a)        = 5.0
 *  Im(a)        = 6.0
 *  b + a        = 2.0 + 10.0i
 *  a - b        = 8.0 + 2.0i
 *  a * b        = -39.0 + 2.0i
 *  b * a        = -39.0 + 2.0i
 *  a / b        = 0.36 - 1.52i
 *  (a / b) * b  = 5.0 + 6.0i
 *  conj(a)      = 5.0 - 6.0i
 *  |a|          = 7.810249675906654
 *  tan(a)       = -6.685231390246571E-6 + 1.0000103108981198i
 *
 *************************************************************************/

public class Complex {
    private final double re;   // the real part
    private final double im;   // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // return a string representation of the invoking Complex object
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // return abs/modulus/magnitude and angle/phase/argument
    public double abs()   { return Math.hypot(re, im); }  // Math.sqrt(re*re + im*im)
    public double phase() { return Math.atan2(im, re); }  // between -pi and pi

    // return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) {
        Complex a = this;             // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // return a new Complex object whose value is (this * b)
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    // scalar multiplication
    // return a new object whose value is (this * alpha)
    public Complex times(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    // return a new Complex object whose value is the conjugate of this
    public Complex conjugate() {  return new Complex(re, -im); }

    // return a new Complex object whose value is the reciprocal of this
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }

    // return a / b
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // return a new Complex object whose value is the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex tangent of this
    public Complex tan() {
        return sin().divides(cos());
    }
    


    // a static version of plus
    public static Complex plus(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }
    
    // a static version of minus
    public static Complex minus(Complex a, Complex b) {
        double real = a.re - b.re;
        double imag = a.im - b.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }
    
    // a static version of times
    public static Complex times(Complex a, Complex b) {
        Complex sum = a.times(b);
        return sum;
    }
    
    // a static version of divides
    public static Complex divides(Complex a, Complex b) {
        Complex sum = a.divides(b);
        return sum;
    }
    
    // get complexs abs
    public static double[] getAbs(Complex[] coms) {
    	if(coms != null){
	    	int N = coms.length;
	    	double[] res = new double[coms.length];
	    	for(int i=0; i<N; ++i){
	    		res[i] = coms[i].abs();
	    	}
	    	return res;
    	}
    	else{
    		return null;
    	}
	}
    
    // create complexs from a double[]
    public static Complex[] createComplexs(double[] x, int offset, int len){
    	Complex[] coms = new Complex[len];
    	int max = x!=null?x.length:0;
    	for(int i=0; i<len; ++i){
    		if(i<max)
    			coms[i] = new Complex(x[i], 0);
    		else
    			coms[i] = new Complex(0, 0);
    	}
    	return coms;
    }
	public static Complex[] createComplexs(double[] x) {
		return createComplexs(x, 0, x.length);
	}
    
    // create complexs from a int[]
    public static Complex[] createComplexs(int[] x, int offset, int len){
    	Complex[] coms = new Complex[len];
    	int max = x!=null?x.length:0;
    	for(int i=0; i<len; ++i){
    		if(i<max)
    			coms[i] = new Complex(x[i], 0);
    		else
    			coms[i] = new Complex(0, 0);
    	}
    	return coms;
    }
    
	public static Complex[] createComplexs(int[] x) {
		return createComplexs(x, 0, x.length);
	}
    
    // get the max modulus
    public static double getMax(Complex[] coms){
    	double max = coms[0].abs();
    	for(int i=1; i<coms.length; ++i){
    		if(coms[i].abs()>max){
    			max = coms[i].abs();
    		}
    	}
    	return max;
    }
    
    public static double getMax(Complex[][] comss){
    	double max = getMax(comss[0]);
    	for(int i=1; i<comss.length; ++i){
    		double tmp = getMax(comss[i]); 
    		if(tmp>max){
    			max = tmp;
    		}
    	}
    	return max;
    }
    
    // get the min modulus
    public static double getMin(Complex[] coms){
    	double min = coms[0].abs();
    	for(int i=1; i<coms.length; ++i){
    		if(coms[i].abs()<min){
    			min = coms[i].abs();
    		}
    	}
    	return min;
    }
    public static double getMin(Complex[][] comss){
    	double min = getMin(comss[0]);
    	for(int i=1; i<comss.length; ++i){
    		double tmp = getMin(comss[i]); 
    		if(tmp<min){
    			min = tmp;
    		}
    	}
    	return min;
    }
}