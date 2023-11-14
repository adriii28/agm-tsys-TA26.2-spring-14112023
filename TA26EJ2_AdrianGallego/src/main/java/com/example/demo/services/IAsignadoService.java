package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Asignado;

public interface IAsignadoService {

	public List<Asignado> listarAsignados();
	
	public Asignado listarAsignadoById(Integer id);
	
	public Asignado guardarNuevo(Asignado a);
	
	public Asignado actualizarAsignado(Asignado a);
	
	public void deleteAsignado(Integer id);
}
