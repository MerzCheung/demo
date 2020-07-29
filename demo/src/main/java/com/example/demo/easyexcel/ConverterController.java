package com.example.demo.easyexcel;

import com.example.demo.Person;
import com.example.demo.annotation.ConverterMethod;
import com.example.demo.converter.NameConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @RequestMapping("/test")
    @ConverterMethod
    public Person getP() {
        Person p = Person.builder().name("张三").address("1").build();
        System.out.println(NameConverter.Str);
        return p;
    }
}
