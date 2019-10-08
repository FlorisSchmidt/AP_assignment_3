package assignment3;

import java.util.ArrayList;
import java.util.Iterator<E>;

public class BST<E extends Comparable<E>> implements SearchTreeInterface<E> {

    private class Node{
        E value;
        Node left, right;

        Node(E value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    BST() {
        root = null;
    }


    @Override
    public Iterator<E> ascendingIterator() {
        // turn BST into ascending Arraylist
        return  null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        // turn BST into descending Arraylist
        return null;
    }


    @Override
    public void insert(E value) {
        root = recursiveInsert(root, value);
    }

    private Node recursiveInsert(Node root, E value) {
        if (this.root == null) return new Node(value);

        if (value.compareTo(root.value) <= 0)
            root.left = recursiveInsert(root.left, value);
        else if (value.compareTo(root.value) > 0)
            root.right = recursiveInsert(root.right, value);

        return root;
    }

    @Override
    public boolean delete(E value) {
        return false;
    }

    private Node recursiveDelete(Node root, E value) {
        if (root == null) return null;

        if (value == root.value) {
            // Node to delete found
            // ... code to delete the node will go here
        }
        if (value.compareTo(root.value) <= 0) {
            root.left = recursiveDelete(root.left, value);
            return root;
        }
        root.right = recursiveDelete(root.right, value);
        return root;
    }



    @Override
    public boolean find(E value) {
        return recursiveSearch(this.root, value);
    }

    private boolean recursiveSearch(Node root, E value) {
        if (root == null) return false;
        if (value == root.value) {
            return true;
        }
        if(value.compareTo(root.value) <= 0) return recursiveSearch(root.left, value) ;
        return recursiveSearch(root.right, value);
    }
}

