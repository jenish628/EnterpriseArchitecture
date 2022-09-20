package edu.mum.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App
{
	public static void main(String[] args) {

		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("springconfig.xml");

		IBookService bookService = applicationContext.getBean("bookService", IBookService.class);

		Book b1 = new Book("123433267", "Harry Potter and the Order of the Phoenix", "J.K. Rowling");
		Book b2 = new Book("888832678", "Harry Potter and the Sorcerer's Stone" , "J.K. Rowling");
		Book b3 = new Book("999923156", "Harry Potter and the Goblet of Fire" ,"J.K. Rowling");


		bookService.buy(b1);
		bookService.buy(b2);
		bookService.buy(b3);

	}
}
