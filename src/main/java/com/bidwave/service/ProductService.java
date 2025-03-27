package com.bidwave.service;

import com.bidwave.dao.CategoryDao;
import com.bidwave.dao.ProductDao;
import com.bidwave.dao.UserDao;
import com.bidwave.dto.CategoryDTO;
import com.bidwave.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 물품 서비스.
 */
@Service
public class ProductService {

    private final ProductDao productDAO;
    private final UserDao userDAO;
    private final CategoryDao categoryDAO;

    public ProductService(ProductDao productDAO, UserDao userDAO, CategoryDao categoryDAO) {
        this.productDAO = productDAO;
        this.userDAO = userDAO;
        this.categoryDAO = categoryDAO;
    }

    public List<ProductDTO> getAllProducts() {
        return productDAO.fetchAllProducts();
    }

    public ProductDTO getProductById(long productId) {
        return productDAO.fetchProductById(productId);
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryDAO.fetchAllCategories(); // 카테고리 목록 조회
    }

    public void addProduct(ProductDTO product) {
        if (userDAO.existsByUserId(product.getUserId()) == 0) {
            throw new IllegalArgumentException("유효하지 않은 사용자 ID입니다.");
        }
        productDAO.insertProduct(product);
    }

    public void updateProduct(ProductDTO product) {
        if (userDAO.existsByUserId(product.getUserId()) == 0) {
            throw new IllegalArgumentException("유효하지 않은 사용자 ID입니다.");
        }
        productDAO.updateProduct(product);
    }

    public void deleteProduct(long productId) {
        productDAO.deleteProduct(productId);
    }
}
