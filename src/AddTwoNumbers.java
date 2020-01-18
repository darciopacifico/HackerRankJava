class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "" + this.val;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int toNextNode = 0;


        ListNode firstNode = null;

        ListNode node = null;
        do {

            int l1Val = 0;
            int l2Val = 0;

            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            int valSum = toNextNode + l1Val + l2Val;

            toNextNode = valSum / 10;

            ListNode newNode = new ListNode(valSum % 10);

            if (firstNode == null) firstNode = newNode;

            if (node != null) {
                node.next = newNode;
            }

            node = newNode;

        } while (l1 != null || l2 != null || toNextNode > 0);

        return firstNode;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(6, new ListNode(5, new ListNode(7)));
        ListNode l2 = new ListNode(7, new ListNode(8, new ListNode(9)));

        ListNode lRes = new AddTwoNumbers().addTwoNumbers(l1, l2);

        StringBuffer sb = new StringBuffer();
        while (lRes != null) {
            sb.append(lRes.val);
            lRes = lRes.next;
        }

        System.out.println("must be " + (756 + 987) + ": " + sb.reverse());

    }
}