package cn.dgkj.test;

import lombok.Data;
import org.junit.Test;

/**
 * @author mawt
 * @description
 * @date 2019/11/20
 */
public class Question2 {

    @Data
    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void run() {
        int[] a1 = {2, 4, 3};
        int[] a2 = {5, 6, 4};

        ListNode l1 = build(a1);
        ListNode l2 = build(a2);
        ListNode ln = addTwoNumbers(l1, l2);

        print(l1);
        print(l2);
        print(ln);
    }

    private ListNode build(int[] a1) {
        ListNode l1 = null;
        for (int i : a1) {
            if (l1 != null) {
                ListNode t = l1;
                while (t.next != null) {
                    t = t.next;
                }
                t.next = new ListNode(i);
            } else {
                l1 = new ListNode(i);
            }
        }
        return l1;
    }

    private void print(ListNode ln) {
        while (ln != null) {
            System.out.print(ln.val + "  ");
            ln = ln.next;
        }
        System.out.println("------------");
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        while (l1 != null) {
            sb1.insert(0, l1.val);
            l1 = l1.next;
        }
        StringBuilder sb2 = new StringBuilder();
        while (l2 != null) {
            sb2.insert(0, l2.val);
            l2 = l2.next;
        }
        String sum = String.valueOf(Long.parseLong(sb1.toString()) + Long.parseLong(sb2.toString()));
        System.out.println(sum);
        int index = sum.length() - 1;
        ListNode head = null;
        int c;
        while (index >= 0) {
            c = Integer.parseInt(sum.charAt(index--) + "");
            if (head == null) {
                head = new ListNode(c);
            } else {
                ListNode ln = head;
                while (ln.next != null) {
                    ln = ln.next;
                }
                ln.next = new ListNode(c);
            }
        }
        return head;
    }

}
