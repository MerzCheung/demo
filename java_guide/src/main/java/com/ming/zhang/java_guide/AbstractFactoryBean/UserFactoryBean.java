package com.ming.zhang.java_guide.AbstractFactoryBean;

import com.ming.zhang.java_guide.BeanFactoryPostProcessor.User;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author 张铭
 * @since 2023/2/8 15:36
 */
@Component
public class UserFactoryBean extends AbstractFactoryBean<User> {
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    protected User createInstance() throws Exception {
        User u = new User(2, "lisi");
        return u;
    }
}
