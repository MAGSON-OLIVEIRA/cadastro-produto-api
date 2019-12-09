//package com.mdo.cadastroproduto.api.repositories;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.mdo.cadastroproduto.api.entities.Produto;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles("test")
//public class ProdutoRepositoryTest {
//	@Autowired
//	private ProdutoRepository produtoRepository;
//	
//	@Before
//	public void setUp() throws Exception{
//		Produto produto = new Produto();
//		produto.setProduto("novoProduto");
//		produto.setDescricao("novo");
//		produto.setFoto("");	
//		produto.setQuantidade(1);
//		produto.setPreco(2.0);
//		this.produtoRepository.save(produto);
//	}
//	
//	@After
//	public final void tearDown() {
//		this.produtoRepository.deleteAll();
//	}
//	
//	@Test
//	public void testBusca() {
//		List<Produto> produto = this.produtoRepository.findAll();
//		assertEquals("novoProduto", produto.get(0).getProduto());
//	}
//	
//}
