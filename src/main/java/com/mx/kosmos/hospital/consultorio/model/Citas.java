package com.mx.kosmos.hospital.consultorio.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Consultorio consultorio;
    
    @ManyToOne
    private Doctor doctor;

    private String nombrePaciente;
    private Date inicioConsulta;
    private Date finConsulta;
    
	public Consultorio getConsultorio() {
		return consultorio;
	}
	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public Date getInicioConsulta() {
		return inicioConsulta;
	}
	public void setInicioConsulta(Date inicioConsulta) {
		this.inicioConsulta = inicioConsulta;
	}
	public Date getFinConsulta() {
		return finConsulta;
	}
	public void setFinConsulta(Date finConsulta) {
		this.finConsulta = finConsulta;
	}

//    Citas (se generan dinámicamente)
//    ● Consultorio
//    ● Doctor
//    ● Horario de consulta
//    ● Nombre del paciente

    
    
}
