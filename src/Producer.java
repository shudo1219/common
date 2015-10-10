import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * Creation Date:2015年7月21日-下午3:45:14
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月21日-下午3:45:14
 * @since 2015年7月21日-下午3:45:14
 */
public class Producer {

//	private static final String IPADDR = "10.1.24.127:9876"; 
	private static final String IPADDR = "192.168.134.32:9876"; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /**
		   * 一个应用创建一个Producer，由应用来维护此对象，可以设置为全局对象或者单例
		   * 注意：ProducerGroupName需要由应用来保证唯一
		   * ProducerGroup这个概念发送普通的消息时，作用不大，但是发送分布式事务消息时，比较关键，
		   * 因为服务器会回查这个Group下的任意一个Producer
		   */
		DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
		producer.setNamesrvAddr(IPADDR);
		producer.setInstanceName("Producer Instance");
		String topic = "Topic";
		
		String tagA = "TagA";
		String tagB = "TagB";
		
		String keyA = "KeyA";
		String keyB = "KeyB";
		
		try {
			/**
			   * Producer对象在使用之前必须要调用start初始化，初始化一次即可, !!!注意：切记不可以在每次发送消息时，都调用start方法
			   */
			producer.start();
			 
			  /**
			   * 一个Producer对象可以发送多个topic，多个tag的消息; 一般是一个topic + 多个tag
			   * 注意：send方法是同步调用，只要不抛异常就标识成功。
			   * 发送成功也可会有多种状态，例如消息写入Master成功，但是Slave不成功，这种情况消息属于成功。
			   *但是对于个别应用如果对消息可靠性要求极高，需要对这种情况做处理。
			   * 另外，消息可能会存在发送失败的情况，失败重试由应用来处理。
			   */
		
			for (int index = 0 ; index < 6; index++){
				Message msg = new Message(topic, tagA, keyA, ("BodyA :" + new Date() + "Hello RocketMQ ,QuickStart" + index).getBytes());
				SendResult sendResult = producer.send(msg);
//				System.out.println("For Msg A, MsgId:" + sendResult.getMsgId()  + ", offset: " + sendResult.getQueueOffset() 
//						+ ", status:" + sendResult.getSendStatus());
				System.out.println("MsgA info in Producer: " + sendResult.toString());
				TimeUnit.MILLISECONDS.sleep(3000);
		//		Thread.sleep(1000);
				
				msg = new Message(topic, tagB, keyB, ("BodyB :" + new Date() + "Hello RocketMQ ,QuickStart" + index).getBytes());
				sendResult = producer.send(msg);
//				System.out.println("For Msg B, MsgId:" + sendResult.getMsgId()  + ", offset: " + sendResult.getQueueOffset() 
//						+ ", status:" + sendResult.getSendStatus());
				System.out.println("MsgB info in Producer: " + sendResult.toString());
				
				/**
				 *
				 *{ 
                    Message msg = new Message("TopicTest2",// topic 
                        "TagB",// tag 
                        "OrderID0034",// key 
                        ("Hello MetaQ").getBytes());// body 
                    SendResult sendResult = producer.send(msg); 
                    System.out.println(sendResult); 
                } 
				 */
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			  /**
			   * 应用退出时，要调用shutdown来清理资源，关闭网络连接，从MetaQ服务器上注销自己
			   * 注意：我们建议应用在JBOSS、Tomcat等容器的退出钩子里调用shutdown方法
			   */
			producer.shutdown();
		}
		
	}

}

