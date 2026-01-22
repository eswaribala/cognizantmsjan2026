package com.cognizant.hospitalmgmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hospitalmgmt.models.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

}
