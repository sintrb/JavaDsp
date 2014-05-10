package com.sin.java.dsp.test;

import com.sin.java.dsp.adapter.ComplexsToDoubles;
import com.sin.java.dsp.adapter.DoublesToComplexs;
import com.sin.java.dsp.adapter.IntsToDoubles;
import com.sin.java.dsp.base.BasePipe;
import com.sin.java.dsp.filter.FFT;
import com.sin.java.dsp.filter.MeanFilter;

// 关于JavaPlot查看https://github.com/sintrb/JavaPlot
import com.sin.java.plot.Plot;
// 关于WaveAccess查看https://github.com/sintrb/WaveAccess
import com.sin.java.waveaccess.WaveFileReader;

/**
 * 
 * @author RobinTang
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		// 从波形文件读取数据，读到的是int数组
		int[] idats = WaveFileReader.readSingleChannel("wav/wav_40_16_1_pcm.wav");
		if(idats!=null){

			// 将int数组转换成double数组，只转换前32768个
			double[] rawdats = new IntsToDoubles(0,32768).calDoubles(idats);
			Plot.figrue("均值滤波");
			Plot.hold_on();
			Plot.plot(rawdats,"r");
			
			// 均值滤波
			double[] fdatas = new MeanFilter().calDoubles(rawdats);
			Plot.plot(fdatas,"g");
			Plot.hold_off();
			
			// -------------------
			// FFT变换
			// FFT变换只接受Complex数组输入，计算结果也是Complex数组，
			// 因此在进行FFT之前先讲double数组转换成Complex[]，计算完了之后转回double数组用于绘图
			// 对于这种需要多次转换的操作建议使用管道操作（BasePipe.pipesCal）
			// 管道的输入数据为rawdats，先经过DoublesToComplexs转换成Complex[]
			// 然后经过FFT管道进行FFT变换
			// 变换结果为complex[]，经过一个ComplexsToDoubles转换成double数组
			// --------------------
			// FFT函数见com.sin.java.dsp.trans.SignalTransfor中
			double[] dffts = (double[])BasePipe.pipesCal(rawdats, new DoublesToComplexs(), new FFT(), new ComplexsToDoubles());
			Plot.figrue("FFT变换");
			Plot.plot(dffts,"b");
		}
		else{
			System.err.println("从文件中读取波形失败");
		}
	}
}



