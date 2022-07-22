package algorithm.java;

/**
 * @author: 章鑫
 * @Project_name：Study
 * @Name: Tree
 * @date: 2021-03-24 10:51
 * @Description: 627.合并二叉树
 **/
public class Tree {
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
        Tree tree = new Tree();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);
        TreeNode treeNode = tree.mergeTrees(t1, t1);
    }
}
