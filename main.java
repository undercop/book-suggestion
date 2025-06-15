
import java.util.Scanner;
public class Main {
   public  static Integer[][] dp;
    public static void main(String[] args) {
        // dice combinations
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] options = new int[6];
        dp = new Integer[6][n+1];
        for(int i = 0 ; i < 6 ; i++){
            options[i] = i+1;
        }
        int ans = help(options , n , 0 );
        
        System.out.print(ans);
        // 1 , 2 , 3 , 4 , 5, 6
    }
    public static int help(int[] options , int target , int si ){
        
        // base cases
        if(si == options.length){
            if(target == 0) return 1;
            if(target != 0) return 0;
        }
        if(target < 0) return 0;
       
            
        if(dp[si][target] != null) return dp[si][target];
        
        
        
        int pick = help(options , target - options[si] , si);
        
        int nopick = help(options , target , si+1 );
        
        int ans = pick + nopick;
        dp[si][target] = ans;
        return ans;
    }
}