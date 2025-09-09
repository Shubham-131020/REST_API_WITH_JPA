package com.example.repo;

import com.example.entity.Product;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.sound.midi.Track;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@EnableRedisRepositories
//public interface IProduct_Repo extends JpaRepository<Product,Integer> {
public interface IProduct_Repo extends CrudRepository<Product,Integer> {
    //@Query("SELECT p FROM Product p WHERE p.prod_Id = :id AND p.prod_Name = :name")
    Optional<Product> findByIdAndName(@Param("id") Integer id, @Param("name") String name);

   // Arrays.asList(1,2,4,5,6,7,8);


}
//    Optional<Product> findByProdIdAndProdName(Integer prodId, String prodName);

