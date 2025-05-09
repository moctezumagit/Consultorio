package com.mx.kosmos.hospital.consultorio.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.mx.kosmos.hospital.consultorio.model.Citas;
import com.mx.kosmos.hospital.consultorio.model.Consultorio;
import com.mx.kosmos.hospital.consultorio.model.Doctor;


public interface CitaRepository extends JpaRepository<Citas, Long> {

	
    @Query(value = "SELECT c FROM Cita c WHERE c.cancelada = false AND (COALESCE(:doctor, '') = '' OR c.doctor = :doctor) AND (COALESCE(:consultorio, -1) = -1 OR c.consultorio = :consultorio) AND (COALESCE(:inicioConsulta, '') = '' OR CONVERT(DATE,c.inicioConsulta,103) = :inicioConsulta) ",nativeQuery = true)
    List<Citas> findByDoctorAndConsultorioAndFecha(String doctor, Integer consultorio, Date inicioConsulta);

    
	 @Query("SELECT c FROM Cita c WHERE c.consultorio = :consultorio AND c.inicioConsulta = :inicioConsulta AND c.cancelada = false")
	    List<Citas> findConflictosConsultorio(Consultorio consultorio, LocalDateTime inicioConsulta);

	    @Query("SELECT c FROM Cita c WHERE c.doctor = :doctor AND c.inicioConsulta = :inicioConsulta AND c.cancelada = false")
	    List<Citas> findConflictosDoctor(Doctor doctor, LocalDateTime inicioConsulta);

	    @Query("SELECT c FROM Cita c WHERE c.nombrePaciente = :nombrePaciente AND c.inicioConsulta BETWEEN :start AND :end AND c.cancelada = false")
	    List<Citas> findConflictosPaciente(String nombrePaciente, LocalDateTime start, LocalDateTime end);

	    @Query("SELECT COUNT(c) FROM Cita c WHERE c.doctor = :doctor AND DATE(c.inicioConsulta) = :fecha AND c.cancelada = false")
	    long countCitasPorDoctorYFecha(Doctor doctor, LocalDate fecha);

	    List<Citas> findByDoctorAndInicioConsultaBetween(Doctor doctor, LocalDateTime start, LocalDateTime end);


}
