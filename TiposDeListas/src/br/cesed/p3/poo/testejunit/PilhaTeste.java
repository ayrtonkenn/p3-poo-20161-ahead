package br.cesed.p3.poo.testejunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.cesed.p3.ayrton.aheadiante.PilhaSequencial;
import br.cesed.p3.ayrton.aheadiante.exceptions.OperacaoInvalidaException;

public class PilhaTeste {
	private PilhaSequencial pilha;
	
	@Before
	public void setUp() throws Exception{
		// TODO Auto-generated method stub
		pilha = new PilhaSequencial();

	}
	
	@After
	public void tearDown() {
		// TODO Auto-generated method stub
		pilha = null;
	}
	@Test
	public void testePush() throws Exception {
		// TODO Auto-generated method stub
		pilha.push("teste1");
		pilha.push("teste2");
		pilha.push("teste3");
		
		assertEquals(pilha.size(), 3);
		
	}
	
	@Test
	public void testePop() throws Exception{
		pilha.push("teste1");
		pilha.push("teste2");
		pilha.push("teste3");
		pilha.pop();
		assertEquals("teste2", pilha.get(1));
	}
	@Test
	public void testePeek() throws Exception{
		pilha.push("teste1");
		pilha.push("teste2");
		pilha.push("teste3");
		Object retorno = pilha.peek();
		assertEquals("teste3", retorno);
		assertEquals(3, pilha.size());
	}
	@Test (expected=OperacaoInvalidaException.class)
	public void testePopSemNada() throws Exception {
		pilha.pop();
	}
	public void test() {
		
		
		fail("Not yet implemented");
	}

}
