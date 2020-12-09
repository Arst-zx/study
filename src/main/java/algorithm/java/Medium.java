package algorithm.java;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：Study
 * @Name: Medium
 * @date: 2020-11-30 14:53
 * @Description:
 **/

import java.util.*;

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

    public static void main(String[] args) {
        Medium3 medium3 = new Medium3();
        int re = medium3.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        System.out.println(re);
    }
}

/**
 * 15
 */
class Medium4 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    List<Integer> list = new LinkedList<>();
                    Integer integer1 = nums[i];
                    Integer integer2 = nums[left];
                    Integer integer3 = nums[right];
                    list.add(integer1);
                    list.add(integer2);
                    list.add(integer3);
                    lists.add(list);
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Medium4 medium4 = new Medium4();
        medium4.threeSum(new int[] {-1,0,1,2,-1,-5});
    }
}

/**
 * 17
 */
class Medium5 {
//    public List<String> letterCombinations(String digits) {
//        List<String> list = new LinkedList<>();
//        if (digits.length() == 0) {
//            return list;
//        }
//        Map<Character, String> map = new HashMap<>(10);
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//        backCombinations(list, map, digits, 0, new StringBuffer());
//        return list;
//    }
//
//    public void backCombinations(List<String> list, Map<Character, String> map, String digits, int index, StringBuffer stringBuffer) {
//        if (index == digits.length()) {
//            list.add(stringBuffer.toString());
//        } else {
//            char digit = digits.charAt(index);
//            String letters = map.get(digit);
//            int lettersCount = letters.length();
//            for (int i = 0; i < lettersCount; i++) {
//                stringBuffer.append(letters.charAt(i));
//                backCombinations(list, map, digits, index + 1, stringBuffer);
//                stringBuffer.deleteCharAt(index);
//            }
//        }
//    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits.length() == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuffer stringBuffer = new StringBuffer();
        back(map, list, stringBuffer, 0, digits);
        return list;
    }

    public void back(Map<Character, String> map, List<String> list, StringBuffer stringBuffer, int index, String digits) {
        if (index == digits.length()) {
            list.add(stringBuffer.toString());
        } else {
            char ch = digits.charAt(index);
            String letters = map.get(ch);
            for (int i = 0; i < letters.length(); i++) {
                stringBuffer.append(letters.charAt(i));
                back(map, list, stringBuffer, index + 1, digits);
                stringBuffer.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        Medium5 medium5 = new Medium5();
        List list = medium5.letterCombinations("234");
        System.out.println(list);
    }
}

/**
 * 19
 */
class Medium6 {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        List<ListNode> listNodes = new LinkedList<>();
//        while (head != null) {
//            listNodes.add(head);
//            head = head.next;
//        }
//        ListNode listNode = new ListNode();
//        ListNode result = listNode;
//        for (int i = 0; i < listNodes.size(); i++) {
//            if (i == listNodes.size() - n) {
//                continue;
//            }
//            listNode.next = listNodes.get(i);
//            listNode.next.next = null;
//            listNode = listNode.next;
//        }
//        return result.next;
//    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode();
        listNode.next = head;
        if (head == null) {
            return null;
        }
        ListNode end = listNode;
        ListNode first = listNode;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while (end.next != null) {
            first = first.next;
            end = end.next;
        }
        if (first.next != null) {
            first.next = first.next.next;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        Medium6 medium6 = new Medium6();
        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
        ListNode listNode1 = medium6.removeNthFromEnd(listNode, 1);
        System.out.println(listNode1);
    }
}

/**
 * 22
 */
class Medium7 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        back(list, stringBuilder, 0, 0, n);
        return list;
    }

    public void back(List<String> list, StringBuilder stringBuilder, int left, int right, int n) {
        if (stringBuilder.length() == 2 * n) {
            list.add(stringBuilder.toString());
            return;
        }
        if (left < n) {
            stringBuilder.append("(");
            back(list, stringBuilder, left + 1, right, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (right < left) {
            stringBuilder.append(")");
            back(list, stringBuilder, left, right + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        Medium7 medium7 = new Medium7();
        List list = medium7.generateParenthesis(4);
        System.out.println(list);
    }
}

/**
 * 31
 */
class Medium8 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int n = nums.length - 2;
        int m = nums.length;
        while (n >= 0) {
            if (nums[n] < nums[n + 1]) {
                int temp = nums[n];
                int l = n + 1;
                while (l < m - 1 && nums[l + 1] > temp) {
                    l++;
                }
                int temp2 = nums[n];
                int min = nums[l];
                nums[n] = min;
                nums[l] = temp2;
                for (int i = n + 1; i < (m + n)/2 + 1; i++) {
                    int temp3 = nums[i];
                    nums[i] = nums[m + n - i];
                    nums[m + n - i] = temp3;
                }
                return;
            }
            n--;
        }
        for (int i = 0; i < m/2; i++) {
            int temp = nums[i];
            nums[i] = nums[m - 1 - i];
            nums[m - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        Medium8 medium8 = new Medium8();
        int[] nums = new int[] {1,4,6,2,1};
        medium8.nextPermutation(nums);
        System.out.println(nums);
    }
}
