package structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph<T extends Comparable<T>> {
	
	private ArrayList<Vertex<T>> verticesGraph;
	private ArrayList<Edge<T>> edgeGraph;
	
	public Graph(){
		verticesGraph = new ArrayList<>();
		edgeGraph = new ArrayList<>();
	}
	
	public void addVertex(T value) {
		Vertex<T> addingVertex = new Vertex<>(value);
		if(this.search(addingVertex.getValue())==null) {
			verticesGraph.add(addingVertex);
		}
	}
	
	public void addEdge(T v1, T v2, int weight) {
		Vertex<T> vertex1 = this.search(v1);
		Vertex<T> vertex2 = this.search(v2);
		
		if(!vertex1.getAdjacencyList().contains(vertex2) && !vertex2.getAdjacencyList().contains(vertex1)) {
			Edge edge1=new Edge(vertex1,vertex2,weight);
			Edge edge2=new Edge(vertex2,vertex1,weight);
			edgeGraph.add(edge1);
			edgeGraph.add(edge2);
			vertex1.addAdjacency(vertex2, weight);
			vertex2.addAdjacency(vertex1, weight);	
		}
	}
	
	public int getWeight(Vertex<T> vertex1,Vertex<T> vertex2) {
		int weight=0;
		for(int i=0;i<edgeGraph.size();i++) {
			if(edgeGraph.get(i).getVertex1()==vertex1) {
				if(edgeGraph.get(i).getVertex2()==vertex2) {
					weight=edgeGraph.get(i).getWeight();
				}
			}
		}
		return weight;
	}
	
	public void print() {
		for(Vertex<T> v : verticesGraph) {
			System.out.println(v.getValue()+": "+v.getAdjacency());
		}
	}
	
	public void printEdges() {
		for(Edge<T> e :edgeGraph) {
			System.out.println("V1: "+e.getVertex1().getValue()+" V2: "+e.getVertex2().getValue()+" W: "+e.getWeight());
		}
		
	}
	
	public void printDistancias() {
		for(Vertex<T> v : verticesGraph) {
			System.out.println(v.getValue()+"-"+distancias.get(v));
		}
		for(int i=0;i<arregloCamino.size();i++) {
			if(distancias.get(arregloCamino.get(i).getVertex2())<arregloCamino.get(i).getWeight()) {
				arregloCamino.remove(i);
			}
		}
	}
	
	public Vertex<T> search(T value){
		boolean founded = false;
		Vertex<T> vertex = null;
		for(Vertex<T> v : verticesGraph) {
			if(v.getValue().compareTo(value)==0) {
				founded = true;
				vertex = v;
			}
		}
		if(founded) {
			return vertex;
		} else {
			return null;
		}
	}
	
	public int getSize() {
		return verticesGraph.size();
	}
	
	public Vertex<T> getElement(int i){
		return verticesGraph.get(i);
	}
	
	public ArrayList<Vertex<T>> getElements(){
		return verticesGraph;
	}
	
	
	private HashMap<Vertex<T>,Integer> distancias;
	private ArrayList<Edge<T>> arregloCamino;
	private Tree<T> arbolGeneradorMinimo;
	
	public void initPrim(Vertex<T> initial) {
		
		for(Vertex<T> v : this.getElements()) {
			v.setColor(Color.WHITE);
		}
		

		distancias=new  HashMap<Vertex<T>,Integer>();
		arregloCamino=new ArrayList<Edge<T>>();
		arbolGeneradorMinimo = new Tree<T>(new Node<T>(initial.getValue()));
		
		for(int i=0;i<verticesGraph.size();i++) {
			if(verticesGraph.get(i).equals(initial)) {
				distancias.put(verticesGraph.get(i),0);
			}else {
				distancias.put(verticesGraph.get(i),Integer.MAX_VALUE);
			}
		}
		prim(initial);
	}
	
	public void prim(Vertex<T> current) {
		for(int i=0;i<current.getAdjacencyList().size();i++) {
			Vertex<T> aux=current.getAdjacencyList().get(i);
			
			
			int distanciaActual=distancias.get(current);
			
			int weight=getWeight(current, aux);
			
			if((distanciaActual+weight)<distancias.get(aux)) {
				
				for(int j=0;j<current.getAdjacencyEdges().size();j++) {
					if(current.getAdjacencyEdges().get(j).getVertex2()==aux) {
						arregloCamino.add(current.getAdjacencyEdges().get(j));
						arbolGeneradorMinimo.find(current.getAdjacencyEdges().get(j).getVertex1().getValue()).getChildren().add(new Node<T>(current.getAdjacencyEdges().get(j).getVertex2().getValue()));
					}
				}
				
				//System.out.println(current.getValue()+"-"+aux.getValue());
				distancias.remove(aux);
				distancias.put(aux, distanciaActual+weight);
			}
		}
		current.setColor(Color.BLACK);

		Vertex<T> siguiente=null;
		for(int i=0;i<current.getAdjacencyList().size();i++) {
			if(i==0) {
				if(current.getAdjacencyList().get(i).getColor()==Color.WHITE) {
					siguiente=current.getAdjacencyList().get(i);
				}
			}else if(siguiente!=null){
				if(distancias.get(siguiente)>distancias.get(current.getAdjacencyList().get(i)) && current.getAdjacencyList().get(i).getColor()==Color.WHITE) {
					siguiente=current.getAdjacencyList().get(i);
				}
			}else {
				if(current.getAdjacencyList().get(i).getColor()==Color.WHITE) {
					siguiente=current.getAdjacencyList().get(i);
				}
			}
		}
		
		if(siguiente!=null) {
			prim(siguiente);
		}
	}

	public HashMap<Vertex<T>, Integer> getDistancias() {
		return distancias;
	}

	public void setDistancias(HashMap<Vertex<T>, Integer> distancias) {
		this.distancias = distancias;
	}

	public ArrayList<Edge<T>> getArregloCamino() {
		return arregloCamino;
	}

	public void setArregloCamino(ArrayList<Edge<T>> arregloCamino) {
		this.arregloCamino = arregloCamino;
	}
	public Tree<T> getArbolGeneradorMinimo() {
		return arbolGeneradorMinimo;
	}

	
}
