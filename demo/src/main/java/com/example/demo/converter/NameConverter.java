package com.example.demo.converter;


public class NameConverter implements ConverterBase {

    public static String Str = "1231331";

    @Override
    public Object converter(String s) {
        return "zhangsan";
    }
}
