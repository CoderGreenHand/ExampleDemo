package com.example.service;

import com.example.mapper.HyScenicSpotPassengerMapper;
import com.example.bean.HyScenicSpotPassenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpotPassengerService {
    @Autowired
    HyScenicSpotPassengerMapper hyScenicSpotPassengerMapper;
    public HyScenicSpotPassenger getSpotPassenger(){
        return hyScenicSpotPassengerMapper.getSpotPassenger();
    }


}
