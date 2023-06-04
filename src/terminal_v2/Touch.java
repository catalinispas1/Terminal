package terminal_v2;

public class Touch extends Graph{
	
	private char[] fileName;
	
	Touch(char[] fileName){
		this.fileName = fileName;
	}
	
	void createFile() {
		if(checkDublicate(String.valueOf(fileName))) return;
		
		addNode(new Node(fileName));
		folderNetwork++;
		addEdge(currentFolder, folderNetwork);
	}
	
	public String toString() {
		return "touch";
	}
}
