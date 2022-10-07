
import java.io.BufferedReader;
/* *
 * 
 * the <code>TreeDriver</code> class allows for user input to upload/create a tree, traverse a tree,
 * and go through a trees option one by one.
 * <Note> program worked when text file was placed in DecisionMakingSystem folder but outside the src file folder
 * 
 * @author Sabrina Johnson
 *    email: sabrina.a.johnson@stonybrook.edu
 *    Stony Brook ID: 114416302
 *    Recitation: 30
 * 
 * 
 * */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* *
 * 
 * the <code>TreeDriver</code> class allows users to load tree from a file, progress through "help session"
 * 
 * @author Sabrina Johnson
 *    email: jsabrina949@gmail.com
 * 
 * 
 * */
public class TreeDriver {

	/**
	 * function prints menu of options
	 */
	public static void menu() {
		System.out.println("L) Load a tree. ");
		System.out.println("B) Begin a help session. ");
		System.out.println("T) Traverse the tree in preorder. ");
		System.out.println("Q) Quit. ");
	}
	
	/**
	 * main method
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		menu();
		BufferedReader objReader = new BufferedReader(new FileReader("hw5Sample.txt"));
		Tree tree = new Tree(); // tree object that will be used
		String line; // will be wtv line we are currently reading
		String option; // the choice of action for ternary tree
		Scanner scan = new Scanner(System.in);
		System.out.println("Choice> ");
		option = scan.next();
		
		do {
			switch(option.toUpperCase()) {
			
			case "L":
				
				while ((line = objReader.readLine()) != null) {

					String[] input = new String[2]; // index 0 is parent and index 1 is number of children
					input = line.trim().split(" ");
					
					String parent = input[0];
					int numofchildren = Integer.parseInt(input[1]);
					
					
					for (int i = 0; i < numofchildren; i++) {
						String l = objReader.readLine().trim();
						String m = objReader.readLine().trim();
						String p = objReader.readLine().trim();
						tree.addNode(l, p, m, parent);
					}
				}
				
				
				menu();
				System.out.println("Choice> ");
				option = scan.next();
				break;
	
				
			case "B":
				
				if (tree.isEmpty())
					System.out.println("tree empty, add node to begin");
				else {
					
					System.out.println("If you desire to leave the help service, choose option 0.\n");
					
					int parent = 0;
					int leftChild = 3 * parent + 1;
					int middleChild = 3 * parent + 2;
					int rightChild = 3 * parent + 3;
					int ans = -1;
					
					do {
						// prints prompts and possible options
						System.out.println(tree.tree[parent].getPrompt());
						
						if(tree.tree[leftChild] != null)
							System.out.println("option 1: " + tree.tree[leftChild].getMsg());
						if(tree.tree[middleChild] != null)
							System.out.println("option 2: " + tree.tree[middleChild].getMsg());
						if(tree.tree[rightChild] != null)
							System.out.println("option 3: " + tree.tree[rightChild].getMsg());
						System.out.println("select option> ");
						ans = scan.nextInt();
						
						switch(ans) {
						case 1:
							parent = leftChild;
							leftChild = 3 * parent + 1;
							middleChild = 3 * parent + 2;
							rightChild = 3 * parent + 3;
							break;
							
						case 2:
							parent = middleChild;
							leftChild = 3 * parent + 1;
							middleChild = 3 * parent + 2;
							rightChild = 3 * parent + 3;
							break;
							
						case 3:
							parent = rightChild;
							leftChild = 3 * parent + 1;
							middleChild = 3 * parent + 2;
							rightChild = 3 * parent + 3;
							break;
							
						case 0:
							System.out.println("Thank you for using our automated help services!");
							System.out.println("exitting...");
							break;
							
						default:
							System.out.println("invalid entry, try again\n");
							break;
						}
						
					} while (ans != 0 && !tree.tree[parent].isLeaf()); // might take out start is leaf part
					
					System.out.println(tree.tree[parent].getPrompt());
					System.out.println("Help session finished.\n");
				}
				
				menu();
				System.out.println("Choice> ");
				option = scan.next();
				break;
				
				
			case "T":
				tree.preOrder();
				System.out.println();
				
				menu();
				System.out.println("Choice> ");
				option = scan.next();
				break;
				
			case "Q":
				//System.out.println("Quitting...");
				break;
				
			default:
				System.out.println("Invalid option, try again. ");
				
				menu();
				System.out.println("Choice> ");
				option = scan.next();
				break;
			}
			
		} while (option.toUpperCase() != "Q");

	}

}
