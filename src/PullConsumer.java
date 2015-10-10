import java.util.List;
import java.util.Set;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * Creation Date:2015年7月21日-下午4:39:23
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月21日-下午4:39:23
 * @since 2015年7月21日-下午4:39:23
 */
public class PullConsumer {

	private static final String IPADDR = "10.1.24.127:9876";
	public static void main(String[] args) {
		DefaultMQPullConsumer pullConsumer = new DefaultMQPullConsumer("PullConsumer-Group");
		pullConsumer.setNamesrvAddr(IPADDR);
		pullConsumer.setInstanceName("Instance for Pull Consumer");
		long offset = 0L;
		try {
			pullConsumer.start();
			Set<MessageQueue>  mqs=  pullConsumer.fetchSubscribeMessageQueues("Topic");
			for( MessageQueue mq : mqs){
				System.out.println("topic in pull consumer:" + mq.getTopic() + " brokerName:"+ mq.getBrokerName());
				PullResult pullResult = pullConsumer.pullBlockIfNotFound(mq, null, offset, 32);
				List<MessageExt> list = pullResult.getMsgFoundList();
				if(list != null && list.size() > 0){
					for (MessageExt msg : list){
						System.out.println("Msg info in pull consumer: " + msg.toString());
					}
				}
				offset = pullResult.getNextBeginOffset();
			}
		} catch (MQClientException e) {
			e.printStackTrace();
		} catch (MQBrokerException e ){
			System.out.println("MQBrokerException " +e.getErrorMessage());
		}catch (RemotingException e){
			System.out.println("RemotingException " + e.getMessage());
		}catch (InterruptedException e){
			System.out.println("InterruptedException " +e.getMessage());
		}
		
	}

}

