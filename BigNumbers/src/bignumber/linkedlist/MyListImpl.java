package bignumber.linkedlist;

/* ******************************************************************************
 * Class     MyListImpl
 * Purpose   The MyListImpl class implements the MyList interface as a Singly
 *               Linked List, with a head Node, tail Node, and the size of the
 *               List as attributes. Alongside the methods defined in the interface,
 *               the `toString` method has also been overloaded to print the values
 *               in the List in their original order. This method is distinct from
 *               the `getStrBigNumber` method, which concatenates the values in reverse
 *               and is specific to the implementation of the BigNumber interface.
 * @attrib   'head'           --    (Node)    the Node at the head of the List
 * @attrib   'tail'           --    (Node)    the Node at the tail of the List
 * @attrib   'size'           --    (int)     the number of elements in the List
 * ***************************************************************************** */
public class MyListImpl implements MyList {

    private Node head;
    private Node tail;
    private int size;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates an empty MyListImpl object, representing an empty List.
     *               The head and tail Nodes are set to null and the size is set to 0.
     * ----------------------------------------------------------------------------*/
    public MyListImpl() {

        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a MyListImpl object from a single Node, representing a List
     *               with a single element. The Node passed in as an argument is set
     *               as both head and tail of the List. Size is set to 1.
     * @param    'inHead'     --    (Node)  a Node with an int data attribute
     * ----------------------------------------------------------------------------*/
    public MyListImpl(Node inHead) {

        this.head = inHead;
        this.tail = inHead;
        this.size = 1;
    }

    /* -----------------------------------------------------------------------------
     * Method    size
     * Purpose   Returns the size of the Linked List
     * @param    None
     * @returns  (int) the number of elements in the Linked List
     * ----------------------------------------------------------------------------*/
    @Override
    public int size() {

        return this.size;
    }

    /* -----------------------------------------------------------------------------
     * Method    get
     * Purpose   Returns the value held at a specific index of the List. Throws
     *               IndexOutOfBoundsException.
     * @param    'index'    --      (int)   the index of the value in the List
     * @returns  (int) the value of the Node at the index
     * ----------------------------------------------------------------------------*/
    @Override
    public int get(int index) {

        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == this.size() - 1) {
            return this.tail.data;
        }

        int counter = 0;
        Node iterator = this.head;

        while (counter < index) {
            iterator = iterator.next;
            counter++;
        }

        return iterator.data;
    }

