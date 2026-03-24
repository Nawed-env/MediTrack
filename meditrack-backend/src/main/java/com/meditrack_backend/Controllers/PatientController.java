package com.meditrack_backend.Controllers;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditrack_backend.DTO.ResponseMessage;
import com.meditrack_backend.Entity.Patient;
import com.meditrack_backend.Service.PatientRegisterService;
import com.meditrack_backend.Utility.Constans;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/patient")
public class PatientController
{
   @Autowired private PatientRegisterService patientService;
   
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
//   @PreAuthorize("hasRole('PATIENT')")
   public ResponseEntity<ResponseMessage> getProfile(Long id)
   {
	  try
	  {
	   Patient byid = patientService.getPatientByid(id);
       if(byid != null)
       {
    	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILURE, "Patient register failed"));
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
   public ResponseEntity<ResponseMessage> getMyProfile()
   {
	   patientService.getMyProfile();
       return new ResponseEntity<ResponseMessage>();
   }
   
}
