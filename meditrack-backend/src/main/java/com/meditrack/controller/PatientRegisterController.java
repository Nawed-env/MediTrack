//package com.meditrack.controller;
//
//import java.net.HttpURLConnection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.meditrack.dto.PatientRegisterDto;
//import com.meditrack.dto.ResponseMessage;
//import com.meditrack.entity.PatientRegister;
//import com.meditrack.service.PatientRegisterService;
//import com.meditrack.utility.Constans;
//
//
//@RestController
//@RequestMapping("/patientRegister")
//public class PatientRegisterController
//{
//   @Autowired private PatientRegisterService patientService;
//   
//   @PostMapping("/register")
//   public ResponseEntity<ResponseMessage> patientRegi(@RequestBody PatientRegisterDto patientdto)
//   {
//       try
//       {
//    	   PatientRegister register = patientService.newRegister(patientdto);
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
//   
//   
//}
