package com.aplicationWork.prova.Config;



import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aplicationWork.prova.entidades.Produtor;
import com.aplicationWork.prova.repositores.ProdutoresRepository;

import lombok.Data;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ProdutoresRepository pRespository;

	@Override
	public void run(String... args) throws Exception {


	}
	

}
