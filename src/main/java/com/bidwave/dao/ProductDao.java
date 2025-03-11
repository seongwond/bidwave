package com.bidwave.dao;

import com.bidwave.dto.ProductDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 물품 DAO.
 */
@Mapper
public interface ProductDao {

    @Select("SELECT * FROM product")
    List<ProductDTO> fetchAllProducts(); // 모든 물품 조회

    @Select("SELECT * FROM product WHERE product_id = #{productId}")
    ProductDTO fetchProductById(long productId); // 물품 ID로 조회

    @Insert("INSERT INTO product (user_id, category_id, product_name, description, product_image, price, end_time) VALUES (#{userId}, #{categoryId}, #{productName}, #{description}, #{productImage}, #{price}, #{endTime})")
    void insertProduct(ProductDTO product); // 물품 등록

    @Update("UPDATE product SET user_id = #{userId}, category_id = #{categoryId}, product_name = #{productName}, description = #{description}, product_image = #{productImage}, price = #{price}, end_time = #{endTime} WHERE product_id = #{productId}")
    void updateProduct(ProductDTO product); // 물품 수정

    @Delete("DELETE FROM product WHERE product_id = #{productId}")
    void deleteProduct(long productId); // 물품 삭제
}
