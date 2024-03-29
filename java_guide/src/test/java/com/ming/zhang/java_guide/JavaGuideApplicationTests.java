package com.ming.zhang.java_guide;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.ming.zhang.java_guide.BeanFactoryPostProcessor.User;
import com.ming.zhang.java_guide.event.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class JavaGuideApplicationTests {

    @Autowired
    private User user;

    @Autowired
    private RegisterService registerService;

    @Test
    public void register() {
        registerService.register("张三");
    }

    @Test
    public void beanFactoryTest() {
        System.out.println(JSON.toJSONString(user));
    }


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
        Date date3 = DateUtil.parse("2017-04-01", "yyyy-MM-dd");
        Date date4 = DateUtil.parse("2017-04-01", "yyyy-MM-dd");
        System.out.println(date3.after(date4));
    }
}
