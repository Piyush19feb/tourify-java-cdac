package com.project.tourify.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users_tb")
//@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	// fields 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "email", nullable = false, length = 100, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false, length = 500)
	private String password;
	
	@Column(name = "phone", nullable = false, length = 15, unique = true)
	private String phone;
	
	@Column(name = "address", nullable = false, length = 100)
	private String address;
	
    @Column(name = "is_deleted", columnDefinition = "INTEGER(1) DEFAULT 0")
    private Integer isDeleted = 0;
    
	@Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	// add FK : role_id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id" , referencedColumnName = "id")
	private Role role;
    
	// mapped FK

//	@OneToOne(mappedBy = "userId")
//	private Property property;
//	
//	@OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
//	private List<Booking> bookingList = new ArrayList<>();
//    
	
	
    //Methods
    
    @PrePersist   // Invoked automatically before an entity is persisted(inserted) into the db
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    
//    public void setRoleId(Long id) { 
//    	this.role = new Role();
//    	this.role.setId(id);
//    }
//    
//    public Long getRoleId() {
//    	return role.getId();
//    }
    
}
