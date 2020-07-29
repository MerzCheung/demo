package com.example.demo;

import com.example.demo.annotation.Converter;
import com.example.demo.converter.AddressConverter;
import com.example.demo.converter.NameConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Converter
    private String name;

    @Converter(converter = AddressConverter.class)
    private String address;
}
