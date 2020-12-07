package com.example.demo;

import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
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

    @Test
    public void random() {
        for(int i = 0; i< 10; i++) {
            System.out.println(new Random().nextInt(9999));
        }
    }

    @Test
    public void quota() {
        Quota q1 = new Quota();
        q1.setStart(1);
        q1.setEnd(30);
        q1.setAmt(10000);
        Quota q2 = new Quota();
        q2.setStart(10);
        q2.setEnd(20);
        q2.setAmt(20000);
        Quota q3 = new Quota();
        q3.setStart(15);
        q3.setEnd(30);
        q3.setAmt(30000);
        Quota q4 = new Quota();
        q4.setStart(15);
        q4.setEnd(25);
        q4.setAmt(10000);
        List<Quota> list = new ArrayList<>();
        list.add(q2);
        list.add(q1);
        list.add(q3);
        list.add(q4);
        list = list.stream().sorted(Comparator.comparing(Quota::getStart)).collect(Collectors.toList());
        List<Integer> starts = new ArrayList<>();
        list.forEach(item -> {
            starts.add(item.getStart());
            starts.add(item.getEnd());
        });
        Collections.sort(starts);
        List<Quota> results = new ArrayList<>();
        Integer end = 0;
        for (int i = 0; i < starts.size() - 1; i++) {
            Integer start = starts.get(i);
            end = starts.get(i + 1);
            if (start != end) {
                Integer amt = 0;
                for (Quota quota : list) {
                    if (quota.getStart() <= start && quota.getEnd() >= end) {
                        amt += quota.getAmt();
                    }
                }
                Quota q = new Quota();
                q.setStart(start);
                q.setEnd(end);
                q.setAmt(amt);
                results.add(q);
            }
        }
        System.out.println(results);
    }

    @Test
    public void date() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        System.out.println(calendar.getTime());
    }
}
