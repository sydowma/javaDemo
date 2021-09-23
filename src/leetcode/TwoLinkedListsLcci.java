package leetcode;

import java.util.Objects;

/**
 * 两链表相交
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 * @author magaofei
 * @date 2021/9/23
 */
public class TwoLinkedListsLcci {

     public static class ListNode {
         int val;
         ListNode next;

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;
             ListNode listNode = (ListNode) o;
             return val == listNode.val;
         }

         @Override
         public int hashCode() {
             return Objects.hash(val);
         }

         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;

        while (!h1.equals(h2)) {
            if (h1 == null) {
                h1 = headB;
            } else {
                h1 = h1.next;
            }

            if (h2 == null) {
                h2 = headA;
            } else {
                h2 = h2.next;
            }
        }
        return h1;
    }

    public static void main(String[] args) {

        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = new ListNode(8);
        listA.next.next.next = new ListNode(4);
        listA.next.next.next.next = new ListNode(5);

        ListNode listB = new ListNode(5);
        listB.next = new ListNode(0);
        listB.next.next = new ListNode(8);
        listB.next.next.next = new ListNode(4);
        listB.next.next.next.next = new ListNode(5);

//        listB.next.next = new ListNode(1);
//        listB.next.next.next = new ListNode(8);
//        listB.next.next.next.next = new ListNode(4);
//        listB.next.next.next.next.next = new ListNode(5);

        ListNode result = getIntersectionNode(listA, listB);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
