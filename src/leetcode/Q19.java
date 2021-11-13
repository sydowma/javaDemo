package leetcode;

/**
 * 删除第K个链表的节点
 */
public class Q19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 先走 k 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 同时走 n - k 步
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删掉倒数第 n 个节点
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Q19 q = new Q19();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = q.removeNthFromEnd(head, 2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
