import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

/**
 * Creation Date:2015年8月5日-下午8:19:04
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年8月5日-下午8:19:04
 * @since 2015年8月5日-下午8:19:04
 */

 class DateTask extends TimerTask {  
    public void run() {  
        System.out.println("任務時間：" + new Date());  
    }  
}  
 
public class TimerTest {
	public static void main(String[] args) {  
        Timer timer = new Timer(); 
        
//        timer.schedule(new DateTask(), 1000);  
        timer.schedule(new DateTask(), 1000, 3000);
        System.out.println("現在時間：" + new Date());  
  
        try {  
            Thread.sleep(20000);  
        }  
        catch(InterruptedException e) {  
        }  
  
        timer.cancel();  
    }  
 }  


