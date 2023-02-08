package com.ming.zhang.java_guide.BeanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @author 张铭
 * @since 2023/2/8 11:03
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanDefinitionName);
//            System.out.println(beanDefinitionName + " getPropertyValues: " + beanDefinition.getPropertyValues().toString());
//        }

    }
}
