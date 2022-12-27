package org.example.faang;

import org.example.DefaultTest;
import org.example.faang.online.MyBinaryTree;
import org.junit.jupiter.api.Test;

import javax.swing.tree.TreeNode;

import static org.example.faang.online.MyBinaryTree.findMaxHeight;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMaxHeightTree extends DefaultTest {


    @Test
    public void positiveHeightTree(){

        MyBinaryTree tree = new MyBinaryTree();
        MyBinaryTree.MyTreeNode myTreeNode = new MyBinaryTree.MyTreeNode(100);
        MyBinaryTree.MyTreeNode leftFirst = new MyBinaryTree.MyTreeNode(50);
        MyBinaryTree.MyTreeNode rightFirst = new MyBinaryTree.MyTreeNode(123);
        MyBinaryTree.MyTreeNode rightLeft = new MyBinaryTree.MyTreeNode(110);
        MyBinaryTree.MyTreeNode rightRight = new MyBinaryTree.MyTreeNode(1111);
        MyBinaryTree.MyTreeNode lastOne = new MyBinaryTree.MyTreeNode(109);

        tree.root = myTreeNode;
        tree.root.left = leftFirst;
        tree.root.right = rightFirst;
        tree.root.right.left = rightLeft;
        tree.root.right.right = rightRight;
        tree.root.right.left.left = lastOne;
        tree.root.right.left.right = lastOne;
        tree.root.right.left.left.left = lastOne;
        tree.root.right.left.left.right = lastOne;
        System.out.println(findMaxHeight(tree.root));
        System.out.println(tree.counter);
    }


}
