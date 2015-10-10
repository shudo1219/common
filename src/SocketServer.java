import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Creation Date:2015年7月20日-下午3:23:25
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月20日-下午3:23:25
 * @since 2015年7月20日-下午3:23:25
 */
/*客户端通过端口6666向服务器端请求连接，服务器端接受客户端的连接请求以后，就在服务器端上安装一个Socket，然后让这个Socket与客户端的Socket连接，这样服务器端就可以与客户端互相通信了，
 * 当有另外一个客户端申请连接时，服务器端接受了以后，又会安装另外一个Socket与这个客户端的Socket进行连接。
*/
public class SocketServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 /*创建一个ServerSocket对象时往往会给它指定一个端口号
		    指定端口号的意思是这个new出来的ServerSocket对象要使用的是哪一个端口号，通过哪一个端口号来监听客户端的连接
		    因此指定一个端口号的意义就是为了告诉计算机ServerSocket对象 在哪个地方监听客户端的连接
		    */
		
		ServerSocket ss = new ServerSocket(6666);

		/*服务器端接收客户端连接的请求是不间断地接收的，所以服务器端的编程一般都是死循环，永不休止地运行着。*/
		while(true){
			/*在服务器端调用accept()方法接受客户端的连接对象,accept()方法是一个阻塞式方法，一直在傻傻地等待着是否有客户端申请连接上来
			  然后服务器端的Socket插座就和客户端的Socket插座建立了连接了
			  客户端能否连接上服务器端，取决于服务器端是否接受客户端的连接请求.
			   如果接受了客户端的连接请求，那么在服务器端就安装上一个Socket插座通过这个插座与连接上的客户端就可以建立连接，互相通信了
			*/
			Socket socket = ss.accept();
			
			/*使用InputStream流接收从客户端发送过来的信息，使用DataInputStream数据流处理接收到的信息*/
			DataInputStream   dis = new DataInputStream(socket.getInputStream());
			/*使用readUTF(方法将接收到的信息全部读取出来，存储到变量str里面
	     	 readUTF()方法也是一个阻塞式方法，会傻傻地等待客户端发送信息过来，然后将接收到的信息读取出来
			如果客户端不写东西过来，它就一直在服务器端傻傻地等待着，直到客户端写东西过来为止
			 堵塞式的方法效率往往是不高的,比如说一个客户端连接上来了，但是它迟迟不发送信息，
			那么服务器端的程序就阻塞住了，这样另外一个客户端就连接不上来了，因为另外一个客户端要想连接上服务器端，就必须得在服务器端调用accept()方法.
			可accept()方法必须得在下一次循环时才能够被调用，现在服务器端的程序运行到调用readUTF()这个方法时就阻塞住了，它要等待着已经连接上来的
			那个客户端发送信息过来后将信息读取出来，如果客户端一直不发信息到服务器端，那么readUTF()方法就一直无法读取到信息，
			那么服务器端的程序会阻塞在这里，无法进行下次循环，这样其他的客户端就无法连接到服务器端了*/
		
			System.out.println("Get message "  + dis.readUTF());
		}
	}

}

