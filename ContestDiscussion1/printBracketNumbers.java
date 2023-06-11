

import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.barcketNumbers(S);
            for(int value :  result)
            System.out.print(value + " ");
            System.out.println();
        
    }
}


class Solution {
    ArrayList<Integer> barcketNumbers(String S) {
        // code here
		ArrayList<Integer> ar = new  ArrayList<>();
		Stack<Integer> st = new Stack<>();
		int next = 1;

		for(int i = 0;i<S.length();i++){
			char c = S.charAt(i);
	//https://course.acciojob.com/idle?question=b35b8b6f-f94e-4fc1-85a5-34d9e486acd7
			if(c == '('){
				ar.add(next);
				st.push(next);
				next++;
			}else if(c==')'){
				if(st.size() > 0) ar.add(st.pop());
			}
		}
		return ar;
    }
};








