package com.cognizant.hospitalmgmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.hospitalmgmt.exceptions.PatientNotFoundException;
import com.cognizant.hospitalmgmt.exceptions.PatientNullException;
import com.cognizant.hospitalmgmt.models.Patient;
import com.cognizant.hospitalmgmt.repositories.PatientRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired 
	private PatientRepository patientRepository;
    @Autowired
    private EntityManager entityManager;
	@Override
	public Patient addPatient(Patient patient) {
		// TODO Auto-generated method stub
		if(patient!=null) {
			return patientRepository.save(patient);
		}else
			throw new PatientNullException("Patient object is null");
		
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientByAdharCardNo(String adharCardNo) {
		// TODO Auto-generated method stub
		return patientRepository.findById(adharCardNo)
				.orElseThrow(()->
				new PatientNotFoundException("Patient not found in the "
						+ "database with Adhar Card No: "+adharCardNo));
	}

	@Override
	public List<Patient> getPatientByPhoneNumber(long contactNumber) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Patient> cq = cb.createQuery(Patient.class);
		Root<Patient> patient = cq.from(Patient.class);
		cq.select(patient).where(cb.equal(patient.get("contactNumber"), contactNumber));
		return entityManager.createQuery(cq).getResultList();
		
	}

	@Override
	public Patient updatePatient(String adharCardNo, long phoneNumber, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePatient(String adharCardNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient getPatientByEmail(String email) {
		// TODO Auto-generated method stub
		return patientRepository.findByEmail(email)
				.orElseThrow(()->new 
						PatientNotFoundException("Patient not found "
								+ "with email: "+email));
	}

}
