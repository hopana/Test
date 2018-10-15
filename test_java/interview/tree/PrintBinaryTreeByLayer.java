package tree;

import java.util.LinkedList;

/**
 * 按层打印二叉树
 *
 * @author hupan
 * @date 2018/09/27
 */
public class PrintBinaryTreeByLayer {

    class BinaryTreeNode {

        private int value;

        private BinaryTreeNode leftChild;

        private BinaryTreeNode rightChild;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public BinaryTreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(BinaryTreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public BinaryTreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(BinaryTreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public void print() {
            LinkedList<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(this);
            // 上一行最后的元素（假设Root的上一层为NULL节点，那么Root是上一层最后的节点）
            BinaryTreeNode last = this;
            // 本行最后的元素（假设Root的上一层为NULL节点，那么Root初始情况下是当前遍历的最后的节点）
            BinaryTreeNode nlast = this;
            while (!queue.isEmpty()) {
                // 从队列里取出一个节点
                BinaryTreeNode node = queue.poll();

                // 如果该节点的左孩子不为null，则将左孩子放入队列，并且移动本次遍历的nlast指针
                if (node.getLeftChild() != null) {
                    queue.offer(node.getLeftChild());
                    nlast = queue.getLast();
                }

                // 如果该节点的右孩子不为null，则将右孩子放入队列，并且移动本次遍历的nlast指针
                if (node.getRightChild() != null) {
                    queue.offer(node.getRightChild());
                    nlast = queue.getLast();
                }

                // 每次遍历到右孩子后，必须判断当前取出的节点是否是上一层最后的节点
                // 1、如果是，则当前层结束，换行
                // 2、如果不是，则打印本次弹出节点值，继续重复上述步骤进行遍历
                if (node == last) {
                    System.out.print(node.getValue() + "\n");
                    last = nlast;
                } else {
                    System.out.print(node.getValue() + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new PrintBinaryTreeByLayer().new BinaryTreeNode(1);
        BinaryTreeNode node2 = new PrintBinaryTreeByLayer().new BinaryTreeNode(2);
        BinaryTreeNode node3 = new PrintBinaryTreeByLayer().new BinaryTreeNode(3);
        BinaryTreeNode node4 = new PrintBinaryTreeByLayer().new BinaryTreeNode(4);
        BinaryTreeNode node5 = new PrintBinaryTreeByLayer().new BinaryTreeNode(5);
        BinaryTreeNode node6 = new PrintBinaryTreeByLayer().new BinaryTreeNode(6);
        BinaryTreeNode node7 = new PrintBinaryTreeByLayer().new BinaryTreeNode(7);
        BinaryTreeNode node8 = new PrintBinaryTreeByLayer().new BinaryTreeNode(8);

        root.setLeftChild(node2);
        root.setRightChild(node3);
        node2.setLeftChild(node4);
        node3.setLeftChild(node5);
        node3.setRightChild(node6);
        node5.setLeftChild(node7);
        node5.setRightChild(node8);

        root.print();
    }
}
