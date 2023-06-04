package terminal_v2;

public class Graph extends GraphData{
	
	public void setStartingPoint() {
		nodes.add(new Node("C:\\"));
		System.out.println(nodes.get(folderNetwork).getFolder());
	}
	
	public void addNode(Node node) {
		if(size == capacity - 1) {
			grow();
		}
		size++;
		nodes.add(node);
	}
	
	public void addEdge(int src, int dst) {
		matrix[src][dst] = 1;
	}
	
	public void print() {
		for(Node node : nodes) {
			System.out.print(node.getFolder() + " ");
		}
	}
	
	private void grow() {
		int newCapacity = (int) (capacity * 1.5);
		int[][] newMatrix = new int[newCapacity][newCapacity];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		capacity = newCapacity;
		matrix = newMatrix;
	}
	
	
	void printMatrix() {
		for(int i = 0; i < nodes.size() ; i++) {
			for(int j = 0; j < nodes.size(); j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean checkDublicate(String file) {
		for(Node node: nodes) {
			if(node.getFile() != null) {
				if(String.valueOf(node.getFile()).equals(file)) {
					System.out.println("This file is already in the current path");
					return true;
				}
			} else {
				if(node.getFolder().equals(file)) {
					System.out.println("This file is already in the current path");
					return true;
				}
			}
		}
		return false;
	}
}
