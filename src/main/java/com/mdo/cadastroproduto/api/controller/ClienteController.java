package com.mdo.cadastroproduto.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdo.cadastroproduto.api.dto.ClienteDto;
import com.mdo.cadastroproduto.api.entities.Cliente;
import com.mdo.cadastroproduto.api.response.Response;
import com.mdo.cadastroproduto.api.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Response<ClienteDto>> save(@Valid @RequestBody ClienteDto dto, BindingResult result) {
		Response<ClienteDto> response = new Response<ClienteDto>();
		
		validarDadosExistentes(dto, result);
		Cliente cliente = this.getClienteNovo(dto);
		if(result.hasErrors()) {
			log.info("Cadastro cliente: {}", dto.toString());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		this.clienteService.persistir(cliente);
		response.setData(getDto(cliente));
		return ResponseEntity.ok(response);
	}
	
	
	private void validarDadosExistentes(ClienteDto dto, BindingResult result) {
		this.clienteService.getClientePorEmail(dto.getEmail())
			.ifPresent(cli -> result.addError(new ObjectError("Cliente", "Cliente já existente.")));
	}

	private ClienteDto getDto(Cliente cliente) {
		ClienteDto dto = new ClienteDto();
		dto.setBairro(cliente.getBairro());
		dto.setCep(cliente.getCep());
		dto.setCidade(cliente.getCidade());
		dto.setCodigo(cliente.getId());
		dto.setEmail(cliente.getEmail());
		dto.setEstado(cliente.getEstado());
		dto.setNome(cliente.getNome());
		dto.setRua(cliente.getRua());
		return dto;
	}

	private Cliente getClienteNovo(ClienteDto dto) {
		Cliente cliente = new Cliente();
		cliente.setSenha(dto.getSenha());
		cliente.setCep(dto.getCep());
		cliente.setBairro(dto.getBairro());
		cliente.setCidade(dto.getCidade());
		cliente.setEmail(dto.getEmail());
		cliente.setEstado(dto.getEstado());
		cliente.setNome(dto.getNome());
		cliente.setRua(dto.getRua());
		return cliente;
	}

}
