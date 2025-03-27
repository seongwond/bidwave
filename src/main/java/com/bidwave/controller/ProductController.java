package com.bidwave.controller;

import com.bidwave.dto.CategoryDTO;
import com.bidwave.dto.ProductDTO;
import com.bidwave.service.ProductService;
import com.bidwave.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 물품 컨트롤러.
 */
@Controller
@RequestMapping("/register-item")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping
    public String showRegisterProductForm(Model model) {
        List<CategoryDTO> categories = productService.getAllCategories(); // 카테고리 목록 조회
        model.addAttribute("categories", categories); // 모델에 카테고리 정보 추가
        model.addAttribute("item", new ProductDTO());
        return "register-item";
    }

    @PostMapping
    public String registerProduct(@RequestParam("description") String description,
                                  @RequestParam(value = "endTimeStr", required = false) String endTimeStr,
                                  @RequestParam(value = "priceStr", required = false) String priceStr,
                                  @RequestParam(value = "productImageInput", required = false) MultipartFile productImageFile,
                                  @RequestParam("category_id") long categoryId, // 카테고리 ID 받기
                                  @ModelAttribute ProductDTO item) {
        // 로그인한 사용자의 email을 얻어옴
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername(); // Spring Security에서 username은 email로 사용
            Long userId = userService.getUserIdByEmail(email); // email로 userId 조회
            if (userId != null) {
                item.setUserId(userId); // userId 설정
            } else {
                throw new IllegalArgumentException("사용자 정보가 없습니다.");
            }
        } else {
            throw new IllegalArgumentException("사용자 정보가 없습니다.");
        }

        item.setCategoryId(categoryId); // 카테고리 ID 설정
        item.setDescription(description);

        // endTime 필드를 Timestamp로 변환
        if (endTimeStr != null && !endTimeStr.isEmpty()) {
            item.setEndTimeStr(endTimeStr);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            try {
                Date date = dateFormat.parse(endTimeStr);
                item.setEndTime(new Timestamp(date.getTime()));
            } catch (ParseException e) {
                item.setEndTime(new Timestamp(System.currentTimeMillis()));
            }
        } else {
            item.setEndTime(new Timestamp(System.currentTimeMillis()));
        }

        // price 필드를 int로 변환
        if (priceStr != null && !priceStr.isEmpty()) {
            item.setPriceStr(priceStr);
            try {
                item.setPrice(Integer.parseInt(priceStr.replace(",", "")));
            } catch (NumberFormatException e) {
                item.setPrice(0);
            }
        } else {
            item.setPrice(0);
        }

        /// 이미지 파일 처리
        if (productImageFile != null && !productImageFile.isEmpty()) {
            try {
                // 파일 이름을 원본 파일명으로 설정
                String fileName = productImageFile.getOriginalFilename();
                // 상대 경로로 파일 저장
                String filePath = "images/" + fileName;
                // static/images 폴더에 파일 저장
                File destinationFile = new File("C:/Users/mks48/IdeaProjects/bidwave/src/main/resources/static/" + filePath);

                // 파일을 지정된 경로로 저장
                productImageFile.transferTo(destinationFile);

                // 저장된 이미지 경로를 ProductDTO에 설정
                item.setProductImage(filePath);  // 상대 경로만 저장 (웹에서 접근할 수 있도록)
            } catch (IOException e) {
                logger.error("이미지 업로드 실패: " + e.getMessage());
            }
        }

        // ProductService를 호출하여 상품 등록
        productService.addProduct(item);

        return "redirect:/main"; // 물품 등록 후 메인 페이지로 리다이렉트
    }
}
