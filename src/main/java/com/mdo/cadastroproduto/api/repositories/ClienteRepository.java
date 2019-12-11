package com.mdo.cadastroproduto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdo.cadastroproduto.api.entities.Cliente;

@Transactional(readOnly = true)
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Transactional(readOnly = true)
	Optional<Cliente> findByEmail(String email);
}

