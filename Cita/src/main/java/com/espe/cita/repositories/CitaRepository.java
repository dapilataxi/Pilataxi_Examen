package com.espe.cita.repositories;

import com.espe.cita.models.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByDoctorId(Long doctorId);

    List<Cita> findByPacienteId(Long pacienteId);
}
