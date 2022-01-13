package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ICursoDao;
import com.example.demo.entity.Curso;

@Service
public class CursoServiceImpl implements ICursoService{

	@Autowired
	private ICursoDao cursosDao;

	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		return (List<Curso>) cursosDao.findAll();
	}

	@Override
	@Transactional
	public void saveCurso(Curso curso) {
		cursosDao.save(curso);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Curso> getCursosProfesor(Long id) {
		return (List<Curso>) cursosDao.findByProfesorId(id);
	}
	
}
