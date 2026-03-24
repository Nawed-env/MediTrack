package com.meditrack_backend.Service;

import com.meditrack_backend.DTO.PatientDto;
import com.meditrack_backend.Entity.Patient;

public interface PatientRegisterService 
{

	Patient newRegister(PatientDto patientdto);

	Patient getPatientByid(Long id);

	void getMyProfile();

}
