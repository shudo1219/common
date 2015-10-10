import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Creation Date:2015年7月20日-下午3:23:36
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 * 
 * @author (刘树东 10546)
 * @version 1.0.0, 2015年7月20日-下午3:23:36
 * @since 2015年7月20日-下午3:23:36
 */
public class ClientSocket {

	public static void main(String[] argv) throws Exception {
		for (int index = 0; index < 100; index++) {
			 /*Client申请连接到Server端上*/
			/*连接上服务器端以后，就可以向服务器端输出信息和接收从服务器端返回的信息
			  输出信息和接收返回信息都要使用流式的输入输出原理进行信息的处理
			*/
			Socket s = new Socket("127.0.0.1", 6666);
			 /*这里是使用输出流OutputStream向服务器端输出信息*/
			//OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream( s.getOutputStream());
			// for (int index =0 ; index <100; index++){
			Thread.sleep(3000);/* 客户端睡眠30秒后再向服务器端发送信息 */
			dos.writeUTF("Hello Server, send from client " + index);
		}
	}
}
