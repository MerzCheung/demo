package com.ming.zhang.java_guide.java8.Optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> boo = Optional.of("boo");
        boolean present = boo.isPresent();
        System.out.println(present);
        System.out.println(boo.get());
        System.out.println(boo.orElse("too"));

        Optional<Object> empty = Optional.empty();
        // System.out.println(empty.isPresent()); // NoSuchElementException
        // System.out.println(empty.get()); // NoSuchElementException
        System.out.println(empty.orElse("1111")); // "1111"

        Optional<String> s1 = Optional.ofNullable("");
        Optional<String> s2 = Optional.ofNullable("123");
        Optional<Object> s3 = Optional.ofNullable(null);
//        System.out.println(s1.isPresent()); // true
//        System.out.println(s1.get()); // ""
//        System.out.println(s1.orElse("444")); // ""
//        System.out.println(s2.isPresent()); // true
//        System.out.println(s2.get()); // "123"
//        System.out.println(s2.orElse("444")); // "123"
//        System.out.println(s3.isPresent()); // NoSuchElementException
//        System.out.println(s3.get()); // NoSuchElementException
        System.out.println(s3.orElse("444")); // 444
    }
}
