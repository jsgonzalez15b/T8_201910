package model.data_structures;

import java.util.Iterator;

public class Grafo <K extends Comparable<K>,V,A> 
{
	//Atributos
	/**
	 * Numero de arcos en el grafo
	 */
	private int nArcos;

	/**
	 * Numero de vertices en el grafo
	 */
	private int nVertices;

	/**
	 * Arreglo de arcos y nodos
	 */
	private V[] arreglo; //editar

	//ver mas atributos?

	//Constructor
	public Grafo()
	{
		nArcos=0;
		nVertices=0;
		arreglo= null; //provisionalmente
	}
	
	//Metodos
	/**
	 * Numero de vertices en el grafo
	 * @return nVertices numero de vertices en el grafo
	 */
	public int V()
	{
		return nVertices;
	}
	
	/**
	 * Numero de arcos en el grafo
	 * @return nVertices numero de vertices en el grafo
	 */
	public int E()
	{
		return nArcos;
	}
	//esqueleto
	
	/**
	 * Adiciona un vertice con un Id único. El vertice tiene la informacion InfoVertex
	 */
	public void addVertex( K idVertex, V infoVertex)
	{
		
	}
	
	/**
	 * Adiciona el arco No dirigido entre el vertice IdVertexIni y el vertice IdVertexFin. El arco tiene la informacion infoArc.
	 */
	public void addEdge(K idVertexIni, K idVertexFin, A
			infoArc )
	{
		
	}
	
	/**
	 * Obtener la informacion de un vertice
	 * @return 
	 */
	public V getInfoVertex(K idVertex)
	{
		return null;
	}
	
	/**
	 * Modificar la información del vértice idVertex
	 */
	public void setInfoVertex(K idVertex, V infoVertex)
	{
		
	}
	
	/**
	 * Obtener la información de un arco
	 * @return 
	 */
	public A getInfoArc(K idVertexIni, K idVertexFin) 
	{
		return null;
	}
	
	/**
	 * Modificar la información del arco entre los vértices idVertexIni eidVertexFin
	 */
	public void setInfoArc(K idVertexIni, K idVertexFin,
			A infoArc)
	{
		
	}
	
	/**
	 * Retorna los identificadores de los vértices adyacentes a idVertex
	 */
	public Iterator<K> adj(K idVertex) 
	{
		return null;
	}

}

