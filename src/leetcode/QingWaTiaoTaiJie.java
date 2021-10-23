package leetcode;

/**
 * 青蛙跳台阶
 * @author magaofei
 * @date 2021/9/23
 */
public class QingWaTiaoTaiJie {

    public static int numWays(int n) {
        if ( n < 0 ){
            throw new RuntimeException("请输入正整数!");
        }
        if (n == 0 || n == 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2 ; i <= n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(70));
    }
}
