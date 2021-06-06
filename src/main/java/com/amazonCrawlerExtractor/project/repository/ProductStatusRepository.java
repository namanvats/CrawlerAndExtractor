package com.amazonCrawlerExtractor.project.repository;

import com.amazonCrawlerExtractor.project.model.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStatusRepository extends JpaRepository<ProductStatus,Integer> {
}
