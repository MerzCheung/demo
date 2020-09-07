package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.landray.sysNotifyTodoWebServiceSource.Message;
import com.example.demo.service.TestService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private TestService testService;

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
    public void test15() throws IllegalAccessException {
        Person p = new Person();
        p.setId(1);
        p.setName("zhangsan");
        p.setAddress("123");
        testService.test(p);
    }


    @Test
    public void test16() throws IllegalAccessException {
        Map map = new HashMap();
        System.out.println(JSON.toJSONString(map));
    }

    @Test
    public void test17() throws IllegalAccessException {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person();
        Person p2 = new Person();
        list.add(p1);
        list.add(p2);
        Person p3 = new Person();
        p3.setList(list);
        Field[] declaredFields = p3.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String name = declaredField.getName();
            Object value = declaredField.get(p3);
            System.out.println(declaredField.getGenericType() instanceof ParameterizedType);
            if (declaredField.getGenericType() instanceof ParameterizedType){
                ParameterizedType pt = (ParameterizedType) declaredField.getGenericType();
                System.out.println(pt.getActualTypeArguments()[0].equals(Person.class));
                System.out.println((List<Person>)value);
            }
        }
    }

    @Test
    public void test18() {
        String str = "{\"pageCount\":1,\"pageno\":1,\"count\":1,\"docs\":[{\"id\":\"174244ffbc7d5477ae44e724d8699259\",\"subject\":\"张铭提交的流程已被审批人驳回，请重新提交文档：深圳市万邑通电子商务有限公司-保证金-头程相关费用-上海卓牧企业管理咨询有限公司-10000005-202008-100.0-人民币-CNY\",\"type\":1,\"key\":\"17420082e0ed82dd1b045c24eb5a359a\",\"param1\":\"174244ffbb85b14cf146ec34917937b8\",\"param2\":\"174244ffbbe51e13b08477b417088743\",\"appName\":null,\"modelName\":\"com.landray.kmss.km.review.model.KmReviewMain\",\"level\":3,\"moduleName\":\"流程管理\",\"modelId\":\"17420082e0ed82dd1b045c24eb5a359a\",\"createTime\":\"2020-08-25 14:30:55\",\"creator\":\"ming.zhang2\",\"creatorName\":\"张铭\",\"link\":\"/sys/notify/sys_notify_todo/sysNotifyTodo.do?method=view&fdId=174244ffbc7d5477ae44e724d8699259\"}]}";
        Object parse = JSON.parseObject(str, Message.class);
        System.out.println(parse.toString());
    }

    @Test
    public void test19() {
        List<Person2> list = new ArrayList<>();
        Person2 p1 = Person2.builder().age(1).address("11").name("33").build();
        Person2 p2 = Person2.builder().age(1).address("11").name("12").build();
        Person2 p3 = Person2.builder().age(2).address("22").name("44").build();
        Person2 p4 = Person2.builder().age(2).address("22").name("55").build();
        Person2 p5 = Person2.builder().age(3).address("3").name("66").build();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        Map<Integer, Map<String, List<Person2>>> collect = list.stream().collect(Collectors.groupingBy(Person2::getAge, Collectors.groupingBy(Person2::getAddress)));
        System.out.println(collect);
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
