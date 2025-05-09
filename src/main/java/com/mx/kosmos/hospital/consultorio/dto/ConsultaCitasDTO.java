package com.mx.kosmos.hospital.consultorio.dto;

import java.util.List;

import com.mx.kosmos.hospital.consultorio.model.Citas;


public class ConsultaCitasDTO extends  RespGeneralConsultDTO{

	private List<Citas> list;

	public List<Citas> getList() {
		return list;
	}

	public void setList(List<Citas> list) {
		this.list = list;
	}
	
}
