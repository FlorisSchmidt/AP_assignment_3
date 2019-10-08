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
        root = null;
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
        root = recursiveInsert(root, value);
    }

    private Node recursiveInsert(Node root, E value) {
        if (root == null) return new Node(value);

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
        Node parent = null;
        if (value == root.value) {
            if (root.left == null && root.right == null) {
                if (parent == null) { new BST();}
                else (if parent.left.value == root.value);
            }
            else if()
        }
        if (value.compareTo(root.value) <= 0) {
            parent = root;
            root.left = recursiveDelete(root.left, value);
            return root;
        }
        root.right = recursiveDelete(root.right, value);
        parent = root;
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

