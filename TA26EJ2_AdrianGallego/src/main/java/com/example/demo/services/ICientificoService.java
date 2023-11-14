package com.example.demo.services;

import java.util.List;
import com.example.demo.dto.Cientifico;

public interface ICientificoService {
	
	public List<Cientifico> listarCientificos();
	
	public Cientifico listarCientificoById(Integer id);
	
	public Cientifico guardarNuevo(Cientifico c); 

	public Cientifico actualizarCientifico(Cientifico c); 
	
	public void deleteCientifico(Integer id);

}
