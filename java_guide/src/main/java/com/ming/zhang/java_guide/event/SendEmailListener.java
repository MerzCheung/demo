package com.ming.zhang.java_guide.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 张铭
 * @since 2023/2/8 16:40
 */
@Component
public class SendEmailListener implements ApplicationListener<RegisterEvent> {

    @Override
    public void onApplicationEvent(RegisterEvent event) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("发送邮件给: " + event.getName());
    }
}
