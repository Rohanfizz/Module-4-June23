import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }

	public static void destroy(int[][] arr,int i,int j){
		if(i<0 || j<0 || i==arr.length || j == arr[0].length || arr[i][j] == 0) return;
		arr[i][j] = 0;

		destroy(arr,i-1,j);//up
		destroy(arr,i+1,j);//down
		destroy(arr,i,j-1);//left
		destroy(arr,i,j+1);//right
	}
	
  public static int numEnclaves(int[][] arr) {
    // your code here
	  int n = arr.length;
	  int m = arr[0].length;
	  //top row
	  for(int j = 0;j<m;j++){
		  if(arr[0][j] == 1) destroy(arr,0,j);
	  }
	  //bottom row
	  for(int j = 0;j<m;j++){
		  if(arr[n-1][j] == 1) destroy(arr,n-1,j);
	  }
	  //left col
	  for(int i = 0;i<n;i++){
		  if(arr[i][0]  == 1)  destroy(arr,i,0);
	  }
	  //right col
	  for(int i = 0;i<n;i++){
		  if(arr[i][m-1]  == 1)  destroy(arr,i,m-1);
	  }
	  int cnt = 0;
	  for(int i=0;i<n;i++){
		  for(int j = 0;j<m;j++) if(arr[i][j] == 1) cnt++;
	  }
	  return cnt;
  }
}












