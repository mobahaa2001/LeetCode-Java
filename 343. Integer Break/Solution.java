/* Solution 1 */
class Solution1 {
    public int integerBreak(int n) {
        int[] result = new int[n + 1];
        result[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i/2; j ++) {
                int product = Math.max(result[j], j) * Math.max(result[i-j], i - j);
                max = Math.max(max, product);
            }
            result[i] = max;
        }
        return result[n];
    }
}

/* Solution 2 */ 

public class Solution2 {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) 
            return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}