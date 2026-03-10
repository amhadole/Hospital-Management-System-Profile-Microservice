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
import com.hms.profile.dto.DoctorDto;
import com.hms.profile.exception.HmsException;
import com.hms.profile.service.DoctorService;

@RestController
@RequestMapping("/profile/doctor")
@Validated
public class DoctorController {
	private final DoctorService doctorService;
	
	public DoctorController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<Long>> addDoctor(@RequestBody DoctorDto doctorDto){
		Long doctor = doctorService.addDoctor(doctorDto);
		ApiResponse<Long> response = new ApiResponse<Long>(HttpStatus.CREATED.value(), "Doctor Added Successfully", doctor, LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<DoctorDto>> getDoctorById(@PathVariable Long id){
		DoctorDto doctotById = doctorService.getDoctotById(id);
		ApiResponse<DoctorDto> response = new ApiResponse<DoctorDto>(HttpStatus.OK.value(), "Fetch Sucessfully", doctotById, LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<ApiResponse<DoctorDto>> updateDoctor(@RequestBody DoctorDto doctorDto) throws HmsException{
		DoctorDto updateDoctor = doctorService.updateDoctor(doctorDto);
		ApiResponse<DoctorDto> response = new ApiResponse<DoctorDto>(HttpStatus.OK.value(), "Doctor Updated Successfully", updateDoctor, LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/exists/{id}")
	public ResponseEntity<ApiResponse<Boolean>> doctorExists(@PathVariable Long id) throws HmsException{
		Boolean doctorExists = doctorService.doctorExists(id);
		ApiResponse<Boolean> response = new ApiResponse<Boolean>(HttpStatus.OK.value(), "Checked If Doctor Exists", doctorExists, LocalDateTime.now());
		return new ResponseEntity<ApiResponse<Boolean>>(response, HttpStatus.OK);
	}

}
