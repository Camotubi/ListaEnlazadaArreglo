package componentesLista;

public class Nodo {
	private Object dato;
	private Integer siguiente;
	public Nodo(Object dato)
	{
		this.dato = dato;
		siguiente = null;
	}
	public Object getDato() {
		return dato;
	}
	public void setDato(Object dato) {
		this.dato = dato;
	}
	public Integer getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Integer siguiente) {
		this.siguiente = siguiente;
	}

}
