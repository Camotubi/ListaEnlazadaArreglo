package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Pedido.ListaPedido;

public class Main2 {
	private static final String menuPrincipal = "1.Agregar Pedido\n2.Eliminar Primer Pedido\n3.Eliminar Pedido Por ID\n4.Eliminar Primer Pedido Por Prioridad\n0.Salir\n:";
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int op;
		ListaPedido ls = new ListaPedido();
		do
		{
			printLista(ls);
			System.out.print(menuPrincipal);
			op = Integer.parseInt(reader.readLine());
			switch(op)
			{
			case 1: adicionar(ls);break;
			case 2: eliminarPrimero(ls);break;
			case 3: eliminar(ls);break;
			case 4: eliminarPorPrioridad(ls);break;
			case 5: eliminarPrimero(ls);break;
			}
		}while(op!=0);

	}
	public static void adicionar(ListaPedido ls) throws IOException
	{
		ls.agregarPedido(reader.readLine(),Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine()));
	}
	public static void eliminar(ListaPedido ls) throws NumberFormatException, IOException
	{
		ls.HacerPedido(Integer.parseInt(reader.readLine()));
	}
	public static void	eliminarPrimero(ListaPedido lista)
	{
		int dirPrincipio = (Integer)lista.getListaID().getPrincipio();
		int idPrincipio = (Integer)lista.getListaID().getNodo()[dirPrincipio].getDato();
		lista.HacerPedido(idPrincipio);
	}
	public static void eliminarPorPrioridad(ListaPedido lista)
	{
		int prioridadMAX = 0;
		int idPrioridadMAX = 0;
		int prioridadActual = 0;
		for(int i = 0; i<10;i++)
		{
			if(lista.getListaPriori().getNodo()[i].getDato()!=null)
			prioridadActual = (Integer)lista.getListaPriori().getNodo()[i].getDato();
			else
			i++;
			if(prioridadActual>prioridadMAX)
			{
				
				prioridadMAX = prioridadActual;
				idPrioridadMAX = (Integer)lista.getListaID().getNodo()[i].getDato();
			}
		}
		lista.HacerPedido(idPrioridadMAX);
	}
	public static void  printLista(ListaPedido lista){
		ListaPedido lista1 = lista;
		System.out.println("\n======================================================\nPrincipio:" + lista1.getListaID().getPrincipio()+"\nDireccion\tID\tDescripccion\t\t\tPrioridad\tSiguiente\tLibre");
		for(int i=0;i<10;i++)
		{
			System.out.println(i+"\t\t"+lista1.getListaID().getNodo()[i].getDato()+"\t"+lista1.getListaDescrip().getNodo()[i].getDato()+"\t\t\t\t"+lista1.getListaPriori().getNodo()[i].getDato()+"\t\t"+ lista1.getListaID().getNodo()[i].getSiguiente() + "\t\t" + lista1.getListaID().getEspacio()[i]);
		}
		System.out.println("======================================================");
	}

}
