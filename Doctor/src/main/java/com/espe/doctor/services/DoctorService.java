package com.espe.doctor.services;

import com.espe.doctor.models.entities.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> findAllDoctors();

    Doctor findDoctorById(Long id);

    Doctor saveDoctor(Doctor doctor);

    Doctor updateDoctor(Long id, Doctor doctorDetails);

    void deleteDoctorById(Long id);
}
