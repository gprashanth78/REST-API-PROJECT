package com.prashanthIt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prashanthIt.entity.CategoryDetails;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDetails, Integer> {
	
	@Query("select categoryName from CategoryDetails")
	public List<CategoryDetails> getAllCategoryDetails();

}
