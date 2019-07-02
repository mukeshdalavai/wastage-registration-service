package com.stackroute.registrationserver.service;

import com.stackroute.rabbitmq.model.CharityMQ;
import com.stackroute.rabbitmq.model.DeliveryBoyMQ;
import com.stackroute.rabbitmq.model.RestaurantMQ;
import com.stackroute.registrationserver.domain.Charities;
import com.stackroute.registrationserver.domain.DeliveryBoys;
import com.stackroute.registrationserver.domain.Restaurants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${restaurant.rabbitmq.exchange}")
    private String restaurantExchange;

    @Value("${saveRestaurant.rabbitmq.routingkey}")
    private String saveRestaurantRoutingkey;

    @Value("${charity.rabbitmq.exchange}")
    private String charityExchange;

    @Value("${saveCharity.rabbitmq.routingkey}")
    private String saveCharityRoutingkey;

    @Value("${deliveryBoy.rabbitmq.exchange}")
    private String deliveryBoyExchange;

    @Value("${saveDeliveryBoy.rabbitmq.routingkey}")
    private String saveDeliveryBoyRoutingkey;

    public void sendToSaveRestaurantQueue(Restaurants restaurants) {

        RestaurantMQ restaurantMQ = new RestaurantMQ(restaurants.getUsername(), restaurants.getPassword(), restaurants.getName(), restaurants.getAddress(), restaurants.getLocation(), restaurants.getCertificateNo());

        rabbitTemplate.convertAndSend(restaurantExchange, saveRestaurantRoutingkey, restaurantMQ);

        System.out.println("Sent RestaurantMQ = " + restaurantMQ);

    }

    public void sendToSaveCharityQueue(Charities charities) {

        CharityMQ charityMQ = new CharityMQ(charities.getUsername(),charities.getPassword(),charities.getName(),charities.getAddress(),charities.getLocation(),charities.getFoodRequirement(),charities.getCertificateNo());
        rabbitTemplate.convertAndSend(charityExchange, saveCharityRoutingkey, charityMQ);

        System.out.println("Sent CharityMQ = " + charityMQ);

    }

    public void sendToSaveDeliveryBoyQueue(DeliveryBoys deliveryBoys) {

        DeliveryBoyMQ deliveryBoyMQ = new DeliveryBoyMQ(deliveryBoys.getUsername(),deliveryBoys.getPassword(),deliveryBoys.getName(),deliveryBoys.getAddress(),deliveryBoys.getLicenseNo());
        rabbitTemplate.convertAndSend(deliveryBoyExchange, saveDeliveryBoyRoutingkey, deliveryBoyMQ);

        System.out.println("Sent CharityMQ = " + deliveryBoyMQ);

    }

}