import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        int[] ans = s.bestProducts(arr);
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }
    }
}

class Solution {
    public static int[] bestProducts(int[][] arr) {
       // Write your code
		int m = arr.length;
		int n = arr[0].length;

		int[] res = new int[m];//number of days / res for every ith day
		int[] pref = new int[n];

		for(int day = 0;day<m;day++){
			int maxi = Integer.MIN_VALUE;
			int maxIdx = -1;

			for(int product = 0;product<n;product++){
				pref[product] += arr[day][product];
				if(pref[product] > maxi){
					maxi = pref[product];
					maxIdx = product;
				}
			}
			res[day] = maxIdx;
		}
		return res;
		
    }
}














