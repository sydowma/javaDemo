//package leetcode.island;
//
///**
// * 子岛屿数量
// * 这道题的关键在于，如何快速判断子岛屿？肯定可以借助 Union Find 并查集算法 来判断，不过本文重点在 DFS 算法，就不展开并查集算法了。
// *
// * 什么情况下 grid2 中的一个岛屿 B 是 grid1 中的一个岛屿 A 的子岛？
// *
// * 当岛屿 B 中所有陆地在岛屿 A 中也是陆地的时候，岛屿 B 是岛屿 A 的子岛。
// *
// * 反过来说，如果岛屿 B 中存在一片陆地，在岛屿 A 的对应位置是海水，那么岛屿 B 就不是岛屿 A 的子岛。
// *
// * 那么，我们只要遍历 grid2 中的所有岛屿，把那些不可能是子岛的岛屿排除掉，剩下的就是子岛。
// */
//public class Q1905 {
//    public int numEnclaves(int[][] A) {
//        int n = A.length, m = A[0].length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
//                    if (A[i][j] == 1) {
//                        dfs(A, i, j);
//                    }
//                }
//            }
//        }
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (A[i][j] == 1) {
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
//}
