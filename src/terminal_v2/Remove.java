package terminal_v2;

public class Remove extends Graph{
	private String removeFile;
	
	Remove(String removeFile) {
		this.removeFile = removeFile;
	}
	
	private int deleteAppeals;
	private boolean folderFound;
	
	void remove() {
		for(int i = 0; i < nodes.size(); i++) {
			if(matrix[currentFolder][i] == 1 ) {
				if(nodes.get(i).getFolder() != null) {
					if(nodes.get(i).getFolder().equals(removeFile)) {
						searchFolderToDelete(i);
						if(deleteAppeals > 1) System.out.println("The file with all the components has been deleted");
						else System.out.println("The file has been deleted");
						folderFound = true;
						break;
					}
				} else {
					if(String.valueOf(nodes.get(i).getFile()).equals(removeFile)){
						delete(i);
						System.out.println("The file has been deleted");
						folderFound = true;
						break;
					}
				}
			}
		}
		if(!folderFound) {
			Pwd pwd = new Pwd();
			System.out.println("The folder with the path: " + pwd.depthFirstSearch(0) + "\\" + removeFile + " does not exist");
		}
	}
		  
	private void searchFolderToDelete(int src) {
		for(int i = 0; i < nodes.size(); i++) {
			if(matrix[src][i] == 1) {
				searchFolderToDelete(i);
			}
		}
		delete(src);
	}
	
	private void delete(int index) {
		if(size == capacity / 3 && capacity > 10) shrink();
		deleteAppeals++;
		int borderColumns = 0;
		int borderLines = 0;
		
		for(int i = 0; i < nodes.size(); i++) {
			for(int j = 0; j < nodes.size(); j++) {
				if(index == j) borderColumns = 1;
				if(index == i) borderLines = 1;
				matrix[i][j] = matrix[i + borderLines][j + borderColumns];
			}
			borderColumns = 0;
		}
		
		size--;
		folderNetwork--;
		nodes.remove(index);
	}
	
	private void shrink() {
		int newCapacity = capacity / 2;
		int[][] newMatrix = new int [newCapacity][newCapacity];
		for(int i = 0; i < nodes.size(); i++) {
			for(int j = 0; j < nodes.size(); j++) {
				newMatrix[i][j] = matrix[i][j];
			}
		}
		capacity = newCapacity;
		matrix = newMatrix;
	}
}
