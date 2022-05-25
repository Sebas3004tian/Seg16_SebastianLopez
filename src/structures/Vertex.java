package structures;

import java.util.ArrayList;

public class Vertex<T> {
	T value;
	Color color;
	Vertex<T> dad;

	ArrayList<Vertex<T>> adjacencyList;

	private ArrayList<Edge<T>> adjacencyEdges;
	
	int d;//tiempo de descubrimiento
	int f;//tiempo de finali
	
	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public Vertex(T value) {
		this.value = value;
		this.dad = null;
		this.adjacencyList = new ArrayList<>();
		this.adjacencyEdges = new ArrayList<>();
	}
	
	public void addAdjacency(Vertex<T> vertex, int weight) {
		this.adjacencyList.add(vertex);
		adjacencyEdges.add(new Edge(new Vertex(getValue()),vertex,weight));
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

	public Vertex<T> getDad() {
		return dad;
	}

	public void setDad(Vertex<T> dad) {
		this.dad = dad;
	}

	public ArrayList<Vertex<T>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(ArrayList<Vertex<T>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	public String getAdjacency() {
		String adjacency = "";
		for(Vertex<T> v : adjacencyList) {
			adjacency+=v.getValue()+" ";
		}
		return adjacency;
	}

	public ArrayList<Edge<T>> getAdjacencyEdges() {
		return adjacencyEdges;
	}

	public void setAdjacencyEdges(ArrayList<Edge<T>> adjacencyEdges) {
		this.adjacencyEdges = adjacencyEdges;
	}
	
	
	
		
}
