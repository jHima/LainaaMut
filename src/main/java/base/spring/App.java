package base.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBean.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		HelloWorld abc = (HelloWorld) context.getBean("moikkaBean");
		obj.printHello();
		abc.printHello();

	}

}
