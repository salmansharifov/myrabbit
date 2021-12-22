package com.example.myrabbit.produce;

import com.example.myrabbit.rabbit.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {
    @Value("${my.rabbitmmq.routing.name}")
    private String routingName;
    @Value("${my.rabbitmmq.exchange.name}")
    private String exchangeName;
    private final RabbitTemplate rabbitTemplate;

    public void sendToMq(Notification notification){
     //   log.info("Message Send: " + notification.getId());
        rabbitTemplate.convertAndSend(exchangeName,"", notification);
       // log.info("message sync ok");
    }
}
