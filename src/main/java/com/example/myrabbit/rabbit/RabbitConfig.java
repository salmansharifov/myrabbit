package com.example.myrabbit.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class RabbitConfig {
 //   @Value("${my.rabbitmmq.queue.name}")
    private String queueName;
    @Value("${my.rabbitmmq.routing.name}")
    private String routingName;
    @Value("${my.rabbitmmq.exchange.name}")
    private String exchangeName;

//    @Bean
//    public Queue queue() {
//        return new Queue("test-rabbit-fanaut");
//    }
//
//    @Bean
//    public Queue newQueue() {
//        return new Queue("test-rabbit-fanaut-1");
//    }

    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange(exchangeName);
    }

    @Bean
    public Declarables bind(final FanoutExchange exchange) {
        Queue queue = new Queue("fan-test");
        Queue anotherQueue = new Queue("fan-test-1");
        return new Declarables(
                queue,
                anotherQueue,
                exchange,
                BindingBuilder.bind(queue).to(exchange),
                BindingBuilder.bind(anotherQueue).to(exchange));
    }


}
