package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.DeliveryBoyProfile;
import com.stackroute.registrationserver.domain.DeliveryBoys;

import java.util.List;

public interface DeliveryBoyService {

    DeliveryBoyProfile saveDeliveryBoy(DeliveryBoys deliveryBoys) throws Exception;
    DeliveryBoyProfile displayDeliveryBoy(String username) throws Exception;
}
