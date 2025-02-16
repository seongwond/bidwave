package com.bidwave.dao;

import com.bidwave.dto.*;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM User WHERE email = #{email}")
    UserDTO getUserByEmail(@Param("email") String email);

    @Insert("INSERT INTO User (email, password, name, phone) VALUES (#{email}, #{password}, #{name}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insertUser(UserDTO user);
}