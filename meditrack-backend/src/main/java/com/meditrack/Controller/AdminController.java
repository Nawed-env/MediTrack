package com.meditrack.Controller;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditrack.dto.ResponseMessage;
import com.meditrack.entity.User;
import com.meditrack.repository.DoctorRepository;
import com.meditrack.repository.MedicalRecordRepository;
import com.meditrack.repository.PatientRepository;
import com.meditrack.repository.UserRepository;
import com.meditrack.utility.Constans;



@RestController
@RequestMapping("/api/admin")
public class AdminController
{
    @Autowired private UserRepository userRepo;
    @Autowired private PatientRepository patientRepo;
    @Autowired private DoctorRepository doctorRepo;
    @Autowired private MedicalRecordRepository medicalRepo;
    
    @GetMapping("/stats")
    public ResponseEntity<ResponseMessage> getStats()
    {
    	 Map<String, Long> stats = Map.of(
    			"totalUsers", userRepo.count(),
    			"totalPatients", patientRepo.count(),
    			"totalDoctors", doctorRepo.count(),
    			"totalRecords", medicalRepo.count());
    	 
    	 if(stats != null)
    	        return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "Hole Records was fetched", stats));
    	 
    	 else
    		 return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "record fetcheding is failed"));
    }
    
    @GetMapping("/user")
    public ResponseEntity<ResponseMessage> getAllUsers()
    {
        List<User> all = userRepo.findAll();
        if(all != null)
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "all users fetched", all));
        
        else
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "fetching all users failed"));
    }
    
    @GetMapping("/user{id}")
    public ResponseEntity<ResponseMessage> deleteUser(@PathVariable Long id)
    {
    	userRepo.deleteById(id);
    	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "user was deleted successfully"));
    }
    
}
