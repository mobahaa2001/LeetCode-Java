class Solution {
    
    static final int MOD = 1000000007;

    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for (int j = 1; j <= m; j++) {
            dp[1][j][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int cost = 1; cost <= k; cost++) {
                    dp[i][j][cost] = (int)(((long) dp[i - 1][j][cost] * j + dp[i][j][cost]) % MOD);
                    for (int prevMax = 1; prevMax < j; prevMax++) {
                        dp[i][j][cost] = (dp[i][j][cost] + dp[i - 1][prevMax][cost - 1]) % MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 1; j <= m; j++) {
            ans = (ans + dp[n][j][k]) % MOD;
        }
        return ans;
    }
    
}