package com.meditrack.Controller;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meditrack.ServiceImpl.MedicalRecordServiceImpl;
import com.meditrack.dto.MedicalRecordDto;
import com.meditrack.dto.ResponseMessage;
import com.meditrack.entity.MedicalRecord;
import com.meditrack.utility.Constans;





@RestController
@RequestMapping("/api/Medicalrecords")
public class MedicalRecordController
{
    @Autowired private MedicalRecordServiceImpl medicalService;
    
    @GetMapping("/my")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<ResponseMessage> getMyRecords()
    {
    	List<MedicalRecord> myRecords = medicalService.getMyRecords();
    	if(myRecords != null)
    		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "Patient records was fetched"));
    	
    	else
    		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "patient records was feched failed"));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> getById(@PathVariable Long id)
    {
    	MedicalRecord byId = medicalService.getById(id);
        if(byId != null)
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "patient medical record fetched"));
        
        else
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,Constans.FAILED, "patient records feching failed"));
    }
    
    @PostMapping("/upload")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<ResponseMessage> uploadRecords(@RequestBody MedicalRecordDto dto)
    {
        MedicalRecord uploadRecords = medicalService.uploadRecords(dto);        
        if(uploadRecords != null)
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "patient records uploaded successfully", uploadRecords));
        
        else
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED,"records uploading failed"));
    }
    
    @GetMapping("/timeLine")
    public ResponseEntity<ResponseMessage> getTimeLine()
    {
        List<MedicalRecord> timeLine = medicalService.getTimeLine();
        if(timeLine!=null)
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constans.SUCCESS, "TimeLine fetched", timeLine));
        
        else
        	return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constans.FAILED, "TimeLine fetching failed"));
    }
    
}
