package com.example.demo;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person2 {

    private String name;

    private String address;

    private Integer age;
}
