package com.prashanthIt.entity;

import jakarta.persistence.*;

import lombok.Data;

/**
 * @author Prashanth G
 * @CreatedDate Aug 08, 2023
 * @version 1.0 This class is used to communicate with data base
 */
@Data
@Entity
@Table(name = "SB_CATEGORY_DTLS_TBL")
public class CategoryDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	/*
	 * @OneToMany(mappedBy = "categoryDetails", cascade = CascadeType.ALL)
	 * 
	 * @JsonBackReference private Set<BookDetails> bookDetails;
	 */
}
