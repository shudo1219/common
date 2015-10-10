import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Creation Date:2015年7月23日-下午3:10:04
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月23日-下午3:10:04
 * @since 2015年7月23日-下午3:10:04
 */
public class AtomicTest implements Runnable{
	//可使用synchronized 达到 同步效果， 如果用int
	//private static int Count = 0;
	//public void run() {
	//	synchronized (this)
//			  System.out.println(Thread.currentThread().getName()   
//	                + ":" + (++Count));  
//	}
	
	private final AtomicInteger count = new AtomicInteger(0);  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicTest test = new AtomicTest();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		Thread t3 = new Thread(test);
		Thread t4 = new Thread(test);
		Thread t5 = new Thread(test);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() 
				+ ":" + count.incrementAndGet());
		
	}

}

