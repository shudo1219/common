/**
 * Creation Date:2015年7月23日-下午1:39:05
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月23日-下午1:39:05
 * @since 2015年7月23日-下午1:39:05
 */
public class ThreadYieldTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner n1 = new Runner();
		Runner2 n2 = new Runner2();
		
		Thread t1 = new Thread(n1);
		t1.start();
		Thread t2 = new Thread(n2);
		t2.setPriority(Thread.NORM_PRIORITY + 5);
		t2.start();
	}

}


class Runner2 implements Runnable{
	private int count = 25;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int index =0 ; index < count; index++){
			System.out.println("index in Runner2 " + index );
			if (index%10==0)
				Thread.yield();
		}
		
	}
}
