package br.cesed.p3.poo.ayrton.tiposort;

public class SelectionSort {
	public static int[] sort(int[] lista, int pivo) {
		int inicio, fim, i = 0, temp;
		while (i < lista.length) {
			if (lista[pivo]<lista[i]) {
				temp = lista[i];
				lista[i] = lista[pivo];
				lista[pivo] = temp;
			} else {

			}
		}
		
	}
	
	private static int[] name() {
	}
}
