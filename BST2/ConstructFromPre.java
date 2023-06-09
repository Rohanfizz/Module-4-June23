import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
	public static int idx;
	public static TreeNode construct(int l,int r,int[] arr){
		if(idx == arr.length) return null; // no elements left
		if(arr[idx] < l || arr[idx] >r){
			//out of range
			return null;
		}
		//if i am on this line of code, this means that the arr[idx] if coming incide the range
		TreeNode nn = new TreeNode(arr[idx]);
		idx++; // idx has aready been used
		nn.left = construct(l,nn.val-1,arr);
		nn.right = construct(nn.val +1,r,arr);
		return nn;
	}
    public static TreeNode CreateTree(int n,int[] preOrder) {
        // Write Your Code here
		idx = 0;
		TreeNode root = construct(Integer.MIN_VALUE,Integer.MAX_VALUE,preOrder);
		return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}