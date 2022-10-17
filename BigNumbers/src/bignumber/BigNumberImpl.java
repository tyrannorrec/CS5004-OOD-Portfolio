package bignumber;
import bignumber.linkedlist.*;

import java.util.Objects;

/* ******************************************************************************
 * Class     BigNumberImpl
 * Purpose   The BigNumberImpl class implements the BigNumber interface. A BigNumber
 *               represents a non-negative number of arbitrary length. Using a
 *               Linked List (via the MyListImpl class), it stores each digit of
 *               the number in a single node of the List, with the least significant
 *               digit at the Head of the List and the most significant digit at the
 *               Tail of the List. Methods are included to shift the number left or
 *               right, to get the length (number of digits) in the BigNumber, to copy
 *               the number, and to return the digit at a certain position in the number.
 *               Methods are also implemented to add a digit to the value of the BigNumber,
 *               and to add two BigNumbers together. `toString`, `equals`, and `compareTo`
 *               have also been implemented.
 * @attrib   'digitList'      --    (MyList)    a List containing the digits of the number
 * ***************************************************************************** */
public class BigNumberImpl implements BigNumber {

    private MyList digitList;

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a BigNumberImpl object, setting the value of the BigNumber
     *               to 0 by instantiating the digitList with a single node with
     *               the value 0.
     * ----------------------------------------------------------------------------*/
    public BigNumberImpl() {

        this.digitList = new MyListImpl();
        this.digitList.insertRear(0);
    }

    /* -----------------------------------------------------------------------------
     * Method    Constructor
     * Purpose   Creates a BigNumberImpl object from a number represented as a String.
     *               Reads the String one char at a time into the digitList. throws
     *               NumberFormatException if a negative integer or non-numeric char
     *               is encountered. Also checks for and removes leading zeroes.
     * @param    'numberAsString'     --    (String)  a String representing a number.
     * ----------------------------------------------------------------------------*/
    public BigNumberImpl(String numberAsString) {

        this.digitList = new MyListImpl();

        // If empty String, initialize value to 0.
        if (Objects.equals(numberAsString, "")) {
            this.digitList.insertRear(0);
            return;
        }

        char currChar;

        // For every char in String, insertFront. If any char is non-numeric, throw exception
        for (int i = 0; i < numberAsString.length(); i++) {
            currChar = numberAsString.charAt(i);

            if (currChar < '0' || currChar > '9') {
                throw new NumberFormatException("The String must represent a valid non-negative integer.");
            }

            this.digitList.insertFront(currChar - '0');
        }

        // Delete leading zeroes if applicable
        int tailIndex = this.length() - 1;
        while (this.length() > 1 && this.getDigitAt(tailIndex) == 0) {
            this.digitList.remove(tailIndex);
            tailIndex--;
        }
    }

    /* -----------------------------------------------------------------------------
     * Method    length
     * Purpose   Returns the number of digits in the BigNumber
     * @param    None
     * @returns  (int) the number of digits in the BigNumber
     * ----------------------------------------------------------------------------*/
    @Override
    public int length() {

        return this.digitList.size();
    }

