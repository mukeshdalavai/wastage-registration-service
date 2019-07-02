package com.stackroute.registrationserver.controller;

import com.stackroute.registrationserver.domain.*;
import com.stackroute.registrationserver.service.CharityService;
import com.stackroute.registrationserver.service.DeliveryBoyService;
import com.stackroute.registrationserver.service.RabbitService;
import com.stackroute.registrationserver.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin(origins = "*")
public class RegistrationController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CharityService charityService;

    @Autowired
    private DeliveryBoyService deliveryBoyService;

    @Autowired
    private RabbitService rabbitService;

    @PostMapping("restaurant-profile")
    public ResponseEntity<RestaurantProfile> saveRestaurant(@RequestBody Restaurants restaurant) throws Exception {
        ResponseEntity responseEntity;

        System.out.println(restaurant);
        try {
            RestaurantProfile returnRestaurant = restaurantService.saveRestaurant(restaurant);
            responseEntity = new ResponseEntity<RestaurantProfile>(returnRestaurant, HttpStatus.CREATED);

            rabbitService.sendToSaveRestaurantQueue(restaurant);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
    @GetMapping("restaurant-profile")
    public ResponseEntity<RestaurantProfile> displayRestaurant(@RequestParam String username)
    {
        ResponseEntity responseEntity;

        try{
            responseEntity=new ResponseEntity(restaurantService.displayRestaurant(username),HttpStatus.CREATED);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @PostMapping("charity-profile")
    public ResponseEntity<CharityProfile> saveCharity(@RequestBody Charities charities) throws Exception {
        ResponseEntity responseEntity;
        try {
            CharityProfile returnCharity = charityService.saveCharity(charities);
            responseEntity = new ResponseEntity<CharityProfile>(returnCharity, HttpStatus.CREATED);
            rabbitService.sendToSaveCharityQueue(charities);
        }
        catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }
    @GetMapping("charity-profile")
    public ResponseEntity<CharityProfile> displayCharity(@RequestParam String username)
    {
        ResponseEntity responseEntity;

        try{
            responseEntity=new ResponseEntity(charityService.displayCharity(username),HttpStatus.CREATED);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping("deliveryBoy-profile")
    public ResponseEntity<DeliveryBoyProfile> saveDeliveryBoy(@RequestBody DeliveryBoys deliveryBoys) throws Exception {
        ResponseEntity responseEntity;
        try {
            DeliveryBoyProfile returnDeliveryBoy = deliveryBoyService.saveDeliveryBoy(deliveryBoys);
            responseEntity = new ResponseEntity<DeliveryBoyProfile>(returnDeliveryBoy, HttpStatus.CREATED);
            rabbitService.sendToSaveDeliveryBoyQueue(deliveryBoys);
        } catch (Exception e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

    @GetMapping("deliveryBoy-profile")
    public ResponseEntity<DeliveryBoyProfile> displayDeliveryBoy(@RequestParam String username)
    {
        ResponseEntity responseEntity;

        try{
            responseEntity=new ResponseEntity(deliveryBoyService.displayDeliveryBoy(username),HttpStatus.CREATED);
        }
        catch (Exception e){
            responseEntity=new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
