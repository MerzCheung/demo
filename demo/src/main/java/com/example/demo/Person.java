package com.example.demo;

import com.example.demo.annotation.Converter;
import com.example.demo.converter.AddressConverter;
import com.example.demo.converter.NameConverter;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Person extends BasePerson {

    @Converter
    private String name;

    @Converter(converter = AddressConverter.class)
    private String address;

    private List<Person> list;
}
