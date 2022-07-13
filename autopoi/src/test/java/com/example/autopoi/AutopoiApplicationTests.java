package com.example.autopoi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class AutopoiApplicationTests {

    @Test
    public void test() {
        List<List<Object>> list = new ArrayList<>();
        list.add(Arrays.asList("1", BigDecimal.valueOf(3)));
        list.add(Arrays.asList("2", BigDecimal.valueOf(1)));
        list.add(Arrays.asList("3", BigDecimal.valueOf(2)));
        double sum = list.stream().mapToDouble(i -> Double.parseDouble(i.get(1).toString())).sum();
        System.out.println(sum);
    }

}
