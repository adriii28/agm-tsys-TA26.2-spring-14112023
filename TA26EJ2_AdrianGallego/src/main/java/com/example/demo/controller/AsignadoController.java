package com.example.demo.controller;

import java.sql.PseudoColumnUsage;
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

import com.example.demo.dto.Asignado;
import com.example.demo.services.AsignadoServiceImpl;

@RestController
@RequestMapping("/api")
public class AsignadoController {
	
	@Autowired
	AsignadoServiceImpl aSer;
	
	@GetMapping("/asignado")
	public List<Asignado> listarAsignados(){
		return aSer.listarAsignados();
	}
	
	@GetMapping("/asignado/{id}")
	public Asignado listarAsignadoById(@PathVariable(name="id") Integer id) {
		return aSer.listarAsignadoById(id);
	}
	
	@PostMapping("/asignado")
	public Asignado guardarAsignado(@RequestBody Asignado a) {
		return aSer.guardarNuevo(a);
	}
	
	@PutMapping("/asignado/{id}")
	public Asignado actualizarAsignado(@PathVariable(name="id") Integer id, @RequestBody Asignado a) {
		Asignado a1 = aSer.listarAsignadoById(id);
		Asignado a2 = new Asignado();
		
		a1.setId(a.getId());
		a1.setCientifico(a.getCientifico());
		a1.setProyecto(a.getProyecto());
		
		a2 = aSer.actualizarAsignado(a1);
		return a1;
	}
	
	@DeleteMapping("/asignado/{id}")
	public void deleteAsignado(@PathVariable(name="id") Integer id) {
		aSer.deleteAsignado(id);
	}
}
