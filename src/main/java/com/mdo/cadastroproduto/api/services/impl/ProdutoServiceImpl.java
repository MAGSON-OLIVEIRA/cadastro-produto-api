package com.mdo.cadastroproduto.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdo.cadastroproduto.api.entities.Produto;
import com.mdo.cadastroproduto.api.repositories.ProdutoRepository;
import com.mdo.cadastroproduto.api.services.EmpresaService;

import jdk.internal.org.jline.utils.Log;

@Service
public class ProdutoServiceImpl  implements EmpresaService {
	
	@Autowired
	ProdutoRepository produtoRepository;

	@Override
	public Optional<Produto> buscarPorProduto(String produto) {
		Log.info("buscar uma produto por nome {}", produto );
		return Optional.ofNullable(produtoRepository.findByProduto(produto));
	}

	@Override
	public Produto persistir(Produto produto) {
		Log.info("salvar empresa na base ", produto.toString());
		return this.produtoRepository.save(produto);
	}

}
