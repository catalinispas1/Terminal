package terminal_v2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		graph.setStartingPoint();
		
		ArrayList<GraphData> commands = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		String command = "";
		
		while(true) {

			command = sc.nextLine();
			String[] commandSplit = command.split(" ");
			
			if(commandSplit[0].equals("mkdir")) {
				if(commandSplit.length == 2) {
					Mkdir mkdir = new Mkdir(commandSplit[1]);
					mkdir.createFolder();
					commands.add(mkdir);
				} else {
					System.out.println("Invalid command");
				}
			}
			
			else if(commandSplit[0].equals("cd")) {
				if(commandSplit.length == 2) {
					Cd cd = new Cd(commandSplit[1]);
					cd.changeDirectory();
					commands.add(cd);
				} else {
					System.out.println("Invalid command");
				}
			}
			
			else if(command.equals("ls")) {
				Ls ls = new Ls();
				ls.printCurrentFiles();
				commands.add(ls);
			}
			
			else if(command.equals("pwd")) {
				Pwd pwd = new Pwd();
				System.out.println(pwd.depthFirstSearch(0));
				commands.add(pwd);
			}
			
			else if(commandSplit[0].equals("touch")) {
				if(commandSplit.length == 2) {
					Touch touch = new Touch(commandSplit[1].toCharArray());
					touch.createFile();
					commands.add(touch);
				} else {
					System.out.println("Invalid command");
				}
			}
			
			else if(command.equals("history")) {
				History history = new History();
				history.printHistory(commands);
				commands.add(history);
			}
			
			else if(commandSplit[0].equals("remove")) {
				if(commandSplit.length == 2) {
					Remove remove = new Remove(commandSplit[1]);
					remove.remove();
					commands.add(remove);
				} else {
					System.out.println("Invalid command");
				}
			}
			
			else if(commandSplit[0].equals("rename")) {
				if(commandSplit.length == 3) {
					Rename rename = new Rename(commandSplit[1], commandSplit[2]);
					rename.rename();
					commands.add(rename);
				}
			}
			
			else if(command.equals("end")){
				System.out.println("Program terminated");
				break;
			}
		}
		sc.close();
	}
}


