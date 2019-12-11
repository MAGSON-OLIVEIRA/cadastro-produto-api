package com.mdo.cadastroproduto.api.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.mdo.cadastroproduto.api.entities.Produto;
import com.mdo.cadastroproduto.api.repositories.ProdutoRepository;
import com.mdo.cadastroproduto.api.services.ProdutoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProdutoServiceTest {
	@MockBean
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Before
	public void setUp() throws Exception{
		BDDMockito.given(this.produtoRepository.save(Mockito.any(Produto.class))).willReturn(new Produto());
		Produto produto = new Produto();
		produto.setProduto("novoProduto");
		produto.setDescricao("novo");
		produto.setFoto("");	
		produto.setQuantidade(1);
		produto.setPreco(2.0);
		this.produtoRepository.save(produto);
	}
	
	@Test
	public final void tearDown() {
		Produto produto = this.produtoService.persistir(new Produto());
		assertNotNull(produto);
	}

	
}
