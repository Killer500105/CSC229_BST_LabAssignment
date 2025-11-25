package com.mycompany.csc229_bst_example;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;  // The root node of the BST

    // Returns true if the tree has no nodes
    public boolean isEmpty() {
        return (this.root == null);
    }

    // Insert a new value into the BST
    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            // If the tree is empty, the root becomes the new node
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }

        // Otherwise recursively find the correct place to insert
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    // Recursive helper method for inserting a new node
    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());

        // Insert into LEFT subtree
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        }
        // Insert into RIGHT subtree
        else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    // ================================
    //  TODO 1: In-Order Traversal
    // ================================

    /*
        In-order traversal visits nodes in this order:
           LEFT -> ROOT -> RIGHT

        This results in sorted order for BSTs.
    */
    public void inOrderTraversal() {
        doInOrder(this.root);
        System.out.println();
    }

    private void doInOrder(BstNode root) {
        if (root == null) return;

        doInOrder(root.getLeft());         // Visit left subtree
        System.out.print(root.getData() + " "); // Visit node itself
        doInOrder(root.getRight());        // Visit right subtree
    }

    // ================================
    //  TODO 2: Pre-Order Traversal
    // ================================

    /*
        Pre-order traversal visits:
            ROOT -> LEFT -> RIGHT

        This is useful for copying or saving tree structure.
    */
    public void preOrderTraversal() {
        doPreOrder(this.root);
        System.out.println();
    }

    private void doPreOrder(BstNode root) {
        if (root == null) return;

        System.out.print(root.getData() + " "); // Visit node
        doPreOrder(root.getLeft());             // Left subtree
        doPreOrder(root.getRight());            // Right subtree
    }

    // ================================
    //  TODO 3: Find Height of the Tree
    // ================================

    /*
        The height of a binary tree is the number of edges on the 
        longest path from the root to a leaf.

        By definition:
            - Empty tree height = -1
            - Root-only tree height = 0
    */
    public Integer findHeight() {
        return height(this.root);
    }

    private int height(BstNode node) {
        if (node == null) 
            return -1; // Height of empty tree

        // Height = 1 + max(left height, right height)
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    // ================================
    //  TODO 4: Get Depth of a Node
    // ================================

    /*
        The depth of a node is the number of edges from the root to that node.

        root depth = 0
        children of root = 1
        etc.

        We recursively search for the target node and keep a running depth count.
    */
    public int getDepth(BstNode node) {
        return computeDepth(root, node, 0);
    }

    private int computeDepth(BstNode current, BstNode target, int depth) {
        if (current == null) return -1;   // Node not found
        if (current == target) return depth;

        // Search left or right depending on value
        if (target.getData() < current.getData()) {
            return computeDepth(current.getLeft(), target, depth + 1);
        } else {
            return computeDepth(current.getRight(), target, depth + 1);
        }
    }

    // ================================
    //  TODO 5: Pretty Print the BST
    // ================================

    /*
        Visually prints the BST sideways using branches:

            └── 50
                ├── 30
                │   ├── 20
                │   └── 40
                └── 70
                    ├── 60
                    └── 80
    */
    public void print() {
        System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
    }

    // Recursive pretty-printer
    private void print(String prefix, BstNode node, boolean isLeft) {
        if (node == null) return;

        // Print current node with a prefix and branch symbol
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getData());

        // Recurse to children with updated prefix spacing
        print(prefix + (isLeft ? "│   " : "    "), node.getLeft(), true);
        print(prefix + (isLeft ? "│   " : "    "), node.getRight(), false);
    }
}
