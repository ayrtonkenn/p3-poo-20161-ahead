package br.cesed.p3.ayrton.aheadiante;

import br.cesed.p3.ayrton.aheadiante.exceptions.ItemNaoEncontradoException;
import br.cesed.p3.ayrton.aheadiante.exceptions.OperacaoInvalidaException;

public class ListaEncadeada{
	// tipo simples, s� com referencia ao inicio

	/*
	 * Sobre listas encadeadas
	 * Elementos conectados por meio de refer�ncias da classe N�
	 * Sem javadoc por enquanto
	 */
	private No inicio = null;
	private int size = 0;
	
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return inicio == null;
	}
	protected No getNoInicio() {
		return inicio;
	}
	
	public void addStart(Object item) {
		No novo = new No(item);
		if (inicio == null) {
			inicio = novo;
		} else {
			No temp = inicio;
			novo.setProximo(temp);
			inicio = novo;
		}
		size++;
	}

	public void addFinal(Object item) {
		// nova instancia criada, novo n�, com o objeto
		No novo = new No(item);
		
		if (inicio == null) {
			inicio = novo;
		}
		else {
			No temp = inicio.getProximo();
			// encontrar �ltima instancia da lista
			while (temp.getProximo()!=null) {
				temp = temp.getProximo();
			}
			// encontrado, agora basta realocar o novo n�.
			temp.setProximo(novo);
		}
		size++;
	}
	
	public void addIndex(Object item, int index) throws Exception {
		No novo = new No(item);
		if (isEmpty()) {
			inicio = novo;
		}
		else {
			No temp = inicio.getProximo(), anterior = inicio;
			// encontrar �ltima instancia da lista
			int i = 0;
			while (i < index) {
				if (temp.getProximo() == null) {
					throw new OperacaoInvalidaException();
				}
				anterior = temp;
				temp = temp.getProximo();
				i++;
			}
			// encontrado, agora basta realocar o novo n�.
			novo.setProximo(temp);
			anterior.setProximo(novo);
		}
		size++;
	}

	public void removeStart() throws OperacaoInvalidaException {
		if (isEmpty()) {
			throw new OperacaoInvalidaException();
		}
		No temp = inicio.getProximo();
		inicio = temp;
		size--;
	}
	public void removeFinal() throws OperacaoInvalidaException {
		// para fins de reuso, j� que usa praticamente o mesmo codigo
		removeIndex(size-1);
	}
	public void removeIndex(int index) throws OperacaoInvalidaException {
		/*
		 * contador - �ndice representado na busca
		 * Sele��o - N� que � buscado e contado pelo contador
		 * anterior - N� anteiror ao que � buscado em sele��o
		 */
		if (index > size) {
			throw new OperacaoInvalidaException();
		} 
		No anterior = inicio, selecao=inicio.getProximo();
		int contador = 0;
		while (index > contador) {
			/*if (selecao.getProximo() == null) {
				throw new OperacaoInvalidaException();
			}*/
			anterior = selecao;
			selecao = selecao.getProximo();
			contador++;
		}
		anterior.setProximo(selecao.getProximo());
		size--;
	}
	public int contains(Object item) throws ItemNaoEncontradoException {
		No temp = inicio;
		int index = 0;
		boolean notFound = false;
		while (notFound) {
			if (item.equals(temp.getItem())) {
				break;
			} else {
				if (temp.getProximo() == null) {
					throw new ItemNaoEncontradoException();
				}
				else {
					temp = temp.getProximo();
					index++;
				}
			}
		}
		return index;
	}
	public Object getItem(int index) throws OperacaoInvalidaException {
		if (index > size) {
			throw new OperacaoInvalidaException();
		}
		No temp = inicio;
		/*
		 * L�gica: Pegar a referencia da classe caso o index seja 0
		 * sen�o usar um contador do 1 at� que atinja o indice desejado
		 */
		if (index != 0) {
			int i = 1;
			while (i <= index) {
				temp = temp.getProximo();
				i++;
			}
		}
		return temp.getItem();
	}
	public void remove(Object item) throws ItemNaoEncontradoException, OperacaoInvalidaException {
		int index = contains(item);
		this.removeIndex(index);
		// problema com exception desnecess�rio?
	}
	// Concatenar arrays ou outras listas encadeadas?
	
	public void concatenate(ListaEncadeada otherlist) {
		int size = otherlist.getSize();
		/*
		 * L�gica: Posiciona a busca do n� na cauda (final) e p�e o n� que vem da outra lista
		 * no pr�ximo do atual, concatenando as duas
		 */
		No temp = inicio;
		while (temp.getProximo()!= null) {
			temp = temp.getProximo();
		}
		temp.setProximo(otherlist.getNoInicio());
		this.size += size;
	}
}
