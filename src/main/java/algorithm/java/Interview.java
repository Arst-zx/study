package algorithm.java;

/**
 * @author: 章鑫
 * @Email: zhangx511@chinaunicom.cn
 * @Project_name：Study
 * @Name: Interview
 * @date: 2021-02-23 14:04
 * @Description:
 **/

/**
 * 百度：翻转二叉树
 */

public class Interview {
    public TNode invertTree(TNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TNode left = invertTree(root.left);
        TNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        Interview interview = new Interview();
        TNode tNode = new TNode(0);
        tNode.left = new TNode(1);
        tNode.right = new TNode(2);
        tNode.left.left = new TNode(3);
        TNode result = interview.invertTree(tNode);
        System.out.println(result);
    }
}

class TNode {
    public int val;
    public TNode left;
    public TNode right;
    public TNode() {}
    public TNode(int val) {
        this.val = val;
    }
}