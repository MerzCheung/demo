package com.ming.zhang.java_guide.接口函数;

import java.util.Arrays;
import java.util.List;

/**
 * @author 张铭
 * @since 2023/2/6 9:51
 */
public class Person {

    public void run(final TestInterface testInterface) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        for (Integer integer : integers) {
            testInterface.play(integer);
        }
    }
}
