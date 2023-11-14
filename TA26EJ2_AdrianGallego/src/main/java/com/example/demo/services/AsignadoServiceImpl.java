package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAsignadoDAO;
import com.example.demo.dto.Asignado;

@Service
public class AsignadoServiceImpl implements IAsignadoService{

	@Autowired
	IAsignadoDAO dao;
	
	@Override
	public List<Asignado> listarAsignados() {
		return dao.findAll();
	}

	@Override
	public Asignado listarAsignadoById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Asignado guardarNuevo(Asignado a) {
		return dao.save(a);
	}

	@Override
	public Asignado actualizarAsignado(Asignado a) {
		return dao.save(a);
	}

	@Override
	public void deleteAsignado(Integer id) {
		dao.deleteById(id);
	}

}
