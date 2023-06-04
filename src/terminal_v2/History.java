package terminal_v2;

import java.util.ArrayList;

public class History extends Graph{
	
	void printHistory(ArrayList <GraphData> commands) {
		for(GraphData commandsList: commands) {
			System.out.println(commandsList);
		}
	}
	
	public String toString() {
		return "history";
	}
}
