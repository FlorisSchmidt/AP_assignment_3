package assignment3;

public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        BST<Integer> bst = new BST<>();
        Integer x = 5;
        Integer y = 6;
        Integer z = 7;
        bst.insert(x);
        bst.insert(y);
        bst.insert(z);
        bst.find(4);
        int k = 5;
    }
}
