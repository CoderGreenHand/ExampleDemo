package com.example.controller;

import com.example.service.SpotPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("getSpotPassenger")
public class HyScenicSpotPassengerController {
    @Autowired
    private SpotPassengerService spotPassengerService;

    @RequestMapping("getData")
    public String getData(){
        return spotPassengerService.getSpotPassenger().toString();
    }



}
