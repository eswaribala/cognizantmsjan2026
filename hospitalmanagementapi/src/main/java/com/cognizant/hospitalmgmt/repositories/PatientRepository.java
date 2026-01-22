package com.cognizant.hospitalmgmt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hospitalmgmt.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {

	Optional<Patient> findByEmail(String email);
}
