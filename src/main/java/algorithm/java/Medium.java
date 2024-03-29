package algorithm.java;

/**
 * @author: 章鑫
 * @Project_name：Study
 * @Name: Medium
 * @date: 2020-11-30 14:53
 * @Description:
 **/
import java.util.*;

/**
 * 2.两数相加
 */
class Medium {
    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        ListNode listNode = new ListNode(0);
        ListNode listNodePointer = listNode;
        int carry = 0;
        while (listNode1 != null || listNode2 != null) {
            int sum = 0;
            if (listNode1 != null) {
                sum += listNode1.val;
                listNode1 = listNode1.next;
            }
            if (listNode2 != null) {
                sum += listNode2.val;
                listNode2 = listNode2.next;
            }
            sum += carry;
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }

            listNodePointer.next = new ListNode(sum % 10);
            listNodePointer = listNodePointer.next;
        }
        if (carry > 0) {
            listNodePointer.next = new ListNode(carry);
        }
        return listNode.next;
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode listNode = new ListNode(0);
//        ListNode l = listNode;
//        int count = 0;
//        while (l1 != null || l2 != null) {
//            int sum = 0;
//            if (l1 != null) {
//                sum += l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                sum += l2.val;
//                l2 = l2.next;
//            }
//            if (count == 1) {
//                sum++;
//            }
//            if (sum > 9) {
//                count = 1;
//            } else {
//                count = 0;
//            }
//            l.next = new ListNode(sum%10);
//            l = l.next;
//        }
//        if (count > 0) {
//            l.next = new ListNode(count);
//        }
//        return listNode.next;
//    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(9);

        Medium medium = new Medium();
        ListNode listNode = medium.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}

/**
 * 3.无重复字符的最长子串
 */
class Medium1 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s.isEmpty()) {
            return max;
        }
        HashSet<Character> hashSet = new HashSet<>();
        int pointer = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                hashSet.remove(s.charAt(i -1));
            }
            while (pointer + 1 < s.length() && !hashSet.contains(s.charAt(pointer + 1))) {
                hashSet.add(s.charAt(pointer + 1));
                pointer++;
            }
            if (pointer - i + 1 > max) {
                max = pointer - i + 1;
            }
        }
        return max;
    }

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

//    public int lengthOfLongestSubstring(String s) {
//        HashSet<Character> hashSet = new HashSet<>();
//        int max = 0;
//        int right = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (i > 0) {
//                hashSet.remove(s.charAt(i-1));
//            }
//            while (right + 1 < s.length() && !hashSet.contains(s.charAt(right + 1))) {
//                hashSet.add(s.charAt(right + 1));
//                right++;
//            }
//            if (right - i + 1 > max) {
//                max = right - i + 1;
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        Medium1 medium1 = new Medium1();
        int num = medium1.lengthOfLongestSubstring("abcabcbb");
        System.out.println(num);
    }
}

/**
 * 5.最长回文子串
 */
class Medium2 {
    public String huiwen(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String oneCharacterCenter = huiwen(s, i, i);
            String twoCharacterCenter = huiwen(s, i, i + 1);
            String maxString = oneCharacterCenter.length() > twoCharacterCenter.length()?oneCharacterCenter:twoCharacterCenter;
            if (maxString.length() > result.length()) {
                result = maxString;
            }
        }
        return result;
    }
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

//    public String longestPalindrome(String s) {
//        if (s.isEmpty() || s.length() == 1) {
//            return s;
//        }
//        String re = s.substring(0, 1);
//        for (int i = 0; i < s.length(); i++) {
//            String oneString = huiwen(s, i, i);
//            String twoString = huiwen(s, i, i + 1);
//            String maxString = oneString.length() > twoString.length() ? oneString : twoString;
//            if (maxString.length() > re.length()) {
//                re = maxString;
//            }
//        }
//        return re;
//    }
//
//    public String huiwen(String s, int left, int right) {
//        int i = left;
//        int j = right;
//        while (i >=0 && j < s.length()) {
//            if (s.charAt(i) == s.charAt(j)) {
//                j++;
//                i--;
//            } else {
//                break;
//            }
//        }
//        return s.substring(i + 1, j);
//    }

    public static void main(String[] args) {
        Medium2 medium = new Medium2();
        String s = medium.longestPalindrome("cbbd");
        System.out.println(s);
    }
}

