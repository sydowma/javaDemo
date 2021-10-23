package leetcode;

public class Q344 {
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        char[] foo = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(foo);
        System.out.println(foo);

    }
}
