package com.meditrack.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.meditrack.dto.MedicalRecordDto;
import com.meditrack.entity.MedicalRecord;
import com.meditrack.entity.Patient;
import com.meditrack.entity.User;
import com.meditrack.repository.MedicalRecordRepository;
import com.meditrack.repository.PatientRepository;
import com.meditrack.repository.UserRepository;

@Service
public class MedicalRecordServiceImpl 
{
    @Autowired private MedicalRecordRepository medicalRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private PatientRepository patientRepo;
    
	public List<MedicalRecord> getMyRecords()
	{
		List<MedicalRecord> list = medicalRepo.findByPatientIdOrderByCreatedDateDesc(getCurrentpatient().getId());
		return list;
	}

	private Patient getCurrentpatient()
	{
		String email = SecurityContextHolder.getContext()
		                     .getAuthentication()
		                     .getName();
		
		User user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("user not found"));
		Patient patient = patientRepo.findByUserId(user.getId()).orElseThrow(() -> new RuntimeException("patient profile not found"));
		return patient;
	}

	 // ── Anyone views single record by ID ──
	public MedicalRecord getById(Long id)
	{
		return medicalRepo.findById(id).orElseThrow(() -> new RuntimeException("Records not found"));
	}

	 // ── Patient self-uploads a report ──
	public MedicalRecord uploadRecords(MedicalRecordDto dto)
	{
		Patient patient = getCurrentpatient();
		MedicalRecord save = medicalRepo.save(MedicalRecord.builder()
				                       .patient(patient).title(dto.getTitle())
				                       .recordType(dto.getRecordType())
				                       .description(dto.getDescription())
				                       .fileUrl(dto.getFileUrl())
				                       .build());
		return save;
	}

	// ── Patient views health timeline ──
	public List<MedicalRecord> getTimeLine()
	{
		List<MedicalRecord> timelineByPatientId = medicalRepo.findTimelineByPatientId(getCurrentpatient().getId());
		
			return timelineByPatientId;
	}
}
