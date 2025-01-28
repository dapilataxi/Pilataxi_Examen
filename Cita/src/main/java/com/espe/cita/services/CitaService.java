package com.espe.cita.services;

import com.espe.cita.models.entities.Cita;

import java.util.List;

public interface CitaService {
    Cita crearCita(Cita cita);

    List<Cita> obtenerCitasPorDoctor(Long doctorId);

    List<Cita> obtenerCitasPorPaciente(Long pacienteId);

    void eliminarCita(Long id);
}
