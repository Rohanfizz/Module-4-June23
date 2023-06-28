import java.util.*;

public class Main {

	static class Pair{
		int node;
		int wt;
		Pair(int node,int wt){
			this.node = node;
			this.wt = wt;
		}
	}
	
  static int primMST(int graph[][], int V) {
    // your code here
	  PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
			return a.wt - b.wt; 
	  });
		boolean[] vis = new boolean[V];
		int ans = 0;
		pq.add(new Pair(0,0));

	  while(pq.size() > 0){
		  Pair curr = pq.remove();

		  if(vis[curr.node]) continue;
		  vis[curr.node] = true;

		  ans+=curr.wt;

		  for(int i = 0;i<V;i++){
			  if(i == curr.node) continue;
			  if(graph[i][curr.node] != 0){
				  int nbr = i;
				  int wt = graph[i][curr.node];
				  if(!vis[nbr]) pq.add(new Pair(nbr,wt));
			  }
		  }
	  }
	  return ans;

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int vertices = sc.nextInt(), edges = sc.nextInt();
    int[][] graph = new int[vertices][vertices];
    for (int i = 0; i < edges; i++) {
      int src = sc.nextInt(), dest = sc.nextInt(), dist = sc.nextInt();
      graph[src][dest] = dist;
      graph[dest][src] = dist;
    }
    sc.close();

    System.out.println(primMST(graph, vertices));
  }
}