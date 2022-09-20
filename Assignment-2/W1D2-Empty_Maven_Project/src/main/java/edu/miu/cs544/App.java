package edu.miu.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

//      ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
        Greeting greeting = applicationContext.getBean("greeting", Greeting.class);
        greeting.sayHello();
        greeting.printA();

    }

}
