package com.case_study.model.entity.product;

import javax.persistence.*;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private int productCost;
    @Column(nullable = false)
    private int productAmount;
    @Column(nullable = false)
    private String productColor;
    @Column(nullable = false)
    private String productDescription;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "id",nullable = false)
    private int productCategory;
}
