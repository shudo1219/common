import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Creation Date:2015年7月23日-下午3:09:21
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月23日-下午3:09:21
 * @since 2015年7月23日-下午3:09:21
 */
public class MMap {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RandomAccessFile raf = new RandomAccessFile(new File("F:/mmap.txt"), "rw");
		FileChannel channel = raf.getChannel();
		//从文件哪个位置开始写
		int startAdd = 10;
		//文件大小
		int size = 1024*1024;
		MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, startAdd, size);
		buffer.clear();
		String data = "Once there was several chances for me to catch!";
		for(int index =0 ; index < 100; index++){
			buffer.put((byte)(65 + index));
			//换行
			buffer.putChar('\n');
		}
		buffer.put(data.getBytes());
		buffer.putChar('\n');
		buffer.putChar('A');
		buffer.putChar('\n');
		//数字256被写成
		buffer.put(new String("256").getBytes());
		buffer.putChar('\n');
		//被识别为	嗇
		buffer.putLong(159833352L);
		buffer.putChar('\n');
		
		
		String number = "215";
		System.out.println(number + "-->" + number.hashCode());
		number = "134";
		System.out.println(number + "-->" + number.hashCode());
		number = "97";
		System.out.println(number + "-->" + number.hashCode());
		}

}

