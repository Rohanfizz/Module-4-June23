import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int cap, Item arr[], int n) {
       // Write your code here
		Arrays.sort(arr, (a,b)->{
			double pwa = 1.0*a.value/a.weight;
			double pwb = 1.0* b.value/b.weight;
			// return pwb-pwa; 10 - 5 +ve
			return pwa < pwb ? 1: -1;
		} );

		double totalProfit = 0.0;
		for(Item i: arr){
			if(cap > i.weight){//i can accomodate the whole item
				cap-=i.weight;
				totalProfit += i.value;
			}else{
				//value of 1 unit of the item
				double unitVal = 1.0*i.value/i.weight;
				totalProfit += unitVal * cap;
				cap =0;
				break;
			}
		}
	
		return totalProfit;
    }
}











