package com.example.demo.converter;

public class AddressConverter implements ConverterBase {

    @Override
    public Object converter(String s) {
        return "上海";
    }
}
