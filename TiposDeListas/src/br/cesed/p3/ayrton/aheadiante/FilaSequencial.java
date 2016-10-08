package br.cesed.p3.ayrton.aheadiante;

public class FilaSequencial {
	private static final int VALOR_COMECO = 5, CRESC_FILA = 2;
	private int posQueue = 0;
	
	Object[] queueatual = new Object[VALOR_COMECO];
	/*
	 * Métodos requesitos:
	 * Verificar se a fila está vazia
	 * Obter o elemento no início da fila
	 * Inserir elemento no fim da fila
	 * Remover o elemento do início da fila e o retorna
	 */

	public void enqueue(Object item) { // Enfileirar / adcionar
		Object[] novoArray;
		if (queueatual.length == posQueue) {
			novoArray = new Object[queueatual.length*CRESC_FILA];
		}
		else {
			novoArray = new Object[queueatual.length];
		}
		novoArray[0] = item;
		for (int i = 0; i < queueatual.length+1; i++) {
			novoArray[i+1] = queueatual[i];
		}
		queueatual = novoArray;
	}
	
	public Object front() {
		return queueatual[posQueue-1];
	}
	public boolean isEmpty() {
		return queueatual[0] == null;
	}
	public Object dequeue() { //remover
		Object retorno = queueatual[posQueue];
		queueatual[posQueue--] = null;
		return retorno;
	}
	
}
