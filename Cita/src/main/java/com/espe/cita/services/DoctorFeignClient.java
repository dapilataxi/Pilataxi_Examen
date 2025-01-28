package com.espe.cita.services;

import com.espe.cita.models.entities.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "doctor-service", url = "http://localhost:8083/api/doctores")
public interface DoctorFeignClient {
    @GetMapping("/{id}")
    Doctor obtenerDoctorPorId(@PathVariable Long id);
}
