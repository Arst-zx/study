package algorithm.java;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Solution5
 * @date: 2019-09-05 17:16
 * @Description: 最长回文子串
 *
 *  * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *  *
 *  * 示例 1：
 *  *
 *  * 输入: "babad"
 *  * 输出: "bab"
 *  * 注意: "aba" 也是一个有效答案。
 *  *
 *  *
 *  * 示例 2：
 *  *
 *  * 输入: "cbbd"
 *  * 输出: "bb"
 *  *
 *  * Related Topics 字符串 动态规划
 **/

//leetcode submit region begin(Prohibit modification and deletion)

public class Solution5 {
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

//leetcode submit region end(Prohibit modification and deletion)
