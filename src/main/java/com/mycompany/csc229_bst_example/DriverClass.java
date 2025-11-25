/*
 * Driver class used to test the BinarySearchTree implementation.
 * It inserts several integers into the BST and prints the results
 * using traversal and visual tree printing.
 */

package com.mycompany.csc229_bst_example;

/**
 * Driver class to demonstrate the functionality of the Binary Search Tree.
 */
public class DriverClass {

    public static void main(String a[]) {

        // Create a new Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();

        /*
         * Insert a sequence of integers into the BST.
         * These values will automatically be arranged in BST order:
         *    - Smaller values go to the left subtree
         *    - Larger values go to the right subtree
         *
         * The structure created will allow us to test traversal and printing.
         */
        bst.insert(8);
        bst.insert(10);
        bst.insert(14);
        bst.insert(3);
        bst.insert(6);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(13);

        // Separator for cleaner output
        System.out.println("\n-------------------");
        System.out.println("In Order Traversal");

        /*
         * In-order traversal prints the BST values in sorted order:
         *      LEFT -> ROOT -> RIGHT
         */
        bst.inOrderTraversal();

        // Print a visual representation of the BST structure
        bst.print();
    }
}
