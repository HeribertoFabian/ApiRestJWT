package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ILenguajeDao;
import com.example.demo.entity.Lenguaje;

@Service
public class LenguajeServiceImpl implements ILenguajeService {
	
	@Autowired
	private ILenguajeDao lenguajeDao;

	@Override
	@Transactional(readOnly = true)
	public List<Lenguaje> findAll() {
		return (List<Lenguaje>) lenguajeDao.findAll();
	}

	@Override
	@Transactional
	public void saveLenguaje(Lenguaje lenguaje) {
		lenguajeDao.save(lenguaje);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Lenguaje findLenguajeById(Long id) {
		return lenguajeDao.findByIdSQL(id);
	}
	
	

}
