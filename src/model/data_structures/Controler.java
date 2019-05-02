package Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;

import VO.verticeInfo;
import View.View;
import model.data_structures.Grafo;
import model.data_structures.Vertice;

public class Controler {

	private Grafo<Integer, Double[], Double> grafo; 
	private View view; 
	public Controler() {
		view= new View(); 
		grafo=new Grafo<>(); 
	}
	
	public void run() {
		Scanner sc= new Scanner(System.in);
		boolean fin=false; 
		while(!fin) {
			view.printMenu();
			int option=sc.nextInt();
			switch(option) {
			case 1: 
				System.out.println("Ingrese 1 si desea cargar el archico: Washington... ");
				System.out.println("Ingrese 2 si desea cargar el archivo: map.xml");
				int archivo=sc.nextInt(); 
				cargarDatos(archivo); 
			}
		}
	}
	
	
	
	
	public int[] cargarDatos(int num) {
		int[] retornar=new int[2]; 
		String file=num==1?"Central-WashingtonDC-OpenStreetMap":"map.xml";
		try {
		SAXParserFactory saxparserfactory= SAXParserFactory.newInstance(); 
		SAXParser SaxParser=saxparserfactory.newSAXParser();
		File f=new File("."+File.separator+"data"+File.separator+file); 
		Handler handler=new Handler(); 
		SaxParser.parse(f, handler);
		ArrayList<Vertice<verticeInfo,Integer,Integer>> arreglo=handler.getVertices();
		System.out.println(arreglo.size()+"");
		}catch(Exception e) {
			System.out.println("Ocurrio un problema leyendo los datos");
		}
		
		return retornar; 
	}
}
