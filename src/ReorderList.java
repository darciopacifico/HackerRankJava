//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

import java.io.IOException;

public class ReorderList {

    ListNode node = null;
    private boolean end = false;

    public void reorderList(ListNode head) {
        node = head;
        reorder(head);
    }

    private void reorder(ListNode head) {
        if (head == null) return;
        reorder(head.next);

        if (end) return;

        ListNode temp = node.next;
        node.next = head;
        head.next = temp;
        node = temp;

        if (node == head || node.next == head) {
            //odd quantity nodes situations
            node.next = null;
            end = true;
            return;
        }
    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        print("[1,2,3,4,5,6,7]");
        print("[1,2,3,4,5,6]");
    }

    private static void print(String input) {
        ListNode head = stringToListNode(input);

        new ReorderList().reorderList(head);
        String out = listNodeToString(head);

        System.out.println(out);
    }
}