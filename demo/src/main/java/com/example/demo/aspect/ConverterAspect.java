package com.example.demo.aspect;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.AutoConverter;
import com.example.demo.annotation.Converter;
import com.example.demo.converter.ConverterBase;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@Aspect
@Component
public class ConverterAspect {

    @Around("execution(public * * (..)) && @annotation(com.example.demo.annotation.ConverterMethod)")
    public Object requiresPermissions(ProceedingJoinPoint point) throws Throwable {
        Object proceed = point.proceed();
        Set set = new HashSet<>();
        if (proceed instanceof Object) {
            Field[] declaredFields = proceed.getClass().getDeclaredFields();
            for (int i = 0 , len = declaredFields.length; i < len; i++) {
                Field declaredField = declaredFields[i];
                declaredField.setAccessible(true);
                Object o = declaredField.get(proceed);
                Converter annotation = declaredField.getAnnotation(Converter.class);
                if (annotation != null) {
                    Class<? extends ConverterBase> converter = annotation.converter();
                    ConverterBase converterBase = converter.newInstance();
                    Object converter1 = converterBase.converter((String) o);
                    declaredField.set(proceed, converter1);
                    System.out.println(converterBase.getClass());
                    set.add(converterBase);
                }
            }

            set.stream().forEach(item -> {
                Field[] declaredFields1 = item.getClass().getDeclaredFields();
                for (int i = 0 , len = declaredFields1.length; i < len; i++) {
                    Field declaredField = declaredFields1[i];
                    declaredField.setAccessible(true);
                    try {
                        declaredField.set(item, null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return proceed;
    }

    public static void clearStatic(Class clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            ExcelProperty annotation = declaredField.getAnnotation(ExcelProperty.class);
            if (annotation != null) {
                Class<? extends com.alibaba.excel.converters.Converter> converter = annotation.converter();
                if (converter != AutoConverter.class) {
                    Field[] declaredFields1 = converter.getDeclaredFields();
                    for (Field declaredField2 : declaredFields1) {
                        declaredField2.setAccessible(true);
                        try {
                            declaredField2.set(converter, null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
