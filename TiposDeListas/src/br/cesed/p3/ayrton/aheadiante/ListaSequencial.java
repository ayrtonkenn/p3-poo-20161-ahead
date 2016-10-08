package br.cesed.p3.ayrton.aheadiante;

import br.cesed.p3.ayrton.aheadiante.exceptions.ItemNaoEncontradoException;

public class ListaSequencial {
	private static final int TAMANHO_LISTA = 5, CRESC_ARRAY = 2;
	/*
	 * Blz, os mï¿½tdoos
	 * Inserir elem no final e no inicio da lista
	 * Excluir elementos no inicio e final da lista
	 * Concatenar duas listas
	 * Verifica se está vazio
	 *  Nï¿½o usar set publico?
	 * 
	 */

	//private ArrayList<Integer> listaatual = new ArrayList<Integer>();
	
	Object[] listaatual = new Object[TAMANHO_LISTA];
	int posArray = 0;
	
	// concatena apenas listas das classes semelhantes 
	public void concatenate(Object[] otherlist) {
		Object[] novoArray = new Object[posArray+otherlist.length];
		int i = 0;
		while (i < posArray) {
			novoArray[i] = listaatual[i++];
		}
		while (i < otherlist.length+posArray) {
			novoArray[i] = otherlist[i++];
		}
		listaatual = novoArray;
	}
	// Mï¿½todo em polimorfismo para as classes do mesmo estilo
	 
	public void concatenate(ListaSequencial otherlist) {
		Object[] novoArray = new Object[otherlist.size()];
		for (int i = 0; i < otherlist.size(); i++) {
			novoArray[i] = otherlist.getElementIndex(i);
		}
		concatenate(otherlist);	
	}

	public void insertFinal(Object object) {
		reallocate(posArray, object, false);
	}
	public void insertStart(Object object) {
		reallocate(0, object, false);
	}
	/*
	public void removeStart() {
		reallocate(0, null, true);
	}
	public void removeFinal() {
		reallocate(posArray-1, null, true);
	}*/
	public void insertIndex(Integer item, int index) {
		reallocate(index, item, false);
	}
	public void removeByIndex(int index) {
		reallocate(index, null, true);
	}
	public Object getElementIndex(int index) {
		return listaatual[index];
	}
	
	public void remove(Object item) throws ItemNaoEncontradoException {
		int index = contains(item);
		removeByIndex(index);
	}
	
	public int contains (Object item) throws ItemNaoEncontradoException {
		Integer index = null;
		for (int i = 0; i < listaatual.length; i++) {
			// operador ternario
			if (listaatual[i].equals(item)) {
				index = i;
				break;
			} else if (listaatual[i] == null) {
				throw new ItemNaoEncontradoException();
			}
		}
		// criar excecao
		return index;
	}
	
	public int size() {
		return posArray;
	}	
	
	public Object getItem(int item) {
		return listaatual[item];
	}
	private void verifySize() {
		if (listaatual.length == posArray) {
			Object[] novoAray = new Object[listaatual.length*CRESC_ARRAY];
			for (int i = 0; i < listaatual.length; i++) {
				novoAray[i] = listaatual[i];
			}
			listaatual = novoAray;
		}
	}
	
	/*
	 * Algorï¿½timo que reposiciona os numeros do array principal, 
	 * usado para adcionar / remover os itens, e remover
	 * quando o objeto for nulo, feito para reuso do cï¿½digo
	 */
	private void reallocate(Integer index, Object item, boolean remove) {
		if (!remove) {
			verifySize();
		}
		// aumentar array caso expanda o objeto e adcione
		Object[] newArray = new Object[listaatual.length];
		int i = 0;
		// realocar elementos anteriores ao indice
		while (i < index) {
			newArray[i] = listaatual[i++];
		}
		/*
		 * Caso a operação seja para adcionar, ele adciona o objeto na posiï¿½ï¿½o desejada e
		 * realoca o resto nas outras posiï¿½ï¿½es.
		 */
		if (!remove) {
			newArray[i++] = item;
			while (i <= posArray) { //teste comentario
				newArray[i] = listaatual [i++-1];
			}
			posArray++;
		}
		/*
		 * caso contrario, ele pula a posiï¿½ï¿½o desejada e realoca os demais.
		 */
		else {
			while (i < posArray-1) {
				newArray[i] = listaatual [i++ +1];
			}
			posArray--;
		}
		listaatual = newArray;
	}
}
