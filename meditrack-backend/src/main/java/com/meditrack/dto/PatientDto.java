package com.meditrack.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto
{
	@Column(name ="name")
    private String name;
	
	@Column(name = "age")
    private Integer age;
	
	@Column(name  = "bloodGroup")
	private String bloodGroup;
	
	@Column(name = "mobilenum")
    private long mobileNum;
	
	@Column(name = "gender")
    private String gender;
	
	
	private Long emergencyNum;
}
