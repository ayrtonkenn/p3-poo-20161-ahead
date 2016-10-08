package br.cesed.p3.ayrton.aheadiante;

public class NoDuplo {
	private NoDuplo proximo;
	private NoDuplo anterior;
	private Object item;
	
	public NoDuplo() {
		// TODO Auto-generated constructor stub
	}
	public NoDuplo(Object item) {
		this.item = item;
	}
	public NoDuplo getProximo() {
		return proximo;
	}
	public void setProximo(NoDuplo proximo) {
		this.proximo = proximo;
	}
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	public NoDuplo getAnterior() {
		return anterior;
	}
	public void setAnterior(NoDuplo anterior) {
		this.anterior = anterior;
	}
	
	

}
