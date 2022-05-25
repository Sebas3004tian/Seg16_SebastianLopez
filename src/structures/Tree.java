package structures;

import java.util.ArrayList;

public class Tree<T> {
	private Node<T> root;
	
	public Tree(Node<T> node) {
		this.root = node;
	}
	
	public Node<T> find(T searchingValue) {
		return find(root, searchingValue);
	}
	
	public Node<T> find(Node<T> node, T searchingValue) {
		if(node == null) {
			return null;
		}
		
		if(node.getValue().equals(searchingValue)) {
			return node;
		}
		
		Node<T> cNode = null;
		
		for(Node<T> child : node.getChildren()) {
			cNode = find(child,searchingValue);
			if(cNode != null) {
				return cNode;
			}
		}
		return null;
	}
	
	public ArrayList<T> preOrder(){
		return preOrder(root);
	}
	
	public ArrayList<T> preOrder(Node<T> root){
		ArrayList<T> res = new ArrayList<T>();
		
		if(root == null) {
			return res;
		}
		
		preOrderHelper(root,res);
		
		return res;
	}
	
	public void preOrderHelper(Node<T> node, ArrayList<T> res){
		if(node == null) {
			return;
		}
		
		res.add(node.getValue());
		
		for(Node<T> cNode : node.getChildren()) {
			preOrderHelper(cNode,res);
		}
	}
		
    
}
