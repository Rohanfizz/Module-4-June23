import java.util.*;

class displayBinay{

    public static void displayBinary(int n){
        String s= "";
        for(int i = 0;i<32;i++){
            int res = (n & (1<<i)) ;
            if(res != 0) s ="1"+ s;
            else s= "0"+s;
        }
        System.out.println(n+":"+s);
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        // displayBinary(12);
        // displayBinary(-12);
        // displayBinary(-8);
        // displayBinary(-20);
        displayBinary(-12);
        displayBinary(Integer.MAX_VALUE+1);
        displayBinary(Integer.MIN_VALUE-1);
        displayBinary(-1);
        scn.close();
    }
}