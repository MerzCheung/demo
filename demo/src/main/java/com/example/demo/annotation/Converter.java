package com.example.demo.annotation;


import com.example.demo.converter.AutoConverter;
import com.example.demo.converter.ConverterBase;

import java.lang.annotation.*;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Converter {

    Class<? extends ConverterBase> converter() default AutoConverter.class;
}
