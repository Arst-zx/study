package algorithm.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：Study
 * @Name: Easy
 * @date: 2020-11-30 14:53
 * @Description: LeetCode热题HOT100
 **/

/**
 * 链表节点类
 */
class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 树节点类
 */
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {};
    public TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 1.两数之和
 */
public class Easy {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    int[] result = new int[] {i,j};
                    System.out.println("[" + i + "," + j + "]");
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

/**
 * 1.两数之和
 */
class Easy1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length >= 2) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    int[] result = new int[2];
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        System.out.println("两个数的下标是：" + result[0] + "," + result[1]);
                        return result;
                    }
                }
            }
            System.out.println("找不到这样的两个数");
            return null;
        } else {
            System.out.println("输入有误");
            return null;
        }
    }

    public static void main(String[] args) {
        Easy1 solution = new Easy1();
        int[] nums = {2,4,6,7};
        int target = 6;
        solution.twoSum(nums, target);
    }
}

/**
 * 7.整数反转
 */
class Easy2 {
    public int reverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        } else {
            int[] result = new int[32];
            int shang = x;
            int i = 0;
            while (shang != 0) {
                int yushu = shang % 10;
                shang = shang / 10;
                result[i] = yushu;
                i++;
            }

            long sum = 0;
            for (int m=0; m<i; m++) {
                Double pow = Math.pow(10d, i - m - 1);
                sum = (long)(sum + result[m] * pow);
            }
            System.out.println(sum);
            return (int)sum;
        }
    }

    public static void main(String[] args) {
        Easy2 solutionl = new Easy2();
        int result = solutionl.reverse(0);
    }
}

/**
 * 9.回文数
 */
class Easy3 {
    public boolean isPalindrome(int x) {
        if (x >=0) {
            int[] result = new int[32];
            int shang = x;
            int i = 0;
            while (shang != 0) {
                int yushu = shang%10;
                shang = shang/10;
                result[i] = yushu;
                i++;
            }

            long sum = 0;
            for (int m=0; m<i; m++) {
                Double pow = Math.pow(10d, i - m - 1);
                sum = (long)(sum + result[m] * pow);
            }

            if (x == sum) {
                System.out.println("true");
                return true;
            }
            System.out.println("false");
            return false;
        } else {
            System.out.println("false");
            return false;
        }
    }

    public static void main(String[] args) {
        Easy3 solution12 = new Easy3();
        solution12.isPalindrome(121232121);
    }
}

/**
 * 13.罗马数字转整数
 */
