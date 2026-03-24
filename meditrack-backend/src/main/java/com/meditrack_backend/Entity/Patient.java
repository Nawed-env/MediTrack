package com.meditrack_backend.Entity;

import java.util.List;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="Patient")
public class Patient
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, unique = true)
	private User user;
	
	@Column(name = "name")
     private String name;
	
	@Column(name = "age")
     private int age;
	
	@Column(name  = "bloodGroup")
	private String bloodGroup;
	
	@Column(name ="mobileNum")
     private long mobileNum;
	
	@Column(name ="gender")
     private String gender;
	
	@Column(name = "emergencyNum")
	private Long emergencyNum;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MedicalRecord> records;
	
	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
	private EmergencyCard emerCard;
}
