package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 填充二叉树的每个next指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将next指针设置为 NULL
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 *
 * 转换后：
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 *
 * @author hupan
 * @date 2018/09/28
 */
public class ConnectTreeNodeAtSameLevel {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode connect(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nfirst = root;
        TreeNode nlast = root;

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                nfirst = node.left;
                nlast = node.left;
            }

            if (node.right != null) {
                queue.offer(node.right);
                nlast = node.right;
            }

            if (node == nfirst) {
                nfirst = node.left;
            }

            if (node == last) {
                last = nlast;
            }
        }

        return null;
    }


    public static void main(String[] args) {
        ConnectTreeNodeAtSameLevel.TreeNode root = new ConnectTreeNodeAtSameLevel().new TreeNode(1);
        ConnectTreeNodeAtSameLevel.TreeNode node2 = new ConnectTreeNodeAtSameLevel().new TreeNode(2);
        ConnectTreeNodeAtSameLevel.TreeNode node3 = new ConnectTreeNodeAtSameLevel().new TreeNode(3);
        ConnectTreeNodeAtSameLevel.TreeNode node4 = new ConnectTreeNodeAtSameLevel().new TreeNode(4);
        ConnectTreeNodeAtSameLevel.TreeNode node5 = new ConnectTreeNodeAtSameLevel().new TreeNode(5);
        ConnectTreeNodeAtSameLevel.TreeNode node6 = new ConnectTreeNodeAtSameLevel().new TreeNode(6);
        ConnectTreeNodeAtSameLevel.TreeNode node7 = new ConnectTreeNodeAtSameLevel().new TreeNode(7);
        ConnectTreeNodeAtSameLevel.TreeNode node8 = new ConnectTreeNodeAtSameLevel().new TreeNode(8);

        root.left = node2;
        root.right=node3;
        node2.left=node4;
        node3.left=node5;
        node3.right=node6;
        node5.left=node7;
        node5.right=node8;
    }

}
