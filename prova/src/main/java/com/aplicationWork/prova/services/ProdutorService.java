package com.aplicationWork.prova.services;
import com.aplicationWork.prova.entidades.Produtor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicationWork.prova.repositores.ProdutoresRepository;


@Service
public class ProdutorService{
	@Autowired
	private ProdutoresRepository Prepository;
	
	public List<Produtor>findAll(){
		
		return Prepository.findAll();
	}
	public Produtor findById(long id) {
		
		Optional<Produtor> obj =Prepository.findById(id);
		return obj.get();
	}
}
