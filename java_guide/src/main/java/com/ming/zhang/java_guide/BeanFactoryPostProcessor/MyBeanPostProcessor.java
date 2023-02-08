package com.ming.zhang.java_guide.BeanFactoryPostProcessor;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * @author 张铭
 * @since 2023/2/8 14:51
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在spring容器初始化对象的基础之上进行执行，在对象初始化之前执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("class name: " + bean.getClass().getName());
        if (AnnotationUtils.findAnnotation(bean.getClass(), HawkBean.class) != null) {
            ReflectionUtils.doWithMethods(bean.getClass(),
                    method -> {
                        System.out.println("method: "+ method.getName());
                    });
        }
        return bean;
    }

    /**
     * 在spring容器初始化对象的基础之上进行执行，在对象初始化之后执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

}
