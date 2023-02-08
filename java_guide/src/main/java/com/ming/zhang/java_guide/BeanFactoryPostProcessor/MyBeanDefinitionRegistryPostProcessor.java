package com.ming.zhang.java_guide.BeanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author 张铭
 * @since 2023/2/8 10:24
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     * 修改Bean
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        BeanDefinition user = configurableListableBeanFactory.getBeanDefinition("user");
//        System.out.println(user.getAttribute("name"));
//        System.out.println(user.getPropertyValues().get("name"));
//        user.getPropertyValues().add("name", "李四");
    }

    /**
     * 注册Bean
     * @param beanDefinitionRegistry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
//        BeanDefinition beanDefinition = new GenericBeanDefinition();
//        beanDefinition.setBeanClassName("com.ming.zhang.java_guide.BeanFactoryPostProcessor.User");
//        beanDefinition.setAttribute("name", "${name}");
//        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
//        propertyValues.add("id", 1);
////        propertyValues.add("name", "zhangsan");
//        beanDefinitionRegistry.registerBeanDefinition("user", beanDefinition);
    }
}
