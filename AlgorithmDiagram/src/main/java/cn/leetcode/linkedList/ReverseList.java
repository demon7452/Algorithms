package cn.leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/description/">...</a>
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode result = iteration(head);
        System.out.println(result);
    }

    public static ListNode reverseList(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        nodeList.get(0).next = null;
        for (int i = nodeList.size() -1; i > 0; i--) {
            nodeList.get(i).next = nodeList.get(i - 1);
        }
        return nodeList.get(nodeList.size() -1);
    }

    private static ListNode iteration(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode remain = current.next;
            current.next = prev;
            prev = current;
            current = remain;
        }
        return prev;
    }


}
