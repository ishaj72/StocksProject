package com.example.onboarding.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.constants.Constants;

@Configuration
public class RabbitMQConfig {

   

    // Declaring the Topic Exchange 
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(Constants.EXCHANGE_NAME);
    }

     @Bean
    public TopicExchange producerExchange() {
        return new TopicExchange(Constants.PRODUCER_EXCHANGE_NAME);
    }

    // Declare your Queue
    @Bean
    public Queue queue() {
        return new Queue(Constants.QUEUE_NAME, true); // durable = true
    }

    // Bind Queue to Exchange with Routing Key
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(Constants.ROUTING_KEY);
    }

    // JSON Message Converter
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    

}
