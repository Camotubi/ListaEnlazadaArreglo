package componentesLista;
public class ListaEnlazadaArreglo {
	private Integer principio = null;
	private boolean[] espacio = new boolean[100];
	private Nodo[] nodo = new Nodo[100];
	public ListaEnlazadaArreglo()
	{
		for(int i = 0; i<100;i++)
		{
			getEspacio()[i] = true;
			getNodo()[i] = new Nodo(null);
		}
		
	}
	
	public void adicionar(Object dato)
	{
		Nodo nodoEntrante = new Nodo(dato);
		Integer dirNodoActual = getPrincipio();
		Integer dirLibre = direccionLibre();
		
		if(getPrincipio() == null)
		{
			getNodo()[0] = nodoEntrante;
			setPrincipio(0);
			getEspacio()[0] = false;
		}else
		{
			
			while(getNodo()[dirNodoActual].getSiguiente()!=null )
			{
				dirNodoActual = getNodo()[dirNodoActual].getSiguiente();
				
			}
			getNodo()[dirNodoActual].setSiguiente(dirLibre);
			getNodo()[dirLibre] = nodoEntrante;
			getEspacio()[dirLibre] = false;
		}
	}
	
	public Object eliminar(Object dato)
	{
		Object retorno = null;
		Nodo nodoActual = getNodo()[getPrincipio()];
		Nodo nodoAnterior = null;
		while(!nodoActual.getDato().equals(dato))
		{
			nodoAnterior = nodoActual;
			nodoActual = getNodo()[nodoActual.getSiguiente()];
		}
		if(nodoAnterior != null)
		{
			getEspacio()[nodoAnterior.getSiguiente()] = true;
			nodoAnterior.setSiguiente(nodoActual.getSiguiente());
			getNodo()[nodoAnterior.getSiguiente()].setDato(null);
			getNodo()[nodoAnterior.getSiguiente()].setSiguiente(null);
			retorno = nodoActual.getDato();
			nodoActual = null;
			System.out.println("por aqa");
		}
		else
		{
			getEspacio()[getPrincipio()] = true;
			setPrincipio(nodoActual.getSiguiente());
			getNodo()[getPrincipio()].setDato(null);
			getNodo()[getPrincipio()].setSiguiente(null);
			System.out.println("por aqi");
			retorno = nodoActual.getDato();
			nodoActual = null;
		}

		return retorno;
	}
	public Integer eliminarYretornarDir(Object dato)
	{
		Integer retorno;
		Nodo nodoActual = getNodo()[getPrincipio()];
		Nodo nodoAnterior = null;
		while(!nodoActual.getDato().equals(dato))
		{
			nodoAnterior = nodoActual;
			nodoActual = getNodo()[nodoActual.getSiguiente()];
		}
		if(nodoAnterior != null)
		{
			Integer  dirSigdeleliminado = nodoActual.getSiguiente();
			getEspacio()[nodoAnterior.getSiguiente()] = true;
			retorno = nodoAnterior.getSiguiente();
			getNodo()[nodoAnterior.getSiguiente()].setDato(null);
			getNodo()[nodoAnterior.getSiguiente()].setSiguiente(null);
			nodoAnterior.setSiguiente(dirSigdeleliminado);
			nodoActual = null;
		}
		else
		{
			retorno = getPrincipio();
			getEspacio()[getPrincipio()] = true;
			getNodo()[getPrincipio()].setDato(null);
			setPrincipio(nodoActual.getSiguiente());
			nodoActual.setSiguiente(null);
			
			nodoActual = null;
		}
		return retorno;
		
	}
	public void eliminarPorDir(Integer dir)
	{
		Nodo nodoAnterior = nodo[principio];
		if(dir!=principio)
		{
			while(!nodoAnterior.getSiguiente().equals(dir))
			{
				nodoAnterior = nodo[nodoAnterior.getSiguiente()];
			}
			nodoAnterior.setSiguiente(nodo[dir].getSiguiente());
			espacio[dir] = true;
			nodo[dir].setSiguiente(null);
			nodo[dir].setDato(null);
		}
		else
		{
			principio = nodo[dir].getSiguiente();
			espacio[dir] = true;
			nodo[dir].setSiguiente(null);
			nodo[dir].setDato(null);
		}
		
		
	}
	public Integer direccionLibre()
	{
		Integer dirLibre = null;
		for(int i = 0; i<100 && dirLibre == null;i++)
		{
			if(getEspacio()[i]==true)
			{
				dirLibre = i;
				
			}
		}
		return dirLibre;
	}

	public Nodo[] getNodo() {
		return nodo;
	}

	public void setNodo(Nodo[] nodo) {
		this.nodo = nodo;
	}

	public Integer getPrincipio() {
		return principio;
	}

	public void setPrincipio(Integer principio) {
		this.principio = principio;
	}

	public boolean[] getEspacio() {
		return espacio;
	}

	public void setEspacio(boolean[] espacio) {
		this.espacio = espacio;
	}

}
