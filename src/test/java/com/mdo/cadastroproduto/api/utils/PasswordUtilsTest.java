package com.mdo.cadastroproduto.api.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mdo.cadastroproduto.api.utils.PasswordUtils;

public class PasswordUtilsTest {
	
	private static final String SENHA = "1233";
	private final BCryptPasswordEncoder bCriptEncoder = new BCryptPasswordEncoder();
	
	@Test
	public void testGerarHashSenhaNull() throws Exception {
		 assertNull(PasswordUtils.gerarBCrypt(null));

	}
	
	@Test
	public void testGerarHashSenha() throws Exception {
		String hash = PasswordUtils.gerarBCrypt(SENHA);
		assertTrue(bCriptEncoder.matches(SENHA, hash));
	}

}
