package com.hms.profile.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.profile.dto.ApiResponse;
import com.hms.profile.dto.PatientDto;
import com.hms.profile.exception.HmsException;
import com.hms.profile.service.PatientService;

@RestController
@RequestMapping("/profile/patient")
@Validated
public class PatientController {
	
	private final PatientService patientService;
	
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<Long>> addPatient(@RequestBody PatientDto patientDto) throws HmsException{
		Long patient = patientService.addPatient(patientDto);
		 ApiResponse<Long> response =
			        new ApiResponse<>(HttpStatus.CREATED.value(), "Patient Created", patient, LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<PatientDto>> getPatientById(@PathVariable Long id){
		PatientDto patient = patientService.getPatientById(id);
		ApiResponse<PatientDto> response = new ApiResponse<PatientDto>(HttpStatus.OK.value(), "Fetch Successfully", patient, LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<ApiResponse<PatientDto>> updatePatient(@RequestBody PatientDto patientDto) throws HmsException{
		PatientDto updatePatient = patientService.updatePatient(patientDto);
		ApiResponse<PatientDto> response = new ApiResponse<PatientDto>(HttpStatus.OK.value(), "Updated Successfully", updatePatient, LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/exists/{id}")
	public ResponseEntity<ApiResponse<Boolean>> patientExists(@PathVariable Long id)throws HmsException{
		Boolean patientExists = patientService.patientExists(id);
		ApiResponse<Boolean> response = new ApiResponse<Boolean>(HttpStatus.OK.value(), "Checked If Patient Exists", patientExists, LocalDateTime.now());
		return new ResponseEntity<ApiResponse<Boolean>>(response, HttpStatus.OK);
	}
}
