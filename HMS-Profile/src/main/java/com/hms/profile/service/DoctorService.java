package com.hms.profile.service;

import com.hms.profile.dto.DoctorDto;
import com.hms.profile.exception.HmsException;

public interface DoctorService {
	public Long addDoctor(DoctorDto doctorDto) throws HmsException;
	public DoctorDto getDoctotById(Long id) throws HmsException;
	public DoctorDto updateDoctor(DoctorDto doctorDto) throws HmsException;

}
