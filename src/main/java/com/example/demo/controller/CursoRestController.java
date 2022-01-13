package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Profesor;
import com.example.demo.service.ICursoService;

@RestController
@RequestMapping("/api")
public class CursoRestController {
	
	@Autowired
	private ICursoService cursoService;
	
	@GetMapping("/cursos")
	public ResponseEntity<?> listarCursos(){
		List<Curso> cursos = cursoService.findAll();
		if(cursos!=null && cursos.size()>0) {
			return new ResponseEntity<>(cursos, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("crear_curso")
	public ResponseEntity<?> agregarCurso(@RequestBody Curso curso){
		cursoService.saveCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping("/cursos_profesor")
	public ResponseEntity<?> cursoProfesor(@RequestBody Profesor profesor){
		List<Curso> cursos_profesor = cursoService.getCursosProfesor(profesor.getId());
		if(cursos_profesor != null && cursos_profesor.size()>0) {
			return new ResponseEntity<>(cursos_profesor, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
