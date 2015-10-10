import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Creation Date:2015年8月5日-下午7:16:10
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年8月5日-下午7:16:10
 * @since 2015年8月5日-下午7:16:10
 */
public class ConcurrentHashMapTest {
	private static Map<Integer, Object> map = new ConcurrentHashMap<Integer, Object>();
	
	public ConcurrentHashMapTest() {
		//此种方法new 出来的HashMap 线程同步，跟HashTable类似
//		Map<String, Object> m2 = Collections.synchronizedMap(new HashMap<String, Object>());
		new Thread("Thread1"){  
            @Override  
            public void run() {  
            	ConcurrentHashMapTest.this.map.put(3, 33); 
            }  
        };  
          
        new Thread("Thread2"){  
            @Override  
            public void run() {  
                map.put(4, 44);  
            }  
        };  
          
        new Thread("Thread3"){  
            @Override  
            public void run() {  
                map.put(7, 77);  
            }  
        };  
        System.out.println(map);  
    } 
	
	public static void main(String[] args) {
		//ConcurrentHashMapTest test = new  ConcurrentHashMapTest();
		new Thread("Thread1"){  
            @Override  
            public void run() {  
                map.put(3, 33);  
            }  
        };  
          
        new Thread("Thread2"){  
            @Override  
            public void run() {  
                map.put(4, 44);  
            }  
        };  
          
        new Thread("Thread3"){  
            @Override  
            public void run() {  
                map.put(7, 77);  
            }  
        };  
	}

}

