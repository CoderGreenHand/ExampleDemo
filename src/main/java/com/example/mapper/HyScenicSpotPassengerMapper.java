package com.example.mapper;

import com.example.bean.HyScenicSpotPassenger;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HyScenicSpotPassengerMapper {
    HyScenicSpotPassenger getSpotPassenger();

}
