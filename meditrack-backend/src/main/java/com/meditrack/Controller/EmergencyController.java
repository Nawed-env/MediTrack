package com.meditrack.Controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditrack.ServiceImpl.EmergencyService;
import com.meditrack.dto.ResponseMessage;
import com.meditrack.entity.EmergencyCard;
import com.meditrack.utility.Constans;




@RestController
@RequestMapping("/api/emergency")
public class EmergencyController
{
    @Autowired private EmergencyService emergencyService;
    
 // PUBLIC — scanned from QR code, no login needed
    @GetMapping("/public/{qrToken}")
    public ResponseEntity<ResponseMessage> getPublicCard(@PathVariable String token)
    {
        EmergencyCard byQrToken = emergencyService.getByQrToken(token);
        if(byQrToken != null)
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "Patient need Emergency", byQrToken));
        
        else
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "emergency cann't support you"));
    }
    
    @PostMapping("/my")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<ResponseMessage> createOrUpdate(@RequestBody EmergencyCard req)
    {
        EmergencyCard orUpdate = emergencyService.createOrUpdate(req);
        if(orUpdate != null)
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "Emergency Cared saved successfully", orUpdate));
        
        else
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "Card is not updated/created"));
    }
    
 // Patient views their own card (to show QR)
    @GetMapping("/my")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<ResponseMessage> getMyCard()
    {
       EmergencyCard myCard = emergencyService.getMyCard();
       if(myCard != null)
    	   return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS,"Emegency Card fetched", myCard));
       
       else
    	   return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "Patient card not found"));
    	   
    }
    
}
