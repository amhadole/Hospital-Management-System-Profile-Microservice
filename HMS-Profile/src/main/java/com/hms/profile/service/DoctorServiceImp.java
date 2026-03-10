package com.hms.profile.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hms.profile.dto.DoctorDto;
import com.hms.profile.entity.DoctorEntity;
import com.hms.profile.exception.HmsException;
import com.hms.profile.repository.DoctorRepository;

@Service
public class DoctorServiceImp implements DoctorService {
	private final DoctorRepository doctorRepository;

	public DoctorServiceImp(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Long addDoctor(DoctorDto doctorDto) throws HmsException {
		Optional<DoctorEntity> email = doctorRepository.findByEmail(doctorDto.getEmail());
		if (email.isPresent()) {
			throw new HmsException("DOCTOR_ALREADY_EXISTS");
		}
		return doctorRepository.save(doctorDto.toEntity()).getId();

	}

	@Override
	public DoctorDto getDoctotById(Long id) throws HmsException {
		return doctorRepository.findById(id).orElseThrow(() -> new HmsException("DOCTOR_NOT_FOUND")).toDto();
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto doctorDto) throws HmsException {
		doctorRepository.findById(doctorDto.getId()).orElseThrow(()-> new HmsException("DOCTOR_NOT_FOUND"));
		return doctorRepository.save(doctorDto.toEntity()).toDto();
	}

	@Override
	public Boolean doctorExists(Long id) throws HmsException {
		return doctorRepository.existsById(id);
	}

}
