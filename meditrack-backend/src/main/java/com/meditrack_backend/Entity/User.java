package com.meditrack_backend.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
	
	@Column(name = "email", unique = true, nullable = false)
   private String email;
	
	@Column(name = "password", nullable = false)
   private String password;
	
	@Column(name  = "role")
   private String role;
	
	@CreationTimestamp
	@Column(name = "createdDate", updatable = false)
   private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "updatedDate")
   private LocalDateTime updatedDate;
	
	private boolean enabled = true;
	
}
