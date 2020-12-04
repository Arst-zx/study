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

/**
 * 3
 */
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

/**
 * 5
 */
class Medium2 {
//    public String longestPalindrome(String s) {
//        String result = "";
//        for (int i = 0; i < s.length(); i++) {
//            List<Character> list = new ArrayList<>();
//            String re;
//            for (int j = i; j < s.length(); j++) {
//                list.add(s.charAt(j));
//                boolean flag = false;
//                for (int k = 0; k <= list.size()/2; k++) {
//                    if (!list.get(k).equals(list.get(list.size() - 1 - k))) {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (flag) {
//                    continue;
//                }
//                re = s.substring(i, j + 1);
//                if (re.length() > result.length()) {
//                    result = re;
//                }
//            }
//        }
//        return result;
//    }

    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        String re = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String oneString = huiwen(s, i, i);
            String twoString = huiwen(s, i, i + 1);
            String maxString = oneString.length() > twoString.length() ? oneString : twoString;
            if (maxString.length() > re.length()) {
                re = maxString;
            }
        }
        return re;
    }

    public String huiwen(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i >=0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                i--;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        Medium2 medium = new Medium2();
        String s = medium.longestPalindrome("cbbd");
        System.out.println(s);
    }
}

/**
 * 11
 */
class Medium3 {
//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int area = 0;
//                int h = j - i;
//                int len = Math.max(height[i], height[j]);
//                area = h * len;
//                if (area > maxArea) {
//                    maxArea = area;
//                }
//            }
//        }
//        return maxArea;
//    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        if (height == null || height.length == 0) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}

