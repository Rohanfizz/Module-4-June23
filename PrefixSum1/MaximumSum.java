import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] A, int[][] ops) {
		int md = 1000000007;
	    int[] pref = new  int[A.length];
		for(int[] op:ops){
			int sp = op[0];
			int ep = op[1];

			pref[sp]+=1;
			if(ep<A.length-1) pref[ep+1]-=1;
		}
		//take prefix sum
		for(int i = 1;i<A.length;i++){
			pref[i] = (pref[i] + pref[i-1])%md;
		}
		
		Arrays.sort(pref);
		Arrays.sort(A);
		int ans = 0;
		for(int i = 0;i<A.length;i++){
			ans = (ans + (A[i] * pref[i])%md)%md;
		}
		return ans%md;
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



