package br.cesed.p3.ayrton.aheadiante;

import java.util.Stack;

import br.cesed.p3.ayrton.aheadiante.exceptions.OperacaoInvalidaException;

public class PilhaSequencial {
	/*
	 *  Empilhar - Push D
	 *  desempilhar - Pop
	 *   Obter o elemento do topo sem removê-lo - Peek
	 *    Informar tamanho da pilha
	 *    Informar se a pilha está vazia
	 */
	
	private static final int VALOR_COMECO = 5;
	private static final int CRESC_PILHA = 2;
	private int posStack = 0;
	
	Object[] pilhaatual = new Object[VALOR_COMECO];
	
	public void push(Object item) {
		if (pilhaatual.length == posStack) {
			Object[] novoAray = new Object[pilhaatual.length*CRESC_PILHA];
			for (int i = 0; i < pilhaatual.length; i++) {
				novoAray[i] = pilhaatual[i];
			}
			pilhaatual = novoAray;
		}
		pilhaatual[posStack++] = item;
	}
	
	public Object pop() throws OperacaoInvalidaException {
		if (posStack == 0) {
			throw new OperacaoInvalidaException();
		}
		Object saida = pilhaatual[posStack];
		pilhaatual[posStack--] = null;
		return saida;
	}
	
	public Object peek() {
		return pilhaatual[posStack-1];
	}
	public int size() {
		return posStack;
	}
	
	public Object get(int index) throws OperacaoInvalidaException {
		if (index >= posStack) {
			throw new OperacaoInvalidaException();
		}
		return pilhaatual[index];
	}
	public boolean isEmpty() {
		// se o primeiro elemento da pilha for vazio, a pilha é vazia por dedução
		return pilhaatual[0] == null;
	}
	
	/* Método anulado
	 * public boolean isFull() {
		return pilhaatual[posStack] != null;
	}*/
}
