/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHeaded = new ListNode(-1);
        ListNode last = preHeaded;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                last.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                last.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    last.next = l1;
                    l1 = l1.next;
                } else {
                    last.next = l2;
                    l2 = l2.next;
                }
            }
            last = last.next;
        }

        return preHeaded.next;
    }
}