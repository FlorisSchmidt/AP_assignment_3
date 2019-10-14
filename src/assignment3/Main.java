package assignment3;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        BST<Integer> bst = new BST<>();
        int[] list = {234, 236, 6748, 13, 87541, 235, 36, 12, 365, 3, 436};
        for (int value : list) {
            bst.insert(new Integer(value));
        }
        boolean x = bst.find(new Integer(3));
        boolean y = bst.find(new Integer(8 ));
        bst.delete(new Integer(236));
        boolean z = false;
        Iterator<Integer> hoi;
        hoi = bst.descendingIterator();
        int k = 2;
    }
}
