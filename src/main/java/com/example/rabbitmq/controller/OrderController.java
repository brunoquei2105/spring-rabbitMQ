package com.example.rabbitmq.controller;


import com.example.rabbitmq.model.MenuOrder;
import com.example.rabbitmq.service.rabbitmq.publisher.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${request.mapping.rabbitmq}")
public class OrderController {

    @Autowired
    private final RabbitMQSender rabbitMQSender;

    public OrderController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping(value = "/producer", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String producer(@RequestBody MenuOrder order){
        rabbitMQSender.send(order);
        return "Message sent to the RabbitMQ Queue Successfully";
    }
}
