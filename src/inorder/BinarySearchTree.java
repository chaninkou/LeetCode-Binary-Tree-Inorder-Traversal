package inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
	TreeNode root;
	
	public void inorderTraversal(){
		List<Integer> result = new ArrayList<Integer>();
		
		inorderTraversal(root, result);
		
		System.out.println(result);
	 }
	
	// Using iteratively way 
    public List<Integer> inorderTraversal(TreeNode root, List<Integer> result){
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode current = root;
        
        // The loop will not end until stack is empty, it stack is not empty, that means its on the bottom left node
        while(current != null || !stack.empty()){
            // Add all the left node to the stack
            while(current != null){
                stack.add(current);
                current = current.left;
            }
            
            // current will be whatever on the top of the stack, which is the lastest node that was visited
            current = stack.pop();
            
            // If it gets here, that means its the left most node, then middle node, then right node
            result.add(current.val);
            
            // Check the right node now, if current is null, then it will just pop the stack
            current = current.right;
        }
        
        return result;
    }
    
    // Recursive way, pretty fast.
     public List<Integer> inorderRecursive(){
         List<Integer> result = new ArrayList<>();
         
         if(root != null){
             inorder(root, result);
         }
         
         return result;
     }
    
	private void inorder(TreeNode node, List<Integer> result) {
		// Check the left side first
		if(node.left != null){
			inorder(node.left, result);
		}
		
		// Add the current node, if there is not left child, add the current node
		result.add(node.val);
		
		// Then check the right child node
		if(node.right != null){
			inorder(node.right, result);
		}
	}

	public void addTreeNode(int[] values) {
		TreeNode nodeToAdd;
		
		for(int value : values){
			nodeToAdd= new TreeNode(value);
			
			if(root == null){
				root = nodeToAdd;
			}
			
			traverseAndAddNode(root, nodeToAdd);
		}

	}
	
	public void traverseAndAddNode(TreeNode root, TreeNode nodeToAdd){		
		if(nodeToAdd.val < root.val){
			if(root.left == null){
				root.left = nodeToAdd;
			} else {
				traverseAndAddNode(root.left,nodeToAdd);
			}
		} else if (nodeToAdd.val > root.val){
			if(root.right == null){
				root.right = nodeToAdd;
			} else {
				traverseAndAddNode(root.right, nodeToAdd);
			}
		}
	}

}
