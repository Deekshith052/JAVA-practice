package com.example.swiggy_driver.service;

import com.example.swiggy_driver.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverLocationService {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    public boolean updateLocation(String location){
        kafkaTemplate.send(AppConstants.DRIVER_LOCATION,location);
        return true;
    }
}
