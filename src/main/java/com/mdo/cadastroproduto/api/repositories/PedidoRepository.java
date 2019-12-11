package com.mdo.cadastroproduto.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdo.cadastroproduto.api.entities.Pedido;

@Transactional(readOnly = true)
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}

