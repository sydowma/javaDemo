package leetcode;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @author magaofei
 * @date 2021/9/5
 */
public class P997 {

    public static int[] sortedSquares(int[] nums) {
        // 双指针
        int i = 0, j = nums.length - 1, x = nums.length - 1;
        int[] nums2 = new int[nums.length];
        while (i <= j) {
            // 先计算平方
            // 分别计算第一个数和最后一个数的平方
            int s1 = nums[i] * nums[i];
            int s2 = nums[j] * nums[j];
            // 判断结果，然后放入新数组
            if (s1 > s2) {
                nums2[x] = s1;
                i++;
            } else {
                // 因为是顺序的数组，所以较大的数必定出现在首尾，判断哪个更大，如果是后边的更大，就放在尾部，然后自减
                nums2[x] = s2;
                j--;
            }
            x--;
        }
        return nums2;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] result = sortedSquares(nums);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
