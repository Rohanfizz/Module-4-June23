import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution {
	public class HuffmanNode{
		char data;
		int freq;
		HuffmanNode left;
		HuffmanNode right;
		HuffmanNode(char c,int f){
			this.data = c;
			this.freq = f;
			this.left = null;
			this.right = null;
		}
	}
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
		PriorityQueue<HuffmanNode> pq = new  PriorityQueue<>((a,b)->{
			if(a.freq < b.freq) return -1;
			return 1;
		});

		for(int i = 0;i<N;i++){
			char cc = S.charAt(i);
			int cf = f[i];
			pq.add(new HuffmanNode(cc,cf));
		}

		while(pq.size()>1){
			HuffmanNode a = pq.remove();
			HuffmanNode b = pq.remove();

			HuffmanNode nn= new HuffmanNode('*',a.freq + b.freq);
			nn.left = a;
			nn.right = b;
			
			pq.add(nn);
		}

		HuffmanNode root = pq.remove();

		ArrayList<String> ans  = new ArrayList<>();
		dfs(root,ans,"");
		return ans;
    }

	public void dfs(HuffmanNode node,ArrayList<String> ans,String psf){
		if(node.left== null && node.right == null){
			ans.add(psf);
			return;
		}
		dfs(node.left,ans,psf+"0");
		dfs(node.right,ans,psf+"1");
	}
    
}










