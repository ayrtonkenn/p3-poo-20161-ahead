package br.cesed.p3.poo.testejunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.cesed.p3.ayrton.aheadiante.ListaEncadeada;
import br.cesed.p3.ayrton.aheadiante.exceptions.OperacaoInvalidaException;

public class ListaEnadeadaTeste {
	
	private ListaEncadeada lista;
	private static final String[] NOMES_ALEATORIOS = {"Maria",
			"João","Jose","Joana","Fulano","Phulano","Sicrano"
	};

	@Before
	public void setUp() throws Exception {
		lista = new ListaEncadeada();
	}

	@After
	public void tearDown() throws Exception {
		lista = null;
	}

	@Test
	public void testGetSize() {
		for (int i = 1; i < 4; i++) {
			lista.addStart(NOMES_ALEATORIOS[i]);
		}
		assertEquals(3, lista.getSize());
	}

	@Test
	public void testIsEmpty() {
		assertEquals(true, lista.isEmpty());
	}

	@Test
	public void testGetNoInicio() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddStart() throws OperacaoInvalidaException {
		for (String string : NOMES_ALEATORIOS) {
			lista.addStart(string);
		}
		assertEquals(NOMES_ALEATORIOS[6], lista.getItem(0) );
		//assertTrue("igual", NOMES_ALEATORIOS[6].equals(lista.getItem(0)));
	}

	@Test
	public void testAddFinal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddIndex() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveStart() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveFinal() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveIndex() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testContains() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetItem() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testConcatenate() {
		fail("Not yet implemented"); // TODO
	}

}
