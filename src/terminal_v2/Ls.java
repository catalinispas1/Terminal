package terminal_v2;

public class Ls extends Graph{
	
	void printCurrentFiles() {
		int printHeader = 0;

		for(int i = 0; i < nodes.size(); i++) {
			if(matrix[currentFolder] [i] == 1) {
				if(nodes.get(i).getFolder() != null) {
					printHeader++;
					if(printHeader == 1) System.out.println("Mode\t  " + "Name");
					System.out.println("d-----\t  " + nodes.get(i).getFolder());
				}
				else {
					printHeader++;
					if(printHeader == 1) System.out.println("Mode\t  " + "Name");
					System.out.println("-a----\t  " + String.valueOf(nodes.get(i).getFile()));
				}
			}
		}
		if(printHeader == 0) System.out.println("The folder is empty");
	}
	
	public String toString() {
		return "ls";
	}
}
