import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int arr[],int n){
        //Write code here
		//TC o(N)
		//sc o(1)
		long train = 0;
		long maxi = Integer.MIN_VALUE;
		
		for(int i = 0;i<n;i++){
			long newTrain = arr[i];//only ith person will be sitting in this
			long prevTrain = train + arr[i];//prev people + me
			//i would take forward the best out of both possibilities
			train = Math.max( newTrain , prevTrain);

			//i have to find max sum subrray
			//i will take the max of all trains, that will give me mss
			maxi = Math.max(train,maxi);
		}
		return maxi;
    }
}

// 2 -3 4 5 -10 2 6 8 -4 3 2 -1 2 -7 3










