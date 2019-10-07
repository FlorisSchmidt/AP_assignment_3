package assignment3;

import java.util.ArrayList;
import java.util.Iterator<E>;

public class BST<E extends Comparable<E>> implements SearchTreeInterface<E> {

    private class Node{
        E key;
        Node left, right;

        public Node(E value) {
            key = value;
            left = right = null;
        }
    }

    Node root;

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

        if (value.compareTo(root.key) < 0)
            root.left = recursiveInsert(root.left, value);
        else if (value.compareTo(root.key) >0)
            root.right = recursiveInsert(root.right, value);

        /* return the (unchanged) node pointer */
        return root;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean find() {
        return false;
    }


}
