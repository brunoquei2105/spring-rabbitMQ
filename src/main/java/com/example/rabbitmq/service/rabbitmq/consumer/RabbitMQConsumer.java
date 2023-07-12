package com.example.rabbitmq.service.rabbitmq.consumer;

import com.example.rabbitmq.model.MenuOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "order.queue", id = "listener")
@Slf4j
public class RabbitMQConsumer {

    @RabbitHandler
    public void consumer(MenuOrder menuOrder){

        log.info("MenuOrder listener invoked - Consuming Message with MenuOrder Identifier : "
                + menuOrder.getOrderIdentifier());

    }
}
