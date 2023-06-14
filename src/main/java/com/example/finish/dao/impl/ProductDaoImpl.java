package com.example.finish.dao.impl;

import com.example.finish.dao.ProductDAO;
import com.example.finish.entity.Product;
import com.example.finish.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDaoImpl implements ProductDAO {

    private final ProductRepository productRepository;
    @Autowired
    public ProductDaoImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }
    @Override
    public Product updateProductName(Long number, String name, int price, int stock) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);
        Product updateProduct;
        if(selectProduct.isPresent()) {
            // update
            Product product = selectProduct.get();
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            product.setUpdatedAt(LocalDateTime.now());
            updateProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }
        return updateProduct;
    }
    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectProduct = productRepository.findById(number);
        if(selectProduct.isPresent()) {
            //delete
            Product product = selectProduct.get();
            productRepository.delete(product);
        } else {
            throw new Exception();
        }

    }


    @Override
    public List<Product> allProduct() {
        List<Product> allProduct = productRepository.findAll();
        return  allProduct;
    }

    @Override
    public List<Product> listAllProductByPrice() {
        return productRepository.findAllByOrderByPriceDesc();
    }
    @Override
    public List<Product> listProductByName(String name) {
        return productRepository.findByNameOrderByPriceDesc(name);
    }
    @Override
    public Product selectProduct(Long number) {
        productRepository.findById(number);
        Product selectProduct = productRepository.getReferenceById(number);
        return selectProduct;
    }


}
