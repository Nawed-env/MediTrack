package com.meditrack.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name  = "EmergencyCard")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmergencyCard
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false, unique = true)
	private Patient patient;
	
	@Column(unique = true, nullable = false)
	private String qrToken;
	
	@Column(name = "allergies")
	private String allergies;
	
	@Column(name  = "bloodGroup")
	private String bloodGroup;
	
	@Column(name  = "emergencyNum")
	private Long emergencyNum;
	
	@Column(name  = "criticalNotes")
	private String criticalNotes;  //e.g : "Diabetic, on insulin
	
	@CreationTimestamp
	@Column(name = "createdDate",updatable = false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "updatedDate")
	private LocalDateTime updatedDate;
}
