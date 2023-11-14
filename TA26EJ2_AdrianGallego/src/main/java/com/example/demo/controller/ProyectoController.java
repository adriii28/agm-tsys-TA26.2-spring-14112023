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

import com.example.demo.dto.Proyecto;
import com.example.demo.services.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	
	@Autowired
	ProyectoServiceImpl pSer;
	
	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectos(){
		return pSer.listarProyectos();
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto listarProyectoById(@PathVariable(name="id") Integer id) {
		return pSer.listarProyectosById(id);	
	}
	
	@PostMapping("/proyectos")
	public Proyecto guardarProyecto(@RequestBody Proyecto p) {
		return pSer.guardarNuevo(p);
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id") Integer id, @RequestBody Proyecto p) {
		Proyecto p1 = pSer.listarProyectosById(id);
		Proyecto p2 = new Proyecto();
		
		p1.setId_proyecto(p.getId_proyecto());
		p1.setHoras(p.getHoras());
		p1.setNombre(p.getNombre());
		
		p2 = pSer.actualizarNuevo(p1);
		
		return p2;
	}
	
	@DeleteMapping("/proyectos/{id}")
	public void deleteProyecto(@PathVariable(name="id") Integer id) {
		pSer.deleteProyecto(id);
	}

}
