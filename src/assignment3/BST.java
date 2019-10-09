package assignment3;

import java.util.ArrayList;
import java.util.Iterator;

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
        init();
    }

    @Override
    public void init() { root = null;
    }

    @Override
    public Iterator<E> ascendingIterator() {
        ArrayList<E> iterator = new ArrayList<E>();
        recursiveTraverse(this.root, iterator);
        return iterator.iterator();
    }

    private void recursiveTraverse(Node root, ArrayList<E> iterator) {
        if (root != null) {
            recursiveTraverse(root.left, iterator);
            System.out.println(root.value);
            recursiveTraverse(root.right, iterator);
        }
        assert root != null;
        iterator.add(root.value);
    }


    @Override
    public Iterator<E> descendingIterator() {
        // turn BST into descending Arraylist
        return null;
    }




    @Override
    public void insert(E value) {
        Node current;
        current = recursiveInsert(root, value);
        if (root == null) root = current;
    }

    private Node recursiveInsert(Node current, E value) {
        if (current == null) return new Node(value);

        if (value.compareTo(current.value) <= 0)
            current.left = recursiveInsert(current.left, value);
        else if (value.compareTo(current.value) > 0)
            current.right = recursiveInsert(current.right, value);
        return root;
    }

    @Override
    public boolean delete(E value) {
        Node deleted = recursiveDelete(root, value);
        return deleted != null;
    }

    private Node recursiveDelete(Node current, E value) {
        if (current == null) return null;
        Node parent = null;
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                if (parent == null) { BST.init();}
                else if(parent.left.value == current.value);
            }
            else if()
        }
        if (value.compareTo(root.value) <= 0) {
            parent = current;
            current.left = recursiveDelete(current.left, value);
            return root;
        }
        parent = current;
        current.right = recursiveDelete(current.right, value);

        return root;
    }



    @Override
    public boolean find(E value) {
        return recursiveSearch(this.root, value);
    }

    private boolean recursiveSearch(Node current, E value) {
        if (current == null) return false;
        if (value == current.value) {
            return true;
        }
        if(value.compareTo(current.value) <= 0) return recursiveSearch(current.left, value) ;
        return recursiveSearch(current.right, value);
    }
}

