package com.hms.profile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.profile.entity.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long>{

	Optional<PatientEntity> findByEmail(String email);

}