class Easy4 {
    public int romanToInt(String s) {
        s = s.replaceAll("IV", "a");
        s = s.replaceAll("IX", "b");
        s = s.replaceAll("XL", "c");
        s = s.replaceAll("XC", "d");
        s = s.replaceAll("CD", "e");
        s = s.replaceAll("CM", "f");
        String[] sum = s.split("");
        int result = 0;
        for (int i=0; i<sum.length; i++) {
            if ("I".equals(sum[i])) {
                result = result + 1;
            }

            if ("V".equals(sum[i])) {
                result = result + 5;
            }

            if ("X".equals(sum[i])) {
                result = result + 10;
            }

            if ("L".equals(sum[i])) {
                result = result + 50;
            }

            if ("C".equals(sum[i])) {
                result = result + 100;
            }

            if ("D".equals(sum[i])) {
                result = result + 500;
            }

            if ("M".equals(sum[i])) {
                result = result + 1000;
            }

            if ("a".equals(sum[i])) {
                result = result + 4;
            }

            if ("b".equals(sum[i])) {
                result = result + 9;
            }

            if ("c".equals(sum[i])) {
                result = result + 40;
            }

            if ("d".equals(sum[i])) {
                result = result + 90;
            }

            if ("e".equals(sum[i])) {
                result = result + 400;
            }

            if ("f".equals(sum[i])) {
                result = result + 900;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Easy4 solutionw = new Easy4();
        solutionw.romanToInt("MCMXCIV");
    }
}

/**
 * 14.罗马数字转整数
 */
class Easy5 {
    public int romanToInt(String s) {
        s = s.replaceAll("IV", "a");
        s = s.replaceAll("IX", "b");
        s = s.replaceAll("XL", "c");
        s = s.replaceAll("XC", "d");
        s = s.replaceAll("CD", "e");
        s = s.replaceAll("CM", "f");
        String[] sum = s.split("");
        int result = 0;
        for (int i=0; i<sum.length; i++) {
            switch (sum[i]) {
                case "I":
                    result = result + 1;
                    break;
                case "V":
                    result = result + 5;
                    break;
                case "X":
                    result = result + 10;
                    break;
                case "L":
                    result = result + 50;
                    break;
                case "C":
                    result = result + 100;
                    break;
                case "D":
                    result = result + 500;
                    break;
                case "M":
                    result = result + 1000;
                    break;
                case "a":
                    result = result + 4;
                    break;
                case "b":
                    result = result + 9;
                    break;
                case "c":
                    result = result + 40;
                    break;
                case "d":
                    result = result + 90;
                    break;
                case "e":
                    result = result + 400;
                    break;
                case "f":
                    result = result + 900;
                    break;
                default:
                    break;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Easy5 solution = new Easy5();
        solution.romanToInt("MCMXCIV");
    }
}

/**
 * 20.最长公共前缀
 */
class Easy6 {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length < 1) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String samestr;
        String result = "";
        for (int m=1; m<=strs[0].length(); m++) {
            samestr = strs[0].substring(0,m);
            boolean flag = false;
            for (int i=1; i<strs.length; i++) {
                if (!strs[i].startsWith(samestr)) {
                    samestr = strs[0].substring(0,m-1);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                if (samestr.length()>result.length()) {
                    result = samestr;
                }
                break;
            } else {
                if (samestr.length()>result.length()) {
                    result = samestr;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Easy6 solutionr = new Easy6();
        String[] ttt = {"ca","a"};
        solutionr.longestCommonPrefix(ttt);
    }
}

/**
 * 21.有效的括号
 */
class Easy7 {
    public boolean isValid(String s) {

        if (s.length()%2 == 1) {
            System.out.println("false");
            return false;
        }

        String[] chars = s.split("");
        Stack<String> stack = new Stack<>();
        stack.push(chars[0]);
        for (int i=1; i<chars.length; i++) {

            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else if (
                    ("(".equals(stack.peek()) && ")".equals(chars[i])) ||
                            ("[".equals(stack.peek()) && "]".equals(chars[i])) ||
                            ("{".equals(stack.peek()) && "}".equals(chars[i]))
            ){
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }

        if (stack.isEmpty()) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    public static void main(String[] args) {
        Easy7 solutioni = new Easy7();
        solutioni.isValid("{}[{}]((){})(){}");
    }
}

/**
 * 3
 */
class Easy9 {
    public int lengthOfLongestSubstring(String s) {

        // 重复字母位置，初始化为0
        int position = 0;

        // 查找重复字母起始位置，初始化为0

        int positionStart = 0;

        // 当前子串长度，初始化为0
        int length = 0;

        // 当前最长子串
        int lengthst = 0;

        if (s.length() <= 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {

            position = s.indexOf(s.charAt(i),positionStart);

            // 找到相同字母
            if (position < i) {

                // 当前子串比当前最长子串长
                if (length > lengthst) {
                    lengthst = length;
                }

                // 当前最长子串比剩下要比的字符长，则直接退出
                if (lengthst >= s.length() - position - 1) {
                    return lengthst;
                }

                positionStart = position + 1;
                length = i - position - 1;
            }

            length++;
        }

        lengthst = length;
        return lengthst;
    }

//        // 初始化子串长度
//        int num = 0;
//
//        // 循环找出最长子串
//        for (int i = 0; i < s.length(); i++) {
//
//            HashMap<Integer,Character> hashMap = new HashMap<>();
//            hashMap.put(i,s.charAt(i));
//
//            for (int j = i + 1; j < s.length(); j++) {
//                if (!hashMap.containsValue(s.charAt(j))) {
//                    hashMap.put(j,s.charAt(j));
//                }else {
//                    break;
//                }
//            }
//
//            if (hashMap.size() > num) {
//                num = hashMap.size();
//            }
//        }
//
//        System.out.println(num);
//        return num;

    // leetcode最佳答案
//        int i = 0;
//        int flag = 0;
//        int length = 0;
//        int result = 0;
//        while (i < s.length()) {
//            int pos = s.indexOf(s.charAt(i),flag);
//            if (pos < i) {
//                if (length > result) {
//                    result = length;
//                }
//                if (result >= s.length() - pos - 1) {
//                    return result;
//                }
//                length = i - pos - 1;
//                flag = pos + 1;
//            }
//            length++;
//            i++;
//        }
//
//        System.out.println(length);
//        return length;
//    }
}

/**
 * 4
 */
class Easy10 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 返回结果
        double num = 0.0;

        // num1为空
        if (nums1 == null) {

            num = nums2[(nums2.length - 1)/2];
            return num;
        }

        // num2为空
        if (nums2 == null) {

            num = nums1[(nums1.length - 1)/2];
            return num;

        }

        // 合并两个数组为一个
        int[] result = new int[nums1.length + nums2.length];

        // 复制num1到result
        System.arraycopy(nums1,0,result,0,nums1.length);

        // 复制num2到result
        System.arraycopy(nums2,0,result,nums1.length,nums2.length);

        // 排序
        Arrays.sort(result);

        // 求平均值
        num = ((double)result[result.length/2] + (double) result[(result.length - 1)/2])/2;

        System.out.println(num);
        return num;
    }
}

/**
 * 5
 */
class Easy11 {
//    public String longestPalindrome(String s) {
//
//        // 当前最长回文子串
//        String string = null;
//
//        // 当前最长子串长度
//        int lengthst = 0;
//
//        // 空串
//        if (s.length() == 0) {
//            return "";
//        }
//
//        // 循环找出最长子串
//        for (int i = 0; i < s.length(); i++) {
//
//            for (int j = i + 1; j < s.length(); j++) {
//
//                // 前一个对比数位置
//                int m = i;
//
//                // 后一个对比数位置
//                int n = j;
//
//                // 奇数个
//                if ((j - i + 1) % 2 == 1) {
//
//                    // 后一个对比数在前一个对比数前面，或者重合
//                    while (s.charAt(m) == s.charAt(n) && n >= m) {
//
//                        if (n == m && (j - i + 1) > lengthst) {
//                            string = s.substring(i,j + 1);
//                            lengthst = j - i + 1;
//                        }
//
//                        n--;
//                        m++;
//
//                    }
//                }
//
//                // 偶数个
//                if ((j - i + 1) % 2 == 0) {
//
//                    while (s.charAt(m) == s.charAt(n) && n > m) {
//
//                        if (m + 1 == n && (j - i + 1) > lengthst) {
//                            string = s.substring(i,j + 1);
//                            lengthst = j - i + 1;
//                        }
//
//                        n--;
//                        m++;
//
//                    }
//                }
//
//            }
//
//        }
//
//        // 如果string为空
//        if (string == null) {
//            return s.substring(0,1);
//        }
//
//        return string;
//    }

    public String longestPalindrome(String s) {

        // 当前最长回文子串
        String string = null;

        // 当前最长子串长度
        int lengthst = 0;

        // 空串
        if (s.length() == 0) {
            return "";
        }

        // 一个字符
        if (s.length() == 1) {
            return s;
        }

        string = s.substring(0,1);

        // 以i字符为中心
        for (int i = 1; i < s.length(); i++) {

            // 中心字符不等于它前面字符
            if (s.charAt(i) != s.charAt(i - 1)) {

                int j = i;
                // abccba
                while (j + 1 < s.length() && s.charAt(j + 1) == s.charAt(j)) {

                    j++;

                    if (j - i + 1 > lengthst) {
                        lengthst = j - i + 1;
                        string = s.substring(i,j + 1);
                    }
                }

                int n = j;
                while (i + j - n - 1 >= 0 && n + 1 > i + j - n - 1 && n + 1 < s.length() && s.charAt(n + 1) == s.charAt(i + j - n - 1)) {

                    if (n + n - i - j + 3 >lengthst) {
                        lengthst = n + n - i - j + 3;
                        string = s.substring(i + j - n - 1,n + 2);
                    }

                    n++;
                }
            }

            // 中心字符等于它前面字符
            if (s.charAt(i) == s.charAt(i - 1)) {

                if (2 > string.length()) {
                    string = s.substring(i - 1,i + 1);
                    lengthst = 2;
                }

                int j = i;
                // abccba
                while (j + 1 < s.length() && s.charAt(j + 1) == s.charAt(j)) {
                    j++;
                    if (j - i + 2 > lengthst) {
                        string = s.substring(i - 1,j + 1);
                        lengthst = j - i + 2;
                    }
                }

                int n = i;
                while (n - 2 >= 0 && j + 1 < s.length() && s.charAt(j + 1) == s.charAt(n - 2) && j - n + 3 >lengthst) {
                    lengthst = j - n + 3;
                    string = s.substring(n - 2,j + 2);
                    j++;
                    n--;
                }
            }

        }

        // 如果string为空
        if (string == null) {
            return "";
        }

        return string;
    }
}

/**
 * 7
 */
class Easy12 {
    public int reverse(int x) {

        // 整数溢出
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE || x == 0) {
            return 0;
        }

        int[] remainder = new int[32];
        int i;

        for (i = 0; x != 0; i++) {

            remainder[i] = x % 10;
            x = x / 10;
        }

        // 返回值
        long returnVal = 0;
        for (int m = 0; m < i + 1 && i - m -1 >= 0; m++) {

            long pow = (new Double(Math.pow(10, (i - m -1)))).intValue();
            returnVal = remainder[m] * pow  + returnVal;
            if (returnVal >= Integer.MAX_VALUE || returnVal <= Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) returnVal;
    }
}

/**
 * 8
 */
class Easy13 {
    public int myAtoi(String str) {

        // 去除首尾空格,并将非数字转换为逗号
        String string = str.trim();
        str = str.trim().replaceAll("[\\D]",";");
        String[] result = str.split(";");

        if (string.isEmpty()) {
            return 0;
        }

        // 返回值
        long num = 0;

        // 按逗号截取
        for (int i = 0; i < result.length; i++) {

            try {
                if (!result[i].isEmpty()) {
                    Long.parseLong(result[i]);
                }
            }catch (Exception e) {
                return 0;
            }

            if (!result[i].isEmpty() && Long.parseLong(result[i]) > num) {

                num = Long.parseLong(result[i]);
            }

        }

        if (string.charAt(0) == '-') {
            num = -num;
            if (num <= Integer.MIN_VALUE) {
                return -2147483648;
            }
        }

        if (string.charAt(0) != '-' && (string.charAt(0) > 57 || string.charAt(0) < 48)) {
            return 0;
        }

        if (num >= Integer.MAX_VALUE) {
            return 2147483647;
        }

        return (int) num;
    }
}

/**
 * 101
 */
class Easy14 {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode treeNode1, TreeNode treeNode2) {

        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }

        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }

        boolean flag = treeNode1.val == treeNode2.val && check(treeNode1.left, treeNode2.right) && check(treeNode1.right, treeNode2.left);
        System.out.println(flag);
        return flag;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(5);

        TreeNode left = new TreeNode(7);
        treeNode.left = left;
        TreeNode right = new TreeNode(7);
        treeNode.right = right;

        TreeNode leftLeft = new TreeNode(8);
        left.left = leftLeft;
        TreeNode leftRight = new TreeNode(8);
        left.right = leftRight;

        TreeNode rightLeft = new TreeNode(8);
        right.left = rightLeft;
        TreeNode rightRight = new TreeNode(0);
        right.right = rightRight;

        Easy14 test = new Easy14();
        test.isSymmetric(treeNode);
    }

}

/**
 * 21
 */
class Easy15 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(4);
        listNode2.next = new ListNode(5);
        listNode2.next.next = new ListNode(6);

        Easy15 test1 = new Easy15();
        ListNode listNode = test1.mergeTwoLists(listNode1, listNode2);
        do {
            System.out.println(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);

    }

}

/**
 * 53
 */
class Easy16 {
    public int maxSubArray(int[] nums) {
        int f_max = nums[0];
        int f_i = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (f_i + nums[i] > nums[i]) {
                f_i = f_i + nums[i];
            } else {
                f_i = nums[i];
            }

            if (f_i > f_max) {
                f_max = f_i;
            }
        }
        return f_max;
    }

    public static void main(String[] args) {
        Easy16 test2 = new Easy16();
        int[] nums = {1,2,3,6,4,-2,-3,6};
        int result = test2.maxSubArray(nums);
        System.out.println(result);
    }
}

/**
 * 70
 */
class Easy17 {
    public long climbStairs(int n) {
        long f1;
        long f2 = 0L;
        long f3 = 1L;
        for (int i = 1; i <= n; ++i) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        return f3;
    }

    public static void main(String[] args) {
        Easy17 test3 = new Easy17();
        long result = test3.climbStairs(9);
        System.out.println(result);
    }
}

/**
 * 104
 */
class Easy18 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right) {
            return left + 1;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        Easy18 test4 = new Easy18();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(4);

