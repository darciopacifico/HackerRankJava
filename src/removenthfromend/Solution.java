package removenthfromend;

class Solution {

    public static void main(String[] args) {
        ListNode n = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        printListNode(new Solution().removeNthFromEnd(n, 2));

        ListNode n2 = new ListNode(1);

        printListNode(new Solution().removeNthFromEnd(n2, 1));
    }

    private static void printListNode(ListNode n) {
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    int n;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        return removeNthFromEndInternal(head);
    }

    public ListNode removeNthFromEndInternal(ListNode head) {
        if (head == null) return null;

        head.next = removeNthFromEndInternal(head.next);

        n--;

        if (n == 0) {
            return head.next;
        }

        return head;
    }
}

class ListNode {
    int val;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode next;

    ListNode(int x) {
        val = x;
    }
}