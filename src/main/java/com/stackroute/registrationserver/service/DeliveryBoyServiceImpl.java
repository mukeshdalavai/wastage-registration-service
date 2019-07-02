package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.DeliveryBoyProfile;
import com.stackroute.registrationserver.domain.DeliveryBoys;
import com.stackroute.registrationserver.repository.DeliveryBoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryBoyServiceImpl implements DeliveryBoyService{
    DeliveryBoyRepository deliveryBoyRepository;

    @Autowired
    public DeliveryBoyServiceImpl(DeliveryBoyRepository deliveryBoyRepository){

        this.deliveryBoyRepository = deliveryBoyRepository;

    }

    @Override
    public DeliveryBoyProfile saveDeliveryBoy(DeliveryBoys deliveryBoys) throws Exception {

        System.out.println(deliveryBoys);

        DeliveryBoyProfile deliveryBoyProfile = new DeliveryBoyProfile(deliveryBoys.getUsername(),deliveryBoys.getName(),deliveryBoys.getEmail(),deliveryBoys.getMobile(),deliveryBoys.getAddress(),deliveryBoys.getLicenseNo(),deliveryBoys.getLicenseName());

        DeliveryBoyProfile savedDeliveryBoyDetails = deliveryBoyRepository.save(deliveryBoyProfile);
        if (savedDeliveryBoyDetails == null)
            throw new Exception("User Already Exists");
        return savedDeliveryBoyDetails;
    }

    @Override
    public DeliveryBoyProfile displayDeliveryBoy(String username) throws Exception {
        return deliveryBoyRepository.findByUsername(username);
    }

}
