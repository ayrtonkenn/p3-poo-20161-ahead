package br.cesed.p3.ayrton.aheadiante;

public class No {
	private No proximo;
	private Object item;
	
	public No() {
		// TODO Auto-generated constructor stub
	}
	public No(Object item) {
		this.item = item;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	
	

}
