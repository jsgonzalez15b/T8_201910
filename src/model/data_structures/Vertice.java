package model.data_structures;

/*
 * Clase de vertice generico, funciona como una tupla con llave id, y valor infoVertex
 */
public class Vertice <K extends Comparable<K>,A>
{

	//Atributos
	/**
	 * Id generico del vertice
	 */
	private K llaveId;

	/**
	 * Arreglo de informacion del vertice
	 */
	private Arco[] infoVertex;

	/**
	 * Tamano en uso
	 */
	private int cargaInfoVertex;

	//Constructor
	/**
	 * @param pLlave llave id del nuevo vertice
	 */
	public Vertice(K pLlave)
	{
		//el metodo agregar arco tiene un factor de carga maximo del 75%
		llaveId = pLlave;
		infoVertex = new Arco[100000];
		cargaInfoVertex = 0;
	}
	//Metodos
	
	/**
	 * retorna la llave del vertice
	 */
	public K darLlave()
	{
		return llaveId;
	}
	
	/**
	 * retorna el arreglo de arcos del vertice (lista de adyacencia)
	 */
	public A[] darArcos()
	{
		return (A[]) infoVertex;
	}
	
	/**
	 * agrega un arco a la lista de adyacencia
	 * @param pPeso Peso del nuevo Arco a crear
	 * @param pLlave Id del vertice asociado al vertive principal
	 */
	public void agregarArco(A pPeso,K pLlave)
	{
		double factorActual= cargaInfoVertex!=0?infoVertex.length/cargaInfoVertex:0;
		int hashCalculado = pLlave.hashCode()& 0x7fffffff %infoVertex.length; 
		
		if(factorActual<0.75)
		{
			//no es requerido un condicional ya que los id son unicos
			infoVertex[hashCalculado]=new Arco(pPeso,pLlave); 	
		}
		else
		{
			reHash();
			agregarArco( pPeso, pLlave);
		}
	}
	
	/**
	 * Actualiza la posicion de todos los elementos del hashTable segun su llave y el nuevo tamano
	 */
	public void	reHash()
	{
		//CAMBIAR
		Arco[] copiaHash= infoVertex; //se crea un copia con los arcos actuales
		infoVertex = new Arco[infoVertex.length*2];//se aumenta la tabla del HashTableLinear

		for ( int i = 0; i < copiaHash.length; i++)//se obtienen los nuevos indices 
		{
			if(copiaHash[i]!=null)
			{
				agregarArco((A)copiaHash[i].darPeso(),(K)copiaHash[i].darAdyacente());
			}
		} 
	}
	
	/**
	 * dado un id de un vertice conectado retorna la informacion asociada al mismo
	 * @param pId Id del vertice asociado al arco, el pId DEBE existir, en el caso contrario el metodo retorna nulo
	 */
	public A darArco(K pId)
	{
		int hashCalculado = pId.hashCode()& 0x7fffffff %infoVertex.length;
		A pArco = (A) infoVertex[hashCalculado];
		
		return pArco;
	}
}
