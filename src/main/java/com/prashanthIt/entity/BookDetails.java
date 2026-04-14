package com.prashanthIt.entity;

import java.util.Date;

import jakarta.persistence.*;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "SB_BOOK_DTLS_TBL")
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Integer bookId;
	@Column(name = "BOOK_NAME")
	private String bookName;
	@Column(name = "BOOK_AUTHOR")
	private String author;
	@Column(name = "BOOK_DESCRIPTION")
	private String bookDescription;
	@Column(name = "BOOK_IMAGE")
	private String bookImage;
	@Column(name = "BOOK_ISBN")
	private String bookIsbn;
	@Column(name = "BOOK_PRICE")
	private Double bookPrice;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "BOOK_PUBLISHED_DATE")
	private Date publishedDate;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private CategoryDetails categoryDetails;
}
