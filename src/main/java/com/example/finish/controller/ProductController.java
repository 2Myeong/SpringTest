package com.example.finish.controller;

import com.example.finish.dto.ChangeProductDto;
import com.example.finish.dto.ProductDto;
import com.example.finish.dto.ProductResponseDto;
import com.example.finish.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //수정
    @PutMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductDto changeProductDto) throws Exception {
//        System.out.println(pricipal.getName());
        ProductResponseDto productResponseDto = productService.changeProductName(changeProductDto.getNumber(), changeProductDto.getName(), changeProductDto.getPrice(), changeProductDto.getStock());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
    //생성
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    //삭제
    @DeleteMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
    //상품 리스트
    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> allProduct( ) {
        List<ProductResponseDto> productResponseDto = productService.allProduct();
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
    //내림차순 상품리스트(가격순)
    @GetMapping("/listOrderByPrice")
    public ResponseEntity<List<ProductResponseDto>> listAllProductByPrice() {
        List<ProductResponseDto> productResponseDto = productService.listAllProductByPrice();
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
    // 이름을 통한 상품리스트
    @GetMapping("/ByName")
    public ResponseEntity<List<ProductResponseDto>> listProductByName(String name) {
        List<ProductResponseDto> productResponseDto = productService.listProductByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    //아이디를 통해 가지고오기
    @GetMapping("/")
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getproduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }
}
