package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Profesor;
import com.example.demo.model.MProfesor;

@Component("mapper")
public class Mapper {

	public static List<MProfesor> convertirLista(List<Profesor> profesores){
		List<MProfesor> mprofesores = new ArrayList<>();
		for(Profesor profesor : profesores) {
			mprofesores.add(new MProfesor(profesor));
		}
		return mprofesores;
	}
	
}
