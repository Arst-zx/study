package algorithm.java;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：study
 * @Name: Solution1
 * @date: 2019-09-02 16:59
 * @Description: 两数之和
 **/

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
 * 整数反转
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


