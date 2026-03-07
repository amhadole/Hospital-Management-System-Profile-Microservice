package com.hms.profile.dto;

import java.time.LocalDate;

import com.hms.profile.entity.PatientEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	private String phone;
	private String address;
	private String aadharNo;
	private BloodGroup bloodGroup;
	private String allergies;
	private String chronicDisease;

	public PatientEntity toEntity() {
		return new PatientEntity(this.id, this.name, this.email, this.dob, this.phone, this.address, this.aadharNo,
				this.bloodGroup, this.allergies, this.chronicDisease);
	}
}
