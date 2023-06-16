import java.util.*;

class Solution{

	
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        // write code here
		//TC:O(n)
		//SC:O(n)
		Deque<Integer> dq = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		//first i have to consider the first window as the window
		//sizes are fixed

		for(int i = 0;i<K;i++){
			while(dq.size()>0 && arr[dq.getLast()] < arr[i]) dq.removeLast();
			dq.add(i);
		}

		ans.add(arr[dq.getFirst()]);

		int sp = 0;
		int ep = K;

		while(ep<N){
			//add To Dq
			while(dq.size()>0 && arr[dq.getLast()] < arr[ep]) dq.removeLast();
			dq.add(ep);
			//Remove extra from front
			while(dq.getFirst() <= sp) dq.removeFirst();
			//get ans for this window
			ans.add(arr[dq.getFirst()]);
			//move to next  window
			sp++;ep++;
		}
		//convert ans  arraylist to array for portal purposes
		int[] res = new int[N-K+1];
		for(int i = 0;i<res.length;i++) res[i] = ans.get(i);
		return res;
		
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
