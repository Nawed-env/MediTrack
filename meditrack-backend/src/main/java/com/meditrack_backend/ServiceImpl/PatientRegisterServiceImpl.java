//package com.meditrack_backend.ServiceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.meditrack.dto.PatientRegisterDto;
//import com.meditrack.entity.PatientRegister;
//import com.meditrack.repository.PatientRegisterRepository;
//import com.meditrack.service.PatientRegisterService;
//
//@Service
//public class PatientRegisterServiceImpl implements PatientRegisterService
//{
//    @Autowired private PatientRegisterRepository patientRepo;
//
//	@Override
//	public PatientRegister newRegister(PatientRegisterDto patientdto)
//	{
//       PatientRegister pr = new PatientRegister();
//       pr.setName(patientdto.getName());
//       pr.setAge(patientdto.getAge());
//       pr.setMobileNum(patientdto.getMobileNum());
//       pr.setGender(patientdto.getGender());
//       return patientRepo.save(pr);
//	}
//}
package com.meditrack_backend.ServiceImpl;


