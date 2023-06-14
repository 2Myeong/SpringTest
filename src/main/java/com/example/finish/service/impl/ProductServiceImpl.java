package com.example.finish.service.impl;

import com.example.finish.dao.ProductDAO;
import com.example.finish.dto.ProductDto;
import com.example.finish.dto.ProductResponseDto;
import com.example.finish.entity.Product;
import com.example.finish.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;
    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());
        return productResponseDto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name, int price, int stock) throws Exception {
        Product changeproduct = productDAO.updateProductName(number, name, price, stock);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(changeproduct.getName());
        productResponseDto.setNumber(changeproduct.getNumber());
        productResponseDto.setPrice(changeproduct.getPrice());
        productResponseDto.setStock(changeproduct.getStock());
        return new ProductResponseDto(changeproduct);
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }


    @Override
    public List<ProductResponseDto> allProduct() {
        List<Product> products = productDAO.allProduct();
        List<ProductResponseDto> productResponseDtoList = products.stream().map(product -> new ProductResponseDto(product)).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public List<ProductResponseDto> listAllProductByPrice() {
        List<Product> products = productDAO.listAllProductByPrice();
        List<ProductResponseDto> productResponseDtoList = products.stream().map(product -> new ProductResponseDto(product)).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public List<ProductResponseDto> listProductByName(String name) {
        List<Product> products = productDAO.listProductByName(name);
        List<ProductResponseDto> productResponseDtoList = products.stream().map(product -> new ProductResponseDto(product)).collect(Collectors.toList());
//        List<ProductResponseDto> result = new ArrayList<>();
//        for (int i=0; i<products.size(); i++) {
//            Product product = products.get(i);
//            ProductResponseDto productResponseDto = new ProductResponseDto(product);
//            result.add(productResponseDto);
//        } //위 문장과 같은 역활을 수행
        return productResponseDtoList;
    }


    @Override
    public ProductResponseDto getproduct(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

}
