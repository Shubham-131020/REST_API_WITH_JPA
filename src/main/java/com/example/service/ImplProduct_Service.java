package com.example.service;

import com.example.customException.ProductNotFoundException;
import com.example.entity.Product;
import com.example.repo.IProduct_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ImplProduct_Service  implements IProduct_service{

    @Autowired
    private IProduct_Repo repo;
    @Override
    @Cacheable(value = "prod")
    public Iterable<Product> fetchAllProductBy() {
        return repo.findAll();
    }

    @Override
    @CachePut(value = "prod",key = "#pro")
    public Product registerProduct(Product pro) {
        return repo.save(pro);
    }

    @Override
    @CachePut(value = "prod",key = "#product")
    public Product UpdateProd(Product product) {
        return  repo.save(product);
    }

    @Override
    @CacheEvict(value = "prod",key ="#id")
    public void deleteProdById(Integer id) {
        System.out.println("Deleted the Id =======> "+id);
         repo.deleteById(id);
    }

    @Override
    @Cacheable("prod")
    public Product fetchByIdAndName(Integer id, String name) {
        System.out.println("-------------------- Accessing with the help of DB ----------------------- ");
        Product Product = repo.findByIdAndName(id,name).get();

        return Product;
    }

    @Override
//    @Cacheable(value = "prod",key ="#id")
    @Cacheable("prod")
    public Product fetchById(Integer id) {
        System.out.println("from db");
//        Optional<Product> byId = repo.findById(id);
        Product product1 = repo.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found"));
//        Product product = byId.get();
return product1;
   }

//    @Override
//    public void UpdateProd(Product product) {
//
//        product.setProd_Name("Led Monitor");
//
//    }

//    @Scheduled(fixedRate = 60000) // every 60 seconds
    @CacheEvict(value = "productCache", allEntries = true)
    public void clearCacheAutomatically() {
        System.out.println("Product cache cleared at " + LocalDateTime.now());
    }
}
