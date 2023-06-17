import java.util.*;

class intro{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println( 12 & 10 ); //AND
        System.out.println( 12 | 2 );   //OR
        System.out.println( 12 ^ 5 );   //XOR

        int n = 21;
        n>>=1; //n = n>>1;
        n<<=1; //n=n<<1;
        System.out.println(n);
        scn.close();
    }
}