/**
 * 11.盛最多水的容器
 */
class Medium3 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        if (height == null || height.length < 1) {
            return maxArea;
        }
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            int area = (j - 1)* Math.min(height[i], height[j]);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

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

//    public int maxArea(int[] height) {
//        int maxArea = 0;
//        if (height == null || height.length == 0) {
//            return 0;
//        }
//        int i = 0;
//        int j = height.length - 1;
//        while (i != j) {
//            int area = (j - i) * Math.min(height[i], height[j]);
//            if (area > maxArea) {
//                maxArea = area;
//            }
//            if (height[i] < height[j]) {
//                i++;
//            } else {
//                j--;
//            }
//        }
//        return maxArea;
//    }

    public static void main(String[] args) {
        Medium3 medium3 = new Medium3();
        int re = medium3.maxArea(new int[] {1,8,6,2,5,4,8,3,7});
        System.out.println(re);
    }
}

/**
 * 15.三数之和
 */
class Medium4 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
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

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new LinkedList<>();
//        if (nums == null || nums.length < 3) {
//            return lists;
//        }
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            int left = i + 1;
//            int right = nums.length - 1;
//            if (nums[i] > 0) {
//                break;
//            }
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            while (left < right) {
//                if (nums[i] + nums[left] + nums[right] == 0) {
//                    while (left < right && nums[left] == nums[left + 1]) {
//                        left++;
//                    }
//                    while (left < right && nums[right] == nums[right - 1]) {
//                        right--;
//                    }
//                    List<Integer> list = new LinkedList<>();
//                    Integer integer1 = nums[i];
//                    Integer integer2 = nums[left];
//                    Integer integer3 = nums[right];
//                    list.add(integer1);
//                    list.add(integer2);
//                    list.add(integer3);
//                    lists.add(list);
//                    left++;
//                    right--;
//                } else if (nums[i] + nums[left] + nums[right] < 0) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//        return lists;
//    }

    public static void main(String[] args) {
        Medium4 medium4 = new Medium4();
        List<List<Integer>> lists = medium4.threeSum(new int[] {-1,0,1,2,-1,-5});
        System.out.println(lists);
    }
}

/**
 * 17.电话号码的字母组合
 */
class Medium5 {
    public  List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits.isEmpty()) {
            return list;
        }
        Map<Character,String> map = new HashMap<>(16);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        back(map, list, digits, 0, new StringBuilder());
        return list;
    }

    public void back(Map<Character, String> map, List list, String digits, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            list.add(stringBuilder.toString());
        } else {
            char ch = digits.charAt(index);
            String letters = map.get(ch);
            for (int i = 0; i < letters.length(); i++) {
                stringBuilder.append(letters.charAt(i));
                back(map, list, digits, index + 1, stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }
    }

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

//    public List<String> letterCombinations(String digits) {
//        List<String> list = new LinkedList<>();
//        if (digits.length() == 0) {
//            return list;
//        }
//        Map<Character, String> map = new HashMap<>();
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//        StringBuffer stringBuffer = new StringBuffer();
//        back(map, list, stringBuffer, 0, digits);
//        return list;
//    }
//
//    public void back(Map<Character, String> map, List<String> list, StringBuffer stringBuffer, int index, String digits) {
//        if (index == digits.length()) {
//            list.add(stringBuffer.toString());
//        } else {
//            char ch = digits.charAt(index);
//            String letters = map.get(ch);
//            for (int i = 0; i < letters.length(); i++) {
//                stringBuffer.append(letters.charAt(i));
//                back(map, list, stringBuffer, index + 1, digits);
//                stringBuffer.deleteCharAt(index);
//            }
//        }
//    }

    public static void main(String[] args) {
        Medium5 medium5 = new Medium5();
        List list = medium5.letterCombinations("234");
        System.out.println(list);
    }
}

