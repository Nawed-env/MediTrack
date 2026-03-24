package com.meditrack_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meditrack_backend.Entity.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long>
{

}
