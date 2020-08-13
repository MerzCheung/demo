package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void sys() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    void sys00() {
        String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].\\\\<>\\-/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
        System.out.println("^$$^))&*1&1+.*-/\\\\'|:;><.,/?-_)(*&^%$#@!~`23".replaceAll(regEx, "0"));
    }



    @Test
    public void test2() {
        System.out.println(new BigDecimal(-1));
        System.out.println(BigDecimal.valueOf(-1));
    }


    @Test
    public void test3() {
        List<String> pscgCodes = new ArrayList<>();
        String errorMsg = StringUtils.join(pscgCodes, ",");
        System.out.println(errorMsg);
    }

    @Test
    public void test4() {
        List<BigDecimal> integers = Arrays.asList(BigDecimal.valueOf(1),BigDecimal.valueOf(2), BigDecimal.valueOf(3));
        BigDecimal reduce = integers.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);
    }

    @Test
    public void test6() {
       Map map = new HashMap();
       map.put("aa", 1);
       map.put("aa", 2);
        System.out.println(map.get("aa"));
    }

    @Test
    public void test7() {
        BigDecimal sourceAmt = BigDecimal.ZERO;
        System.out.println(sourceAmt.abs());
    }

    @Test
    public void test8() {
        System.out.println(!(null == null) + "");
    }


    @Test
    public void test9() {
        Person p1 = new Person();
        p1.setName("1");
        Person p2 = new Person();
        p2.setName(p1.getName());
        p1.setName("2");
        System.out.println(p2.toString());
    }

    @Test
    public void test10() {
        Map map = new HashMap();
        Person p1 = new Person();
        p1.setName("1");
        map.put("a", p1);
        Person p2 = new Person();
        p2.setName("2");
        map.put("b", p2);
        ArrayList arrayList = new ArrayList<>(map.values());
        System.out.println(arrayList);
    }

    @Test
    public void test11() {
        BigDecimal b1 = BigDecimal.ZERO;
        System.out.println(b1.compareTo(BigDecimal.ZERO));
        System.out.println(b1.compareTo(BigDecimal.ONE));
    }



    @Test
    public void test12() {
//        List<Long> updateSettlementList = new ArrayList<>();
//        Object[] split = {"1", "2"};
//        CollectionUtils.addAll(updateSettlementList, split);
        Long a = null;
        System.out.println(0 != a);
    }

    @Test
    public void test13() {
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int start = 0;
        int curr = 4;
        int end = 0;
        while (start < ids.size()) {
            end = start + curr;
            List<Integer> subIds = ids.subList(start, Math.min(ids.size(), end));
            start += curr;
//            subIds.clear();
        }
    }

    @Test
    public void test14() {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map);
    }

    @Test
    void sys2() {
        List<Person> list = new ArrayList<>();
        Person p1 = Person.builder().name("张三").address(null).build();
        Person p2 = Person.builder().name("李四").address("123").build();
        Person p3 = Person.builder().name("李四").address("332").build();
        Person p4 = Person.builder().name("李四").address(null).build();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
//        Map<String, String> collect = list.stream().collect(Collectors.toMap(Person::getName, obj -> Optional.ofNullable(obj.getAddress()).orElse("")));
//        String s = JSON.toJSONString(collect);
//        System.out.println(s);
//
//        Map<String, String> map = JSON.parseObject(s, Map.class);
//        System.out.println(map);
//        System.out.println(map.isEmpty());
//        System.out.println(map.get("123"));

        ArrayList<Person> collect = list.stream().collect(
                collectingAndThen(toCollection(() -> new TreeSet<>(comparing(Person::getName))), ArrayList::new));
        System.out.println(collect);
    }

    @Test
    void toMap() {
        Person p1 = Person.builder().name("张三").address(null).build();
        Person p2 = Person.builder().name("李四").address("123").build();
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
//        Map map1 = list.stream().collect(Collectors.toMap(Person::getName, obj -> Optional.ofNullable(obj.getAddress()).orElse(obj.getName())));
//        System.out.println(map1);
        Map map2 = list.stream().collect(Collectors.toMap(Person::getName, Person::getAddress));
        System.out.println(map2);
    }

    @Test
    void contextLoads() {
        System.out.println(new BigDecimal(Double.parseDouble("9.30")));
        System.out.println(new BigDecimal(Double.parseDouble("0.17")));
        System.out.println(new BigDecimal("9.30"));
        System.out.println(new BigDecimal(Double.toString(Double.parseDouble("9.3000000000000007"))));
        System.out.println(new BigDecimal("0.17"));
        System.out.println(Double.toString(9.3000000000000007));
    }

    @Test
    void contextLoads2() {
       String str1 = "123";
        str1.intern();
       String str2 = "123";
        str2.intern();
        System.out.println(str1==str2);
    }

    @Test
    void contextLoads3() {
        Map<String, String> multipleConfigVoMap = new HashMap<>();
        multipleConfigVoMap.put("1000381", "Winit返利");
        multipleConfigVoMap.put("1000383", "消费");
        multipleConfigVoMap.put("1000389", "商务折扣");
        multipleConfigVoMap.put("1000390", "礼品卡抵扣");
        multipleConfigVoMap.put("1000391", "优惠券抵扣");
        multipleConfigVoMap.put("123333", null);
        String s = multipleConfigVoMap.get("123333");
        System.out.println(Optional.ofNullable(s).orElse("消费"));
    }

    @Test
    void contextLoads4() {
        BigDecimal t1 = new BigDecimal(1.745).multiply(BigDecimal.valueOf(100));
        BigDecimal t2 = new BigDecimal(0.745).multiply(BigDecimal.valueOf(100));
        BigDecimal t3 = BigDecimal.valueOf(0.745);
        t1 = t1.setScale(2, BigDecimal.ROUND_HALF_UP);
        t2 = t2.setScale(2, BigDecimal.ROUND_HALF_UP);
        t3 = t3.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("t1: " + t1.divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP));
        System.out.println("t2: " + t2.divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP));
        System.out.println("t3: " + t3);
    }

}
