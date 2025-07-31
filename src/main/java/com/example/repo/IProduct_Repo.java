package com.example.repo;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IProduct_Repo extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p WHERE p.prod_Id = :id AND p.prod_Name = :name")
    Optional<Product> findByIdAndName(@Param("id") Integer id, @Param("name") String name);
}
//    Optional<Product> findByProdIdAndProdName(Integer prodId, String prodName);

