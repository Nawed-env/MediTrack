package com.meditrack.Controller;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meditrack.Service.DoctorService;
import com.meditrack.dto.MedicalRecordDto;
import com.meditrack.dto.ResponseMessage;
import com.meditrack.entity.Doctor;
import com.meditrack.entity.MedicalRecord;
import com.meditrack.entity.Patient;
import com.meditrack.utility.Constans;



@RestController
@RequestMapping("api/Doctor")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorController
{
    @Autowired private DoctorService doctorService;
    
    @GetMapping("/profile")
    public ResponseEntity<ResponseMessage> getProfile()
    {
    	Doctor doctor = doctorService.getDoctorProfile();
    	if(doctor != null)
    		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "Doctor id is fetch", doctor));
    	
    	else
    		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "Doctor id doesnt fetch with this id"));
    }
    
    @GetMapping("/patients")
    public ResponseEntity<ResponseMessage> getMyPatient()
    {
    	List<Patient> patients = doctorService.getMyPatients();
    	if(patients != null)
    		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "getting all patients", patients));
    	
    	else
    		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "Patients feching failed"));
    }
    
    @GetMapping("/patients/{patientId}/records")
    public ResponseEntity<ResponseMessage> getPatientRecords(@PathVariable Long id)
    {
    	List<MedicalRecord> records = doctorService.getPatientRecords(id);
    	if(records != null)
             return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "feching all records by doctor", records));
    	
    	else
    		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "feching records is failed"));
    }
    
//    new patient register to doctor
    @PostMapping("/patients/records")
    public ResponseEntity<ResponseMessage> addRecord( @PathVariable Long patientId, @RequestBody MedicalRecordDto dto)
    {
    	MedicalRecord saved = doctorService.addRecord(patientId, dto);        
         if(saved != null)
        	 return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "new Patient was register", saved));
         
         else
        	 return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "new Patient register failed"));
    }
    
//    update doctor note
    @PutMapping("/records/{id}/note")
    public ResponseEntity<ResponseMessage> updateNote(@PathVariable Long id, @RequestParam String note)
    {
        MedicalRecord record = doctorService.updateNote(id, note);
        if(record != null)
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "Doctor note was updated", record));
        
        else
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_METHOD, Constans.FAILED, "note is not updated"));
    }
    
    @DeleteMapping("records{id}")
    public ResponseEntity<ResponseMessage> deleteRecord(@PathVariable Long id)
    {
    	 doctorService.deleteRecord(id);
    	 return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "record was deleted"));
    }
}
