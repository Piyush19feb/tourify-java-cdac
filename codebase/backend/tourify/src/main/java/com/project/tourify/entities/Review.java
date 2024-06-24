package com.project.tourify.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviews_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "review", nullable = false, length = 500)
	private String review;
	
	@Column(name = "rating", nullable = false)
	private int rating;
	
	@Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	// add FK: property_id
	
	@ManyToOne
	@JoinColumn(name = "property_id")
	private Property propertyId;
	
	//Methods
	
	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}

}
