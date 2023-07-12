package com.example.rabbitmq.service.rabbitmq.publisher;

import com.example.rabbitmq.model.MenuOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.amqp.core.Queue;

@Service
@Slf4j
public class RabbitMQSender {

    @Autowired
    private final AmqpTemplate rabbitTemplate;

    @Autowired
    private final Queue queue;

    public RabbitMQSender(AmqpTemplate amqpTemplate, Queue queue) {
        this.rabbitTemplate = amqpTemplate;
        this.queue = queue;
    }

    public void send (MenuOrder order){
        rabbitTemplate.convertAndSend(queue.getName(), order);
        log.info("Sending Message to the Queue: "+ order.toString());
    }
}
