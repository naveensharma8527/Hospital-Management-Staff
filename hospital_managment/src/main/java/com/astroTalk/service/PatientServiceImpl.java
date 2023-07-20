package com.astroTalk.service;

import com.astroTalk.entity.Patient;
import com.astroTalk.entity.PatientStatus;
import com.astroTalk.exception.PatientException;
import com.astroTalk.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository pr;

    @Override
    public Patient addPatient(Patient patient) {

        Patient addedPatient = pr.save(patient);
        return addedPatient;
    }

    @Override
    public List<Patient> getAllPatient() throws PatientException {

        List<Patient> patients = pr.findAll();

        if (patients.isEmpty()){
            throw new PatientException("No Patient in Record");
        }

        return patients;
    }

    @Override
    public String changePatientStatus(Integer patientId) throws PatientException {

        Optional<Patient> pat = pr.findById(patientId);
        if (pat.isEmpty()){
            throw new PatientException("No patient with given id found");
        }
         Patient patient = pat.get();
        patient.setStatus(PatientStatus.DISCHARGED);
        pr.save(patient);

        return "Patient status changed successfully";
    }
}
