package com.bidwave.dao;

import com.bidwave.dto.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Insert("INSERT INTO user (email, password, name, phone) VALUES (#{email}, #{password}, #{name}, #{phone})")
    void registerUser(UserDTO user);

    @Select("SELECT COUNT(*) > 0 FROM user WHERE email = #{email}")
    boolean existsByEmail(String email);

    @Select("SELECT * FROM user WHERE email = #{email}")
    UserDTO findByEmail(String email);

    @Select("SELECT b.bid_id, b.user_id, b.auction_id, b.amount, b.bid_time, p.product_name " +
            "FROM bid b " +
            "INNER JOIN auction a ON b.auction_id = a.auction_id " +
            "INNER JOIN product p ON a.product_id = p.product_id " +
            "WHERE b.user_id = #{userId}")
    List<BidDTO> getBidListByUserEmail(String email);

    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    UserDTO fetchUserById(Long userId);

    // existsByUserId 메서드 수정: int 반환
    @Select("SELECT COUNT(*) FROM user WHERE user_id = #{userId}")
    int existsByUserId(Long userId); // 사용자 ID로 존재 여부 확인

    @Select("SELECT * FROM user")
    List<UserDTO> fetchAllUsers(); // 모든 사용자 조회

}
