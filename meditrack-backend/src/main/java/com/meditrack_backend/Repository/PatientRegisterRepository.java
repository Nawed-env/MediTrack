package com.meditrack_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meditrack_backend.Entity.PatientRegister;

@Repository
public interface PatientRegisterRepository extends JpaRepository<PatientRegister, Long>
{

}
