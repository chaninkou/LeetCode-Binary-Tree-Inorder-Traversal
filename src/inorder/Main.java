package inorder;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {	
		BinarySearchTree tree = new BinarySearchTree();
		
		int[] input = {10,8,4,9,15,14,16};
		
		System.out.println("Input: " + Arrays.toString(input));
		
		tree.addTreeNode(input);
		
		System.out.println("Inorder Solution: ");
		
		tree.inorderTraversal();
		
		//System.out.println(tree.inorderRecursive());
	}
}
