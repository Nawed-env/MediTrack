package com.meditrack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meditrack.entity.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long>
{

	List<MedicalRecord> findByDoctorIdOderByCreatedAtDesc(Long id);

	List<MedicalRecord> findByPatientIdOderByCreatedAtDesc(Long id);

}
