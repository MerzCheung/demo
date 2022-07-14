package com.ming.zhang.java_guide.java8.内置的函数式接口;

import java.util.function.Consumer;

class Person2 {
    String firstName;
    String lastName;

    Person2() {}

    Person2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}


public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Person2> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person2("Luke", "Skywalker"));
    }
}
