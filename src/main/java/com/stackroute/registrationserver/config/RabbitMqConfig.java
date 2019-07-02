package com.stackroute.registrationserver.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${saveRestaurant.rabbitmq.queue}")
    String saveRestaurantQueue;

    @Value("${restaurant.rabbitmq.exchange}")
    String restaurantExchange;

    @Value("${saveRestaurant.rabbitmq.routingkey}")
    private String saveRestaurantRoutingkey;

    @Value("${saveCharity.rabbitmq.queue}")
    String saveCharityQueue;

    @Value("${charity.rabbitmq.exchange}")
    String charityExchange;

    @Value("${saveCharity.rabbitmq.routingkey}")
    private String saveCharityRoutingkey;

    @Value("${saveDeliveryBoy.rabbitmq.queue}")
    String saveDeliveryBoyQueue;

    @Value("${deliveryBoy.rabbitmq.exchange}")
    String deliveryBoyExchange;

    @Value("${saveDeliveryBoy.rabbitmq.routingkey}")
    private String saveDeliveryBoyRoutingkey;

    @Bean
    Queue resQueue() {
        System.out.println("inside RestaurantMQ queue");
        return new Queue(saveRestaurantQueue, true);
    }

    @Bean
    DirectExchange resExchange() {
        System.out.println("inside RestaurantMQ exchange");
        return new DirectExchange(restaurantExchange);
    }

    @Bean
    Binding resBinding() {
        System.out.println("inside RestaurantMQ binding");
        return BindingBuilder.bind(resQueue()).to(resExchange()).with(saveRestaurantRoutingkey);
    }

    @Bean
    Queue chrQueue() {
        System.out.println("inside CharityMQ queue");
        return new Queue(saveCharityQueue, true);
    }

    @Bean
    DirectExchange chrExchange() {
        System.out.println("inside CharityMQ exchange");
        return new DirectExchange(charityExchange);
    }

    @Bean
    Binding chrBinding() {
        System.out.println("inside CharityMQ binding");
        return BindingBuilder.bind(chrQueue()).to(chrExchange()).with(saveCharityRoutingkey);
    }
    @Bean
    Queue dbQueue() {
        System.out.println("inside Delivery boy queue");
        return new Queue(saveDeliveryBoyQueue, true);
    }

    @Bean
    DirectExchange dbExchange() {
        System.out.println("inside Delivery Boy exchange");
        return new DirectExchange(deliveryBoyExchange);
    }

    @Bean
    Binding dbBinding() {
        System.out.println("inside Delivery Boy binding");
        return BindingBuilder.bind(dbQueue()).to(dbExchange()).with(saveDeliveryBoyRoutingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        System.out.println("inside jsonMessageConverter");
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        System.out.println("inside rabbitTemplate");
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }


}
