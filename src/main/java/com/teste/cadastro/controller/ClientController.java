package com.teste.cadastro.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teste.cadastro.model.Cliente;
import com.teste.cadastro.repository.ClienteRepository;

import utils.Validador;

@RequestMapping("/")
@Controller
public class ClientController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@CrossOrigin
	@PostMapping(value = "/reg", consumes = "application/json", produces = "application/json")
	public ResponseEntity<HashMap<String, String>> CreateRegistry(@RequestBody Cliente cliente) {
		HashMap<String, String> aceito = Validador.IsValido(cliente);
		if (aceito.get("valido")=="1") {
			clienteRepository.save(cliente);	
	}
	
	
	return new ResponseEntity<>(aceito, HttpStatus.OK);
	}
}