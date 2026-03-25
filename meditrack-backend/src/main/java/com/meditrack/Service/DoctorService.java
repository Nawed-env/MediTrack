package com.meditrack.Service;

import java.util.List;

import com.meditrack.dto.MedicalRecordDto;
import com.meditrack.entity.Doctor;
import com.meditrack.entity.MedicalRecord;
import com.meditrack.entity.Patient;

public interface DoctorService 
{

	Doctor getDoctorProfile();

	List<Patient> getMyPatients();

	List<MedicalRecord> getPatientRecords(Long id);

	MedicalRecord addRecord(Long patientId, MedicalRecordDto dto);

	MedicalRecord updateNote(Long id, String note);

	void deleteRecord(Long id);

}
