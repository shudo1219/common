import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;
import java.util.Calendar;

/**
 * Creation Date:2015年7月20日-下午2:36:46
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月20日-下午2:36:46
 * @since 2015年7月20日-下午2:36:46
 */
public class TestSerializeAndDeserialize {
	private static String fileName = "E:/Person.txt";
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Person person = new Person("shudo", "M", 28);
		serializePerson(person);
		Person born = deserializePerson();
		System.out.println(MessageFormat.format("name={0},age={1},sex={2}", born.getName(), born.getAge(), born.getSex()));
		System.out.println(Calendar.MILLISECOND);
	}

	private static void serializePerson(Person person) throws FileNotFoundException, IOException{
		ObjectOutputStream os = new ObjectOutputStream(
				new FileOutputStream(new File(fileName)));
		
		os.writeObject(person);
		os.close();
		System.out.println("It makes it to serialize person");
	}
	
	private static Person deserializePerson() throws FileNotFoundException, IOException, Exception{
		ObjectInputStream is = new ObjectInputStream( 
				new FileInputStream(new File(fileName)));
		
		Person born = (Person)is.readObject();
		is.close();
		
		return born;
	}
}

