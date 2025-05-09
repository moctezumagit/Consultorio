package com.mx.kosmos.hospital.consultorio.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mx.kosmos.hospital.consultorio.constantes.Constantes;
import com.mx.kosmos.hospital.consultorio.dto.ConsultaCitasDTO;
import com.mx.kosmos.hospital.consultorio.service.CitaService;

@Controller
@RequestMapping("/api/citas")
public class CitasController {


	@Autowired
	private CitaService citaService ;
	
	@GetMapping("/gridConsultarCitas")
	public ResponseEntity<?> getGridConsultarCitas(
			  @DateTimeFormat(pattern = "yyyy-MM-dd") Date  fecha,
              @RequestParam(required = false) Integer consultorio,
              @RequestParam(required = false) String doctor
    ) {
		ConsultaCitasDTO resp = null;	
		try {
			
			resp = citaService.obtenerCitas (fecha,consultorio,doctor);
		
			if (resp .getList() != null) {
				resp.setCodigo(Constantes.ID_RESPONSE_EXITO);
				resp.setMensaje(Constantes.MENSAJE_RESPONSE_EXITO);
			}else {
				resp.setCodigo(Constantes.ID_RESPONSE_ERROR);
				resp.setMensaje(Constantes.MENSAJE_RESPONSE_ERROR);
			}
			return ResponseEntity.ok(resp);
		}catch (Exception e){
			resp.setCodigo(Constantes.ID_RESPONSE_ERROR);
			resp.setMensaje(e.getMessage());
			resp.setCausa(""+e.getCause());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(resp);
		}
	
		
	}

}
