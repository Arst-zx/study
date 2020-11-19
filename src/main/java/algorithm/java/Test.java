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