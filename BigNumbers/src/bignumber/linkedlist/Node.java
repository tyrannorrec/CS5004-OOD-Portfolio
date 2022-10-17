package bignumber.linkedlist;

/* ******************************************************************************
 * Class     Node
 * Purpose   The Node class represents a Node in a List. Each Node holds data
 *               of the int type and a pointer to the next Node in the List.
 * @attrib   'data'           --    (int)     the Node at the head of the List
 * @attrib   'next'           --    (Node)    the next Node in the List
 * ***************************************************************************** */
public class Node {

    protected int data;
    protected Node next;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a Node object with an int value as its data. `next` is set
     *               to null. Used when inserting into the Rear of List.
     * @param    'inData'     --    (int)    the value held by the Node
     * ----------------------------------------------------------------------------*/
    public Node(int inData) {

        this.data = inData;
        this.next = null;
    }

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a Node object with an int value as its data. `next` is set
     *               to the Node passed in to the Constructor, `inNext`. Used when
     *               inserting into the Front of List.
     * @param    'inData'     --    (int)    the value held by the Node
     * @param    'inNext'     --    (Node)   next Node in the List
     * ----------------------------------------------------------------------------*/
    public Node(int inData, Node inNext) {

        this.data = inData;
        this.next = inNext;
    }

    /* -----------------------------------------------------------------------------
     * Method    toString
     * Purpose   Returns the value of the Node as a String
     * @param    None
     * @returns  (String)  the value of the Node as a String
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {
        return Integer.toString(this.data);
    }

} /* ****************************************************************************** */
