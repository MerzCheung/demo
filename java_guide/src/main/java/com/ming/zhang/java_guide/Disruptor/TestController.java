package com.ming.zhang.java_guide.Disruptor;

import com.ming.zhang.java_guide.event.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张铭
 * @since 2023/2/6 15:45
 */
@RestController
@RequestMapping("/disruptor")
public class TestController {

    @Autowired
    private MsgProducer msgProducer;

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/send")
    public void send(@RequestParam String message) {
        msgProducer.send(message);
    }

    @RequestMapping("/register")
    public void register() {
        registerService.register("张三");
    }
}
