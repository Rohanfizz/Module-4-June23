import java.util.*;

class Solution {
	
	public class Pair{
		int node;
		int color; //color == 1, blue, color == -1 = red
		Pair(int node,int color){
			this.node = node;
			this.color = color;
		}
	}
	
    public int possibleBipartition(int n, int[][] dislikes) {
        // Write your code here
		ArrayList<ArrayList<Integer>> graph  = new  ArrayList<>();

		for(int i = 0;i<=n;i++){
			//this loop will run n+1 times because 1 based  indexing
			graph.add(new ArrayList<Integer>());
		}

		for(int[] edge: dislikes){
			int u = edge[0];
			int v = edge[1];

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		int[] vis = new int[n+1];
		Queue<Pair> q = new LinkedList<>();
		for(int i = 1;i<=n;i++){
			if(vis[i] != 0) continue;
			q.add(new Pair(i,1));
			
			while(q.size()>0){
				//remove
				Pair curr = q.remove();
				int node = curr.node;
				int color = curr.color;
				//mark
				if(vis[node] != 0) continue;
				vis[node] = color;
				//work
				//add nbr
				int oppColor = (color == 1 ? -1 : 1);
				for(int nbr: graph.get(node)){
					if(vis[nbr] == 0) q.add(new Pair(nbr,oppColor));
					else if(vis[nbr] == oppColor) continue;
					else if(vis[nbr] == color) return 0;
				}
			}
		}
		
		return 1;
		
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}