package com.mdo.cadastroproduto.api.services;

import com.mdo.cadastroproduto.api.entities.Produto;

public interface EmpresaService {
	// assinatura do método para implemntação da classe que a implementar. 
	//Optional<Produto> buscarPorProduto(String produto);
	Produto persistir(Produto produto);

}
