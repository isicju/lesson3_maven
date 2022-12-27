package org.example.faang.online;

public class MyBinaryTree {

    public MyTreeNode root;
    public static int counter = 0;

    public static class MyTreeNode {
        int value;
        public MyTreeNode left;
        public MyTreeNode right;

        public MyTreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }

    }

    public static int findMaxHeight(MyTreeNode treeNode) {
        if (treeNode == null) return 0;
        else {
            int maxLeftHeight = findMaxHeight(treeNode.left);
            int maxRightHeight = findMaxHeight(treeNode.right);

            if (maxLeftHeight > maxRightHeight) {
                return maxLeftHeight + 1;
            } else {
                return maxRightHeight + 1;
            }
        }
    }


}
