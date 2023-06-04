package terminal_v2;

public class Mkdir extends Graph {
	private String folderName;
	
	Mkdir(String folderName){
		this.folderName = folderName;
	}
	
	void createFolder() {
		if(checkDublicate(folderName)) return;
		
		addNode(new Node(folderName));
		folderNetwork++;
		addEdge(currentFolder, folderNetwork);
		printMatrix();
	}
	
	public String toString() {
		return "mkdir";
	}
}
