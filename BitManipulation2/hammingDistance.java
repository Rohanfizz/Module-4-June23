import java.util.*;

class Accio{

	static int countSetBits(int x){
		int cnt = 0;
		while(x > 0){
			cnt++;
			x = x & (x-1);
		}
		return cnt;
	}
	
    static int HammingDistance(int a,int b){
        //write code here
		int x = a^b;
		//at every position where the bits are different in x
		//ill be having a 1
		//only thing remaining is to count the number of 1s in x
		//count the number of set bits in x
		return countSetBits(x);
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Accio obj = new Accio();
        int ans=obj.HammingDistance(a,b);
        System.out.println(ans);
    }
}
