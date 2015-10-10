import java.io.Serializable;

/**
 * Creation Date:2015年7月20日-下午2:35:21
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年7月20日-下午2:35:21
 * @since 2015年7月20日-下午2:35:21
 */
public class Person implements Serializable{

	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 7592930394427200495L;
	
	private String name;
	
	private String sex;
	
	private int age;
	
	public Person(String name, String sex, int age){
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

