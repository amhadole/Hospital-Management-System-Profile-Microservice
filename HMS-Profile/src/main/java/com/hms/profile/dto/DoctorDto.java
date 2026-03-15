package com.hms.profile.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.hms.profile.entity.DoctorEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	private String phone;
	private String address;
	private String licenseNo;
	private String specialization;
	private String department;
	private Integer totalExp;
	
	private LocalTime workStart;
	private LocalTime workEnd;
	private LocalTime breakStart;
	private LocalTime breakEnd;
	private Integer slotDuration;
	
	public DoctorEntity toEntity() {
		return new DoctorEntity(this.id, this.name, this.email, this.dob, this.phone, this.address, this.licenseNo, this.specialization, this.department, this.totalExp, this.workStart, this.workEnd, this.breakStart, this.breakEnd, this.slotDuration);
				
	}
}