/**
 * 19.删除链表的倒数第N个节点
 */
class Medium6 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode();
        listNode.next = head;
        if (head == null) {
            return null;
        }
        ListNode first = listNode;
        ListNode end = listNode;
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

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode listNode = new ListNode();
//        listNode.next = head;
//        if (head == null) {
//            return null;
//        }
//        ListNode end = listNode;
//        ListNode first = listNode;
//        for (int i = 0; i < n; i++) {
//            end = end.next;
//        }
//        while (end.next != null) {
//            first = first.next;
//            end = end.next;
//        }
//        if (first.next != null) {
//            first.next = first.next.next;
//        }
//        return listNode.next;
//    }

    public static void main(String[] args) {
        Medium6 medium6 = new Medium6();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode listNode1 = medium6.removeNthFromEnd(listNode, 1);
        System.out.println(listNode1);
    }
}

/**
 * 22.括号生成
 */
class Medium7 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        back(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void back(List<String> list, StringBuilder stringBuilder, int left, int right, int n) {
        if (stringBuilder.length() == n * 2) {
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

//    public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<>();
//        StringBuilder stringBuilder = new StringBuilder();
//        back(list, stringBuilder, 0, 0, n);
//        return list;
//    }
//
//    public void back(List<String> list, StringBuilder stringBuilder, int left, int right, int n) {
//        if (stringBuilder.length() == 2 * n) {
//            list.add(stringBuilder.toString());
//            return;
//        }
//        if (left < n) {
//            stringBuilder.append("(");
//            back(list, stringBuilder, left + 1, right, n);
//            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        }
//        if (right < left) {
//            stringBuilder.append(")");
//            back(list, stringBuilder, left, right + 1, n);
//            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        }
//    }

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

/**
 * 33
 */
class Medium9 {
//    public int search(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r)/2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Medium9 medium9 = new Medium9();
        int result = medium9.search(new int[] {14,15,16,17,0,1,2,3,4,5,6}, 15);
        System.out.println(result);
    }
}

/**
 * 34
 */
class Medium10 {
//    public int[] searchRange(int[] nums, int target) {
//        int[] result = new int[2];
//        result[0] = -1;
//        result[1] = -1;
//        if (nums == null || nums.length == 0) {
//            return result;
//        }
//        int l = 0;
//        int r = nums.length - 1;
//        while (l <= r) {
//            if (nums[l] == target) {
//                result[0] = l;
//                break;
//            }
//            l++;
//        }
//        while (r >= 0) {
//            if (nums[r] == target) {
//                result[1] = r;
//                break;
//            }
//            r--;
//        }
//        return result;
//    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        if (nums.length == 1 && target == nums[0]) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r)/2;
            if (nums[m] == target) {
                while (m - 1 >= 0 && nums[m] == nums[m - 1]) {
                    m--;
                }
                result[0] = m;
                while (m + 1 < nums.length && nums[m] == nums[m + 1]) {
                    m++;
                }
                result[1] = m;
                return result;
            } else if (nums[m] > target) {
                while (m - 1 >= 0 && nums[m] == nums[m - 1]) {
                    m--;
                }
                r = m - 1;
            } else if (nums[m] < target) {
                while (m + 1 < nums.length && nums[m] == nums[m + 1]) {
                    m++;
                }
                l = m + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Medium10 medium10 = new Medium10();
        int[] result = medium10.searchRange(new int[] {2,4}, 4);
        System.out.println(result);
    }
}

/**
 * 39
 */
class Medium11 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> list = new ArrayDeque<>();
        dfs(candidates, target, 0, lists, list);
        return lists;
    }

    public void dfs(int[] candidates, int target, int left, List<List<Integer>> lists, Deque<Integer> list) {
        if (left == candidates.length) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            System.out.println(lists);
            return;
        }
        dfs(candidates, target, left + 1, lists, list);
        if (target - candidates[left] >= 0) {
            list.addLast(candidates[left]);
            System.out.println(list);
            dfs(candidates, target - candidates[left], left, lists, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Medium11 medium11 = new Medium11();
        medium11.combinationSum(new int[] {2,3,6,7}, 7);
    }
}

/**
 * 46
 */
class Medium12 {
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        if (nums.length == 0) {
//            return lists;
//        }
//        List<Integer> list = new ArrayList<>();
//        for (Integer num : nums) {
//            list.add(num);
//        }
//        int sum = 0;
//        dfs(lists, list, nums, 0, sum);
//        return lists;
//    }
//
//    public void dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int start, int sum) {
//        sum++;
//        System.out.println("第" + sum + "次进入dfs");
//        if (start == nums.length) {
//            List<Integer> list1 = new ArrayList<>(list);
//            System.out.println("第" + sum + "次将list1 " + list1 + " 加入lists" + ",start=" + start + ",交换前list=" + list);
//            lists.add(list1);
//        }
//        for (int i = start; i < nums.length; i++) {
//            System.out.println("第" + sum + "次进入循环");
//            System.out.println("start=" + start + ",i=" + i + ",交换前list=" + list);
//
//            Collections.swap(list, start, i);
//
//            System.out.println("start=" + start + ",i=" + i + ",交换后list=" + list);
//
//            dfs(lists, list, nums, start + 1, sum);
//
//            System.out.println("第" + sum + "次进入循环");
//
//            Collections.swap(list, start, i);
//
//            System.out.println("start=" + start + ",i=" + i + ",恢复list=" + list);
//        }
//    }

//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        backtrack(nums, list, lists, 0);
//        return lists;
//    }
//
//    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> lists, int first) {
//        // 所有数都填完了
//        if (first == nums.length) {
//            lists.add(new ArrayList<>(list));
//        }
//        for (int i = first; i < nums.length; i++) {
//            // 动态维护数组
//            Collections.swap(list, first, i);
//            // 继续递归填下一个数
//            backtrack(nums, list, lists, first + 1);
//            // 撤销操作
//            Collections.swap(list, first, i);
//        }
//    }

//    public List<List<Integer>> permute(int[] nums) {
//        int len = nums.length;
//        // 使用一个动态数组保存所有可能的全排列
//        List<List<Integer>> lists = new ArrayList<>();
//        if (len == 0) {
//            return lists;
//        }
//
//        boolean[] used = new boolean[len];
//        List<Integer> list = new ArrayList<>(len);
//
//        dfs(nums, len, 0, list, used, lists);
//        return lists;
//    }
//
//    private void dfs(int[] nums, int len, int depth, List<Integer> list, boolean[] used, List<List<Integer>> lists) {
//        if (depth == len) {
//            lists.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < len; i++) {
//            if (!used[i]) {
//                list.add(nums[i]);
//                used[i] = true;
//                System.out.println("  递归之前 => " + list);
//                dfs(nums, len, depth + 1, list, used, lists);
//                used[i] = false;
//                list.remove(list.size() - 1);
//                System.out.println("递归之后 => " + list);
//            }
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(lists, nums, new ArrayList<>(), visited);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, int[] nums, ArrayList<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                list.add(nums[i]);
                backtrack(lists, nums, list, visited);
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Medium12 medium12 = new Medium12();
        List<List<Integer>> lists = medium12.permute(new int[] {1,2});
        System.out.println(lists);
    }
}

/**
 * 48
 */
class Medium13 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (i != 0 && j == i) {
                    break;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Medium13 medium13 = new Medium13();
        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        medium13.rotate(matrix);
        System.out.println(matrix);
    }
}

