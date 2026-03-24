package com.meditrack_backend.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditrack_backend.DTO.PatientDto;
import com.meditrack_backend.Entity.Patient;
import com.meditrack_backend.Repository.PatientRepository;
import com.meditrack_backend.Service.PatientRegisterService;

@Service
public class PatientRegisterServiceImpl implements PatientRegisterService
{
    @Autowired private PatientRepository patientRepo;

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
				.getAu
		return null;
	}
}
