package com.ming.zhang.java_guide.java8.内置的函数式接口;
/*

Predicate 是一个可以指定入参类型，并返回 boolean 值的函数式接口。它内部提供了一些带有默认实现的方法，可以 被用来组合一个复杂的逻辑判断（and, or, negate）：
*/

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate1 = (s) -> s.length() > 0;
        Predicate<String> predicate2 = (s) -> s.length() > 5;
        System.out.println(predicate1.test("foo"));
        System.out.println(predicate1.negate().test("foo"));
        System.out.println(predicate1.and(predicate2).test("foo"));
        System.out.println(predicate1.or(predicate2).test("foo"));
    }
}
