package tree;

/**
 * 按层打印二叉树
 *
 * @author hupan
 * @date 2018/09/28
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 按层打印二叉树
 */
class ZigzagLevelOrder {
    class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Integer val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> all = new ArrayList<>(16);
        List<Integer> list = new ArrayList<>(16);

        queue.add(root);
        TreeNode last = root;
        TreeNode nlast = root;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                nlast = node.left;
            }

            if (node.right != null) {
                queue.offer(node.right);
                nlast = node.right;
            }

            if (node == last) {
                list.add(node.val);
                last = nlast;
                all.add(list);
                list = new ArrayList<>(16);
            } else {
                list.add(node.val);
            }
        }

        return all;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new ZigzagLevelOrder().new TreeNode(3);
        TreeNode node1 = new ZigzagLevelOrder().new TreeNode(9);
        TreeNode node2 = new ZigzagLevelOrder().new TreeNode(20);
        TreeNode node3 = new ZigzagLevelOrder().new TreeNode(15);
        TreeNode node4 = new ZigzagLevelOrder().new TreeNode(7);

        treeNode.left = node1;
        treeNode.right = node2;
        node2.left = node3;
        node2.right = node4;

        List<List<Integer>> list = levelOrder(treeNode);
        System.out.println(list);
    }

}