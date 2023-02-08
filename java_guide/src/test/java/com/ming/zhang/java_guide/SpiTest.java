package com.ming.zhang.java_guide;

import com.ming.zhang.java_guide.SPI.spring.PersonTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张铭
 * @since 2023/2/7 16:27
 */
@SpringBootTest
public class SpiTest {

    @Autowired
    private PersonTest personTest;

    @Test
    public void say() {
//        personTest.say();
        PersonTest bean = (PersonTest) SpringContextUtils.getBean(PersonTest.class);
        bean.say();
    }
}
