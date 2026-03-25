package com.meditrack.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private User user;
	
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name  = "hospital")
	private String hospital;
	
	@Column(name = "licenseNum")
	private String licenseNum;
	
	@Column(name = "mobileNum")
	private String mobileNum;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MedicalRecord> records;
	
	@Column(name = "phone")
	private Long phone;
	
	@CreationTimestamp
	@Column(name  = "createdDate", updatable = false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name  = "updatedDate")
	private LocalDateTime updatedDate;
	
}
