package com.amazonCrawlerExtractor.project.model;
import java.sql.Timestamp;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String skuId;

    private String title;

    private String description;

    private String latestOfferPrice;

    private String latestOverAllCount;

    private Timestamp created_at;
    
    private Timestamp updated_at;

    private String Star1;
    private String Star2;
    private String Star3;
    private String Star4;
    private String Star5;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "product")
    private List<ProductStatus> productStatuses = new ArrayList<>();

    @JsonManagedReference
    public List<ProductStatus> getProductStatuses() {
        return productStatuses;
    }
}