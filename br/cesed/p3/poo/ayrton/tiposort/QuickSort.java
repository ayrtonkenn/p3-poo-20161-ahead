package br.cesed.p3.poo.ayrton.tiposort;

public class QuickSort {
	public static int[] sort(int[] lista, int inicio, int fim) {
		int meio = (fim-inicio)/2, i = inicio, j = fim-1, temp;
		/*
		 * percorre o array no inicio e final atraves de um pivo
		 * caso
		 */
		while (i <= j) {
			while (lista[j] < meio) {
				i++;
			}
			while (lista[j] > meio) {
				j--;
			}
			if (i <= j) {
				temp = lista[i];
				lista[i++] = lista[j];
				lista[j--] = temp;
			}
			if(inicio < j){
				sort(lista, inicio, j);
			}
			if(i < fim){
				sort(lista, i, fim);
			}
		}
		return lista;
		
	}
}
