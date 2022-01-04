package leetcode.slidewindow;

/**
 * 最小覆盖子串
 */
public class Q76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int start = 0, end = 0, minStart = 0, minEnd = 0, count = t.length();
        while (end < s.length()) {
            if (map[s.charAt(end)] > 0) {
                count--;
            }
            map[s.charAt(end)]--;
            end++;
            while (count == 0) {
                if (end - start < minEnd - minStart) {
                    minStart = start;
                    minEnd = end;
                }
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0) {
                    count++;
                }
                start++;
            }
        }
        return minEnd == 0 ? "" : s.substring(minStart, minEnd);
    }

    public static void main(String[] args) {
        Q76 q76 = new Q76();
        System.out.println(q76.minWindow("ABCCADOBECODEBANCABC", "ABC"));
    }
}
