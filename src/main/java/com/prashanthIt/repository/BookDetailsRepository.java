package com.prashanthIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prashanthIt.entity.BookDetails;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetails, Integer> {

}
