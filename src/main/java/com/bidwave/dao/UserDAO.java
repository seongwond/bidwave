package com.bidwave.dao;

import com.bidwave.dto.*;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserDAO {
    @Insert("INSERT INTO user (email, password, name, phone) VALUES (#{email}, #{password}, #{name}, #{phone})")
    void registerUser(UserDTO user);
    // 회원가입 할 때 회원값 데이터베이스에 삽입

    @Select("SELECT COUNT(*) > 0 FROM user WHERE email = #{email}")
    boolean existsByEmail(String email); // 이메일 존재 여부 확인 쿼리

    @Select("SELECT * FROM user WHERE email = #{email}")
    UserDTO findByEmail(String email);
    // 로그인할 때 해당 이메일이 있는지 확인하는 select

    @Select("SELECT b.bid_id, b.user_id, b.auction_id, b.amount, b.bid_time, p.product_name " +
            "FROM bid b " +
            "INNER JOIN auction a ON b.auction_id = a.auction_id " +
            "INNER JOIN product p ON a.product_id = p.product_id " +
            "WHERE b.user_id = #{email}")
    List<BidDTO> getBidListByUserEmail(String email);
}