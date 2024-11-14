package com.bitsnbytes.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitsnbytes.product.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