/**
 * 49
 */
class Medium14 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Medium14 medium14 = new Medium14();
        List<List<String>> lists = medium14.groupAnagrams(new String[] {"ate", "eat"});
        System.out.println(lists);
    }
}

/**
 * 55
 */
class Medium15 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                if (i + nums[i] > max) {
                    max = i + nums[i];
                }
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Medium15 medium15 = new Medium15();
        int[] nums = new int[] {1,2,3,0,0,0,4};
        boolean flag = medium15.canJump(nums);
        System.out.println(flag);
    }
}

/**
 * 56
 */
class Medium16 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[len][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                if (intervals[i][0] > intervals[j][0]) {
//                    int[] temp = intervals[i];
//                    intervals[i] = intervals[j];
//                    intervals[j] = temp;
//                }
//            }
//        }
        List<int[]> list = new LinkedList<>();
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 0; i < len; i++) {
            if (intervals[i][0] > max) {
                list.add(new int[] {min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
            if (intervals[i][0] <= max && intervals[i][1] > max) {
                max = intervals[i][1];
            }
            if (i == len - 1) {
                list.add(new int[] {min, max});
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        Medium16 medium16 = new Medium16();
        int[][] nums = medium16.merge(new int[][] {{1,4},{0,1}});
        System.out.println(nums);
    }
}

/**
 * 62
 */
class Medium17 {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                 result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Medium17 medium17 = new Medium17();
        medium17.uniquePaths(5,6);
    }
}

/**
 * 64
 */
class Medium18 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        result[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }
        return result[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Medium18 medium18 = new Medium18();
        medium18.minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}});
    }
}

