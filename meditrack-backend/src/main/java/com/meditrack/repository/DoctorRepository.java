package com.meditrack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meditrack.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>
{

	Optional<Doctor> findByUserId(Long id);

}
