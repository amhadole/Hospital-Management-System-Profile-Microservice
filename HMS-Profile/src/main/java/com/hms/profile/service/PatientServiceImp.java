package com.hms.profile.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hms.profile.dto.PatientDto;
import com.hms.profile.entity.PatientEntity;
import com.hms.profile.exception.HmsException;
import com.hms.profile.repository.PatientRepository;

@Service
public class PatientServiceImp implements PatientService {
	private final PatientRepository patientRepository;

	public PatientServiceImp(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public Long addPatient(PatientDto patientDto) throws HmsException {
		Optional<PatientEntity> email = patientRepository.findByEmail(patientDto.getEmail());
		if (email.isPresent()) {
			throw new HmsException("PATIENT_ALREADY_EXISTS");
		}
		return patientRepository.save(patientDto.toEntity()).getId();

	}

	@Override
	public PatientDto getPatientById(Long id) throws HmsException {

		return patientRepository.findById(id).orElseThrow(() -> new HmsException("PATIENT_NOT_FOUND")).toDto();
	}

	@Override
	public PatientDto updatePatient(PatientDto patientDto) throws HmsException {
		patientRepository.findById(patientDto.getId()).orElseThrow(()-> new HmsException("PATEINT_NOT_FOUND"));
		return patientRepository.save(patientDto.toEntity()).toDto();
	}

}
