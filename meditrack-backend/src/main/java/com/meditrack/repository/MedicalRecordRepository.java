package com.meditrack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meditrack.entity.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long>
{

	List<MedicalRecord> findByDoctorIdOrderByCreatedDateDesc(Long id);

	List<MedicalRecord> findByPatientIdOrderByCreatedDateDesc(Long id);

	@Query("SELECT r FROM MedicalRecord r WHERE r.patient.id = :patientId ORDER BY r.createdDate DESC")
    List<MedicalRecord> findTimelineByPatientId(@Param("patientId") Long patientId);

}
