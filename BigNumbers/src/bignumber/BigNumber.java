package bignumber;
import bignumber.linkedlist.*;

/* ******************************************************************************
 * Interface  BigNumber
 * Purpose    The BigNumber interface models a positive integer of arbitrary length,
 *                represented by its digits. Individual digits are to be stored in
 *                a single node of a Linked List. Methods included provide the
 *                ability to left-shift or right-shift a BigNumber, to get the length
 *                or a copy of the BigNumber, as well as to add a digit to the value
 *                of the BigNumber, and to add two BigNumbers together. The interface
 *                extends Comparable<BigNumber> and overrides the `compareTo` method
 *                for the class. It also overrides the `toString` and `equals` methods.
 *                BigNumber is implemented by the BigNumberImpl concrete class.
 * ***************************************************************************** */
public interface BigNumber extends Comparable<BigNumber> {

    /* -----------------------------------------------------------------------------
     * Method    length
     * Purpose   Returns the number of digits in the BigNumber
     * @param    None
     * @returns  (int) the number of digits in the BigNumber
     * ----------------------------------------------------------------------------*/
    int length();

    /* -----------------------------------------------------------------------------
     * Method    shiftLeft
     * Purpose   Left-shift BigNumber by one position. Equivalent to multiplying by 10.
     *               If called with negative numOfShifts, calls shiftRight with positive
     *               numOfShifts instead.
     * @param    'numOfShifts'      --      (int)   the number of times to left-shift
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void shiftLeft(int numOfShifts);

    /* -----------------------------------------------------------------------------
     * Method    shiftRight
     * Purpose   Right-shift BigNumber by one position. Equivalent to div 10.
     *               If called with negative numOfShifts, calls shiftLeft with positive
     *               numOfShifts instead.
     * @param    'numOfShifts'      --      (int)   the number of times to right-shift
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void shiftRight(int numOfShifts);

    /* -----------------------------------------------------------------------------
     * Method    addDigit
     * Purpose   Add to BigNumber the value of a single digit. Throws IllegalArgumentException
     *               if argument is not a valid digit.
     * @param    'inDigit'      --      (int)   the value to add to the BigNumber
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void addDigit(int inDigit);

    /* -----------------------------------------------------------------------------
     * Method    getDigitAt
     * Purpose   Returns digit at the specified position. Throws IllegalArgumentException
     *               if position is out of bounds.
     * @param    'position'      --      (int)   the position of the digit
     * @returns  (int) the digit at the specified position
     * ----------------------------------------------------------------------------*/
    int getDigitAt(int position);

    /* -----------------------------------------------------------------------------
     * Method    setDigitAt
     * Purpose   Sets digit at the specified position. Throws IllegalArgumentException
     *               if position is out of bounds.
     * @param    'position'      --      (int)   the position of the digit
     * @param    'inDigit'       --      (int)   the value to set at the position
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setDigitAt(int position, int inDigit);

    /* -----------------------------------------------------------------------------
     * Method    copy
     * Purpose   Returns a copy of this BigNumber obj.
     * @param    None
     * @returns  (BigNumber) a copy of this BigNumber obj
     * ----------------------------------------------------------------------------*/
    BigNumber copy();

    /* -----------------------------------------------------------------------------
     * Method    add
     * Purpose   Adds two BigNumbers together and returns the value as a new
     *               BigNumber object.
     * @param    'other'      --      (BigNumber)   the second addend
     * @returns  (BigNumber) the sum of the two BigNumbers
     * ----------------------------------------------------------------------------*/
    BigNumber add(BigNumber other);

    /* -----------------------------------------------------------------------------
     * Method    getDigitList
     * Purpose   Returns the digitList.
     * @param    None
     * @returns  (MyList) the digits of the BigNumber as a Linked List
     * ----------------------------------------------------------------------------*/
    MyList getDigitList();

    /* -----------------------------------------------------------------------------
     * Method    setDigitList
     * Purpose   Replaces the digitList with a new digitList.
     * @param    'inDigitList'  --  (MyList)    a list of digits representing a BigNumber
     * @returns  None
     * ----------------------------------------------------------------------------*/
    void setDigitList(MyList inDigitList);

    /* -----------------------------------------------------------------------------
     * Method    compareTo
     * Purpose   Compares two BigNumbers. Returns -1 if this is smaller than other,
     *               returns 1 if this is larger than other, and 0 is they are equal.
     * @param    'other'  --  (BigNumber)    a BigNumber object
     * @returns  (int) 1, 0, or -1, depending on whether this is larger than, equal
     *               to, or smaller than other
     * ----------------------------------------------------------------------------*/
    @Override
    int compareTo(BigNumber other);

    /* -----------------------------------------------------------------------------
     * Method    equals
     * Purpose   Returns true if BigNumbers are equal. Else, returns false.
     *               Throws IllegalArgumentException when argument is null or not a
     *               BigNumberImpl object.
     * @param    'obj'     --    (Object)   a comparator against this BigNumber
     * @returns  (boolean) true if two BigNumbers are equal; false if not equal
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean equals(Object obj);

    /* -----------------------------------------------------------------------------
     * Method    toString
     * Purpose   Returns String representation of the BigNumber. Calls relevant
     *               method in MyListImpl class.
     * @param    None
     * @returns  (String) String representation of the BigNumber
     * ----------------------------------------------------------------------------*/
    @Override
    String toString();

} /* ****************************************************************************** */
