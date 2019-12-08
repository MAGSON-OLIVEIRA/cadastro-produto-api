package com.mdo.cadastroproduto.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mdo.cadastroproduto.api.entities.Produto;

@Transactional(readOnly = true)
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	// transactional ajunda na perfomace  quando for consulta. Nao bloqueia o banco de dado 
	@Transactional(readOnly = true)
	Produto findByProduto(String produto);
}

