/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int max(TreeNode node){
		TreeNode temp = node;
		while(temp.right != null) temp = temp.right;
		return temp.val;
	}
    public TreeNode deleteNode(TreeNode node, int val){
        // WRITE YOUR CODE HERE
		if(node == null) return null;
		if(node.val < val){//the value i want to delete is in the right subtree
			node.right = deleteNode(node.right,val);
		}else if(node.val > val){//the value i want to delete is in the left subtree
			node.left = deleteNode(node.left,val);
		}else{//i am standing on the node which needs to be deleted

			if(node.left == null && node.right == null){//no children
				return null;
			}else if(node.left == null && node.right != null){
				return node.right;
			}else if(node.left != null && node.right == null){
				return node.left;
			}else{//i am having both children
				//get the left  subtrees max
				int leftMax = max(node.left); //returns the max value in left bst
				node.val = leftMax;
				node.left = deleteNode(node.left,leftMax);
			}
			
		}
		return node;
    }
}