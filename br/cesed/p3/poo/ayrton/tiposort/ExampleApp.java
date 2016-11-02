package br.cesed.p3.poo.ayrton.tiposort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExampleApp {
	private static int[] getTextTxt(String in) throws IOException{
		InputStream aux = new FileInputStream(in);
	    InputStreamReader aux2 = new InputStreamReader(aux);
	    BufferedReader aux3 = new BufferedReader(aux2);
	    String text = aux3.readLine();
	    String[] array = text.split(" ");
	    int[] array2 = new int[array.length];
	    for (int i = 0; i < array.length; i++){
	    	array2[i] = Integer.parseInt(array[i]);
	    }
	    return array2;
	}
	public static void main(String[] args) {
		
		try {
			
			int[] lista = getTextTxt("\textoztesteEntrada.txt");
			int[] ordembubble = BubbleSort.sort(lista);
			int[] ordemmerge = Merge.sort(lista);
			int[] ordemquick = QuickSort.sort(lista, 0, lista.length);
			for (int i : ordemquick) {
				System.out.print(i + ' ' );
			}
			for (int i : ordemmerge) {
				System.out.print(i + ' ');
			}
			for (int i : ordembubble) {
				System.out.println(i + ' ');
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
	}
	
	
}

