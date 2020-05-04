package com.mdo.cadastroproduto.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdo.cadastroproduto.api.entities.Cliente;
import com.mdo.cadastroproduto.api.services.ClienteService;

@RestController
@RequestMapping("/api/list")
@CrossOrigin(origins = "*")
public class ClienteListController {
	private static final Logger log = LoggerFactory.getLogger(ClienteListController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> list() {

		return this.clienteService.listar();

	}
	
	

}
