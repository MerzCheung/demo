package com.ming.zhang.java_guide.接口函数;

/**
 * @author 张铭
 * @since 2023/2/6 9:52
 */
public class Test {

    public static void main(String[] args) {
        Person p = new Person();
        p.run(i -> {
            System.out.println(i);
        });
    }
}
