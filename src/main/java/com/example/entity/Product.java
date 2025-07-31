package com.example.entity ;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
//@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

public class Product implements Serializable {
    @Id
//    @SequenceGenerator(name = "seq1",initialValue = 1,allocationSize = 1)
//    @GeneratedValue(generator = "seq1",strategy = GenerationType.IDENTITY)
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prod_Id;
    @Column(length = 50)
    private String prod_Name;
    private Integer prod_Price;
    private Integer prod_Qty;


}
