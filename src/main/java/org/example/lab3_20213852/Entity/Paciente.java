package org.example.lab3_20213852.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "edad",nullable = false)
    private Integer edad;

    @Column(name = "genero",nullable = false)
    private String genero;

    @Column(name = "diagnostico",nullable = false)
    private String diagnostico;

    @Column(name = "fecha_cita",nullable = false)
    private String fechaCita;


    @Column(name = "numero_habitacion",nullable = false)
    private Integer numeroHabitacion;

    @Column(name = "oftalmologo_id",nullable = false)
    private Integer oftalmologoId;

    @Column(name = "clinica_id",nullable = false)
    private Integer clinicaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public Integer getOftalmologoId() {
        return oftalmologoId;
    }

    public void setOftalmologoId(Integer oftalmologoId) {
        this.oftalmologoId = oftalmologoId;
    }

    public Integer getClinicaId() {
        return clinicaId;
    }

    public void setClinicaId(Integer clinicaId) {
        this.clinicaId = clinicaId;
    }
}
