package leetcode;

import java.util.Arrays;

/**
 * 图像渲染
 * https://leetcode-cn.com/problems/flood-fill/
 */
public class Q733 {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return dfs(image, sr, sc, newColor, image[sr][sc]);
    }
    public static int[][] dfs(int[][] image, int i, int j, int newColor, int num) {

        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newColor || image[i][j] != num) {

        } else {
            int temp = image[i][j];
            image[i][j] = newColor;
            dfs(image, i + 1, j, newColor, temp);
            dfs(image, i - 1, j, newColor, temp);
            dfs(image, i, j + 1, newColor, temp);
            dfs(image, i, j - 1, newColor, temp);
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        System.out.println(Arrays.toString(floodFill(image, sr, sc, newColor)));
    }
}
