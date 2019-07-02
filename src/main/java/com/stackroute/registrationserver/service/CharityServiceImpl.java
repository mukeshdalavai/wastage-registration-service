package com.stackroute.registrationserver.service;

import com.stackroute.registrationserver.domain.Charities;
import com.stackroute.registrationserver.domain.CharityProfile;
import com.stackroute.registrationserver.repository.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityServiceImpl implements CharityService {

    CharityRepository charityRepository;

    @Autowired
    public CharityServiceImpl(CharityRepository charityRepository){

        this.charityRepository = charityRepository;

    }

    @Override
    public CharityProfile saveCharity(Charities charities) throws Exception {
        CharityProfile charityProfile = new CharityProfile(charities.getUsername(), charities.getName(),charities.getEmail(),charities.getMobile(), charities.getAddress(),charities.getLocation(),charities.getFoodRequirement(),charities.getCertificateNo(),charities.getCertificateName());
        CharityProfile savedCharity = charityRepository.save(charityProfile);
        if (savedCharity == null)
            throw new Exception("User Already Exists");
        return savedCharity;
    }

    @Override
    public CharityProfile displayCharity(String username) throws Exception {
        return charityRepository.findByUsername(username);
    }
}