        int result = test4.maxDepth(treeNode);
        System.out.println(result);
    }
}

/**
 * 121
 */
class Easy19 {
//    public int maxProfit(int[] prices) {
//        if (prices.length < 2) {
//            return 0;
//        }
//        int max = 0;
//        for (int i = 0; i < prices.length-1; i++) {
//            int pre = prices[i+1];
//            for (int j = i+1; j < prices.length; j++) {
//                if (prices[j] > pre) {
//                    pre = prices[j];
//                }
//            }
//            if (pre - prices[i] > max) {
//                max = pre - prices[i];
//            }
//        }
//        return max;
//    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < pre) {
                pre = prices[i];
            }
            if (prices[i] - pre > max) {
                max = prices[i] - pre;
            }
        }
        return max;
    }
}

/**
 * 136
 */
class Easy20 {
//    public int singleNumber(int[] nums) {
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer integer = nums[i];
//            if (stack.contains(integer)) {
//                stack.remove(integer);
//            } else {
//                stack.push(integer);
//            }
//        }
//        return stack.pop();
//    }

    public int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            singleNumber = singleNumber ^ nums[i];
        }
        return singleNumber;
    }
}

/**
 * 141
 */
class Easy21 {
//    public boolean hasCycle(ListNode head) {
//        List<ListNode> list = new ArrayList<>();
//        while (head.next != null) {
//            if (list.contains(head)) {
//                return true;
//            } else {
//                list.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

/**
 * 155
 */
//class MinStack {
//
//    private Stack<Integer> stack;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack<>();
//    }
//
//    public void push(int x) {
//        Integer integer = x;
//        stack.push(integer);
//    }
//
//    public void pop() {
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        if (stack == null) {
//            return 0;
//        }
//        int min = stack.get(0);
//        for (int i = 0; i < stack.size(); i++) {
//            if (stack.get(i) < min) {
//                min = stack.get(i);
//            }
//        }
//        return min;
//    }
//}

/**
 * 155
 */
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        Integer integer = x;
        stack.push(integer);
        if (minStack.empty()) {
            minStack.push(integer);
        } else if (integer < minStack.peek()){
            minStack.push(integer);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(6);
//        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }
}

/**
 * 160
 */
class Easy22 {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ArrayList<ListNode> arrayList = new ArrayList<>();
//        while (headA != null) {
//            arrayList.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (arrayList.contains(headB)) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
//    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listNodeA = headA;
        ListNode listNodeB = headB;
        while (listNodeA != listNodeB) {
            if (listNodeA == null) {
                listNodeA = headB;
            } else {
                listNodeA = listNodeA.next;
            }

            if (listNodeB == null) {
                listNodeB = headA;
            } else {
                listNodeB = listNodeB.next;
            }
        }
        return listNodeA;
    }
}

/**
 * 169
 */
class Easy23 {
//    public int majorityElement(int[] nums) {
//        int num = 0;
//        int value = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            if (nums[i] == value) {
//                continue;
//            }
//            for (int j = i; j < nums.length; j++) {
//                if (nums[j] == nums[i]) {
//                    count++;
//                }
//            }
//            if (count > num) {
//                num = count;
//                value = nums[i];
//            }
//        }
//        return value;
//    }

//    public int majorityElement(int[] nums) {
//        int value = 0;
//        int count = 0;
//        for (int num : nums) {
//            if (count == 0) {
//                value = num;
//            }
//            if (num == value) {
//                count++;
//            } else {
//                count--;
//            }
//        }
//        System.out.println(value);
//        return value;
//    }


