package com.ming.zhang.java_guide.java8.内置的函数式接口;
/*

它不接受入参，直接为我们生产一个指定的结果，有点像生产者模式
*/

import java.util.function.Supplier;

class Person {
    String name;
    Integer age;
    Person(){}
    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Person> s = Person::new;
        Person person1 = s.get();
        System.out.println(person1.hashCode());
        System.out.println(person1.name);
        System.out.println(person1.age);
        Person person2 = s.get();
        System.out.println(person2.hashCode());
        System.out.println(person2.name);
        System.out.println(person2.age);
    }


}
