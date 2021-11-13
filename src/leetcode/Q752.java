package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解开密码锁的最少次数
 */
public class Q752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        for (String deadend : deadends) {
            if (deadend.equals(target)) {
                return -1;
            }
            queue.add(deadend);
        }
        queue.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String next = getNext(cur, j);
                    if (!queue.contains(next) && !deadends[0].equals(next)) {
                        queue.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static String getNext(String cur, int index) {
        char[] chars = cur.toCharArray();
        int num = chars[index] - '0';
        if (num == 9) {
            chars[index] = '0';
        } else {
            chars[index] = (char)(num + 1 + '0');
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Q752 q752 = new Q752();
        System.out.println(q752.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}
