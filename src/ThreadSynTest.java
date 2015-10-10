/**
 * Creation Date:2015年7月23日-下午2:06:39
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月23日-下午2:06:39
 * @since 2015年7月23日-下午2:06:39
 */
public class ThreadSynTest implements Runnable {

	private Timer timer = new Timer();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadSynTest test = new ThreadSynTest();
		Thread t1 = new Thread(test);
		t1.setName("Thread-1");
		t1.start();
		Thread t2 = new Thread(test);
		t2.setName("Thread-2");
		t2.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		timer.add(Thread.currentThread().getName());
	}

}

class Timer{
	private static int num = 0;
	public void add(final String name){ // 在声明方法时加入synchronized时表示在执行这个方法的过程之中当前对象被锁定
		// num ++ 不是原子操作，若不加synchronized, 
		//HiThread-1, you are 2 visitors
		//HiThread-2, you are 2 visitors
		synchronized (this) {
			  /*
			   * 使用synchronized(this)来锁定当前对象，这样就不会再出现两个不同的线程同时访问同一个对象资源的问题了 只有当一个线程访问结束后才会轮到下一个线程来访问
			  */
			num ++;
			try {
				if(Thread.currentThread().getName().equals("Thread-1"))
					Thread.sleep(7000);
				else
					Thread.sleep(3000);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hi " + name + ", you are " + num + " visitors");
		}
	}
}

