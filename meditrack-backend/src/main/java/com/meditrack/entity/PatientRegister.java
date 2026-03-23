package com.meditrack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="MediTrack")
public class PatientRegister 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@Column(name = "name")
     private String name;
	
	@Column(name = "age")
     private int age;
	
	@Column(name ="mobileNum")
     private long mobileNum;
	
	@Column(name ="gender")
     private String gender;
}
