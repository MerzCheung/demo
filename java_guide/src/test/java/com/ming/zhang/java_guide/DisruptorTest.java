package com.ming.zhang.java_guide;

import com.ming.zhang.java_guide.Disruptor.MsgProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 张铭
 * @since 2023/2/6 15:39
 */
@SpringBootTest
public class DisruptorTest {

    @Autowired
    private MsgProducer msgProducer;

    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            msgProducer.send("消息" + i);
        }
    }
}
