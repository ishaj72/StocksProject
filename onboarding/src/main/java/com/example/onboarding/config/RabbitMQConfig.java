package com.example.onboarding.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Queue names
    public static final String ONBOARD_QUEUE = "onboard.queue";
    public static final String ONBOARD_DEAD_LETTER_QUEUE = "onboard.dlq";

    // Exchange names
    public static final String ONBOARD_EXCHANGE = "onboard.exchange";
    public static final String ONBOARD_DLX = "onboard.dlx";

    // Routing keys
    public static final String ONBOARD_ROUTING_KEY = "onboard.routing.key";
    public static final String ONBOARD_DLQ_ROUTING_KEY = "onboard.dlq.routing.key";

    // Main Queue - with dead letter exchange configuration
    @Bean
    public Queue onboardQueue() {
        return new Queue(ONBOARD_QUEUE, true, false, false);
    }

    // Dead Letter Queue
    @Bean
    public Queue onboardDeadLetterQueue() {
        return new Queue(ONBOARD_DEAD_LETTER_QUEUE, true, false, false);
    }

    // Main Exchange
    @Bean
    public DirectExchange onboardExchange() {
        return new DirectExchange(ONBOARD_EXCHANGE, true, false);
    }

    // Dead Letter Exchange
    @Bean
    public DirectExchange onboardDeadLetterExchange() {
        return new DirectExchange(ONBOARD_DLX, true, false);
    }

    // Binding between main queue and main exchange
    @Bean
    public Binding onboardBinding(Queue onboardQueue, DirectExchange onboardExchange) {
        return BindingBuilder.bind(onboardQueue)
                .to(onboardExchange)
                .with(ONBOARD_ROUTING_KEY);
    }

    // Binding between DLQ and DLX
    @Bean
    public Binding onboardDLQBinding(Queue onboardDeadLetterQueue, DirectExchange onboardDeadLetterExchange) {
        return BindingBuilder.bind(onboardDeadLetterQueue)
                .to(onboardDeadLetterExchange)
                .with(ONBOARD_DLQ_ROUTING_KEY);
    }
}
