package algorithm.java;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Solution6
 * @date: 2019-09-10 10:41
 * @Description:
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *
 *
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 *
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 *
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 * Related Topics 数学
 **/

//leetcode submit region begin(Prohibit modification and deletion)

public class Solution6 {
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

//leetcode submit region end(Prohibit modification and deletion)