    /* -----------------------------------------------------------------------------
     * Method    shiftLeft
     * Purpose   Left-shift BigNumber by one position. Equivalent to multiplying by 10.
     *               If called with negative numOfShifts, calls shiftRight with positive
     *               numOfShifts instead.
     * @param    'numOfShifts'      --      (int)   the number of times to left-shift
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void shiftLeft(int numOfShifts) {

        if (numOfShifts == 0) {
            return;
        }

        // If BigNumber is 0, return
        if (this.length() == 1 && this.getDigitAt(0) == 0) {
            return;
        }

        // If numOfShifts is negative, call shiftRight
        if (numOfShifts < 0) {
            this.shiftRight(-1 * numOfShifts);
            return;
        }

        // General case
        for (int i = 0; i < numOfShifts; i++) {
            this.digitList.insertFront(0);
        }
    }

    /* -----------------------------------------------------------------------------
     * Method    shiftRight
     * Purpose   Right-shift BigNumber by one position. Equivalent to div 10.
     *               If called with negative numOfShifts, calls shiftLeft with positive
     *               numOfShifts instead.
     * @param    'numOfShifts'      --      (int)   the number of times to right-shift
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void shiftRight(int numOfShifts) {

        if (numOfShifts == 0) {
            return;
        }

        // If BigNumber is 0, return
        if (this.length() == 1 && this.getDigitAt(0) == 0) {
            return;
        }

        // If numOfShifts is negative, call shiftLeft
        if (numOfShifts < 0) {
            this.shiftLeft(-1 * numOfShifts);
            return;
        }

        // If numOfShifts is greater than length,
        // set to length and insert extra Node with value 0
        if (numOfShifts >= this.length()) {
            numOfShifts = this.length();
            this.digitList.insertRear(0);
        }

        // General case
        for (int i = 0; i < numOfShifts; i++) {
            this.digitList.remove(0);
        }
    }

    /* -----------------------------------------------------------------------------
     * Method    addDigit
     * Purpose   Add to BigNumber the value of a single digit. Throws IllegalArgumentException
     *               if argument is not a valid digit.
     * @param    'inDigit'      --      (int)   the value to add to the BigNumber
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void addDigit(int inDigit) {

        if (inDigit < 0 || inDigit > 9) {
            throw new IllegalArgumentException("The addend must be a single non-negative digit.");
        }

        int currIndex = 0;
        int currDigitValue = inDigit;
        boolean carry = true;

        // While carry flag is true
        while (carry) {

            // If no more Nodes and the carry flag is still true,
            // insert new Node at Rear to hold the 1
            if (currIndex == this.length()) {
                this.digitList.insertRear(1);
                carry = false;
            }

            // Else, if currIndex < this.length()
            else {
                // Get carry + current index value
                currDigitValue += this.getDigitAt(currIndex);

                // If total value is single digit, then just set value
                // to this Node and end loop
                if (currDigitValue <= 9) {
                    this.digitList.set(currIndex, currDigitValue);
                    carry = false;
                }

                // Else, if total value is two digits, set value of
                // current Node and carry 1 to next Node
                else {
                    currDigitValue -= 10;
                    this.digitList.set(currIndex, currDigitValue);
                    currDigitValue = 1;
                    currIndex++;
                }
            }
        }
    }

    /* -----------------------------------------------------------------------------
     * Method    getDigitAt
     * Purpose   Returns digit at the specified position. Throws IllegalArgumentException
     *               if position is out of bounds.
     * @param    'position'      --      (int)   the position of the digit
     * @returns  (int) the digit at the specified position
     * ----------------------------------------------------------------------------*/
    @Override
    public int getDigitAt(int position) {

        if (position < 0 || position >= this.length()) {
            throw new IllegalArgumentException("Invalid position passed.");
        }

        return this.digitList.get(position);
    }

    /* -----------------------------------------------------------------------------
     * Method    setDigitAt
     * Purpose   Sets digit at the specified position. Throws IllegalArgumentException
     *               if position is out of bounds.
     * @param    'position'      --      (int)   the position of the digit
     * @param    'inDigit'       --      (int)   the value to set at the position
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void setDigitAt(int position, int inDigit) {

        if (position < 0 || position >= this.length()) {
            throw new IllegalArgumentException("Invalid position passed.");
        }

        this.digitList.set(position, inDigit);
    }

    /* -----------------------------------------------------------------------------
     * Method    copy
     * Purpose   Returns a copy of this BigNumber obj.
     * @param    None
     * @returns  (BigNumber) a copy of this BigNumber obj
     * ----------------------------------------------------------------------------*/
    @Override
    public BigNumber copy() {

        MyList digitListCopy = this.digitList.subList(0, this.length() - 1);
        BigNumber bigNumberCopy = new BigNumberImpl();
        bigNumberCopy.setDigitList(digitListCopy);

        return bigNumberCopy;
    }

