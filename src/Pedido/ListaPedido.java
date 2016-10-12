package Pedido;

import componentesLista.ListaEnlazadaArreglo;

public class ListaPedido {
	private ListaEnlazadaArreglo listaDescrip = new ListaEnlazadaArreglo();
	private ListaEnlazadaArreglo listaPriori = new ListaEnlazadaArreglo();
	private ListaEnlazadaArreglo listaID = new ListaEnlazadaArreglo();
	
	public void HacerPedido(Integer b){
		Integer dirIDeliminada;
		dirIDeliminada=getListaID().eliminarYretornarDir(b);
		System.out.println(dirIDeliminada);
		getListaPriori().eliminarPorDir(dirIDeliminada);
		getListaDescrip().eliminarPorDir(dirIDeliminada);
	}
	
	public void agregarPedido(String s, Integer a, Integer b)
	{
		getListaDescrip().adicionar(s);
		getListaPriori().adicionar(a);
		getListaID().adicionar(b);
	}

	public ListaEnlazadaArreglo getListaDescrip() {
		return listaDescrip;
	}

	public void setLista1(ListaEnlazadaArreglo lista1) {
		this.listaDescrip = lista1;
	}

	public ListaEnlazadaArreglo getListaPriori() {
		return listaPriori;
	}

	public void setLista2(ListaEnlazadaArreglo lista2) {
		this.listaPriori = lista2;
	}

	public ListaEnlazadaArreglo getListaID() {
		return listaID;
	}

	public void setListaID(ListaEnlazadaArreglo listaID) {
		this.listaID = listaID;
	}

}

