package br.cesed.p3.poo.testejunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.cesed.p3.ayrton.aheadiante.FilaSequencial;

public class FilaSequencialTeste {
	private FilaSequencial fila = new FilaSequencial();
	
	@Before
	public void setUp() throws Exception {
		fila = new FilaSequencial();
	}

	@After
	public void tearDown() throws Exception {
		fila = null;
	}
	
	public void AddTest() {
		fila.add("teste1");
	}

	@Test
	public void test() {
		fail("Not yet implemented"); // TODO
	}

}
