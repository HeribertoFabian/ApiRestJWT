package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Lenguaje;
import com.example.demo.entity.Profesor;
import com.example.demo.model.ProfesorLenguaje;
import com.example.demo.service.ILenguajeService;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorLenguajeRestController {

	@Autowired
	private ILenguajeService lenguajeService;
	
	@Autowired
	private IProfesorService profesorService;
	
	@PostMapping("/lenguajes_profesor")
	public ResponseEntity<?> listaLenguajesProfesor(@RequestBody Profesor profesor){
		Profesor profesorDB = profesorService.findById(profesor.getId());
		if(profesorDB != null) {
			Collection<Lenguaje> listaLenguajes = profesorDB.getLenguajes();
			if(listaLenguajes != null) {
				return new ResponseEntity<>(listaLenguajes, HttpStatus.OK);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping("/save_lenguaje_profesor")
	public ResponseEntity<?> saveLenguajeProfesor(@RequestBody ProfesorLenguaje profesorLenguaje){
		Profesor profesorDb = profesorService.findById(profesorLenguaje.getProfesor().getId());
		if(profesorDb != null) {
			Lenguaje lenguajeDB = lenguajeService.findLenguajeById(profesorLenguaje.getLenguaje().getId());
			if(lenguajeDB != null) {
				profesorDb.addLenguaje(lenguajeDB);
				profesorService.save(profesorDb);
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
}
