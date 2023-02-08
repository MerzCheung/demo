package com.ming.zhang.java_guide.SPI.spring;

import com.example.demo.spi_demo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 张铭
 * @since 2023/2/7 16:27
 */
@Component
public class PersonTest {
    @Autowired
    private Person person;

    public void say() {
        person.say();
    }
}
