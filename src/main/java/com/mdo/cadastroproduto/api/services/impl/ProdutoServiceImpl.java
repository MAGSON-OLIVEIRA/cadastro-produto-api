package com.mdo.cadastroproduto.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdo.cadastroproduto.api.controller.ClienteController;
import com.mdo.cadastroproduto.api.entities.Produto;
import com.mdo.cadastroproduto.api.repositories.ProdutoRepository;
import com.mdo.cadastroproduto.api.services.ProdutoService;

//import jdk.internal.org.jline.utils.Log;

@Service
public class ProdutoServiceImpl  implements ProdutoService {
	
	private static final Logger log = LoggerFactory.getLogger(ProdutoServiceImpl.class);
	
	@Autowired
	ProdutoRepository produtoRepository;

//	@Override
//	public Optional<Produto> buscarPorProduto(String produto) {
//		Log.info("buscar uma produto por nome {}", produto );
//		return Optional.ofNullable(produtoRepository.findByProduto(produto));
//	}

	@Override
	public Produto persistir(Produto produto) {
		log.info("salvar produto na base ", produto.toString());
		return this.produtoRepository.save(produto);
	}

}
