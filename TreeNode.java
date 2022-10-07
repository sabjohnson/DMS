
/* *
 * 
 * the <code>TreeNode</code> class creates objects serving as nodes in a ternary tree.
 * 
 * @author Sabrina Johnson
 *    email: jsabrina949@gmail.com
 * 
 
 * */
public class TreeNode {
	
	private String label; // name of node
	private String message; // message of node being presented
	private String prompt; // prompt for children nodes
	TreeNode[] children = new TreeNode[3]; // array of children nodes (left, middle, right)
	
	/**
	 * sets the name of the node
	 * @param label is the name of the node
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * sets the message of the node
	 * @param message is the message being set for the node
	 */
	public void setMsg(String message) {
		this.message = message;
	}
	
	/**
	 * sets the prompt for the message
	 * @param prompt is the prompt for the message
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	/**
	 * sets node as the left child for a specified node
	 * @param left is the node being set as the left child
	 */
	public void setLeft(TreeNode left) {
		this.children[0] = left;
	}
	
	/**
	 * sets node as the middle child for a specified node
	 * @param middle is the node being set as the middle child
	 */
	public void setMiddle(TreeNode middle) {
		this.children[1] = middle;
	}
	
	/**
	 * sets node as the right child for a specified node
	 * @param right is the node being set as the right child
	 */
	public void setRight(TreeNode right) {
		this.children[2] = right;
	}
	
	
	/**
	 * returns the label for a node
	 * @return the label of a specified node
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * returns the message for a node
	 * @return the message of a specified node
	 */
	public String getMsg() {
		return this.message;
	}
	
	/**
	 * returns the prompt for a node
	 * @return the prompt of a specified node
	 */
	public String getPrompt() {
		return this.prompt;
	}
	
	
	/**
	 * returns the left child of a node
	 */
	public TreeNode getLeft() {
		if (this.children[0] != null)
			return this.children[0];
		return null;
	}
	
	/**
	 * returns the middle child of a node
	 * @return the middle child of a node
	 */
	public TreeNode getMiddle() {
		if (this.children[1] != null)
			return this.children[1];
		return null;
	}
	
	/**
	 * returns the right child of a node
	 * @return the right child of a node
	 */
	public TreeNode getRight() {
		if (this.children[2] != null)
			return this.children[2];
		return null;
	}
	
	/**
	 * returns an array of all children of a specified node
	 * @return  an array of all children of a specified node
	 */
	public TreeNode[] getChildren() {
		return this.children;
	}
	
	/**
	 * creates a TreeNode object with specified values (label, message, prompt)
	 * @param label is the label of the new TreeNode
	 * @param message is the message of the new TreeNode
	 * @param prompt is the prompt of the new TreeNode
	 */
	public TreeNode(String label, String message, String prompt) {
		setLabel(label);
		setMsg(message);
		setPrompt(prompt);
		
		this.children[0] = this.children[1] = this.children[2] = null;
	}
	
	/**
	 * determines if a node is a leaf (has no children)
	 * @return boolean value of if a node is a leaf (no children)
	 */
	public boolean isLeaf() {
		if (this.children[0] == null && this.children[1] == null && this.children[2] == null)
			return true;
		else
			return false;
	}
	
	
	
	/**
	 * prints a node and its descendants in pre-order traversal (used in preOrder function for tree class)
	 */
	public void preOrder() {
		System.out.println("Label: " + this.getLabel());
		System.out.println("Prompt: " + this.getPrompt());
		System.out.println("Message: " + this.getMsg());
		if (this.getLeft() != null)
			this.getLeft().preOrder();
		if (this.getMiddle() != null)
			this.getMiddle().preOrder();
		if (this.getRight() != null)
			this.getRight().preOrder();
		
	}
	

}
