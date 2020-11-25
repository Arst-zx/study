package algorithm.java;

import java.util.Stack;

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

/**
 * 104
 */
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

/**
 * 121
 */
class Test5 {
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
class Test6 {
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
class Test7 {
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
class Test8 {
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
class Test9 {
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
        Test9 test9 = new Test9();
        int value = test9.majorityElement(new int[]{3, 3, 3, 4, 4, 3});
        System.out.println(value);
    }
}

/**
 * 198
 */
class Test10 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
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
}

/**
 * 206
 */
class Test11 {
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
        Test11 test11 = new Test11();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode result = test11.reverseList(listNode);
        System.out.println(result);
    }
}