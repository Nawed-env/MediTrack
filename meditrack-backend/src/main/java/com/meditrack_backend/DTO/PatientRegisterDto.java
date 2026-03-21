package com.meditrack_backend.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRegisterDto
{
	@Column(name ="name")
    private String name;
	
	@Column(name = "age")
    private int age;
	
	@Column(name = "mobilenum")
    private long mobileNum;
	
	@Column(name = "gender")
    private String gender;
}
