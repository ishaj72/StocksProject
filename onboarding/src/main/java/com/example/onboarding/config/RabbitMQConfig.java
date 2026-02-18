package com.example.onboarding.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Your exchange and routing key for PRODUCING messages
    public static final String PRODUCER_EXCHANGE_NAME = "user.topic";
    public static final String PRODUCER_ROUTING_KEY = "user.info.send";

   // Exchange name (from producer)
    public static final String EXCHANGE_NAME = "stocklist.topic";
    
    // Routing key (from producer)
    public static final String ROUTING_KEY = "notification.otp.send";
    
    // Your queue name (you can choose any name)
    public static final String QUEUE_NAME = "otp-notification-queue";

    // Declare the Topic Exchange (must match producer's exchange)
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }


     @Bean
    public TopicExchange producerExchange() {
        return new TopicExchange(PRODUCER_EXCHANGE_NAME);
    }

    // Declare your Queue
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true); // durable = true
    }

    // Bind Queue to Exchange with Routing Key
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    // JSON Message Converter
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