    /* -----------------------------------------------------------------------------
     * Method    set
     * Purpose   Sets the value held at a specific index of the List. Throws
     *               IndexOutOfBoundsException.
     * @param    'index'    --      (int)   the index of the value in the List
     * @param    'data'    --      (int)   the value to set at the index
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void set(int index, int data) {

        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == this.size() - 1) {
            this.tail.data = data;
            return;
        }

        int counter = 0;
        Node iterator = this.head;

        while (counter < index) {
            iterator = iterator.next;
            counter++;
        }

        iterator.data = data;
    }

    /* -----------------------------------------------------------------------------
     * Method    insertRear
     * Purpose   Inserts a new Node with the value at the Rear of the List
     * @param    'data'     --      (int)   the value to insert at the Rear of List
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void insertRear(int data) {

        this.size++;

        if (this.head == null) {
            this.head = new Node(data);
            this.tail = this.head;
        }

        else if (this.head == this.tail) {
            this.tail = new Node(data);
            this.head.next = this.tail;
        }

        else {
            this.tail.next = new Node(data);
            this.tail = this.tail.next;
        }
    }

    /* -----------------------------------------------------------------------------
     * Method    insertFront
     * Purpose   Inserts a new Node with the value at the Front of the List
     * @param    'data'     --      (int)   the value to insert at the Front of List
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void insertFront(int data) {

        Node iterator = this.head;
        this.size++;

        if (iterator == null) {
            this.head = new Node(data);
            this.tail = this.head;
            return;
        }

        this.head = new Node(data, iterator);
    }

    /* -----------------------------------------------------------------------------
     * Method    remove
     * Purpose   Deletes the Node at the specified index. Throws IndexOutOfBoundsException.
     * @param    'index'    --      (int)   the index of the value in the List
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void remove(int index) {

        if (index >= this.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty. Nothing to remove.");
        }

        this.size--;

        // If head to be removed
        if (index == 0) {
            // If singleton List
            if (this.head == this.tail) {
                head = null;
                tail = null;
            }
            // Else, move head to next
            else {
                head = head.next;
            }
        }

        // General case
        else {
            int counter = 1;
            Node prevNodePtr = this.head;
            Node currNodePtr = prevNodePtr.next;

            while (counter < index) {
                prevNodePtr = currNodePtr;
                currNodePtr = currNodePtr.next;
                counter++;
            }

            if (currNodePtr == tail) {
                this.tail = prevNodePtr;
            }

            prevNodePtr.next = currNodePtr.next;

        }
    }

    /* -----------------------------------------------------------------------------
     * Method    subList
     * Purpose   Returns a subList from the startIndex to the endIndex. Throws
     *               IndexOutOfBoundsException.
     * @param    'startIndex'    --    (int)   index representing first Node of the subList
     * @param    'endIndex'      --    (int)   index representing last Node of the subList
     * @returns  (MyList) a subList frm the startIndex to the endIndex of the original List
     * ----------------------------------------------------------------------------*/
    @Override
    public MyList subList(int startIndex, int endIndex) {

        if (endIndex >= this.size() || startIndex < 0 || endIndex < startIndex) {
            throw new IndexOutOfBoundsException();
        }

        MyList newList = new MyListImpl();

        int counter = 0;
        Node iterator = this.head;

        while (counter < startIndex) {
            iterator = iterator.next;
            counter++;
        }

        while (counter <= endIndex) {
            newList.insertRear(iterator.data);
            iterator = iterator.next;
            counter++;
        }

        return newList;
    }

    /* -----------------------------------------------------------------------------
     * Method    equals
     * Purpose   Returns true if all Nodes and attributes are equal. Else, returns false.
     *               Throws IllegalArgumentException when argument is null or not a
     *               MyListImpl object.
     * @param    'obj'     --    (Object)   a comparator against this List
     * @returns  (boolean) true if two Lists are equal; false if not equal
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            throw new IllegalArgumentException("Argument must not be null.");
        }

        if (!(obj instanceof MyListImpl)) {
            throw new IllegalArgumentException("Argument must be an instance" +
                    " of the MyListImpl class.");
        }

        MyListImpl other = (MyListImpl) obj;

        if (this.size() != other.size()) {
            return false;
        }

        int counter = 0;
        Node thisIterator = this.head;
        Node otherIterator = other.head;

        // If any Node not equal, return false.
        while (counter < this.size()) {
            if (thisIterator.data != otherIterator.data) {
                return false;
            }
            thisIterator = thisIterator.next;
            otherIterator = otherIterator.next;
            counter++;
        }

        return true;
    }

    /* -----------------------------------------------------------------------------
     * Method    getStrBigNumber
     * Purpose   Returns a String concatenating the value of each Node in reverse
     *               order. Specific to the implementation of BigNumber, where
     *               each Node represents a digit; the Head is the smallest value
     *               digit and the Tail is the largest value digit.
     * @param    None
     * @returns  (String) a String representing a BigNumber
     * ----------------------------------------------------------------------------*/
    public String getStrBigNumber() {

        StringBuilder printable = new StringBuilder();
        Node iterator = this.head;

        while (iterator != null) {
            printable.insert(0, iterator.data);
            iterator = iterator.next;
        }

        return printable.toString();
    }

    /* -----------------------------------------------------------------------------
     * Method    toString
     * Purpose   Returns a String concatenating the value of each Node in order,
     *               with an arrow signifying the 'next' connection.
     * @param    None
     * @returns  (String) a String depicting the Linked List
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {

        StringBuilder printable = new StringBuilder();
        Node iterator = this.head;

        while (iterator != null) {
            printable.append(iterator.data);
            if (iterator.next != null) {
                printable.append(" -> ");
            }
            iterator = iterator.next;
        }

        return printable.toString();
    }

} /* ****************************************************************************** */
