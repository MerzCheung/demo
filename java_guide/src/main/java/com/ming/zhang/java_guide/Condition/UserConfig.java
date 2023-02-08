package com.ming.zhang.java_guide.Condition;

import com.ming.zhang.java_guide.BeanFactoryPostProcessor.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author 张铭
 * @since 2023/2/8 15:16
 */
@Configuration
public class UserConfig {

    @Bean
    @Conditional(MyCondition.class) // 如果为true, 则创建Bean
//    @ConditionalOnBean
//    @ConditionalOnClass
    public User user() {
        return new User(1, "张三");
    }
}
