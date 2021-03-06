package assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class BST<E extends Comparable<E>> implements SearchTreeInterface<E> {

    private class Node {
        E value;
        Node left, right;

        Node(E value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    BST() {
        init();
    }

    @Override
    public void init() {
        root = null;
        size = 0;
    }

    @Override
    public Iterator<E> ascendingIterator() {
        ArrayList<E> iterator = new ArrayList<E>();
        ascendingTraverse(root, iterator);
        return iterator.iterator();
    }

    @Override
    public Iterator<E> descendingIterator() {
        ArrayList<E> iterator = new ArrayList<E>();
        descendingTraverse(root, iterator);
        return iterator.iterator();
    }

    public int size() {
        return size;
    }

    private void ascendingTraverse(Node current, ArrayList<E> iterator) {
        if (current != null) {
            if(current.left != null) ascendingTraverse(current.left, iterator);
            iterator.add(current.value);
            if(current.right != null) ascendingTraverse(current.right, iterator);
        }
    }

    private void descendingTraverse(Node current, ArrayList<E> iterator) {
        if (current != null) {
            if(current.right != null) descendingTraverse(current.right, iterator);
            iterator.add(current.value);
            if(current.left != null) descendingTraverse(current.left, iterator);
        }
    }

    @Override
    public void insert(E value) {
        Node current;
        current = recursiveInsert(root, value);
        size ++;
        if (root == null) root = current;
    }

    private Node recursiveInsert(Node current, E value) {
        if (current == null) return new Node(value);
        if (value.compareTo(current.value) <= 0) {
            current.left = recursiveInsert(current.left, value);
        } else if (value.compareTo(current.value) > 0)
            current.right = recursiveInsert(current.right, value);
        return current;
    }

    @Override
    public boolean delete(E value) {
        if (root == null) return false;
        Node parent;
        Node target;
        if (root.value.compareTo(value) == 0) {
            parent = target = root;
        }
        else {
           parent = findParent(value);
           target = findChild(parent, value);
        }
        if(parent == null) return false;
        switch (numberOfChildren(target)) {
            case 0:
                return deleteLeaf(parent, target);
            case 1:
                return deleteParentOfOne(parent, target);
            case 2:
                return deleteParentOfTwo(target);
        }
        return false;
    }

    private boolean deleteLeaf(Node parent, Node target) {
        if(target == root) {
            init();
            return true;
        }
        else if (leftRelation(parent, target)) {
            parent.left = null;
        } else parent.right = null;
        size--;
        return true;
    }

    private boolean deleteParentOfOne(Node parent, Node target) {
        if (target == root) {
            if (root.left != null) root = root.left;
            else root = root.right;
            size--;
            return true;
        }
        boolean leftRelation = leftRelation(parent, target);
        if (leftRelation) {
            if (target.left != null) {
                parent.left = target.left;
            }
            parent.left = target.right;
        } else {
            if (target.left != null) {
                parent.right = target.left;
            }
            parent.right = target.right;
        }
        size--;
        return true;
    }


    private boolean deleteParentOfTwo(Node target) {
            Node successor = findSuccessor(target);
            Node parent;
            parent = findParent(successor.value);
            target.value = successor.value;
            if (leftRelation(parent, successor)) {
                parent.left = null;
            } else parent.right = null;
            size--;
            return true;
        }


    private Node findSuccessor(Node parent) {
        Node seeker = parent.right;
        while(true) {
            while (seeker.left != null) {
                seeker = seeker.left;
            }
            if(seeker.right != null) {
                seeker = seeker.right;
            }
            else break;
        }
        return seeker;
    }

    private boolean leftRelation(Node parent, Node child) {
        if(parent.left != null) {
            return parent.left.value.compareTo(child.value) == 0;
        }
        return false;
    }

    private int numberOfChildren(Node current) {
        if(current.left != null) {
            if(current.right == null) return 1;
            else return 2;
        }
        else if(current.right != null) {
            return 1;
        }
        return 0;
    }

    private Node findParent(E value) {
        return recursiveFindParent(root, null, value);
    }

    private Node findChild(Node parent, E value) {
        if (parent == null) return null;
        if (parent.left != null) {
            if (parent.left.value.compareTo(value) == 0) return parent.left;
        }
        if (parent.right != null) {
            if (parent.right.value.compareTo(value) == 0) return parent.right;
        }
        return null;
    }

    private Node recursiveFindParent(Node current, Node parent, E value) {
        if (current == null) return null;
        if (current.value.compareTo(value) == 0) return parent;
        else if (value.compareTo(current.value) <= 0) {
            parent = current;
            return recursiveFindParent(current.left, parent, value);
        }
        parent = current;
        return recursiveFindParent(current.right, parent, value);
    }


    @Override
    public boolean find(E value) {
        if(root==null) return false;
        if(root.value.compareTo(value) == 0) return true;
        Node parent = findParent(value);
        return findChild(parent, value) != null;
    }

}

