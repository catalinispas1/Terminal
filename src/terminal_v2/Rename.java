package terminal_v2;

public class Rename extends Graph{
	private String oldName;
	private String newName;
	
	Rename(String oldName, String newName){
		this.oldName = oldName;
		this.newName = newName;
	}
	
	void rename() {
		boolean folderFound = false;
		for(int i = 0; i < nodes.size(); i++) {
			if(matrix[currentFolder][i] == 1) {
				if(nodes.get(i).getFolder() != null) {
					if(nodes.get(i).getFolder().equals(newName)) {
						System.out.println("This file have already exist in the current path");
						return;
					}
				} else {
					if(String.valueOf(nodes.get(i).getFile()).equals(newName)) {
						System.out.println("This file have already exist in the current path");
						return;
					}
				}
			}
		}
		
		for(int i = 0; i < nodes.size(); i++) {
			if(nodes.get(i).getFolder() != null) {
				if(matrix[currentFolder][i] == 1 && nodes.get(i).getFolder().equals(oldName)) {
					nodes.get(i).setFolder(newName);
					folderFound = true;
					break;
				}
			} else {
				if(matrix[currentFolder][i] == 1 && String.valueOf(nodes.get(i).getFile()).equals(oldName)) {
					nodes.get(i).setFile(newName);
					folderFound = true;
					break;
				}
			}
		}
		if(!folderFound) {
			Pwd pwd = new Pwd();
			System.out.println("Cannot change the name because the path " + pwd.depthFirstSearch(0) + "\\" + oldName + " does not exist.");
		} else System.out.println("The file was successfully renamed.");
	}
}
