package com.meditrack.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.meditrack.dto.MedicalRecordDto;
import com.meditrack.entity.Doctor;
import com.meditrack.entity.MedicalRecord;
import com.meditrack.entity.Patient;
import com.meditrack.entity.User;
import com.meditrack.repository.DoctorRepository;
import com.meditrack.repository.MedicalRecordRepository;
import com.meditrack.repository.PatientRepository;
import com.meditrack.repository.UserRepository;

@Service
public class DoctorServiceImpl 
{
    @Autowired private DoctorRepository doctorRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private MedicalRecordRepository medicalRepo;
    @Autowired private PatientRepository patientRepo;

	public Doctor getDoctorProfile()
	{
		return getCurrentDoctor();
	}

	private Doctor getCurrentDoctor()
	{
		String email = SecurityContextHolder.getContext()
				               .getAuthentication().getName();
		
		User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("user not found"));
		
		return doctorRepo.findByUserId(user.getId()).orElseThrow(() -> new RuntimeException("Doctor profile is not found"));
	}

	public List<Patient> getMyPatients()
	{
        Doctor doctor = getCurrentDoctor();
        return medicalRepo.findByDoctorIdOderByCreatedAtDesc(doctor.getId()).stream()
        		                                                            .map(MedicalRecord::getPatient)
        		                                                            .distinct()
        		                                                            .toList();
	}

	public List<MedicalRecord> getPatientRecords(Long id)
	{
		getCurrentDoctor();
		List<MedicalRecord> list = medicalRepo.findByPatientIdOderByCreatedAtDesc(id);
		return list;
	}

	public MedicalRecord addRecord(Long patientId, MedicalRecordDto dto)
	{
		Doctor doctor = getCurrentDoctor();
		Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new RuntimeException("patient not found"));
		
		MedicalRecord record = MedicalRecord.builder()
				                            .patient(patient)
				                            .doctor(doctor)
				                            .title(dto.getTitle())
				                            .recordType(dto.getRecordType())
				                            .description(dto.getDescription())
				                            .doctorNote(dto.getDoctorNote())
				                            .fileUrl(dto.getFileUrl())
				                            .build();
		return medicalRepo.save(record);
	}

	public MedicalRecord updateNote(Long id, String note)
	{
		Doctor doctor = getCurrentDoctor();
		MedicalRecord record = medicalRepo.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
		
		// only the doctor who created the record can edit it
		 if (!record.getDoctor().getId().equals(doctor.getId())) {
	            throw new RuntimeException("Access denied: not your record");
	        }
	        record.setDoctorNote(note);
	        return medicalRepo.save(record);
	}

	public void deleteRecord(Long id)
	{
		Doctor doctor = getCurrentDoctor();
		MedicalRecord record = medicalRepo.findById(id).orElseThrow(() -> new RuntimeException("record not found"));
		
		if(!record.getDoctor().getId().equals(doctor.getId())) {
            throw new RuntimeException("Access denied");
        }
        medicalRepo.deleteById(id);
	}

	
}
