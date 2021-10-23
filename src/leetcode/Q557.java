package leetcode;

public class Q557 {
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0, right = 0;
        while(right <= n) {
            if(right == n || arr[right] == ' ') {
                reverseString(arr, left, right -1);
                left = right + 1;
            }
            right++;
        }
        s = new String(arr);
        return s;
    }
    public static void reverseString(char[] s,int left, int right) {
        while(left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "东京 爱情 故事";

        System.out.println(reverseWords(s));
    }
}
