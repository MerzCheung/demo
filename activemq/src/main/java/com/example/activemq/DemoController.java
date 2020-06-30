package com.example.activemq;

import com.alibaba.fastjson.JSON;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
/**
 * 建议json字符串格式传输，否则容易导致消费者解析消息异常
 */
public class DemoController {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	@Autowired
	private Topic topic;

	@Autowired
	private Session session;

	@RequestMapping(value = "/{name}")
	public String home(@PathVariable(value = "name") String name) throws IOException, JMSException {
		Map<String, String> msg = new HashMap<>();
		msg.put("key", "hi,activeMQ");
        Queue queue = session.createQueue("120.77.58.11417");
        jmsMessagingTemplate.convertAndSend(queue, JSON.toJSONString(msg));
		return "hello springboot";
	}

	@RequestMapping(value = "/2")
	public String home2() throws IOException {
		Map<String, String> msg = new HashMap<>();
		msg.put("key", "##hi,activeMQ2");
		ParamVo paramVo = new ParamVo();
		paramVo.setUserId(123l);
		paramVo.setUserName("demo");
		jmsMessagingTemplate.convertAndSend(topic, JSON.toJSONString(paramVo));
		return "hello springboot";
	}

}
