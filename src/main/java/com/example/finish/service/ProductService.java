package com.example.finish.service;

import com.example.finish.dto.ProductDto;
import com.example.finish.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    //상품정보 저장
    ProductResponseDto saveProduct(ProductDto productDto);

    //상품 정보 수정
    ProductResponseDto changeProductName(Long number, String name, int price, int stock) throws Exception;

    //상품 정보 삭제
    void deleteProduct(Long number) throws Exception;

    //모든 상품 정보 리스트
    List<ProductResponseDto> allProduct();

    //상품 정보 가격 내림차순 리스트
    List<ProductResponseDto> listAllProductByPrice();

    //이름으로 상품 검색
    List<ProductResponseDto> listProductByName(String name);
    //상품 번호 검색
    ProductResponseDto getproduct(Long number);
}

