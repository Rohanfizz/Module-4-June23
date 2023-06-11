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

    boolean validate(TreeNode node,long l,long r){
        if(node== null) return true;
        if(node.val < l || node.val > r) return false;
        boolean left = validate(node.left,l,(long)node.val-1);
        boolean right = validate(node.right,(long)node.val+1,r);
        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}