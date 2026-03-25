package com.meditrack.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.meditrack.Service.PatientService;
import com.meditrack.dto.PatientDto;
import com.meditrack.entity.Patient;
import com.meditrack.entity.User;
import com.meditrack.repository.PatientRepository;
import com.meditrack.repository.UserRepository;

@Service
public class PatientServiceImpl implements PatientService
{

	@Autowired private PatientRepository patientRepo;
	@Autowired private UserRepository userRepo;

	@Override
	public Patient newRegister(PatientDto patientdto)
	{
       Patient pr = new Patient();
       pr.setName(patientdto.getName());
       pr.setAge(patientdto.getAge());
       pr.setBloodGroup(patientdto.getBloodGroup());
       pr.setMobileNum(patientdto.getMobileNum());
       pr.setGender(patientdto.getGender());
       return patientRepo.save(pr);
	}

	@Override
	public Patient getPatientByid(Long id)
	{
		Optional<Patient> byId = patientRepo.findById(id);
		Patient patient = byId.get();
		return patient;
	}

	@Override
	public Patient getMyProfile()
	{
		return getCurrentPatient();
	}

	private Patient getCurrentPatient()
	{
		String email = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		User user = userRepo.findByEmail(email)
				        .orElseThrow(() -> new RuntimeException("User not found"));
        return patientRepo.findByUserId(user.getId())
    .orElseThrow(() -> new RuntimeException("Patient profile not found"));
	}
	
	@Override
	public List<Patient> getAllPatients()
	{
		List<Patient> all = patientRepo.findAll();
		return all;
		
	}

	@Override
	public Patient updateProfile(PatientDto dto)
	{
		Patient p = getCurrentPatient();
		
		if(dto.getName() != null)
			p.setName(dto.getName());
		
		if(dto.getAge() != null)
			p.setAge(dto.getAge());
		
		if(dto.getGender() != null)
			p.setGender(dto.getGender());
		
		if(dto.getBloodGroup() != null)
			p.setBloodGroup(dto.getBloodGroup());
		
		if(dto.getEmergencyNum() != null)
			p.setEmergencyNum(dto.getEmergencyNum());
		
		return patientRepo.save(p);
	}
}


