package com.example.service;

import com.example.entity.Product;
import org.springframework.stereotype.Service;


public interface IProduct_service {
    public Iterable<Product> fetchAllProductBy();
    public Product registerProduct(Product pro);
    public Product fetchById(Integer id);
    public Product UpdateProd(Product product);
    public void deleteProdById(Integer id);
    public Product fetchByIdAndName(Integer id, String name);

    public void clearCacheAutomatically();

}
