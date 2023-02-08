package com.ming.zhang.java_guide.event;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import org.springframework.web.servlet.FrameworkServlet;

/**
 * @author 张铭
 * @since 2023/2/8 16:57
 */
@Component
public class HttpRecordListener implements ApplicationListener<ServletRequestHandledEvent> {
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        FrameworkServlet frameworkServlet = (FrameworkServlet) event.getSource();
        String clientAddress = event.getClientAddress();
        String description = event.getDescription();
        String method = event.getMethod();
        String requestUrl = event.getRequestUrl();
        String servletName = event.getServletName();
        int statusCode = event.getStatusCode();
        long timestamp = event.getTimestamp();
        System.out.println(JSON.toJSONString(event));
    }
}
