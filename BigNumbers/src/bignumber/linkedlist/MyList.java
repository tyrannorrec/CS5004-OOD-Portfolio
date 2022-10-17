package bignumber.linkedlist;

/* ******************************************************************************
 * Interface  MyList
 * Purpose    The MyList interface models a List ADT. Methods provide the ability
 *                to add an element to the front or rear of the list, to get, set,
 *                or remove an element at a specified index, as well as to get the
 *                size of the List. The `subList` method can be called to return a
 *                sublist or copy of the List. An additional method, `getStrBigNumber`,
 *                concatenates the String representation of each value in reverse order.
 *                The interface is implemented by the concrete class MyListImpl.
 * ***************************************************************************** */
public interface MyList {

    /* -----------------------------------------------------------------------------
     * Method    size
     * Purpose   Returns the size of the Linked List
     * @param    None
     * @returns  (int) the number of elements in the Linked List
     * ----------------------------------------------------------------------------*/
    int size();

    /* -----------------------------------------------------------------------------
     * Method    get
     * Purpose   Returns the value held at a specific index of the List. Throws
     *               IndexOutOfBoundsException.
     * @param    'index'    --      (int)   the index of the value in the List
     * @returns  (int) the value of the Node at the index
     * ----------------------------------------------------------------------------*/
    int get(int index);

    /* -----------------------------------------------------------------------------
     * Method    set
     * Purpose   Sets the value held at a specific index of the List. Throws
     *               IndexOutOfBoundsException.
     * @param    'index'    --      (int)   the index of the value in the List
     * @param    'data'    --      (int)   the value to set at the index
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void set(int index, int data);

    /* -----------------------------------------------------------------------------
     * Method    insertRear
     * Purpose   Inserts a new Node with the value at the Rear of the List
     * @param    'data'     --      (int)   the value to insert at the Rear of List
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void insertRear(int data);

    /* -----------------------------------------------------------------------------
     * Method    insertFront
     * Purpose   Inserts a new Node with the value at the Front of the List
     * @param    'data'     --      (int)   the value to insert at the Front of List
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void insertFront(int data);

    /* -----------------------------------------------------------------------------
     * Method    remove
     * Purpose   Deletes the Node at the specified index. Throws IndexOutOfBoundsException.
     * @param    'index'    --      (int)   the index of the value in the List
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void remove(int index);

    /* -----------------------------------------------------------------------------
     * Method    subList
     * Purpose   Returns a subList from the startIndex to the endIndex. Throws
     *               IndexOutOfBoundsException.
     * @param    'startIndex'    --    (int)   index representing first Node of the subList
     * @param    'endIndex'      --    (int)   index representing last Node of the subList
     * @returns  (MyList) a subList frm the startIndex to the endIndex of the original List
     * ----------------------------------------------------------------------------*/
    MyList subList(int startIndex, int endIndex);

    /* -----------------------------------------------------------------------------
     * Method    getStrBigNumber
     * Purpose   Returns a String concatenating the value of each Node in reverse
     *               order. Specific to the implementation of BigNumber, where
     *               each Node represents a digit; the Head is the smallest value
     *               digit and the Tail is the largest value digit.
     * @param    None
     * @returns  (String) a String representing a BigNumber
     * ----------------------------------------------------------------------------*/
    String getStrBigNumber();

} /* ****************************************************************************** */
