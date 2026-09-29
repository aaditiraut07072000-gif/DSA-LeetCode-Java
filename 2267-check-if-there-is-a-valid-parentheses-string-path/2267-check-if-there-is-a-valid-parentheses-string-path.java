
class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Path length must be even for a valid string
        if ((m + n) % 2 == 0) {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m + n];

        // Starting cell
        if (grid[0][0] == '(') {
            dp[0][0][1] = true;
        } else {
            return false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int bal = 0; bal < m + n; bal++) {

                    if (!dp[i][j][bal]) {
                        continue;
                    }

                    // Move down
                    if (i + 1 < m) {
                        if (grid[i + 1][j] == '(') {
                            dp[i + 1][j][bal + 1] = true;
                        } else if (bal > 0) {
                            dp[i + 1][j][bal - 1] = true;
                        }
                    }

                    // Move right
                    if (j + 1 < n) {
                        if (grid[i][j + 1] == '(') {
                            dp[i][j + 1][bal + 1] = true;
                        } else if (bal > 0) {
                            dp[i][j + 1][bal - 1] = true;
                        }
                    }
                }
            }
        }

        // Valid path must end with balance 0
        return dp[m - 1][n - 1][0];
    }
}