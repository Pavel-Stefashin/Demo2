package com.example.demo.product;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
//@AllArgsConstructor
public class Product {

    public Product(){}

    public Product(//int id,
                 //Long id,
                   String category,
                   String productionRuler,
                   String title,
                   String serialNumber,
                   int marketPrice,
                   int purchasePrice){
        //this.id = id;
        this.category = category;
        this.productionRuler = productionRuler;
        this.title = title;
        this.serialNumber = serialNumber;
        this.marketPrice = marketPrice;
        this.purchasePrice = purchasePrice;
    }

    public Product(//int id,
                   Long id,
                   String category,
                   String productionRuler,
                   String title,
                   String serialNumber,
                   int marketPrice,
                   int purchasePrice){
        this.id = id;
        this.category = category;
        this.productionRuler = productionRuler;
        this.title = title;
        this.serialNumber = serialNumber;
        this.marketPrice = marketPrice;
        this.purchasePrice = purchasePrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "Category")
    private String category;
    @Column(name = "Line")
    private String productionRuler;//линейка товаров
    @Column(name = "Name")
    private String title;
    @Column(name = "SerNum")
    private String serialNumber;//серийный номер
    @Column(name = "Description",columnDefinition = "text")
    private String description;
    @Column(name = "MarketPrice")
    private int marketPrice;//рыночная цена
    @Column(name = "PurchasingPrice")
    private int purchasePrice;//закупоная цена
    @Column(name = "Comments",columnDefinition = "text")
    private String comment;
}