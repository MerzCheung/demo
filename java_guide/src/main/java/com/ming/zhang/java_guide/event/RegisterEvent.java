package com.ming.zhang.java_guide.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author 张铭
 * @since 2023/2/8 16:37
 */
public class RegisterEvent extends ApplicationEvent {

    private String name;

    public RegisterEvent(Object source, String name) {
        super(source);
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
