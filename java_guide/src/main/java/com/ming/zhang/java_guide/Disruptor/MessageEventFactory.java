package com.ming.zhang.java_guide.Disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author 张铭
 * @since 2023/2/6 15:08
 */
public class MessageEventFactory implements EventFactory<MessageModel> {
    @Override
    public MessageModel newInstance() {
        return new MessageModel();
    }
}
