import java.util.*;

class Solution {


	public int longestSubstringKrepeatingUnique(String s,int x,int k){
		//This function returns the length of longest substring having exactly x unique characters and all of them occuring at least k times
		HashMap<Character,Integer> hm= new  HashMap<>();

		int unique = 0;
		int countKRep = 0;

		int sp =0;
		int ep = 0;
		int ans  = 0;

		while(ep<s.length()){
			//introduce
			char nc =s.charAt(ep); 
			hm.put(nc, hm.getOrDefault(nc,0) + 1 );

			if(hm.get(nc) == 1) unique++;
			if(hm.get(nc) == k) countKRep++;

			//due to addition of a new character, it is possible that the window might become invalid
			while(unique > x){
				char badChar = s.charAt(sp);
				hm.put(badChar,hm.get(badChar)-1);

				if(hm.get(badChar) == 0) unique--;
				if(hm.get(badChar) == k-1) countKRep--;

				sp++;
			}

			//lets check if we can update the answer
			if(unique == x && countKRep == x) ans  = Math.max(ans,ep-sp+1);

			ep++;
		}
		return ans;
		
	}
	
    public int longestSubstring(String s, int k) {
        // write code here
		//TC: O(26*n)
		//SC: O(1);
		int ans = 0;
		for(int i = 1;i<=26;i++){
			int iUnique = longestSubstringKrepeatingUnique(s,i,k);
			ans = Math.max(ans,iUnique);
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
