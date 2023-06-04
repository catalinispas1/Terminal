package terminal_v2;

public class Cd extends Graph{
	
	private String searchPath;
	
	Cd(String searchPath){
		this.searchPath = searchPath;
	}
	
	void changeDirectory() {
		if(searchPath.equals("..")) {
			if(currentFolder == 0) return;

			for(int i = 0; i < nodes.size(); i++) {
				if(matrix[i][currentFolder] == 1) {
					currentFolder = i;
					break;
				}
			}
			return;
		}
		else {
			boolean cdFound = false;
			for(int i = 0; i < nodes.size(); i++) {
				if(matrix[currentFolder][i] == 1 && searchPath.equals(nodes.get(i).getFolder())) {
					currentFolder = i;
					cdFound = true;
					break;
				}
			}
			if(!cdFound) {
				Pwd pwd = new Pwd();
				System.out.println("Cannot find path " + pwd.depthFirstSearch(0) + "\\" + searchPath + " because it does not exist.");
			}
		}
	}
	
	public String toString() {
		return "cd";
	}
}
