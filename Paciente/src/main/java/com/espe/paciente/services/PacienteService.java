package com.espe.paciente.services;

import com.espe.paciente.models.entities.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> obtenerTodosLosPacientes();

    Paciente obtenerPacientePorId(Long id);

    Paciente guardarPaciente(Paciente paciente);

    Paciente actualizarPaciente(Long id, Paciente detallesPaciente);

    void eliminarPaciente(Long id);
}
