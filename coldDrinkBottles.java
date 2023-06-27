import java.io.*;
import java.util.*;

class Solution {

    public List<Integer> coldDrink(int arr[], int n, int k) {
        // write code here

		HashMap<Integer,Integer> hm =new HashMap<>(); // drink : quantity
		int sp = 0;
		int ep = 0;

		int mini = Integer.MAX_VALUE;
		int osp = -1;
		int oep = -1;

		while(ep<n){
			//introduce
			int newDrink = arr[ep];
			hm.put(newDrink,hm.getOrDefault(newDrink,0) + 1);

			//shrink
			while(hm.size() == k){
				if(mini > ep-sp+1){
					mini = ep-sp+1;
					osp = sp;
					oep = ep;
				}
				int badDrink = arr[sp];
				hm.put(badDrink , hm.get(badDrink) - 1);
				if(hm.get(badDrink) == 0) hm.remove(badDrink);
				sp++;
			}

			//if im standing on this line, the window is having < k drinks
			ep++;
		}
		List<Integer> res = new ArrayList<>();
		if(osp == -1){
			res.add(-1);
			return res;
		}
		res.add(osp);
		res.add(oep);
		return res;
		
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        List<Integer> ans = Obj.coldDrink(arr, n, k);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        sc.close();
    }
}
