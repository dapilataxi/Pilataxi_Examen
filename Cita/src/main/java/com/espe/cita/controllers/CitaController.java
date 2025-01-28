package com.espe.cita.controllers;

import com.espe.cita.models.entities.Cita;
import com.espe.cita.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        return ResponseEntity.ok(citaService.crearCita(cita));
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Cita> obtenerCitasPorDoctor(@PathVariable Long doctorId) {
        return citaService.obtenerCitasPorDoctor(doctorId);
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Cita> obtenerCitasPorPaciente(@PathVariable Long pacienteId) {
        return citaService.obtenerCitasPorPaciente(pacienteId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return ResponseEntity.noContent().build();
    }
}
