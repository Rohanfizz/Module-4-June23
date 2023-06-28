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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res= new  ArrayList<>();
        TreeNode  curr  = root;

        while(curr != null){
            if(curr.left == null){
                //pre
                //in
                res.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode rmn = curr.left;//i want  to search the rightmost node in my left subtree
                while(rmn.right != null && rmn.right != curr){
                    rmn = rmn.right;
                }

                if(rmn.right == null){
                    // no link is already established,
                    //this means this is the first time we are 
                    // visiting this node, hence preorder

                    //pre
                    rmn.right = curr; // establishing the link
                    curr = curr.left;
                }else{
                    //if there was already a link
                    //this means this is the second time im visiting the current node

                    //inorder
                    res.add(curr.val);
                    rmn.right = null; //demolish the link
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}

















