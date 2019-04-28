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
	private Vertice[] arreglo; 

	

	//Constructor
	public Grafo()
	{
		nArcos=0;
		nVertices=0;
		arreglo= new Vertice[100000]; //implementacion de factor de carga 0.75
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
	 * Adiciona un vertice con un Id unico. El vertice tiene la informacion InfoVertex
	 */
	public void addVertex( K idVertex, V infoVertex) //PREGUNTAR SEGUNDO PARAMETRO
	{
		double factorActual= nVertices/arreglo.length;
		int hashCalculado = idVertex.hashCode()& 0x7fffffff %arreglo.length; 
		
		if(factorActual<0.75)
		{
			if(arreglo[hashCalculado]!=null)//no es requerido un else ya que los id son unicos
			{
				arreglo[hashCalculado]=new Vertice(idVertex);
				nVertices++;
			}
		}
		else
		{
			reHashGrafo();
			addVertex( idVertex, infoVertex);
		}
	}
	
	/**
	 * Actualiza la posicion de todos los elementos del hashTable segun su llave y el nuevo tamano
	 */
	public void	reHashGrafo()
	{
		Vertice[] copiaHash= arreglo; //se crea un copia con los vertices actuales
		arreglo = new Vertice[arreglo.length*2];//se aumenta la tabla del HashTableLinear

		for ( int i = 0; i < copiaHash.length; i++)//se obtienen los nuevos indices 
		{
			if(copiaHash[i]!=null)
			{
				addVertex((K)copiaHash[i].darLlave(),(V)copiaHash[i].darArcos());
			}
		} 
	}
	/**
	 * Adiciona el arco No dirigido entre el vertice IdVertexIni y el vertice IdVertexFin. El arco tiene la informacion infoArc.
	 */
	public void addEdge(K idVertexIni, K idVertexFin, A infoArc )
	{
		int hashCalculado1 = idVertexIni.hashCode()& 0x7fffffff %arreglo.length; 
		int hashCalculado2 = idVertexFin.hashCode()& 0x7fffffff %arreglo.length; 
		
		//necesariamente ambos vertices deben existir? PREGUNTAR
		if(arreglo[hashCalculado1]!=null && arreglo[hashCalculado2]!=null)
		{
			arreglo[hashCalculado1].agregarArco(infoArc, idVertexFin); //se agrega el peso del arco y el vertice Fin como conexion al primero
			arreglo[hashCalculado2].agregarArco(infoArc, idVertexIni); //se agrega el peso del arco y el vertice Ini como conexion al segundo
		}
//		if(arreglo[hashCalculado1]==null || arreglo[hashCalculado2]==null) ASK XD
//		{
//			//se crean los vertices que no han sido creados
//			if(arreglo[hashCalculado1]==null)
//			{
//				arreglo[hashCalculado1]= new Vertice( idVertexIni);
//			}
//			if(arreglo[hashCalculado2]==null)
//			{
//				arreglo[hashCalculado2]= new Vertice( idVertexFin);
//			}
//			
//			arreglo[hashCalculado1].agregarArco(infoArc, idVertexFin); //se agrega el peso del arco y el vertice Fin como conexion al primero
//			arreglo[hashCalculado2].agregarArco(infoArc, idVertexIni); //se agrega el peso del arco y el vertice Ini como conexion al segundo
//		}
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
	 * Modificar la informacion del vertice idVertex
	 */
	public void setInfoVertex(K idVertex, V infoVertex)
	{
		
	}
	
	/**
	 * Obtener la informacion de un arco
	 * @return 
	 */
	public A getInfoArc(K idVertexIni, K idVertexFin) 
	{
		return null;
	}
	
	/**
	 * Modificar la informacion del arco entre los vertices idVertexIni eidVertexFin
	 */
	public void setInfoArc(K idVertexIni, K idVertexFin,
			A infoArc)
	{
		
	}
	
	/**
	 * Retorna los identificadores de los vÃ©rtices adyacentes a idVertex
	 */
	public Iterator<K> adj(K idVertex) 
	{
		return null;
	}

}

