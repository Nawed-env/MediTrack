package com.meditrack_backend.Entity;

import com.meditrack_backend.DTO.Role;

import lombok.Data;

@Data
public class RegisterRequest 
{
   private  String email;
   private String password;
   private String name ;
   private Role role;               //patient / doctor
   private String specialization;   //for doctors only
   private String licenseNum;       //for doctors only
}
