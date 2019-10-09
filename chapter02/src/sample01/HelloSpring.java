package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messageBean = (MessageBean)context.getBean("messageBeanImpl");
		messageBean.sayHello();
		messageBean.sayHello("����", 20000);
		messageBean.sayHello("�丶��", 3500, 7);
	}
}
