package com.example.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author merz
 * @Description:
 * @date 2018/10/24 10:51
 */
@Component
public class JMSConsumer {
    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

    @JmsListener(destination = QueueList.BUSINESS1,containerFactory="jmsListenerContainerQueue")
    public void receiveTopic(String msg) {
        logger.info("接收到消息：{}",msg);
    }

//    @JmsListener(destination ="120.77.58.11417",containerFactory="jmsListenerContainerQueue")
    public void receiveTopic2(String msg) {
        logger.info("接收到消息：{}",msg);
    }

    @JmsListener(destination = QueueList.BUSINESS2,containerFactory="jmsListenerContainerTopic")
    public void receiveQueue(String msg) {
        logger.info("接收到消息222：{}",msg);
    }
}