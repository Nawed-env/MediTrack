package com.meditrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meditrack.entity.PatientRegister;

@Repository
public interface PatientRegisterRepository extends JpaRepository<PatientRegister, Long>
{

}