    /* -----------------------------------------------------------------------------
     * Method    add
     * Purpose   Adds two BigNumbers together and returns the value as a new
     *               BigNumber object.
     * @param    'other'      --      (BigNumber)   the second addend
     * @returns  (BigNumber) the sum of the two BigNumbers
     * ----------------------------------------------------------------------------*/
    @Override
    public BigNumber add(BigNumber other) {

        // Create new BigNumber obj and empty the digitList
        BigNumberImpl newNumber = new BigNumberImpl();
        newNumber.getDigitList().remove(0);

        int currIndex = 0;
        int thisIndexSum;
        int carryValue = 0;

        // While index is less than the smaller length of the two BigNumbers
        while (currIndex < this.length() && currIndex < other.length()) {

            // Get the sum of the two digits at the same position plus any value carried from
            // previous index
            thisIndexSum = this.getDigitAt(currIndex) + other.getDigitAt(currIndex) + carryValue;

            // If sum is single digit, insert sum into newNumber and set carry to 0
            if (thisIndexSum <= 9) {
                newNumber.getDigitList().insertRear(thisIndexSum);
                carryValue = 0;
            }

            // Else, if sum is two digits, insert sum into newNumber and set carry value
            else {
                carryValue = thisIndexSum;
                thisIndexSum = thisIndexSum % 10;
                newNumber.getDigitList().insertRear(thisIndexSum);
                carryValue = (carryValue - thisIndexSum) / 10;
            }
            currIndex++;
        }

        // CASE in which this is longer than other
        while (currIndex < this.length()) {
            thisIndexSum = this.getDigitAt(currIndex) + carryValue;
            if (thisIndexSum <= 9) {
                newNumber.getDigitList().insertRear(thisIndexSum);
                carryValue = 0;
            }
            else { // If thisIndexSum > 9
                carryValue = thisIndexSum;
                thisIndexSum = thisIndexSum % 10;
                newNumber.getDigitList().insertRear(thisIndexSum);
                carryValue = (carryValue - thisIndexSum) / 10;
            }
            currIndex++;
        }

        // CASE in which other is longer than this
        while (currIndex < other.length()) {
            thisIndexSum = other.getDigitAt(currIndex) + carryValue;
            if (thisIndexSum <= 9) {
                newNumber.getDigitList().insertRear(thisIndexSum);
                carryValue = 0;
            }
            else { // If thisIndexSum > 9
                carryValue = thisIndexSum;
                thisIndexSum = thisIndexSum % 10;
                newNumber.getDigitList().insertRear(thisIndexSum);
                carryValue -= thisIndexSum;
            }
            currIndex++;
        }

        // If all nodes accounted for and there is still a carryValue, insert at Rear
        if (carryValue > 0) {
            newNumber.getDigitList().insertRear(carryValue);
        }

        return newNumber;
    }

    /* -----------------------------------------------------------------------------
     * Method    getDigitList
     * Purpose   Returns the digitList.
     * @param    None
     * @returns  (MyList) the digits of the BigNumber as a Linked List
     * ----------------------------------------------------------------------------*/
    @Override
    public MyList getDigitList() {

        return this.digitList;
    }

    /* -----------------------------------------------------------------------------
     * Method    setDigitList
     * Purpose   Replaces the digitList with a new digitList.
     * @param    'inDigitList'  --  (MyList)    a list of digits representing a BigNumber
     * @returns  None
     * ----------------------------------------------------------------------------*/
    @Override
    public void setDigitList(MyList inDigitList) {

        this.digitList = inDigitList;
    }

    /* -----------------------------------------------------------------------------
     * Method    compareTo
     * Purpose   Compares two BigNumbers. Returns -1 if this is smaller than other,
     *               returns 1 if this is larger than other, and 0 is they are equal.
     * @param    'other'  --  (BigNumber)    a BigNumber object
     * @returns  (int) 1, 0, or -1, depending on whether this is larger than, equal
     *               to, or smaller than other
     * ----------------------------------------------------------------------------*/
    @Override
    public int compareTo(BigNumber other) {

        // Compare lengths
        if (this.length() > other.length()) {
            return 1;
        }

        else if (this.length() < other.length()) {
            return -1;
        }

        // If lengths are equal, compare Nodes from most significant to least significant Nodes
        else {
            for (int i = this.length() - 1; i >= 0; i--) {
                if (this.getDigitAt(i) > other.getDigitAt(i)) {
                    return 1;
                } else if (this.getDigitAt(i) < other.getDigitAt(i)) {
                    return -1;
                }
            }
        }

        // If no returns are triggered by conditionals, then the numbers are equal
        return 0;
    }

    /* -----------------------------------------------------------------------------
     * Method    equals
     * Purpose   Returns true if BigNumbers are equal. Else, returns false.
     *               Throws IllegalArgumentException when argument is null or not a
     *               BigNumberImpl object.
     * @param    'obj'     --    (Object)   a comparator against this BigNumber
     * @returns  (boolean) true if two BigNumbers are equal; false if not equal
     * ----------------------------------------------------------------------------*/
    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            throw new IllegalArgumentException("Argument must not be null.");
        }

        if (!(obj instanceof BigNumberImpl)) {
            throw new IllegalArgumentException("Argument must be an instance" +
                    " of the BigNumberImpl class.");
        }

        BigNumberImpl other = (BigNumberImpl) obj;
        return Objects.equals(this.toString(), other.toString());
    }

    /* -----------------------------------------------------------------------------
     * Method    toString
     * Purpose   Returns String representation of the BigNumber. Calls relevant
     *               method in MyListImpl class.
     * @param    None
     * @returns  (String) String representation of the BigNumber
     * ----------------------------------------------------------------------------*/
    @Override
    public String toString() {

        return this.digitList.getStrBigNumber();
    }

} /* ****************************************************************************** */
