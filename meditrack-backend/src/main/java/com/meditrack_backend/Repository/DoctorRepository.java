package com.meditrack_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meditrack_backend.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>
{

}
