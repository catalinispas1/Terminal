package terminal_v2;

import java.util.ArrayList;

public abstract class GraphData {
	
	static int size = 1;
	static int capacity = 10;
	static int[][] matrix = new int[capacity][capacity];
	
	static ArrayList<Node> nodes = new ArrayList<>();
	
	static int currentFolder = 0;
	static int folderNetwork = 0;
}
