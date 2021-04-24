package com.mattyoungberg.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node root;

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        public Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    private enum TraversalType {
        PREORDER, INORDER, POSTORDER
    }

    public BinaryTree() {
        this.root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.data)
                return current;
            else if (key < current.data)
                current = current.leftChild;
            else
                current = current.rightChild;
        }
        return null;
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (key < current.data) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        if (root == null)
            return false;
        Node current = root;
        Node parent = root;
        boolean currentIsLeftChild = true;
        while (current.data != key) {
            parent = current;
            if (key < current.data) {
                currentIsLeftChild = true;
                current = current.leftChild;
            } else {
                currentIsLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)
                root = null;
            else if (currentIsLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        } else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (currentIsLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        } else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (currentIsLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        } else {
            Node successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (currentIsLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node nodeToDelete) {
        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete;
        Node current = nodeToDelete.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != nodeToDelete.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = nodeToDelete.rightChild;
        }
        return successor;
    }

    public List<Integer> traverse(TraversalType type) {
        List<Integer> list = new ArrayList<>();
        switch (type) {
            case INORDER:
                inOrder(root, list);
                break;
            case PREORDER:
                preOrder(root, list);
                break;
            case POSTORDER:
                postOrder(root, list);
                break;
        }
        return list;
    }

    private void inOrder(Node localRoot, List<Integer> list) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild, list);
            list.add(localRoot.data);
            inOrder(localRoot.rightChild, list);
        }
    }

    private void preOrder(Node localRoot, List<Integer> list) {
        if (localRoot != null) {
            list.add(localRoot.data);
            preOrder(localRoot.leftChild, list);
            preOrder(localRoot.rightChild, list);
        }
    }

    private void postOrder(Node localRoot, List<Integer> list) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild, list);
            postOrder(localRoot.rightChild, list);
            list.add(localRoot.data);
        }
    }
}
