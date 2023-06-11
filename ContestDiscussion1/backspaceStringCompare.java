import java.io.*;
import java.util.*;

class Solution{
       //https://course.acciojob.com/idle?question=25c52021-b22e-4b2a-9183-fa026ba80c8b 
   public static boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

	   for(int i = 0;i<S.length();i++){
		   char c = S.charAt(i);
		   if(c == '#'){
			   if(s1.size()>0) s1.pop();
		   }else  s1.push(c);
	   }

	   
	   for(int i = 0;i<T.length();i++){
		   char c = T.charAt(i);
		   if(c == '#'){
			   if(s2.size()>0) s2.pop();
		   }else  s2.push(c);
	   }

	   while(s1.size() > 0 && s2.size()>0){
		   if(s1.peek() != s2.peek()) return false;
		   s1.pop();
		   s2.pop();
	   }
		if(s1.size() != s2.size()) return false;
	   return true;
    }

}

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
                Solution Obj  = new Solution();
		System.out.print(Obj.backspaceCompare(s,t));
	}
}
