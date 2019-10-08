package test;

import algorithm.java.ListNode;
import algorithm.java.Solution2;
import org.junit.Test;

public class Solution2Test {

    @Test
    public void addTwoNumbers() {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(5);
        listNode3.next = listNode4;

        Solution2 solution2 = new Solution2();
        solution2.addTwoNumbers(listNode1,listNode3);
    }
}