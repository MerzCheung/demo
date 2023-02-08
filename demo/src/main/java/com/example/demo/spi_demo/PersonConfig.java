package com.example.demo.spi_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张铭
 * @since 2023/2/7 16:25
 */
@Configuration
public class PersonConfig {

    @Bean
    public Person person() {
        return new Person();
    }
}
