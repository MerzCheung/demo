package com.ming.zhang.java_guide;

import com.alibaba.fastjson.JSON;
import com.example.demo.spi_demo.PersonConfig;
import com.ming.zhang.java_guide.BeanFactoryPostProcessor.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaGuideApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JavaGuideApplication.class, args);
//        PersonConfig bean = run.getBean(PersonConfig.class);
//        bean.person().say();

//        User user = run.getBean(User.class);
//        System.out.println(JSON.toJSONString(user));
    }

}
