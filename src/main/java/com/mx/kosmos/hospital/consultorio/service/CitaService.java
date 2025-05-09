package com.mx.kosmos.hospital.consultorio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.kosmos.hospital.consultorio.dto.ConsultaCitasDTO;
import com.mx.kosmos.hospital.consultorio.exception.NegocioException;
import com.mx.kosmos.hospital.consultorio.model.Citas;
import com.mx.kosmos.hospital.consultorio.repository.CitaRepository;


@Service
public class CitaService {
	
	   @Autowired
	    private CitaRepository citaRepository;
	   

	public ConsultaCitasDTO obtenerCitas(Date fecha, Integer consultorio, String doctor)throws NegocioException {
		ConsultaCitasDTO resp = new ConsultaCitasDTO();	
		if( fecha != null ) {
		 List<Citas> cita= citaRepository.findByDoctorAndConsultorioAndFecha(doctor,consultorio,fecha);
		 resp.setList(cita);
		return resp;
		}else {
			throw new NegocioException("El valor de la fecha es obligatorio, favor de seleccionar uno");
		}
	}

}
