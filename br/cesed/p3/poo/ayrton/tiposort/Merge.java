package br.cesed.p3.poo.ayrton.tiposort;

public class Merge {
	public static int[] sort(int[] lista) {
		/*
		 * Alg de oredenação por merge
		 * Referencia:
		 * Ele começa dividindo o array ao meio, em várias camadas,
		 * chamando por recursividade até o tamaho deles for de um elemento.
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
		while (arrayA.length > posA && arrayB.length > posB) {
			/*
			 * fazer comparação simples para cada um, crescente
			 */
			/*if (arrayA[posA] < arrayB[posB]) {
				
				result[posResult++] = arrayA[posA++];
				//posB++;
				
			} else {
				result[posResult++] = arrayB[posB++];
				//posA++;
			}*/
			result[posResult++] = (arrayA[posA] < arrayB[posB])?arrayA[posA++]:arrayB[posB++];
		}
		/*
		 * Parte de compara��o caso todos os numeros
		 * menores estejam concentrados em um array, o que implica
		 * em numeros que faltam ser ordeados em uma parte
		 */
		while (posA < arrayA.length) {
			result[posResult++] = arrayA[posA++];
		}
		while (posB < arrayB.length) {
			result[posResult++] = arrayB[posB++];
		}
		
		return result;
	}

}
