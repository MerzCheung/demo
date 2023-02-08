package com.ming.zhang.java_guide.Disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author 张铭
 * @since 2023/2/6 15:14
 */
@Configuration
public class MQManager {

    @Bean
    public RingBuffer<MessageModel> messageModelRingBuffer() {
        // 定义用于事件处理的线程池， Disruptor通过java.util.concurrent.ExecutorSerivce提供的线程池来触发consumer的事件处理。
//        ExecutorService executor = Executors.newFixedThreadPool(3);// 这么写就认定只有3个消费者
        ThreadFactory executor = Executors.defaultThreadFactory();

        // 指定事件工厂
        MessageEventFactory factory = new MessageEventFactory();
        // 指定ringbuffer字节大小, 必须为2的N次方(能将求模运算转为位运算提高效率), 否则影响效率
        int bufferSize = 1024 * 256;
        // 单生产者模式, 多生产者模式时可以使用ProducerType.MULTI
        /**
         * 消费者常见的等待策略
         * BusySpinWaitStrategy： 自旋等待，类似Linux Kernel使用的自旋锁。低延迟但同时对CPU资源的占用也多。
         * BlockingWaitStrategy： 使用锁和条件变量。CPU资源的占用少，延迟大，默认等待策略。
         * SleepingWaitStrategy： 在多次循环尝试不成功后，选择让出CPU，等待下次调度，多次调度后仍不成功，尝试前睡眠一个纳秒级别的时间再尝试。这种策略平衡了延迟和CPU资源占用，但延迟不均匀。
         * YieldingWaitStrategy： 在多次循环尝试不成功后，选择让出CPU，等待下次调。平衡了延迟和CPU资源占用，但延迟也比较均匀。
         * PhasedBackoffWaitStrategy： 上面多种策略的综合，CPU资源的占用少，延迟大
         */
        Disruptor<MessageModel> disruptor = new Disruptor<>(factory, bufferSize, executor, ProducerType.SINGLE, new BlockingWaitStrategy());
        // 定义消费者
        MsgConsumer msg1 = new MsgConsumer("1");
        MsgConsumer msg2 = new MsgConsumer("2");
        MsgConsumer msg3 = new MsgConsumer("3");
        MsgConsumer msg4 = new MsgConsumer("4");
        MsgConsumer msg5 = new MsgConsumer("5");

        /**
         * 定义消费者执行模式(在这里一个消费者也就是一个线程, 消费者执行模式也就是线程的执行模式)
         *         disruptor.handleEventsWith(msg1, msg2, msg3, msg4); // 统一消费: 一个消息会被所有的消费者消费
         *         disruptor.handleEventsWithWorkerPool(msg1, msg2); // 分组消费: 一个消息只能被一个消费者消费, 多消费者轮询处理
         *         disruptor.handleEventsWith(msg1, msg3).then(msg2); // 顺序消费: 1,3先并行处理, 然后2处理
         */
        // 多支线顺序消费：消费者1和消费者3一个支线，消费者2和消费者4一个支线，消费者3和消费者4消费完毕后，消费者5再进行消费
        disruptor.handleEventsWith(msg1, msg3);
        disruptor.handleEventsWith(msg2, msg4);
        disruptor.after(msg3, msg4).handleEventsWith(msg5);

        // 启动disruptor线程
        disruptor.start();
        // 获取ringbuffer环, 用于接受生产者生产的事件
        RingBuffer<MessageModel> ringBuffer = disruptor.getRingBuffer();
        return ringBuffer;
    }
}
