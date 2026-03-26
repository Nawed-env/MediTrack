package com.meditrack.ServiceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditrack.entity.EmergencyCard;
import com.meditrack.entity.Patient;
import com.meditrack.repository.EmergencyCardRepository;

@Service
public class EmergencyService 
{
    @Autowired private EmergencyCardRepository emergencyRepo;
    @Autowired private PatientServiceImpl patientService;
    
	public EmergencyCard getByQrToken(String token)
	{
		EmergencyCard qrToken = emergencyRepo.findByQrToken(token).orElseThrow(() -> new RuntimeException("Invalid orToken"));
		return qrToken;
	}

	public EmergencyCard createOrUpdate(EmergencyCard req)
	{
		Patient patient = patientService.getCurrentPatient();
		EmergencyCard card = emergencyRepo.findByPatientId(patient.getId()).orElse(EmergencyCard.builder()
				                                                                                             .patient(patient)
				                                                                                             .qrToken(UUID.randomUUID().toString())
				                                                                                             .build());
		card.setBloodGroup(req.getBloodGroup());
		card.setAllergies(req.getAllergies());
		card.setEmergencyNum(req.getEmergencyNum());
		card.setCriticalNotes(req.getCriticalNotes());
		return emergencyRepo.save(card);
	}

	public EmergencyCard getMyCard()
	{
		Patient patient = patientService.getCurrentPatient();
		EmergencyCard card = emergencyRepo.findByPatientId(patient.getId()).orElseThrow(() -> new RuntimeException("Emergency card not created"));
		return card;
	}
    
    
}
