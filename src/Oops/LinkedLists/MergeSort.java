package Oops.LinkedLists;

public class MergeSort {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode sort(ListNode[] lists) {
        if (lists.length == 0) return null;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (ListNode nodeRow : lists) {
            for (ListNode head = nodeRow; head != null; head = head.next) {
                min = Math.min(min, head.val);
                max = Math.max(max, head.val);
            }
        }

        min = Math.abs(min);
        int[] freq = new int[max + min + 1];

        for (ListNode nodeRow : lists) {
            for (ListNode head = nodeRow; head != null; head = head.next) {
                freq[head.val + min]++;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                int val = i - min;
                while (freq[i]-- > 0) {
                    temp.next = new ListNode(val);
                    temp = temp.next;
                }
            }
        }

        return dummy.next;

    }

    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {

            System.out.print(head.val + " ");

            head = head.next;
        }
        System.out.print("]");
    }

    static void main() {
        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});
        printList(sort(lists));

    }
}
