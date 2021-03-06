package guo.ping.ioc.bean;

import guo.ping.ioc.loadbean.Car;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactoryTests;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/7/23 21:01
 * @project: spring
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

	@Test
	public void testSimpleLoad() {
		ClassPathResource resource = new ClassPathResource("beanFactoryTest.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
		Car car = (Car) beanFactory.getBean("testCarFactoryBean");
		System.out.println(myTestBean.getTestStr());
		System.out.println(car);
	}

	@Test
	public void testWxIOC(){
		ClassPathResource classPathResource = new ClassPathResource("wxTest/beans.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(classPathResource);
		Person me = beanFactory.getBean(Person.class);
		System.out.println(me.getName());
	}
}
