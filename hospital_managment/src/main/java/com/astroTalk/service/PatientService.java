package com.astroTalk.service;

import com.astroTalk.entity.Patient;
import com.astroTalk.exception.PatientException;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PatientService {

    public Patient addPatient(Patient patient);

    public List<Patient> getAllPatient() throws PatientException;

    public String changePatientStatus(Integer patientId) throws PatientException;

}
