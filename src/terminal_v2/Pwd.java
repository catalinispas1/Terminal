package terminal_v2;

import java.util.ArrayList;

public class Pwd extends Graph{
	private ArrayList<Node> currentPath = new ArrayList<>();
	private String getPath = "";
	
	public String depthFirstSearch(int src) {
		
		boolean[] visited = new boolean [nodes.size()];
		boolean[] backTrack = new boolean[nodes.size()];
		
		dfsHelper(src, visited, backTrack);
		
		for(int i = 0; i < currentPath.size()-1; i++) {
			getPath = getPath + currentPath.get(i).getFolder() + "\\";
		}
		getPath += currentPath.get(currentPath.size()-1).getFolder();
		
		return getPath;
	}
	
	private void dfsHelper(int src, boolean[] visited, boolean[] backTrack) {		
		if(visited[src]) {
			return;
		}
		
		else {
			visited[src] = true;
		}
		
		for(int i = 0; i <= currentFolder; i++) {
			if(matrix[src][i] == 1) {
				dfsHelper(i, visited, backTrack);
			}
		}
		
		if(src == currentFolder) {
			for(int i = 0; i <= currentFolder; i++) {
				if(!backTrack[i] && visited[i]) {
					currentPath.add(nodes.get(i));
				}
			}
		}
		backTrack[src] = true;
	}
	
	public String toString() {
		return "pwd";
	}
}
