package assignment3;

public class BST<E extends Comparable<E>> implements SearchTreeInterface<E> {

    private class Node{
        E key;
        Node left, right;

        public Node(E item) {
            left = right = null;
        }
    }
}
