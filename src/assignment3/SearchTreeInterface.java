package assignment3;
import java.util.Iterator;

public interface SearchTreeInterface<E extends Comparable<E>> {

    /** @elements
     *  All elements of type E extending the comparable class
     *  @structure
     *    Left subtree of a node contains only nodes with values lesser than the node's key.
     *    Right subtree of a node contains only nodes with values greater than the node's key.
     *  @domain
     *    Only alphanumeric characters. Identifiers begins with a letter.
     *    Identifier has a length at least 1 character
     *  @constructor
     *    There is a default constructor that creates an empty tree
     *  @precondition
     *    --
     *  @postcondition
     *    The new SearchTree-object contains an empty tree
     *
     **/


    /** @precondition
     * --
     * @postcondition
     * The data stored in the binary search tree was iterated in
     * monotonically non-decreasing order and was added in this
     * order to an object of the type Iterator<E>.
     * This  object  of  the type Iterator<E>was  subsequently
     * returned.
     **/
    Iterator<E>ascendingIterator ();

    /** @precondition
     * --
     * @postcondition
     *The data stored in the binary search tree was iterated in
     * monotonically non-increasing order and was added in this
     * order to an object of the type Iterator<E>.
     * This object of the type Iterator<E>was subsequently
     * returned.
     **/
    Iterator<E>descendingIterator ();


    /** @precondition
     * --
     * @postcondition
     * SearchTree-POST is empty and root its root points to null.
     **/
    void init();


    /** @precondition
     * --
     * @postcondition
     * SearchTree-POST contains the value passed as argument.
     **/
    void insert(E value);

    /** @precondition
     * The SearchTree is not empty.
     * @postcondition
     * SearchTree-POST does not contain the value.
     * @return  true: SearchTree-PRE contains the value passed as argument and has now been deleted.
     *          false: SearchTree-PRE does not contain the value.
     **/
    boolean delete(E value);

    /** @precondition
     * The SearchTree is not empty.
     * @postcondition
     * @return  true: SearchTree contains the value passed as argument.
     *          false: SearchTree does not contain the value passed as argument.
     **/
    boolean find(E value);
}
