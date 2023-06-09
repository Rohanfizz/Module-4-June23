import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {

	class Pair{
		Node parent;
		int l;
		int r;
		Pair(Node parent, int l,int r){
			this.parent = parent;
			this.l = l;
			this.r = r;
		}
	}
	
    Node bstFromLevel(int arr[], int n) {
        // write code here
		Queue<Pair> q = new  LinkedList<>();

		Node root = new  Node(arr[0]);
		q.add(new Pair(root,Integer.MIN_VALUE,root.data-1));//platform for left child of root
		q.add(new Pair(root, root.data+1 , Integer.MAX_VALUE )); // platform for right child of root

		int idx = 1;

		while(q.size() > 0){
			Pair curr = q.remove();
			
			if(idx == arr.length){
				//no more people are remaining
				continue;
			}
			//check range
			if(arr[idx] < curr.l || arr[idx]>curr.r){
				//out of range and i cannot sit on this platform
				continue;
			}
			//if im here, this means that i can sit on this platform
			Node nn = new Node(arr[idx]);

			//check from the curr.parent, if  im left child or the right 
			if(nn.data < curr.parent.data) curr.parent.left = nn;
			else curr.parent.right = nn;

			idx++;

			//add my platforms as i can also be a potential parent  in the future
			q.add( new Pair(nn, curr.l, nn.data-1));//left child platform
			q.add(new Pair(nn, nn.data + 1,curr.r));//right child platform
		}
		return root;
		
    }
}