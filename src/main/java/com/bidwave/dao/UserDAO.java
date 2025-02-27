package com.bidwave.dao;

import com.bidwave.dto.*;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserDAO {
    @Insert("INSERT INTO user (email, password, name, phone) VALUES (#{email}, #{password}, #{name}, #{phone})")
    void registerUser(UserDTO user);
    // 회원가입 할 때 회원값 데이터베이스에 삽입

    @Select("SELECT * FROM user WHERE email = #{email}")
    UserDTO findByEmail(String email);
    // 로그인할 때 해당 이메일이 있는지 확인하는 select
}