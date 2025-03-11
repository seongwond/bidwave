package com.bidwave.service;

import com.bidwave.dao.ProductDao;
import com.bidwave.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 물품 서비스.
 */
@Service
public class ProductService {

    private final ProductDao productDAO;

    public ProductService(ProductDao productDAO) {
        this.productDAO = productDAO;
    }

    public List<ProductDTO> getAllProducts() { // 모든 물품 조회
        return productDAO.fetchAllProducts();
    }

    public ProductDTO getProductById(long productId) { // 물품 ID로 조회
        return productDAO.fetchProductById(productId);
    }

    public void addProduct(ProductDTO product) { // 물품 등록
        productDAO.insertProduct(product);
    }

    public void updateProduct(ProductDTO product) { // 물품 수정
        productDAO.updateProduct(product);
    }

    public void deleteProduct(long productId) { // 물품 삭제
        productDAO.deleteProduct(productId);
    }
}

