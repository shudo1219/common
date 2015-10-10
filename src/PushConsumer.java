import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * Creation Date:2015年7月21日-下午4:17:58
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月21日-下午4:17:58
 * @since 2015年7月21日-下午4:17:58
 */
public class PushConsumer {

//	private static final String IPADDR = "10.1.24.127:9876"; 
	private static final String IPADDR = "192.168.134.32:9876"; 
	public static void main(String[] args) {
		 /**
	       *使用方式给用户感觉是消息从RocketMQ服务器推到了应用客户端。
	       *但实际PushConsumer内部是使用长轮询Pull方式从MetaQ服务器拉消息，
	       *然后再回调用户Listener方法
	       */
		// TODO Auto-generated method stub
		 /**
         * 一个应用创建一个Consumer，由应用来维护此对象，可以设置为全局对象或者单例
         * 注意：ConsumerGroupName需要由应用来保证唯一
         */
		DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("ConsumerGroupName");
		pushConsumer.setNamesrvAddr(IPADDR);
		pushConsumer.setInstanceName("Instance for Push Consumer");
		try {
			/**订阅Topic下Tag为TagA的消息 
			  *订阅指定topic下tags分别等于TagA或TagC或TagD consumer.subscribe("TopicTest1", "TagA || TagC || TagD");
	         */
			pushConsumer.subscribe("Topic", "TagA");
			 /**
	         * 订阅指定topic下所有消息 consumer.subscribe("TopicTest2", "*");
	         * 注意：一个consumer对象可以订阅多个topic
	         */
	        
			//程序第一次启动从消息队列头取数据 
			pushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
	        //默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
			pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
				@Override
				public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
						ConsumeConcurrentlyContext context) {
					System.out.println("Size of MessageExt:" + list.size());
					for (MessageExt msg :list){
						//System.out.println("MsgId:" + msg.getMsgId() + ", topic in push consumer:" +  msg.getTopic() + ", key:" + msg.getKeys() 
						//		+  ", body:" + msg.getBody() + ", storeHost:" + msg.getStoreHost());
						System.out.println(msg.getBody() + ",Msg info in Push consumer: " + msg.toString());
					}
					// TODO Auto-generated method stub
					return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
				}
			});
			//Consumer对象在使用之前必须要调用start初始化，初始化一次即可
			pushConsumer.start();
			
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}

