package com.espe.doctor.services;

import com.espe.doctor.models.entities.Doctor;
import com.espe.doctor.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Doctor doctor = findDoctorById(id);
        doctor.setName(doctorDetails.getName());
        doctor.setSpecialty(doctorDetails.getSpecialty());
        doctor.setExperience(doctorDetails.getExperience());
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        Doctor doctor = findDoctorById(id);
        doctorRepository.delete(doctor);
    }
}
