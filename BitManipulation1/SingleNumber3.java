import java.util.*;

class Solution {

	public static Boolean kthBitIsSet(int n,int k){
        // Your code here
		int mask = (1<<k);
		return (n & mask) != 0;
    }
	
    public int[] singleNumber3(int n, int[] nums) {
        // write code here
		//take the xor of all elements
		//so that i get a^b
		int xor = 0;
		for(int x: nums) xor ^= x;
		int k = 0;
		while(kthBitIsSet(xor,k) == false) k++;

		//i have to make 2 groups
		//one having kth bit set
		//second having kth bit not set
		int kthBitSet = 0;
		int kthBitNotSet = 0;
		for(int x: nums){
			if(kthBitIsSet(x,k)) kthBitSet ^= x;
			else kthBitNotSet ^= x;
		}
		int[] res = new int[2];
		res[0]  = kthBitSet;
		res[1] = kthBitNotSet;
		Arrays.sort(res);
		return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}