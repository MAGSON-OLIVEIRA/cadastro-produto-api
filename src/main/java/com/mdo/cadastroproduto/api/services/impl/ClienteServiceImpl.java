package com.mdo.cadastroproduto.api.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdo.cadastroproduto.api.entities.Cliente;
import com.mdo.cadastroproduto.api.repositories.ClienteRepository;
import com.mdo.cadastroproduto.api.services.ClienteService;

@Service
public class ClienteServiceImpl  implements ClienteService {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	ClienteRepository clienteRepository;
	
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Cliente persistir(Cliente cliente) {
		log.info("salvar cliente na base ", cliente.toString());
		return this.clienteRepository.save(cliente);
	}

	@Override
	public Optional<Cliente> getClientePorEmail(String email) {
		log.info("pesquisar cliente na base ", email);
		return this.clienteRepository.findByEmail(email);
	}

	@Override
	public List<Cliente> listar() {
		List<Cliente> list = manager.createNativeQuery("SELECT * FROM cliente", Cliente.class).getResultList();
		return list;
	}
	

}
