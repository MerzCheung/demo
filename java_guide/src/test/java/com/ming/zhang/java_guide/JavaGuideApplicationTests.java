package com.ming.zhang.java_guide;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class JavaGuideApplicationTests {

    @Test
    void contextLoads() {
        String dateStr = "2017-04-02";
        Date date = DateUtil.parse(dateStr);
        String dateStr1 = "2017-03-01";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01";
        Date date2 = DateUtil.parse(dateStr2);
        boolean isIn = DateUtil.isIn(date,date1,date2);
        System.out.println(isIn);
    }

}
