package com.espe.cita.models.entities;

import lombok.Data;

@Data
public class Doctor {
    private Long id;
    private String name;
    private String specialty;
    private int experience;
}
