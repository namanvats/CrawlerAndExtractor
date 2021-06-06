package com.amazonCrawlerExtractor.project.repository;

import com.amazonCrawlerExtractor.project.model.Product;
import com.amazonCrawlerExtractor.project.model.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer>{

     @Query(value = "SELECT P FROM Product  P WHERE P.skuId = ?1")
     Product findProductBySkuId(String skuId);

     @Query(value = "SELECT PS FROM ProductStatus PS where PS.product.skuId = ?1")
     List<ProductStatus> findAllProductStatus(String skuId);
}