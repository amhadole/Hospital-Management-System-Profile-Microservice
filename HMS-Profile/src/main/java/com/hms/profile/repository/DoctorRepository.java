package com.hms.profile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hms.profile.dto.DoctorDropdown;
import com.hms.profile.entity.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long>{

	Optional<DoctorEntity> findByEmail(String email);
	
	Optional<DoctorEntity> findByLicenseNo(String licenseNo);
	
	
	@Query("Select d.id As id, d.name As name From DoctorEntity d")
	List<DoctorDropdown> findAllDoctorDropdown();
	
	@Query("Select d.id As id, d.name As name From DoctorEntity d Where d.id in :id")
	List<DoctorDropdown> findAllDoctorDropdownById(@Param("id")List<Long> id);
}
