import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution
{
    
    int[] solve(Job arr[], int n){
        // Your code here

		Arrays.sort(arr, (a,b)->{
			return b.profit-a.profit;
		});

		int[] days = new int[5005];

		int cnt = 0;
		int totalProfit = 0;

		for(Job j: arr){
			int deadline = j.deadline;
			int profit = j.profit;
			// while(deadline > 0 && days[deadline] != 0) deadline--;
			for(int i = deadline;i>0;i--){
				if(days[i] == 0){//i am doing no job on the ith day
					//i will do current job here
					days[i] =profit;
					cnt++;
					totalProfit+=profit;
					break;
				}
			}
		}

		int[] res = new int[2];
		res[0] = cnt;
		res[1] = totalProfit;
		return res;
		
    }
}











