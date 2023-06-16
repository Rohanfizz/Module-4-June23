import java.io.*;
import java.util.*;

class Solution {
	public boolean isValid(HashMap<Character,Integer> curr,HashMap<Character,Integer> ideal){
		for(char c: ideal.keySet()){
			int idealFreq = ideal.get(c);
			int currFreq = curr.getOrDefault(c,0);
			if(currFreq < idealFreq) return false;
		}
		return true;
	}
    public String minWindow(String s, String t) {
		// write code here
		HashMap<Character,Integer> ideal  = new HashMap<>();
		for(int i = 0;i<t.length();i++){
			char c = t.charAt(i);
			ideal.put(c, ideal.getOrDefault(c,0) + 1 );
		}

		int sp = 0;
		int ep = 0;
		HashMap<Character,Integer> curr = new HashMap<>();
		int ans = Integer.MAX_VALUE;
		int osp = -1;
		int oep = -1;

		while(ep<s.length()){
			//introduce
			char c = s.charAt(ep);
			curr.put(c,curr.getOrDefault(c,0)+1);

			//shrink until the window is valid
			while(isValid(curr,ideal)){
				c = s.charAt(sp);
				if(ans > ep-sp+1){
					ans = ep-sp+1;
					osp = sp;
					oep = ep;
				}
				curr.put(c,curr.get(c)-1);
				sp++;
			}

			ep++;
		}
		return s.substring(osp,oep+1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}