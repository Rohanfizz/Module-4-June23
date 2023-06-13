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
		int cs = 0;
		int ce = 0;
		int os = -1;
		int oe = -1;

		for(int i =0;i<n;i++){
			long newTrain = arr[i];
			long  prevTrain = train + arr[i];

			if(newTrain > prevTrain){
				cs = i;
				train = newTrain;
			}else{
				train = prevTrain;
			}

			if(train > maxi){
				maxi = train;
				os = cs;
				oe = ce;
			}

			
		}
		System.out.println(os+" "+oe);
		return maxi;
		
    }
}

// 2 -3 4 5 -10 2 6 8 -4 3 2 -1 2 -7 3










