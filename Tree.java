  
/* *
 * 
 * the <code>Tree</code> class creates Tree objects serving as a ternary tree of depth 3 (40 nodes).
 * 
 * @author Sabrina Johnson
 *    email: jsabrina949@gmail.com
 * 
 * 
 * */
public class Tree {
	int max = 40; // is the max number of nodes in a 
	int root = 0; // the index value of root in array dont need this
	TreeNode[] tree = new TreeNode[max]; // array of TreeNodes to represent ternary tree
	
	/**
	 * creates Tree object with null values for TreeNodes
	 */
	public Tree() {
		for (TreeNode x : tree) {
			x = null;
		}
	}
	
	/**
	 * checks if array is empty (root node is null)
	 * @return the boolean value of if the array is "empty" (root is null value)
	 */
	public boolean isEmpty() {
		if (tree[root] == null)
			return true;
		else
			return false;
	}
	
	/**
	 * creates and adds new node to array of TreeNodes. searches for parent label and
	 *  adds to its children (left leaning)
	 *  
	 * @param label is the label of the new node being added
	 * @param prompt is the prompt of the new node being added
	 * @param message is the message of the new node being added
	 * @param parentLabel is the parents label to which new node will be added
	 * @return a boolean value of if the new node was successfully added
	 */
	public void addNode(String label, String prompt, String message, String parentLabel) {
		TreeNode node = new TreeNode(label, message, prompt);
		// checks if tree is empty
		if (this.isEmpty()) {
			this.tree[root] = node;
			
		} else {
			for (int i = 0; i <= max - 1; i++) {
				if (this.tree[i] != null && this.tree[i].getLabel().equals(parentLabel)) {
					if (this.tree[3*i + 1] == null) {
						this.tree[3*i + 1] = node;
						this.tree[i].setLeft(node);
						
					} else if (this.tree[3*i + 2] == null){
						this.tree[3*i + 2] = node;
						this.tree[i].setMiddle(node);
						
					} else {
						this.tree[3*i + 3] = node;
						this.tree[i].setRight(node);
						
					}
					
				}
			} // end for loop
			
		}	
	}
	
	
	
	/**
	 * prints the TreeNode array in pre-order traversal (utilizes preOrder function for TreeNode class)
	 */
	public void preOrder() {
		 tree[root].preOrder();	
	}
	
	
	
}
