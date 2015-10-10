/**
 * Creation Date:2015年7月23日-上午11:28:53
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月23日-上午11:28:53
 * @since 2015年7月23日-上午11:28:53
 */
public class TheadJoinTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner r1 = new Runner();
		//r1.run(); 				//调用run跟普通函数调用一样，达不到线程并发执行效果 
		Thread t1 = new Thread(r1); //要启动一个新的线程就必须new一个Thread对象出来, 这里使用Thread(Runnable target)构造方法
		t1.setName("Runnable 1");
		//启动新开辟的线程，新线程执行的是run()方法，新线程与主线程会一起并行执行
		t1.start();
		try {
			t1.join(); /// 调用join()方法合并线程，将子线程mythread合并到主线程里面. 合并线程后，执行完t1， 再回到主线程。程序的执行的过程就相当于是方法的调用的执行过程
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int index = 0; index <5; index++){
			System.out.println("Index in Main " + index);
		}
	}

}


class Runner implements Runnable{
	@Override
	public void run() {
		for (int index = 0; index <25; index++){
			System.out.println("Index in Runner " + index);
		}
	}
	
}

