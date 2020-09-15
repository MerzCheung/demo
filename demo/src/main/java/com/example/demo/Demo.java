package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Demo {
    private Integer id;
    private String name;
    private Integer age;
}
