package com.ming.zhang.java_guide.BeanFactoryPostProcessor;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author 张铭
 * @since 2023/2/8 10:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String name;
}
