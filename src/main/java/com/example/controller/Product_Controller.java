package com.example.controller;

import com.example.entity.Product;
import com.example.service.IProduct_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/pro")
public class Product_Controller {
    @Autowired
    private IProduct_service service;
    @GetMapping("/")
    public String home()
    {
        return "Register";
    }
    @GetMapping("/all")
    public Iterable<Product> getAllProduct()
    {
     return service.fetchAllProductBy();
    }
    @PostMapping("/register")
    public Product saveProduct(@RequestBody Product pro)
    {
        Product product = service.registerProduct(pro);
        return product;
    }
   /* @PutMapping("/update/{id}/{name}")
    public Product upDateById(@PathVariable("id") int id,@PathVariable("name") String name)
    {
        Product product = service.fetchById(id);

            product.setProd_Name(name);

        return service.UpdateProd(product);
    }*/
@DeleteMapping("/delete/{id}")
    public Product DeletById(@PathVariable("id")Integer id)
{
    Product product = service.fetchById(id);
    service.deleteProdById(id);
    return product;
}
@GetMapping("/fetch/{id}")
public Product getProductById(@PathVariable("id") Integer id)
{
    return service.fetchById(id);
}

@GetMapping("/byName/{id}/{name}")
    public Product fetchByIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        Product Product = service.fetchByIdAndName(id,name);

        return Product;
    }



    @DeleteMapping("/cache/clear")
    public ResponseEntity<String> clearProductCache() {
        service.clearCacheAutomatically();
        return ResponseEntity.ok("Product cache cleared successfully");
    }


}
