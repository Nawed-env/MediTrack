package com.meditrack_backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditrack_backend.Service.DoctorService;


@RestController
@RequestMapping("/Doctor")
public class DoctorController
{
    @Autowired private DoctorService doctorService;
    
//    @GetMapping("/profile")
//    public ResponseEntity<ResponseMessage> getProfile()
//    {
//    	doctorService.getDoctorProfile();
//        return new ResponseEntity.ok();
//    }
    
}
