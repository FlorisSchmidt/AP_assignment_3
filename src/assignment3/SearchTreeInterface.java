package assignment3;
import java.util.Iterator;

public interface SearchTreeInterface<E extends Comparable<E>> {

    /**
    @postcondition
    The data stored in the binary search tree was iterated in
    monotonically non-decreasing order and was added in this
    order to an object of the type Iterator<E>.
    This  object  of  the type Iterator<E>was  subsequently
    returned.
     **/
    Iterator<E>ascendingIterator ();

    /**
    @postcondition
    The data stored in the binary search tree was iterated in
    monotonically non-increasing order and was added in this
    order to an object of the type Iterator<E>.
    This object of the type Iterator<E>was subsequently
    returned.**/
    Iterator<E>descendingIterator ();

}
