package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class ThreadTest {

    @Test
    public void test() {
        List<Demo> list = new ArrayList<>();
        Demo d1 = Demo.builder().id(2).name("1").age(1).build();
        Demo d2 = Demo.builder().id(1).name("1").age(1).build();
        Demo d3 = Demo.builder().id(4).name("2").age(2).build();
        Demo d4 = Demo.builder().id(3).name("2").age(2).build();
        Demo d5 = Demo.builder().id(5).name("2").age(1).build();
        Demo d6 = Demo.builder().id(6).name("3").age(2).build();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
        list.add(d6);
        Map<String, Map<Integer, List<Demo>>> collect = list.stream().sorted(Comparator.comparing(Demo::getId))
                .collect(Collectors.groupingBy(Demo::getName, Collectors.groupingBy(Demo::getAge)));
        System.out.println(collect);
    }
}
