package yechao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yechao.*;

public class TestSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-mybatis.xml"); 
		HelloWord obj = (HelloWord) context.getBean("helloBean");
		obj.printHello();
		

	}

}
