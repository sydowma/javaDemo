package leetcode.island;

/**
 * 飞地的问题
 * 这题不让你求封闭岛屿的数量，而是求封闭岛屿的面积总和。
 * 其实思路都是一样的，先把靠边的陆地淹掉，然后去数剩下的陆地数量就行了，注意第 1020 题中 1 代表陆地，0 代表海水：
 */
public class Q1020 {
    int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 淹掉靠边的陆地
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        // 数一数剩下的陆地
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 1;
                }
            }
        }

        return res;
    }

    void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == 0) {
            // 已经被淹过了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 0;
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        Q1020 q = new Q1020();
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(q.numEnclaves(grid));
    }
}
