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
}
