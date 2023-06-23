import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

	void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] path,int src,ArrayList<Integer> psf){
		//mark
		path[src] = true;
		psf.add(src);
		int totalVtx = graph.size()-1;
		if(psf.size() == totalVtx){
			//i have detected an hamiltonian path
			System.out.print(psf);

			
			int start =psf.get(0);

			for(int nbr: graph.get(src)){
				if(nbr == start){
					System.out.print("( Cycle Found )");
					break;
				}
			}
			
			path[src] = false;
			psf.remove(psf.size()-1);
			System.out.println();
			return;
		}

		for(int nbr: graph.get(src)){
			if(!path[nbr]) dfs(graph,path,nbr,psf);
		}

		path[src] = false;
		psf.remove(psf.size()-1);
		
	}
	
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		//insert N+1 empty arraylists bcs 1 based indexing
		for(int i = 0;i<=N;i++) graph.add(new ArrayList<>());

		for(ArrayList<Integer> edge: Edges){
			int u = edge.get(0);
			int v = edge.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		boolean[] path = new boolean[N+1];


		for(int i = 1;i<=N;i++){
			ArrayList<Integer> psf  = new ArrayList<>();
			dfs(graph,path,i,psf);
		}
	    return false;//dummy
    }
}









