package algorithm.java;

import java.util.Stack;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Solution1
 * @date: 2019-09-02 16:59
 * @Description: 两数之和
 **/

/**
 * 1
 */
public class Solution1 {
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
 * 1
 */
class Solution {
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
        Solution solution = new Solution();
        int[] nums = {2,4,6,7};
        int target = 6;
        solution.twoSum(nums, target);
    }
}

/**
 * 7.整数反转
 */
class Solutionl {
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
        Solutionl solutionl = new Solutionl();
        int result = solutionl.reverse(0);
    }
}

/**
 * 9.回文数
 */
class Solution12 {
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
        Solution12 solution12 = new Solution12();
        solution12.isPalindrome(121232121);
    }
}

/**
 * 13.罗马数字转整数
 */
class Solutionw {
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
        Solutionw solutionw = new Solutionw();
        solutionw.romanToInt("MCMXCIV");
    }
}

/**
 * 14.罗马数字转整数
 */
class Solutione {
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
        Solutione solution = new Solutione();
        solution.romanToInt("MCMXCIV");
    }
}

/**
 * 20.最长公共前缀
 */
class Solutionr {
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
        Solutionr solutionr = new Solutionr();
        String[] ttt = {"ca","a"};
        solutionr.longestCommonPrefix(ttt);
    }
}

/**
 * 21.有效的括号
 */
class Solutioni {
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
        Solutioni solutioni = new Solutioni();
        solutioni.isValid("{}[{}]((){})(){}");
    }
}