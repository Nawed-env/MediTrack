package com.meditrack_backend.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meditrack_backend.Repository.DoctorRepository;
import com.meditrack_backend.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService
{
    @Autowired private DoctorRepository doctorRepo;

	@Override
	public void getDoctorProfile()
	{
		
	}

	
}
