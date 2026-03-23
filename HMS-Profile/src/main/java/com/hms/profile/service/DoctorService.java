package com.hms.profile.service;

import java.util.List;

import com.hms.profile.dto.DoctorDropdown;
import com.hms.profile.dto.DoctorDto;
import com.hms.profile.exception.HmsException;

public interface DoctorService {
	public abstract Long addDoctor(DoctorDto doctorDto) throws HmsException;
	public abstract DoctorDto getDoctotById(Long id) throws HmsException;
	public abstract DoctorDto updateDoctor(DoctorDto doctorDto) throws HmsException;
	public abstract Boolean doctorExists(Long id)throws HmsException;
	
	public List<DoctorDropdown> getDoctorDropdown() throws HmsException;
}
