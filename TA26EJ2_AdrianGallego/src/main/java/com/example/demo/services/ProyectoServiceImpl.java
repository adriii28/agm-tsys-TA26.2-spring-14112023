package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDAO;
import com.example.demo.dto.Proyecto;

@Service
public class ProyectoServiceImpl implements IProyectoService{

	@Autowired
	IProyectoDAO dao;
	
	@Override
	public List<Proyecto> listarProyectos() {
		return dao.findAll();
	}

	@Override
	public Proyecto listarProyectosById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Proyecto guardarNuevo(Proyecto p) {
		return dao.save(p);
	}

	@Override
	public Proyecto actualizarNuevo(Proyecto p) {
		return dao.save(p);
	}

	@Override
	public void deleteProyecto(Integer id) {
		dao.deleteById(id);		
	}

}
