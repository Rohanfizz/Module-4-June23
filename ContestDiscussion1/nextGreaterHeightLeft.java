import java.io.*;
import java.util.*;

class Accio {
	//https://course.acciojob.com/idle?question=2b7faf76-32ba-4e55-9c58-726a91f9861c
        public static int[] solve(int[] arr) {
        // Your Code Here
			int n = arr.length;
			int[] res = new int[n];
			Stack<Integer> st = new Stack<>();
			for(int i = 0;i<n;i++){
				while(st.size() > 0 && arr[st.peek()] <= arr[i]) st.pop();

				if(st.size()==0){
					res[i] = -1;
				}else res[i] = i-st.peek();

				st.push(i);
			}

			return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Accio Obj = new Accio();
        int[] result = Obj.solve(arr1);
        for (int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
        System.out.println('\n');
    }
}