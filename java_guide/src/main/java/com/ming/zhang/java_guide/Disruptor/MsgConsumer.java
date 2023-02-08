package com.ming.zhang.java_guide.Disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 张铭
 * @since 2023/2/6 15:09
 */
@Slf4j
public class MsgConsumer implements EventHandler<MessageModel>, WorkHandler<MessageModel> {

    private String name;

    public MsgConsumer(String name) {
        this.name = name;
    }

    /**
     * 重写EventHandler方法
     * @param msgEvent
     * @param l
     * @param b
     * @throws Exception
     */
    @Override
    public void onEvent(MessageModel msgEvent, long l, boolean b) throws Exception {
        log.info("重写EventHandler方法");
        try {
            //这里停止1000ms是为了确定消费消息是异步的
            log.info("消费者"+name+"处理消息开始");
            if (msgEvent != null) {
                log.info("消费者"+name+"消费的信息是：{}",msgEvent.getMessage());
            }
        } catch (Exception e) {
            log.info("消费者"+name+"处理消息失败");
        }
        log.info("消费者"+name+"处理消息结束");
    }

    /**
     * 重写WorkHandler方法
     * @param messageModel
     * @throws Exception
     */
    @Override
    public void onEvent(MessageModel messageModel) throws Exception {
        log.info("重写WorkHandler方法");
        try {
            //这里停止1000ms是为了确定消费消息是异步的
            Thread.sleep(1000);
            if (messageModel != null) {
                log.info("消费者"+name+"消费的信息是：{}",messageModel.getMessage());
            }
        } catch (Exception e) {
            log.info("消费者"+name+"处理消息失败");
        }
        log.info("消费者"+name+"处理消息结束");
    }
}
