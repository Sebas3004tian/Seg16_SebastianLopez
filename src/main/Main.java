package main;

import java.util.ArrayList;

import structures.Edge;
import structures.Graph;
import structures.Tree;
import structures.Vertex;

public class Main {

	public static void main(String[] args) {
		Graph<String> routes = new Graph<>();
		
		
		routes.addVertex("Libreria gadner");
		routes.addVertex("Libreria Euler");
		routes.addVertex("Libreria Konisberg");
		routes.addVertex("Libreria Voronoi");
		routes.addVertex("Libreria Gauss");
		routes.addVertex("Casita");
		routes.addVertex("Libreria Richter");
		routes.addVertex("Libreria Fibonacci");
		routes.addVertex("Libreria Fahrenheit");
		routes.addVertex("Libreria Hilbert");
		routes.addVertex("Libreria Celsius");
		
		routes.addEdge("Libreria gadner", "Libreria Euler", 415);
		routes.addEdge("Libreria gadner", "Libreria Voronoi", 170);
		routes.addEdge("Libreria gadner", "Libreria Fibonacci", 310);
		routes.addEdge("Libreria Euler","Libreria Voronoi", 317);
		routes.addEdge("Libreria Euler", "Casita", 330);
		routes.addEdge("Libreria Euler", "Libreria Gauss", 230);
		routes.addEdge("Libreria Euler", "Libreria Konisberg", 300);
		routes.addEdge("Libreria Konisberg", "Libreria Gauss", 275);
		routes.addEdge("Libreria Konisberg", "Libreria Richter", 225);
		routes.addEdge("Libreria Konisberg", "Libreria Celsius", 450);
		routes.addEdge("Libreria Celsius", "Libreria Richter", 280);
		routes.addEdge("Libreria Celsius", "Libreria Fahrenheit", 255);
		routes.addEdge("Libreria Celsius", "Libreria Hilbert", 312);
		routes.addEdge("Libreria Hilbert", "Libreria Fahrenheit", 230);
		routes.addEdge("Libreria Hilbert", "Libreria Fibonacci", 250);
		routes.addEdge("Libreria Fibonacci", "Libreria Fahrenheit", 450);
		routes.addEdge("Libreria Fibonacci", "Casita", 345);
		routes.addEdge("Libreria Fibonacci", "Libreria Voronoi", 299);
		routes.addEdge("Libreria Voronoi", "Casita", 190);
		routes.addEdge("Casita", "Libreria Gauss", 180);
		routes.addEdge("Casita", "Libreria Fahrenheit", 180);
		routes.addEdge("Libreria Gauss", "Libreria Fahrenheit", 314);
		routes.addEdge("Libreria Richter", "Libreria Gauss", 198);
		routes.addEdge("Libreria Richter", "Libreria Fahrenheit", 267);
		
		
		
		routes.initPrim(routes.search("Casita"));
		
		
		

		System.out.println("------------DISTANCIAS MINIMAS DESDE EL VERTICE ELEGIDO------------------------");
		routes.printDistancias();
		
		
		
		
		ArrayList<Edge<String>> arregloCamino= new ArrayList<Edge<String>>();
		arregloCamino=routes.getArregloCamino();
		
		ArrayList<String> camino= new ArrayList<String>();
		
		System.out.println("------------ARISTAS PARA EL ARBOL------------------------");

		for(int i=0;i<arregloCamino.size();i++) {
			System.out.println(arregloCamino.get(i).getVertex1().getValue()+"()"+arregloCamino.get(i).getWeight()+"()"+arregloCamino.get(i).getVertex2().getValue());
		}
		
		System.out.println("------------ARBOL EN PREORDER------------------------");
		
		Tree<String> arbolGeneradorMinimo = routes.getArbolGeneradorMinimo();
		ArrayList<String> preOrder = arbolGeneradorMinimo.preOrder();
		
		for(String s : preOrder) {
			System.out.println(s);
		}
	}

}
