package com.ming.zhang.java_guide.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author 张铭
 * @since 2023/2/8 16:41
 */
@Service
public class RegisterService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String name) {
        System.out.println(String.format("%s用户注册成功", name));
        this.applicationEventPublisher.publishEvent(new RegisterEvent(this, name));
        System.out.println(String.format("%s用户发送邮件完成", name));
    }
}
