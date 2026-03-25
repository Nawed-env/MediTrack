package com.meditrack.Controller;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditrack.Service.PatientService;
import com.meditrack.dto.PatientDto;
import com.meditrack.dto.ResponseMessage;
import com.meditrack.entity.Patient;
import com.meditrack.utility.Constans;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/patient")
public class PatientController
{
   @Autowired private PatientService patientService;
   
//   @PostMapping("/register")
//   public ResponseEntity<ResponseMessage> patientRegi(@RequestBody PatientDto patientdto)
//   {
//       try
//       {
//    	   Patient register = patientService.newRegister(patientdto);
//    	   if(register != null)
//    	   {
//    		   return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "Patient register successfully register", register));
//    	   }
//    	   else
//    	   {
//    		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILURE, "Patient register failed"));
//    	   }
//       }
//       catch(Exception e)
//       {
//    	   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constans.FAILED, "Internal server error", e.getLocalizedMessage()));
//       }
//   }
   
   @GetMapping("/profile/{id}")
   @PreAuthorize("hasRole('DOCTOR','ADMIN')")
   public ResponseEntity<ResponseMessage> getProfile(@PathVariable Long id)
   {
	  try
	  {
	   Patient byid = patientService.getPatientByid(id);
       if(byid != null)
       {
    	   return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.FAILURE, "Patient register successfully"));
       }
       else
       {
    	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILURE, "Patient is not existed"));
       }
	  }
	  catch (Exception e)
	  {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constans.FAILURE, "Internal Server error"));
	  }
   }
   
   @GetMapping("/profile")
   @PreAuthorize("hasRole('PATIENT')")
   public ResponseEntity<ResponseMessage> getMyProfile()
   {
	   Patient myProfile = patientService.getMyProfile();
	   if(myProfile != null)
	   {
          return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "patient fetched successfully"));
	   }
	   else
	   {
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILURE, "Patient is not existed"));
	   }
   }
   
   @GetMapping("all")
   @PreAuthorize("hasRole('ADMIN')")
   public ResponseEntity<ResponseMessage> getAllPatients()
   {
	   List<Patient> allPatients = patientService.getAllPatients();
       return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "all Patients List", allPatients));
   }
   
  @PutMapping("/profile")
  @PreAuthorize("hasRole('PATIENT')")
  public ResponseEntity<ResponseMessage> updateProfile(@RequestBody PatientDto dto)
  {
	  Patient updateProfile = patientService.updateProfile(dto);
	  if(updateProfile != null)
		  return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.FAILURE, "Patient updated successfully"));
	  
	  else
		 return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.FAILURE, "Patient feching failed"));
  }
}
