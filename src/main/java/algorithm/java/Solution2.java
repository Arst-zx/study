package algorithm.java;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * Related Topics 链表 数学
 */

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: S2
 * @date: 2019-09-03 10:38
 * @Description: 两数相加
 **/

/**
 * 1
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 相加后新的链表
        ListNode listNode = new ListNode(0);
        ListNode l = listNode;

        // 相加大于10的进位值，0或者1
        int flowVal = 0;

        // 循环相加两个链表的值
        while (l1 != null || l2 != null) {

            // l1当前节点值为n,l2当前节点值为m
            int n = l1 != null ? l1.val : 0;
            int m = l2 != null ? l2.val : 0;
            int sum = n + m + flowVal;
            flowVal = sum/10;

            // 相加后节点
            l.next = new ListNode(sum % 10);
            l = l.next;

            // l1不是空链表
            if (l1 != null) {
                l1 = l1.next;
            }

            // l2不是空链表
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (flowVal > 0) {
            l.next = new ListNode(flowVal);
        }

        while (listNode != null) {
            System.out.println(listNode.next.val);
            listNode = listNode.next;
        }
        return listNode.next;
    }
}

