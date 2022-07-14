package com.ming.zhang.java_guide.java8.函数式接口;

import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        Converter<Integer, String> c = Integer::valueOf;
        Integer convert = c.convert("123");
        System.out.println(convert);
        Predicate<Integer> p = f -> f > 0;
        System.out.println(p.test(10));
    }
}
