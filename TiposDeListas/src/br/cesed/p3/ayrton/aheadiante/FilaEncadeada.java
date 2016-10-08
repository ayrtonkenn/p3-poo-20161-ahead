package br.cesed.p3.ayrton.aheadiante;

public class FilaEncadeada {
	private No inicio = null;
	private int size = 0;
	
	public void enqueue(Object item) {
		No novo = new No(item);
		if (isEmpty()) {
			inicio = novo;
		}
		novo.setProximo(inicio);
		inicio = novo;
	}
	
	public boolean isEmpty() {
		return inicio==null;
	}
}