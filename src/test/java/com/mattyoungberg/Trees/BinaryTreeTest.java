package com.mattyoungberg.Trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void traversals() {
        BinaryTree tree = new BinaryTree();     //                      (6)
        tree.insert(6);                    //                      /  \
        tree.insert(3);                    //                    (3)  (10)
        tree.insert(10);                   //                   /   \    \
        tree.insert(2);                    //                 (2)   (5)  (12)
        tree.insert(5);                    //                 /          /
        tree.insert(12);                   //               (1)        (11)
        tree.insert(1);
        tree.insert(11);
        assertArrayEquals(new int[]{1, 2, 3, 5, 6, 10, 11, 12}, tree.traverse(BinaryTree.TraversalType.INORDER));
        assertArrayEquals(new int[]{6, 3, 2, 1, 5, 10, 12, 11}, tree.traverse(BinaryTree.TraversalType.PREORDER));
        assertArrayEquals(new int[]{1, 2, 5, 3, 11, 12, 10, 6}, tree.traverse(BinaryTree.TraversalType.POSTORDER));
    }
}
