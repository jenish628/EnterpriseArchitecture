package edu.miu.cs544;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
    @Value("Hello World")
    private String greeting;

    @Value("jenish")
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void printA(){
        System.out.println(a);
    }
    public void sayHello(){
        System.out.println(greeting);
    }

    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public Greeting() {
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
