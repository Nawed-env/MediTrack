package com.meditrack.entity;

import com.meditrack.dto.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   private  String email;
   private String password;
   private String name ;
   private Role role;               //patient / doctor
   private String specialization;   //for doctors only
   private String licenseNum;       //for doctors only
}
