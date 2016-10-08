package br.cesed.p3.ayrton.aheadiante;

import br.cesed.p3.ayrton.aheadiante.exceptions.OperacaoInvalidaException;

public class PilhaEncadeada {
	private No finalnum = null;
	private int size;
	/*
	 * ao contrário dos outros, o nó do começo é o final da pilha, o nó
	 * do próximo, na cauda, é o começo, para melhor desempenho.
	 */
	public void add(Object item) {
		No novo = new No(item);
		if (finalnum == null) {
			finalnum = novo;
		} else {
			No temp = finalnum;
			novo.setProximo(temp);
			finalnum = temp;
		}
		size++;
	}
	public Object pop() throws OperacaoInvalidaException {
		if (finalnum == null ) {
			throw new OperacaoInvalidaException();
		}
		No pop = finalnum, temp = finalnum.getProximo();
		finalnum = temp;
		size--;
		return pop.getItem();
	}
	public Object peek() {
		return finalnum.getItem();
	}
	
	protected int size() {
		return size;
	}
	public boolean isEmpty() {
		return finalnum == null;
	}
	
}
