package principal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import componentesLista.ListaEnlazadaArreglo;

public class Main {
	private static final String menuPrincipal = "1.Adicionar\n2.Eliminar\n0.Salir\n:";
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		ListaEnlazadaArreglo lista1 = new ListaEnlazadaArreglo();
		int op;
		do
		{
			printLista(lista1);
			System.out.print(menuPrincipal);
			op = Integer.parseInt(reader.readLine());
			switch(op)
			{
			case 1: adicionar(lista1);break;
			case 2: eliminar(lista1);break;
			}
		}while(op!=0);
	}
	public static void  printLista(ListaEnlazadaArreglo lista){
		ListaEnlazadaArreglo lista1 = lista;
		System.out.println("\n======================================================\nPrincipio:" + lista1.getPrincipio()+"\nDireccion\tDato\tSiguiente\tLibre");
		for(int i=0;i<10;i++)
		{
			System.out.println(i+"\t\t"+lista1.getNodo()[i].getDato()+"\t"+ lista1.getNodo()[i].getSiguiente() + "\t\t" + lista1.getEspacio()[i]);
		}
		System.out.println("======================================================");
	}
	public static void eliminar(ListaEnlazadaArreglo lista) throws IOException
	{
		System.out.println("Dato a Eliminar:");
		System.out.println(lista.eliminar(reader.readLine()));
	}
	public static void eliminarPrimero(ListaEnlazadaArreglo lista)
	{
		
	}
	public static void adicionar(ListaEnlazadaArreglo lista) throws IOException
	{
		System.out.print("Adicionar:");
		lista.adicionar(reader.readLine());
	}
}
