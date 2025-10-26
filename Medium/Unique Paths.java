class Solution {
    public int uniquePaths(int m, int n) {
        return (int) combination(m + n - 2, Math.min(m - 1, n - 1));
    }
    private long combination(int a, int b) {
        long res = 1;
        for (int i = 1; i <= b; i++) {
            res = res * (a - i + 1) / i;
        }
        return res;
    }
}