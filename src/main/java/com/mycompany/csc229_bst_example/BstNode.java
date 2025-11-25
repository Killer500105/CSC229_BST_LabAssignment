/*
 * Basic node class used for the Binary Search Tree (BST).
 * Each node stores:
 *   - an Integer value (data)
 *   - a reference to a left child
 *   - a reference to a right child
 */
package com.mycompany.csc229_bst_example;

/**
 * Represents a single node inside a Binary Search Tree.
 * Each node may have:
 *     - a left child
 *     - a right child
 *     - an integer data value
 */
public class BstNode {

    // References to the left and right children
    private BstNode left;
    private BstNode right;

    // The value stored in this node
    private Integer data;

    /**
     * Constructor to create a new BST node with the given value.
     * Initially, the node has no children (left and right are null).
     *
     * @param data the integer value to store in the node
     */
    public BstNode(Integer data) {
        this.data = data;
    }

    /**
     * Returns the left child of this node.
     *
     * @return the left child (or null if none)
     */
    public BstNode getLeft() {
        return left;
    }

    /**
     * Sets the left child of this node.
     *
     * @param left the new left child node
     */
    public void setLeft(BstNode left) {
        this.left = left;
    }

    /**
     * Returns the right child of this node.
     *
     * @return the right child (or null if none)
     */
    public BstNode getRight() {
        return right;
    }

    /**
     * Sets the right child of this node.
     *
     * @param right the new right child node
     */
    public void setRight(BstNode right) {
        this.right = right;
    }

    /**
     * Returns the integer value stored in this node.
     *
     * @return the node's data value
     */
    public Integer getData() {
        return data;
    }

}
