package com.prashanthIt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Prashanth G
 * @CreatedDate Aug 08, 2023
 * @version 1.0 This class is used to communicate with data base
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SB_CATEGORY_DTLS_TBL")
public class CategoryDetails {

	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@OneToMany(mappedBy = "category")
	private List<BookDetails> bookDetails;
}
