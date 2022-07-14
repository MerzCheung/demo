package com.ming.zhang.java_guide.java8.Lambda表达式;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//         Collections.sort(names, (String a, String b) -> b.compareTo(a));
        // names.sort((a, b) -> b.compareTo(a));
        names.sort(String::compareTo);
        System.out.println(names);
    }
}
