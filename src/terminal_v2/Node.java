package terminal_v2;

public class Node {
	private String folder;
	private char[] file;
	
	Node(String folder){
		this.folder = folder;
	}
	
	Node(char[] file){
		this.file = file;
	}
	
	public String getFolder() {
		return folder;
	}
	
	public char[] getFile() {
		return file;
	}
	
	public void setFolder(String folder) {
		this.folder = folder;
	}
	
	public void setFile(String file) {
		this.file = file.toCharArray();
	}
}
