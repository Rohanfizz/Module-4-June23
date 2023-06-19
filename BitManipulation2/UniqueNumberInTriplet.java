import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	public static boolean ithBitIsSet(int n,int i){
		return (n & (1<<i)) != 0;
	}
    public static int singleNumber(int[] nums) {
    // Your code here
		int[] freq = new int[32];
		//In the below loop, we will keep the track of freq of all the bits for every number
		//in how many numbers the ith bit is set?-> freq[i]
		for(int x: nums){
			for(int bit = 0;bit<32;bit++){
				if(ithBitIsSet(x,bit)) freq[bit]++;
			}
		}

		//Now i have to detect all the poeple where freq[i] is extra
		//or freq[i] % 3 != 0
		int ans = 0;
		for(int bit = 0;bit<32;bit++){
			if(freq[bit]%3 != 0) ans += (1<<bit); //(2^bit)
		}
		return ans;
}
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}