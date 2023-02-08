package com.ming.zhang.java_guide.commandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 张铭
 * @since 2023/2/7 17:47
 */
@Component
@Order(2)
public class MyStart2 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("服务启动, MyStart2");
    }
}
