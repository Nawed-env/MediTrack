package com.meditrack.Service;

import java.util.List;

import com.meditrack.dto.PatientDto;
import com.meditrack.entity.Patient;

public interface PatientService {

	Patient newRegister(PatientDto patientdto);

	Patient getPatientByid(Long id);

	Patient getMyProfile();

	List<Patient> getAllPatients();

	Patient updateProfile(PatientDto dto);

}


