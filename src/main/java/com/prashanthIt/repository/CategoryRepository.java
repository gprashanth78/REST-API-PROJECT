package com.prashanthIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashanthIt.entity.CategoryDetails;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDetails, Integer> {

}
