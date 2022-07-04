package br.com.claro.ControllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.claro.Controller.ContatosController;
import br.com.claro.Model.Contatos;
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class ContatosControllerTest {
	
	@Autowired
	
	private ContatosController contatosControl;
	/***
	 * Testa verificando se os dados estão corretos voltando ok
	 */
	@Test
	public void findByEmailTest() {
		Contatos contato =  contatosControl.findByEmail("anderson.cesar@testeclaro.com.br");
		assertEquals("Anderson Cesar Dias", contato.getNome());
		assertEquals("19999725028", contato.getTelefone());
		assertEquals("13348590", contato.getCep());
		assertEquals("Rua Frederico Fortunato Blollo", contato.getEndereco());
		assertEquals("Indaiatuba", contato.getCidade());
		assertEquals("SP", contato.getUf());
		assertEquals("2022-07-02 00:00:00.0", String.valueOf(contato.getDh_cadastro()));
	}
	/***
	 * Testa verificando se os dados estão corretos voltando erro
	 * por faltar parte do nome "Cesar"
	 */
	@Test
	public void findByEmailTestError() {
		Contatos contato =  contatosControl.findByEmail("anderson.cesar@testeclaro.com.br");
		assertEquals("Anderson  Dias", contato.getNome());
		assertEquals("19999725028", contato.getTelefone());
		assertEquals("13348590", contato.getCep());
		assertEquals("Rua Frederico Fortunato Blollo", contato.getEndereco());
		assertEquals("Indaiatuba", contato.getCidade());
		assertEquals("SP", contato.getUf());
		assertEquals("2022-07-02 00:00:00.0", String.valueOf(contato.getDh_cadastro()));
	}
	
	@Test
	public void deletarContatosTest(){
		contatosControl.deletarContatos("anderson.cesar@testeclaro.com.br");
		
		
	}
}
