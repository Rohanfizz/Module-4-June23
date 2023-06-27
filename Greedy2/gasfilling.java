import java.util.*;

class Solution {
    
    public int filling(int gas[],int cost[],int n) {
        //Write your code here
		int  totalGas = 0;
		int totalCost = 0;
		for(int i=0;i<n;i++){
			totalGas+=gas[i];
			totalCost+=cost[i];
		}
		if(totalGas < totalCost) return -1; // Answer is not possible
		//if im standing at this line, answer does exist
		int tank = 0;
		int start = -1;

		for(int i = 0;i<n;i++){
			tank+=gas[i];
			tank-=cost[i];
			if(tank<0){
				//reset everything
				start = -1; //to forget current starting point
				tank = 0;
			}else{
				if(start == -1){
					//this means that we have not encountered any starting position
					start = i;
				}
			}
		}
		return start;
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}
