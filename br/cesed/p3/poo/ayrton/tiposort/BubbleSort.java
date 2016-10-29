package br.cesed.p3.poo.ayrton.tiposort;

public class BubbleSort {
	public static int[] sort(int[] lista) {
		for (int i = lista.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (lista[j] > lista[j+1]) {
					int temp = lista[j];
					lista[j] = lista[j+1];
					lista[j+1] = temp;
		}	}	}
		
		return lista;
	}
	
}
