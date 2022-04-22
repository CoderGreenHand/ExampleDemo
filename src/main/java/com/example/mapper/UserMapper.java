package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User insertUser();
}
