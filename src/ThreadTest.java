/**
 * Creation Date:2015年8月6日-下午6:59:20
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年8月6日-下午6:59:20
 * @since 2015年8月6日-下午6:59:20
 */

/**
 * 
 * 这两种线程创建方式的比较

使用Runnable接口
实际工作中，几乎所有的多线程应用都用实现Runnable这种方式。
Runnable适合多个相同程序代码的线程去处理同一资源的情况。把虚拟CPU(线程)同程序的代码、数据有效的分离，较好的体现了面向对象的设计思想。
避免由于Java的单继承特性带来的局限性。也就是如果新建的类要继承其他类的话,因为JAVA中不支持多继承,就只能实现java.lang.Runnable接口。
有利于程序的健壮性，代码能够被多个线程共享，代码与数据是独立的。

                      
继承Thread类
不能再继承他类了。
编写简单，可以直接操纵线程，无需使用Thread.currentThread()。
 */


/**
* 使用Thread类模拟4个售票窗口共同卖100张火车票的程序
* 没有共享数据，每个线程各卖100张火车票
* 
*/
/**
public class ThreadTest {

public static void main(String[] args){
new MyThread().start();
new MyThread().start();
new MyThread().start();
new MyThread().start();
}

public static class MyThread extends Thread{
//车票数量
private int tickets=100;
@Override
public void run() {
while(tickets>0){
System.out.println(this.getName()+"卖出第【"+tickets--+"】张火车票");
}
}
}
}
*/
/**
extends Thread:  new Thread(){ run() }.start();     

implements Runnable:  new Thread( new Runnable(){ run()} ).start();
**/

/**
 * 
 * 
 * 
 public class Counter {
 
    public static int count = 0;
 
    public static void inc() {
 
        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
         count++;
    }
 
    public static void main(String[] args) {
 
        //同时启动1000个线程，去进行i++计算，看看实际结果, 
 
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            }).start();
        }
 
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + Counter.count);
    }
}
 */



/**
* 使用Runnable接口模拟4个售票窗口共同卖100张火车票的程序
* 
* 共享数据，4个线程共同卖这100张火车票
*/
public class ThreadTest {

	public static void main(String[] args) {
		Runnable runnable=new MyThread();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
		}

	public static class MyThread implements Runnable{
		//车票数量
		private int tickets=100;
		public void run() {
			while(tickets > 0){
				System.out.println(Thread.currentThread().getName()+"卖出第【"+tickets--+"】张火车票");
		}
		}

		}
}

