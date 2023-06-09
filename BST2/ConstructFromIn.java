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

    public TreeNode construct(int[] arr,int l,int r){
        if(l > r) return null; // the range is invalid

        //decide the mid index
        int midIdx = (l+r)/2;
        //construct new  node
        TreeNode nn = new TreeNode(arr[midIdx]);
        nn.left = construct(arr , l , midIdx-1 );
        nn.right = construct(arr, midIdx+1 , r );
        return nn;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = construct(nums, 0 ,nums.length-1);
        return root;
    }
}








