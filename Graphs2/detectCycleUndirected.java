import java.io.*;
import java.util.*;

class Solution {

	public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int src,boolean[] vis){
		
		Queue<Integer> q = new LinkedList<>();

		q.add(src);

		while(q.size()>0){
			//remove
			int curr = q.remove();
			//mark
			if(vis[curr] == true) return true;//cycle is present
			vis[curr] = true;
			//work
			//Add Unvisited nbrs
			ArrayList<Integer> myNbrs = graph.get(curr);
			for(int nbr: myNbrs){
				if(!vis[nbr]) q.add(nbr);
			}
		}
		return false;
	}
	
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
       // Your code here
		boolean[] vis = new boolean[graph.size()];
		for(int i = 0;i<V;i++){
			if(vis[i] == true) continue;
			boolean isCompCyclic = bfs(graph,i,vis);
			if(isCompCyclic ) return true;
		}
		return false;
		
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}