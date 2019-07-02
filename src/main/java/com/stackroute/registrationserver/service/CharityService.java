package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Charities;
import com.stackroute.registrationserver.domain.CharityProfile;

import java.util.List;

public interface CharityService {

    CharityProfile saveCharity(Charities charities) throws Exception;
    CharityProfile displayCharity(String username) throws Exception;

}