/**
 * 75
 */
class Medium19 {
//    public void sortColors(int[] nums) {
//        int n = nums.length;
//        int l = 0;
//        int r = n - 1;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 0) {
//                continue;
//            }
//            for (int j = i + 1; j < n; j++) {
//                if (nums[j] == 0) {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                    break;
//                }
//            }
//        }
//        for (int i = n - 1; i >= 0; i--) {
//            if (nums[i] == 0) {
//                return;
//            }
//            if (nums[i] == 2) {
//                continue;
//            }
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] == 2) {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                    break;
//                }
//            }
//        }
//    }

//    public void sortColors(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
//    }

    public void sortColors(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
            while (i <= right && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Medium19 medium19 = new Medium19();
        medium19.sortColors(new int[] {2,0,2,1,1,0});
    }
}

/**
 * 78
 */
class Medium20 {
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return lists;
    }

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        dfs(cur + 1, nums);
        list.remove(list.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        Medium20 medium20 = new Medium20();
        medium20.subsets(new int[] {1,2,3});
    }
}

/**
 * 79 难
 */
class Medium21 {
    public boolean exist(char[][] board, String word) {
        int length = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int length, int width, String word, int index) {
        if (board[length][width] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        visited[length][width] = true;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1} ,{0, -1}};
        boolean result = false;
        for (int[] direction : directions) {
            int i = length + direction[0];
            int j = width + direction[1];
            if (i < board.length && i >= 0 && j >= 0 && j < board[0].length) {
                if (!visited[i][j]) {
                    boolean flag = check(board, visited, i, j, word, index + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[length][width] = false;
        return result;
    }

    public static void main(String[] args) {
        Medium21 medium21 = new Medium21();
        medium21.exist(new char[][] {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED");
    }
}

/**
 * 94
 */
class Medium22 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        inorder(treeNode.left, list);
        list.add(treeNode.val);
        inorder(treeNode.right, list);
    }

    public static void main(String[] args) {
        Medium22 medium22 = new Medium22();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        medium22.inorderTraversal(treeNode);
    }
}

/**
 * 96 卡塔兰数
 */
class Medium23 {
    public int numTrees(int n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result = result * 2 * (2 * i + 1)/(i + 2);
        }
        return (int)result;
    }

    public static void main(String[] args) {
        Medium23 medium23 = new Medium23();
        int result = medium23.numTrees(19);
        System.out.println(result);
    }
}

/**
 * 98
 */
class Medium24 {
    long result = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (root.val <= result) {
            return false;
        }
        result = root.val;
        boolean right = isValidBST(root.right);
        return right;
    }

    public static void main(String[] args) {
        Medium24 medium24 = new Medium24();
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(1);
        boolean flag = medium24.isValidBST(treeNode);
        System.out.println(flag);
    }
}

/**
 * 102
 */
class Medium25 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        System.out.println("linkedList尾部加入root：" + linkedList);
        while (!linkedList.isEmpty()) {
            System.out.println("开始循环linkedList：" + linkedList);
            List<Integer> list = new ArrayList<>();
            System.out.println("新建list：" + list);
            int length = linkedList.size();
            System.out.println("linkedList长度：" + length);
            for (int i = 1; i <= length; i++) {
                TreeNode treeNode = linkedList.poll();
                System.out.println("linkedList头部弹出：" + linkedList);
                list.add(treeNode.val);
                System.out.println("当前list：" + list);
                if (treeNode.left != null) {
                    linkedList.offer(treeNode.left);
                    System.out.println("linkedList加入左节点：" + linkedList);
                }
                if (treeNode.right != null) {
                    linkedList.offer(treeNode.right);
                    System.out.println("linkedList加入右节点：" + linkedList);
                }
            }
            lists.add(list);
            System.out.println("结果集：" + lists);
        }
        return lists;
    }

    public static void main(String[] args) {
        Medium25 medium25 = new Medium25();
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(1);
        List<List<Integer>> lists = medium25.levelOrder(treeNode);
        System.out.println(lists);
    }
}

