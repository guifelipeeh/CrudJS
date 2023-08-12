package com.aplicationWork.prova.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicationWork.prova.entidades.Produtor;
import com.aplicationWork.prova.services.ProdutorService;

@RestController
@RequestMapping(value = "/produtores")
public class ProdutorResources {

	@Autowired
	private ProdutorService pService;

	@GetMapping
	public ResponseEntity<List<Produtor>> findAll() {
		List<Produtor> list = pService.findAll();

		return ResponseEntity.ok().body(list);
		}
	
		
		@GetMapping(value ="/{id}")
		public ResponseEntity<Produtor> findById(@PathVariable Long id)
		{
			Produtor obj = pService.findById(id); 	
				
			return ResponseEntity.ok().body(obj);	
			}
		


}
