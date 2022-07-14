package com.ming.zhang.java_guide.java8.内置的函数式接口;

import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Comparator<Person2> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person2 p1 = new Person2("John", "Doe");
        Person2 p2 = new Person2("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0
    }
}
