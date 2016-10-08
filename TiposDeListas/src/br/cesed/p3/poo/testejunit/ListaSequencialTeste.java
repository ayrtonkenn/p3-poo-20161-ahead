package br.cesed.p3.poo.testejunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.cesed.p3.ayrton.aheadiante.ListaSequencial;

public class ListaSequencialTeste {
	private static final String[] NOMES_ALEATORIOS = {"Maria",
			"João","Jose","Joana","Fulano","Phulano","Sicrano"
	};
	public ListaSequencial lista;
	@Before
	public void setUp() {
		lista = new ListaSequencial();
	}
	
	@After
	public void tearDown() {
		lista = null;
	}
	@Test
	public void testInsertFinal() throws Exception{
		lista.insertFinal("Joao");
		lista.insertFinal("Maria");
		assertEquals("Maria", lista.getElementIndex(1));
	}
	
	@Test
	public void testRemoveFinal() {
		for (int i = 1; i < 3; i++) {
			lista.insertStart(NOMES_ALEATORIOS[i]);
		}
		lista.removeByIndex(1);
		assertEquals(NOMES_ALEATORIOS[2], lista.getItem(0));
		assertEquals(1, lista.size());
	}
	@Test
	public void testInsertStart() throws Exception {
		lista.insertStart("Joao");
		lista.insertStart("Maria");
		assertEquals("Maria", lista.getElementIndex(0));
	}
	public void testConcatenateArray() {
		String[] arraytest = {"Fulano", "Sicrano", "Deltrano"};
		lista.insertFinal("Joao");
		lista.insertStart("Maria");
		lista.concatenate(arraytest);
		assertEquals("Deltrano", lista.getElementIndex(4));
	}
	@Test
	public void testInsertIndex() throws Exception {
		lista.insertStart("Joao");
		lista.insertStart("Maria");
		assertEquals("Maria", lista.getElementIndex(0));
		assertEquals(2, lista.size());
	}
	@Test
	public void testOverflow() {
		for (int i = 0; i < 6; i++) {
			lista.insertStart(NOMES_ALEATORIOS[i]);
		}
		assertEquals(NOMES_ALEATORIOS[5], lista.getElementIndex(0));
	}
	@test
	public void testContains() {
		for (int i = 0; i < 5; i++) {
			lista.insertFinal(NOMES_ALEATORIOS[i]);
		}
		assertEquals(2, lista.contains(NOMES_ALEATORIOS[3]);
	}
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetOutofIndex() {
		lista.insertStart("Joao");
		lista.insertStart("Maria");
		lista.getElementIndex(20);
	}

	@Test
	public void testSize() {
		assertEquals(0, lista.size());
	}

}
