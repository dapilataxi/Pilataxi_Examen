package com.espe.cita.models.entities;

import lombok.Data;

@Data
public class Paciente {
    private Long id;
    private String nombre;
    private int edad;
    private String direccion;
}
