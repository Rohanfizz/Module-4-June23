import java.util.*;

class Solution {

    public long solve(int arr[][]) {
        // Your code here

		//making suffix sum for  row 0
		for(int j = arr[0].length-2;j>=0;j--) arr[0][j] = arr[0][j] + arr[0][j+1];

		//making prefix sum for row 1
		for(int j = 1;j<arr[0].length;j++) arr[1][j] = arr[1][j] + arr[1][j-1];

		//i will explore all the possible  paths for robot 1
		//and will keep the worst dont by robot 2 in res
		int res = Integer.MAX_VALUE;

		for(int j  =0;j<arr[0].length;j++){
			//if robot 1 switches rows on jth col
			int option1 = j==arr[0].length-1? 0 : arr[0][j+1];
			int option2 = j==0? 0 : arr[1][j-1];

			int robot2 = Math.max(option1,option2);
			res = Math.min(res,robot2);
		}
		return res;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int grid[][]=new int[2][n];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();

        }
        
        Solution obj=new Solution();
        System.out.println(obj.solve(grid));
        sc.close();
    }
}