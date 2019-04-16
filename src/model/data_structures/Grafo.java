package model.data_structures;

public class Grafo <V extends Comparable<V>> 
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
    arreglo= new V[3]; //provisionalmente
	}
}
