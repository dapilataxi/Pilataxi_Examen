package com.espe.cita.services;

import com.espe.cita.models.entities.Paciente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "paciente-service", url = "http://localhost:8081/api/pacientes")
public interface PacienteFeignClient {
    @GetMapping("/{id}")
    Paciente obtenerPacientePorId(@PathVariable Long id);
}
