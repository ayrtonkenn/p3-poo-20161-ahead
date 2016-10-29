package br.cesed.p3.poo.ayrton.tiposort;

public class Merge {
	public static int[] sort(int[] lista) {
		/*
		 * Alg de oredenação por merge
		 * Referencia:
		 * Ordena da seguinte lógica
		 * Faz a seleção do primeiro elemento, caso ele seja menor que o segundo, ele troca,
		 * e conta os que estão atrás
		 */
		if (lista.length==1) {
			return lista;
		}
		final int metade = lista.length/2;
		
		int[] lado1 = cutList(0, metade, lista), lado2 = cutList(metade, lista.length, lista);
		/*
		 * chamar a mesma fun��o por recursividade para separar os outros
		 * at� houver apenas um indice 1
		 */
		lado1 = sort(lado1); lado2 = sort(lado2);
		
		int[] retorno = conqueue(lado1, lado2, lista);
		
		return retorno;
		
	}
	
	public static int[] cutList(int indexstart, int indexfinal, int[] lista) {
		int[] retorno = new int[indexfinal-indexstart];
		for (int i = 0; i < retorno.length; i++) {
			retorno[i] = lista[i+indexstart];
		}
		return retorno;
	}
	
	private static int[] conqueue(int[] arrayA, int[] arrayB, int[] lista) {
		int posA = 0, posB = 0, posResult = 0;
		
		int[] result = new int[lista.length];
		/*
		 * comparar cada numero
		 */
		while (posA < arrayA.length && posB < arrayB.length) {
			/*
			 * fazer comparação simples para cada um, crescente
			 */
			if (arrayA[posA] > arrayB[posB]) {
				
				result[posResult] = arrayB[posB++];
				
			} else {
				result[posResult] = arrayA[posA++];
			}
		}
		/*
		 * op ternario para atribuir um valor para o estado do booleano
		 */
		result[result.length-1] = (posA > posB)?lista[posA]:arrayB[posB];
		
		int i = 0;
		while (i < posA) {
			result[i] = arrayA[i++];
		}
		while (i < posB) {
			result[i] = arrayB[i++];
		}
		return result;
	}

}
