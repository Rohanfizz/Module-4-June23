import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
		//sort on the basis of starting point
		Collections.sort(A , (a,b)->{
			return a.get(0) - b.get(0);
		} );

		int pep  = -1;
		int psp = -1;
		int cnt = 0;

		for(List<Integer> interval : A){
			int csp = interval.get(0);
			int cep = interval.get(1);

			if(pep >= csp){
				//overlap so i have to choose among prev and curr
				if(cep < pep){
					psp = csp;
					pep = cep;
					//im not incrementing cnt as im not adding a new interval
				}
			}else{
				//no overlap
				cnt++;
				psp = csp;
				pep = cep;
			}
		}
		return cnt;
	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
