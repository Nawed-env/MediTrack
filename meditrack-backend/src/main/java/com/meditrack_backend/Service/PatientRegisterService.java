package com.meditrack_backend.Service;

import com.meditrack_backend.DTO.PatientRegisterDto;
import com.meditrack_backend.Entity.PatientRegister;

public interface PatientRegisterService {

	PatientRegister newRegister(PatientRegisterDto patientdto);

}
