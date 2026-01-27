package com.cognizant.hospitalmgmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.hospitalmgmt.models.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}