/**
 * 105.从前序与中序遍历序列构造二叉树
 */
class Medium26 {
    public Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode myBuildTree(int[] preorder, int preorder_start, int preorder_end, int[] inorder, int inorder_start, int inorder_end) {
        if (preorder_start > preorder_end) {
            return null;
        }
        int preorder_root = preorder_start;
        int inorder_root = map.get(preorder[preorder_root]);
        TreeNode treeNode = new TreeNode(preorder[preorder_root]);
        int left_length = inorder_root - inorder_start;
        treeNode.left = myBuildTree(preorder, preorder_start + 1, preorder_start + left_length, inorder, inorder_start, inorder_root - 1);
        treeNode.right = myBuildTree(preorder, preorder_start + 1 + left_length, preorder_end, inorder, inorder_root + 1, inorder_end);
        return treeNode;
    }

//    public Map<Integer, Integer> map = new HashMap<>();
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        for (int i = 0; i < preorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return myBuildTree(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
//    }
//
//    public TreeNode myBuildTree(int[] preorder, int preorder_start, int preorder_end, int[] inorder, int inorder_start, int inorder_end) {
//        if (preorder_start > preorder_end) {
//            return null;
//        }
//        int preorder_root = preorder_start;
//        int inorder_root = map.get(preorder[preorder_root]);
//        TreeNode root = new TreeNode(preorder[preorder_root]);
//        int left_length = inorder_root - inorder_start;
//        root.left = myBuildTree(preorder, preorder_start + 1, preorder_start + left_length, inorder, inorder_start, inorder_root - 1);
//        root.right = myBuildTree(preorder, preorder_start + left_length + 1, preorder_end, inorder, inorder_root + 1, inorder_end);
//        return root;
//    }

    public static void main(String[] args) {
        Medium26 medium26 = new Medium26();
        TreeNode treeNode = medium26.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        System.out.println(treeNode);
    }
}

class Medium27 {
    public void flatten(TreeNode root) {

    }
}