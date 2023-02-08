package com.ming.zhang.java_guide.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 张铭
 * @since 2023/2/8 17:26
 */
@Component
public class RegisterListener {

    @EventListener
    @Order(2)
    public void sendEmail(RegisterEvent event) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(event.getName() + "发送邮件");
    }

    @EventListener
    @Order(1)
    public void sendSms(RegisterEvent event) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(event.getName() + "发送短信");
    }
}
