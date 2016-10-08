package br.cesed.p3.ayrton.aheadiante;

public class DequeSequencial {
	private static final int DEQUE_COMECO = 5, CRESC_DEQUE = 2, POS_COMECO = 1;
	private int posDequeStart, posDequeFinal = POS_COMECO;
	/*
	 * 
	 */
	Object[] dequeatual = new Object[DEQUE_COMECO];
	public Object getFirst() {
		return dequeatual[posDequeStart];
	}
	public Object getLast() {
		return dequeatual[posDequeFinal];
	}
	public void addStart(Object item) {
		verifySize(false);
		dequeatual[posDequeStart--] = item;
	}
	public void addFinal(Object item) {
		verifySize(true);
		dequeatual[posDequeFinal++] = item;
	}
	public void removeStart() {
		dequeatual[posDequeStart++] = null;
	}
	public void removeFinal() {
		dequeatual[posDequeStart--] = null;
	}
	public int size() {
		return posDequeFinal - posDequeStart;
	}
	public void concatenate(DequeSequencial otherdeque) {
		Object[] novoArray = new Object[size()+otherdeque.size()];
		Object[] otherArray = otherdeque.getDequeatual();
		int i = 0;
		while (i < size()) {
			novoArray[i] = dequeatual[i++];
		}
		while (i < otherdeque.size()+size()) {
			novoArray[i] = otherArray[i++];
		}
		dequeatual = novoArray;
	}
	protected Object[] getDequeatual() {
		return dequeatual;
	}
	private void verifySize(boolean side) {
		Object[] novoDeque;
		// true - direita, false - esquerda
		if (side) {
			if( dequeatual.length == posDequeFinal) {
				Object[] novoArray = new Object[dequeatual.length*CRESC_DEQUE];
				for (int i = 0; i < dequeatual.length; i++) {
					novoArray[i] = dequeatual[i];
				}
			}
		else {
			int crescimento = dequeatual.length*CRESC_DEQUE;
				novoDeque = new Object[crescimento];
				for (int i = 0; i < dequeatual.length; i++) {
					novoDeque[i+crescimento] = dequeatual[i];
				}
			}
		}
	}
}
