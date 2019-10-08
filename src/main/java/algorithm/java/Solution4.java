package algorithm.java;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * Related Topics 数组 二分查找 分治算法
 */

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Solution4
 * @date: 2019-09-04 17:26
 * @Description:
 **/

//leetcode submit region begin(Prohibit modification and deletion)

public class Solution4 {
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

//leetcode submit region end(Prohibit modification and deletion)

