package com.meditrack.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.meditrack.dto.RecordType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class MedicalRecord
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
	
	@Column(name = "title")
   private String title;
	
	@Column(name  = "recordType")
   private RecordType recordType;
	
	@JoinColumn(name = "doctor_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Doctor doctor;
	
	@JoinColumn(name = "patient_id",nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;
	
	@Column(name = "description")
   private String description;
	
	@Column(name ="fileUrl")
	private String fileUrl;
	
	@Column(name = "doctorName")
   private String doctorNote;
   
   @CreationTimestamp
   @Column(name = "createdDate", updatable = false)
   private LocalDateTime createdDate;
   
   @UpdateTimestamp
   @Column(name = "updatedDate")
   private LocalDateTime updatedDate;
   
}
