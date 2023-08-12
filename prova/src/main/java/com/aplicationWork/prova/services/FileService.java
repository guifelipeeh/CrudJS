package com.aplicationWork.prova.services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aplicationWork.prova.entidades.Produtor;
import com.aplicationWork.prova.repositores.ProdutoresRepository;

@Service
public class FileService {
	private ProdutoresRepository produtoresRepository;
	@Autowired
	 public FileService(ProdutoresRepository produtoresRepository) {
	        this.produtoresRepository = produtoresRepository;
	    }

    public List<Produtor> processFile(MultipartFile file) {
        List<Produtor> produtores = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) 
           {	
            	System.out.println(line);
                Produtor produtor = parseLineToProdutor(line);
                produtoresRepository.saveAll(produtores);
                
                if(produtor != null)
                produtores.add(produtor);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Tratar o erro de alguma forma adequada, como lançar uma exceção personalizada ou retornar uma mensagem de erro.
        }

        return produtores;
    }
        private Produtor parseLineToProdutor(String line) {
           
            if (line.isEmpty())
            {
              
                return null; // Ou lança uma exceção ou retorna null, dependendo do caso
            }
           
            String numeroTransacao = line.substring(0, Math.min(1, line.length()));
            String data2 = line.substring(3, Math.min(26, line.length()));
            String descricaoProduto = line.substring(26, Math.min(56, line.length()));
            int valor = Integer.parseInt(line.substring(57, Math.min(65, line.length())).trim());
            String nomeVendedor = line.substring(66).trim();
            data2 = converterData(data2);
            int id = 0;
      
            return new Produtor(numeroTransacao, data2, descricaoProduto, valor, nomeVendedor, id);
        }
       
           public String converterData(String dataHoraString ) {
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd'T'HH:mm:ssXXX");
               ZonedDateTime zonedDateTime = ZonedDateTime.parse(dataHoraString, formatter);

               String dataHoraFormatada = zonedDateTime.format(formatter);
                return dataHoraFormatada;
            }
        }


