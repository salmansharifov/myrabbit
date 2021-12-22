package com.example.myrabbit.consume;

import com.example.myrabbit.rabbit.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    @RabbitListener(queues = {"fan-test"})
    public void consumeMq(Notification notification){
        System.out.println("queue message : " + notification.toString());
    }



    @RabbitListener(queues = {"fan-test-1"})
    public void consumeAnotherMq(Notification notification){
        System.out.println("queue message in consumeAnotherMq: " + notification.toString());
    }
}
