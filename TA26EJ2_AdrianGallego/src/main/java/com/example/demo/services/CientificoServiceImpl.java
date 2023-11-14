package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;

@Service
public class CientificoServiceImpl implements ICientificoService{

	@Autowired
	ICientificoDAO dao;
	
	@Override
	public List<Cientifico> listarCientificos() {
		return dao.findAll();
	}

	@Override
	public Cientifico listarCientificoById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public Cientifico guardarNuevo(Cientifico c) {
		return dao.save(c);
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico c) {
		return dao.save(c);
	}

	@Override
	public void deleteCientifico(Integer id) {
		dao.deleteById(id);
		
	}

}
