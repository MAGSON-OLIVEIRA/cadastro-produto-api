package com.mdo.cadastroproduto.api.services;

import java.util.List;
import java.util.Optional;

import com.mdo.cadastroproduto.api.entities.Cliente;

public interface ClienteService {
	Cliente persistir(Cliente cliente);
	Optional<Cliente> getClientePorEmail(String email);
	List<Cliente> listar();
}
