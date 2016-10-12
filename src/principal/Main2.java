package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Pedido.ListaPedido;

public class Main2 {
	private static final String menuPrincipal = "1.Agregar Pedido\n2.Eliminar Primer Pedido\n3.Eliminar Pedido Por ID\n4.Eliminar Primer Pedido Por Prioridad\n0.Salir\n:";
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args)  {
		int op =-1;
		ListaPedido ls = new ListaPedido();
		do
		{
			try{
			printLista(ls);
			System.out.print(menuPrincipal);
			op = Integer.parseInt(reader.readLine());
			
				switch(op)
				{
				case 1: adicionar(ls);break;
				case 2: eliminarPrimero(ls);break;
				case 3: try{eliminar(ls);}catch(Exception e){System.out.println(e.getMessage());};break;
				case 4: eliminarPorPrioridad(ls);break;
				case 5: eliminarPrimero(ls);break;
				}
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}while(op!=0);

	}
	public static void adicionar(ListaPedido ls) throws NumberFormatException, Exception
	{
		String desc = null;
		boolean goodIn = false;
		do{
			System.out.println("Inserte la descripcion:");
			try{
				desc=reader.readLine();
				goodIn = true;
			}
			catch(IOException e)
			{
				System.out.println("Problema con teclado, intente denuevo");
			}
			
		}while(!goodIn);
		goodIn = false;
		int prio = 0;
		do{
			
			System.out.println("Inserte la prioridad:");
			try{
				prio=Integer.parseInt(reader.readLine());
				goodIn = true;
			}
			
			catch(IOException e)
			{
				System.out.println("Problema con teclado, intente denuevo\n\n");
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("Inserte un numero porfavor\n\n");
			}
		}while(!goodIn);
		goodIn = false;
		int id = 0;
		do{
		System.out.println("Inserte el ID:");
		try{
			id=Integer.parseInt(reader.readLine());
			goodIn=true;
		}
		
		catch(IOException e)
		{
			System.out.println("Problema con teclado, intente denuevo\n\n");
		}
		
		catch(NumberFormatException e)
		{
			System.out.println("Inserte un numero porfavor\n\n");
		}
		}while(!goodIn);
		goodIn = false;
		ls.agregarPedido(desc,prio,id);
	}
	public static void eliminar(ListaPedido ls) throws Exception
	{
		if(ls.getListaID().getPrincipio()==null)
			throw new Exception("Lista Vacia");
		boolean goodIn = false;
		do{
			try{
				ls.HacerPedido(Integer.parseInt(reader.readLine()));
				goodIn=true;
			}
			catch(IOException e)
			{
				System.out.println("Problema con teclado, intente denuevo\n\n");
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("Inserte un numero porfavor\n\n");
			}
		}while(!goodIn);
	}
	public static void	eliminarPrimero(ListaPedido lista) throws Exception
	{
		if(lista.getListaID().getPrincipio()==null)
			throw new Exception("Lista Vacia");
		int dirPrincipio = (Integer)lista.getListaID().getPrincipio();
		int idPrincipio = (Integer)lista.getListaID().getNodo()[dirPrincipio].getDato();
		lista.HacerPedido(idPrincipio);
	
	
		
	}
	public static void eliminarPorPrioridad(ListaPedido lista) throws Exception
	{
		int prioridadMAX = 0;
		int idPrioridadMAX = 0;
		int prioridadActual = 0;
		if(lista.getListaID().getPrincipio() == null)
			throw new Exception("Lista vacia");
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
