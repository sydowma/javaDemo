package leetcode;

/**
 * 合并链表
 */
public class Q21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 虚拟头节点
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            // 比较 l1 和 l2 2个指针
            // 将值较小的节点接到 cur 指针
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            // cur 指针不断的前进
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(new ListNode(1), new ListNode(2)));
    }
}
