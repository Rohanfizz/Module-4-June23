import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k){
        //Write your code here

		int ans = 0;
		int sp = 0;
		int ep = 0;

		int numZero = 0;

		while(ep<n){
			
			//introduce  new person
			if(arr[ep] == 0) numZero++; //if the person who wants to join the window is 0, he will increase the number of zeroes in my window
			
			//it is possible due to the new person the window might become invalid
			//shrink until valid
			while(numZero > k){
				if(arr[sp] == 0) numZero--;//if the person who wants to leave the window is 0, he will decrease the number of zeroes in my window
				sp++;
			}

			//if im standing on this line of code, the window is ofcourse valid
			//update the answer
			ans = Math.max(ans,ep-sp+1);//ep-sp+1 is the curr  window length

			//expand the window
			ep++;
		}
		return ans;
		
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}