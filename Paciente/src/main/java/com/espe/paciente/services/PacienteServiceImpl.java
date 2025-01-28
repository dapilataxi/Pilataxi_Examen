package com.espe.paciente.services;

import com.espe.paciente.models.entities.Paciente;
import com.espe.paciente.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> obtenerTodosLosPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente actualizarPaciente(Long id, Paciente detallesPaciente) {
        Paciente paciente = obtenerPacientePorId(id);
        paciente.setNombre(detallesPaciente.getNombre());
        paciente.setEdad(detallesPaciente.getEdad());
        paciente.setDireccion(detallesPaciente.getDireccion());
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        Paciente paciente = obtenerPacientePorId(id);
        pacienteRepository.delete(paciente);
    }
}
