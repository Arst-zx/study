package algorithm.java;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：Study
 * @Name: Medium
 * @date: 2020-11-30 14:53
 * @Description:
 **/

import java.util.HashSet;

/**
 * 2
 */
public class Medium {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode = new ListNode(0);
        ListNode l = listNode;
        int count = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (count == 1) {
                sum++;
            }
            if (sum > 9) {
                count = 1;
            } else {
                count = 0;
            }
            l.next = new ListNode(sum%10);
            l = l.next;
        }
        if (count > 0) {
            l.next = new ListNode(count);
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(9);

        Medium medium = new Medium();
        medium.addTwoNumbers(l1, l2);
    }
}

class Medium1 {
//    public int lengthOfLongestSubstring(String s) {
//        if (s.isEmpty()) {
//            return 0;
//        }
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len = 0;
//            for (int j = i; j < s.length(); j++) {
//                int index = s.indexOf(s.charAt(j), i);
//                if (index >= j) {
//                    len++;
//                } else {
//                    break;
//                }
//            }
//            if (len > max) {
//                max = len;
//            }
//        }
//        return max;
//    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int max = 0;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                hashSet.remove(s.charAt(i-1));
            }
            while (right + 1 < s.length() && !hashSet.contains(s.charAt(right + 1))) {
                hashSet.add(s.charAt(right + 1));
                right++;
            }
            if (right - i + 1 > max) {
                max = right - i + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Medium1 medium1 = new Medium1();
        int num = medium1.lengthOfLongestSubstring("abcabcbb");
        System.out.println(num);
    }
}

