package com.espe.cita.services;

import com.espe.cita.models.entities.Cita;
import com.espe.cita.repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private DoctorFeignClient doctorFeignClient;

    @Autowired
    private PacienteFeignClient pacienteFeignClient;

    @Override
    public Cita crearCita(Cita cita) {
        try {
            // Validar que el doctor existe
            doctorFeignClient.obtenerDoctorPorId(cita.getDoctorId());
        } catch (Exception e) {
            throw new RuntimeException("El doctor con ID " + cita.getDoctorId() + " no existe.");
        }

        try {
            // Validar que el paciente existe
            pacienteFeignClient.obtenerPacientePorId(cita.getPacienteId());
        } catch (Exception e) {
            throw new RuntimeException("El paciente con ID " + cita.getPacienteId() + " no existe.");
        }

        // Guardar la cita
        return citaRepository.save(cita);
    }

    @Override
    public List<Cita> obtenerCitasPorDoctor(Long doctorId) {
        return citaRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Cita> obtenerCitasPorPaciente(Long pacienteId) {
        return citaRepository.findByPacienteId(pacienteId);
    }

    @Override
    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }
}
