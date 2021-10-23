package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Q167 {

    public static int[] twoSum(int[] numbers, int target) {
        // 双指针
        if (numbers.length == 0) {
            return null;
        }
        int j = numbers.length - 1;
        for (int i = 0; i < j;) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                // 因为数组是有序的，可以从直接判断大小
                j--;
            } else {
                i++;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(Q167.twoSum(nums, target)));
    }
}
