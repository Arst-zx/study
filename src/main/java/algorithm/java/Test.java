package algorithm.java;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：Study
 * @Name: Test
 * @date: 2020-11-17 10:04
 * @Description:
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 101
 */
class Test {

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

        Test test = new Test();
        test.isSymmetric(treeNode);
    }

}

/**
 * 21
 */
class Test1 {

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

        Test1 test1 = new Test1();
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
class Test2 {
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
        Test2 test2 = new Test2();
        int[] nums = {1,2,3,6,4,-2,-3,6};
        int result = test2.maxSubArray(nums);
        System.out.println(result);
    }
}

/**
 * 70
 */
class Test3 {
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
        Test3 test3 = new Test3();
        long result = test3.climbStairs(9);
        System.out.println(result);
    }
}

class Test4 {

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
        Test4 test4 = new Test4();
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