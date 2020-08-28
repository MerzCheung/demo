package com.example.demo.service.impl;

import com.example.demo.BasePerson;
import com.example.demo.Person;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void test(BasePerson basePerson) throws IllegalAccessException {
        System.out.println(basePerson);
        if (basePerson instanceof Person) {
            Person person = (Person)basePerson;
            System.out.println(person.toString());
        }

        Field[] declaredFields = basePerson.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String name = declaredField.getName();
            Object value = declaredField.get(basePerson);
            System.out.println(name + "--------" + value);
        }
    }
}
