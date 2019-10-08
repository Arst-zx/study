package algorithm.java;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Solution3
 * @date: 2019-09-03 15:45
 * @Description: 无重复字符的最长子串
 **/

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *       请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * Related Topics 哈希表 双指针 字符串 Sliding Window
 */

//leetcode submit region begin(Prohibit modification and deletion)

public class Solution3 {
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

//leetcode submit region end(Prohibit modification and deletion)

