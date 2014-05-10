# JavaDsp


数字信号处理(DSP)方面的Java封装，包含常用的一些处理方法，如滤波、信号变换等等。




## 说明

#### 架构（管道风格）

考虑到信号处理都是数据（信号）的输入和输出，为了便于多重操作（前一个输出作为后一个的输入），整个库大量采用“管道”风格。
在com.sin.java.dsp.base下面定义了管道的基本属性和基本操作。

数据类型变换和信号处理都属于管道操作，他们都继承子管道基类。

常用的调用：BasePipe.pipesCal(原始输入, 管道1, 管道2, 管道3)，该调使“原始输入”顺序“流过”管道1、 管道2、 管道3。上一个管道的输出类型必须是下一个管道的输入类型，否则会出现类型转换错误。

如果只使用单个管道对数据进行处理的话可能会是这样的：管道A.calDoubles(数据)，让数据流过“管道A”，并将流出后的数据强制转换成double[]。

具体的使用实例见test下面。

#### 包结构说明

* com.sin.java.dsp 根目录
* com.sin.java.dsp.base 基础包，保护复数定义和管道定义
* com.sin.java.dsp.adapter 适配器，用于数据类型转换
* com.sin.java.dsp.filter 广义滤波器（所有的信号变换都定义为滤波）
* com.sin.java.dsp.trans 信号变换
* com.sin.java.dsp.util 工具包

## 部分运行截图

* 对信号进行滤波

![image](https://raw.githubusercontent.com/sintrb/JavaDsp/master/doc/screenshots/meanflt.png)

* 对信号进行FFT

![image](https://raw.githubusercontent.com/sintrb/JavaDsp/master/doc/screenshots/fft.png)


=

## 怎么获取这些代码？

* 如果你只是想简单的使用这些代码的话你可以把它当作一个压缩包下载到你的电脑上，点击右边的“Download ZIP”:

![image](https://raw.githubusercontent.com/sintrb/forgithub/master/img/screenshots/githubdownloadzip.png)


* 如果你喜欢这些代码，那么你可以加星：

![image](https://raw.githubusercontent.com/sintrb/forgithub/master/img/screenshots/githubstart.png)

* 如果你觉得这些代码还有很多可以改善的地方，那么请先fork一下（欢迎fork）：

![image](https://raw.githubusercontent.com/sintrb/forgithub/master/img/screenshots/githubfork.png)

* fork之后这些代码就变成了你的了，你可以从自己的仓库中把它们clone到你的电脑上，之后的操作就和git一样了：

![image](https://raw.githubusercontent.com/sintrb/forgithub/master/img/screenshots/githubsshclone.png)

**享受开源带来的乐趣吧**

 