    public int count(int[] nums, int value) {
        int count = 0;
        for (int num: nums) {
            if (num == value) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementR(int[] nums, int min, int max) {
        if (min == max) {
            return nums[min];
        }

        int left = majorityElementR(nums, min, (max + min)/2);
        int right = majorityElementR(nums, (max + min)/2 + 1, max);

        if (left == right) {
            return left;
        }

        int leftCount = count(nums, left);
        int rightCount = count(nums, right);

        if (leftCount > rightCount) {
            return left;
        }
        return right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementR(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        Easy23 test9 = new Easy23();
        int value = test9.majorityElement(new int[]{3, 3, 3, 4, 4, 3});
        System.out.println(value);
    }
}

/**
 * 198.打家劫舍
 */
class Easy24 {
    public int rob(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int sum1 = nums[0];
        int sum2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = sum2;
            sum2 = Math.max(sum1 + nums[i], sum2);
            sum1 = temp;
        }
        return sum2;
    }

//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int sum1 = nums[0];
//        int sum2 = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < nums.length; i++) {
//            int temp = sum2;
//            sum2 = Math.max(sum1 + nums[i], sum2);
//            sum1 = temp;
//        }
//        return sum2;
//    }

    public static void main(String[] args) {
        Easy24 easy24 = new Easy24();
        int result = easy24.rob(new int[] {2,7,9,3,1});
        System.out.println(result);
    }
}

/**
 * 206
 */
class Easy25 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode listNode = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return listNode;
//    }

    public static void main(String[] args) {
        Easy25 test11 = new Easy25();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode result = test11.reverseList(listNode);
        System.out.println(result);
    }
}

/**
 * 226
 */
class Easy26 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right  == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

/**
 * 234
 */
class Easy27 {
//    public boolean isPalindrome(ListNode head) {
//        if (head == null) {
//            return true;
//        }
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (head != null) {
//            arrayList.add(head.val);
//            head = head.next;
//        }
//        for (int i = 0; i < arrayList.size()/2; i++) {
//            if (!arrayList.get(i).equals(arrayList.get(arrayList.size() - 1 - i))) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到后半部分的第一个节点firstPartEnd
        ListNode secondPartfirst = secondPartfirst(head);

        // 反转后半部分为reverseListNode
        ListNode reverseListNode = reverseListNode(secondPartfirst);

        // 判断是否为回文
        ListNode pre = reverseListNode;
        ListNode temp = head;
        while (pre != null) {
            if (pre.val != temp.val) {
                return false;
            }
            pre = pre.next;
            temp = temp.next;
        }

        // reverseListNodevv反转回
        secondPartfirst.next = reverseListNode(reverseListNode);

        return true;
    }

