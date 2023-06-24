import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	   
        int n=sc.nextInt(); 
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            arr.add(x);
        }
        
        Solution ob=new Solution();
        System.out.println(ob.candies(arr,n));
        
	}
}


class Solution {
    public int candies(ArrayList<Integer> A,int n) {
        //Write code here
		int[] l2r = new int[n];
		int[] r2l = new  int[n];
		int total = 0;

		//left to right
		for(int i = 0;i<n;i++){
			if(i == 0) l2r[i] = 1;
			else{
				if(A.get(i-1) >= A.get(i)) l2r[i] = 1;
				else l2r[i] = l2r[i-1] + 1;
			}
		}
		//right to left
		for(int i = n-1;i>=0;i--){
			if(i == n-1) r2l[i] = 1;
			else{
				if(A.get(i+1) >= A.get(i)) r2l[i] = 1;
				else r2l[i] = r2l[i+1] + 1;
			}
		}

		for(int i = 0;i<n;i++){
			total+= Math.max(l2r[i] , r2l[i]);
		}
		return total;
	
    }
}









