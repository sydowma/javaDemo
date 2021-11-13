package leetcode.island;

/**
 * Q200
 * 岛屿数量
 * 其中只包含 0 或者 1，0 代表海水，1 代表陆地，且假设该矩阵四周都是被海水包围着的。
 * 遍历到一个 1 的时候，把四周都淹了水，然后把这个 1 改成 0。
 * 为什么每次遇到岛屿，都要用 DFS 算法把岛屿「淹了」呢？主要是为了省事，避免维护 visited 数组。
 */
public class Q200 {

    // 主函数，计算岛屿书香
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量+1
                    res ++;
                    // 然后用 dfs 把岛屿淹了
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经被淹过了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        Q200 q = new Q200();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(q.numIslands(grid));
    }
}