    public ListNode secondPartfirst(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseListNode(ListNode listNode) {
        ListNode pre = null;
        while (listNode != null) {
            ListNode temp = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        Easy27 test13 = new Easy27();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(1);
        boolean tag = test13.isPalindrome(listNode);
        System.out.println(tag);
    }
}

/**
 * 283
 */
class Easy28 {
//    public void moveZeroes(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] != 0) {
//                        int temp = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = temp;
//                        break;
//                    }
//                }
//            }
//        }
//    }

//    public void moveZeroes(int[] nums) {
//        ArrayList<Integer> arrayList = new ArrayList<>(nums.length);
//        int count = 0;
//        for (int num : nums) {
//            if (num != 0) {
//                arrayList.add(num);
//            }
//            count++;
//        }
//        while (count != 0) {
//            arrayList.add(0);
//            count--;
//        }
//        for (int i = 0; i < arrayList.size(); i++) {
//            nums[i] = arrayList.get(i);
//        }
//    }

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                j++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Easy28 test14 = new Easy28();
        test14.moveZeroes(new int[] {0,0,1});
    }
}

/**
 * 448
 */
class Easy29 {
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        HashMap<Integer, Boolean> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            hashMap.put(nums[i], true);
//        }
//        List<Integer> list = new LinkedList<>();
//        for (int i = 1; i <= nums.length; i++) {
//            if (!hashMap.containsKey(i)) {
//                list.add(i);
//            }
//        }
//        return list;
//    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]) - 1;
            if (nums[temp] > 0) {
                nums[temp] *= -1;
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            Integer temp = i + 1;
            if (nums[i] < 0) {
                list.add(temp);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Easy29 test15 = new Easy29();
        List list = test15.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(list);
    }
}

/**
 * 461
 */
class Easy30 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while (num > 0) {
            int yushu = num%2;
            if (yushu == 1) {
                count++;
            }
            num = num/2;
        }
        return count;
    }

    public static void main(String[] args) {
        Easy30 test16 = new Easy30();
        test16.hammingDistance(1,4);
    }
}

/**
 * 543
 */
class Easy31 {
    int count = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root);
        return count - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        count = Math.max(count, left + right + 1);
        return Math.max(left + 1, right +1);
    }

    public static void main(String[] args) {
        Easy31 test17 = new Easy31();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        int num = test17.diameterOfBinaryTree(treeNode);
        System.out.println(num);

    }
}

/**
 * 617
 */
class Easy32 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);
        return treeNode;
    }

    public static void main(String[] args) {
        Easy32 test18 = new Easy32();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        TreeNode t = test18.mergeTrees(treeNode, treeNode);
        System.out.println(t);
    }
}