package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cientifico;
import com.example.demo.services.CientificoServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificoController {
	
	@Autowired
	CientificoServiceImpl cSer;
	
	@GetMapping("/cientificos")
	public List<Cientifico> listarCientificos(){
		return cSer.listarCientificos();
	}
	
	@GetMapping("/cientificos/{id}")
	public Cientifico listarCientificoById(@PathVariable(name="id") Integer id) {
		return cSer.listarCientificoById(id);
	}
	
	@PostMapping("/cientificos")
	public Cientifico guardarNuevo(@RequestBody Cientifico c) {
		return cSer.guardarNuevo(c);
	}
	
	@PutMapping("/cientificos/{id}")
	public Cientifico actualizarCientifico(@PathVariable(name="id") Integer id, @RequestBody Cientifico c) {
		Cientifico c1 = cSer.listarCientificoById(id);
		Cientifico c2 = new Cientifico();
		
		c1.setId_cientifico(c.getId_cientifico());
		c1.setDni(c.getDni());
		c1.setNom_apels(c.getNom_apels());
		
		c2 = cSer.actualizarCientifico(c1);
		
		return c2;
	}

	@DeleteMapping("/cientificos/{id}")
	public void deleteCientifico(@PathVariable(name="id") Integer id) {
		cSer.deleteCientifico(id);
	}
}
