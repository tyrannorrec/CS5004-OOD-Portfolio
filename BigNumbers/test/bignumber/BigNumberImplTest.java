package bignumber;
import bignumber.linkedlist.*;

import org.junit.Test;
import static org.junit.Assert.*;


public class BigNumberImplTest {

    @Test
    public void testConstructor() {

        BigNumber test1 = new BigNumberImpl();
        assertEquals("0", test1.toString());

        String numString2 = "81726100";
        BigNumber test2 = new BigNumberImpl(numString2);
        assertEquals(numString2, test2.toString());

        String numString3 = "000098342720857200050003";
        BigNumber test3 = new BigNumberImpl(numString3);
        assertEquals("98342720857200050003", test3.toString());

        String numString4 = "";
        BigNumber test4 = new BigNumberImpl(numString4);
        assertEquals("0", test4.toString());
    }

    @Test (expected = NumberFormatException.class)
    public void testConstructorException() {

        BigNumber test = new BigNumberImpl("1000a149");
    }

    @Test
    public void testLength() {

        BigNumber test1 = new BigNumberImpl();
        assertEquals(1, test1.length());

        BigNumber test2 = new BigNumberImpl("2110000");
        assertEquals(7, test2.length());

        BigNumber test3 = new BigNumberImpl("81641746001172846197");
        assertEquals(20, test3.length());
    }

    @Test
    public void testShiftLeft() {

        BigNumber test1 = new BigNumberImpl();
        BigNumber test2 = new BigNumberImpl();
        test1.shiftLeft(5);
        assertEquals(test2, test1);

        test1 = new BigNumberImpl("5");
        test2 = new BigNumberImpl("5000");
        test1.shiftLeft(3);
        assertEquals(test2, test1);

        test2 = new BigNumberImpl("50");
        test1.shiftLeft(-2);
        assertEquals(test2, test1);

        test1 = new BigNumberImpl();
        test2 = new BigNumberImpl();
        test1.shiftLeft(-10);
        assertEquals(test2, test1);
    }

    @Test
    public void testShiftRight() {

        BigNumber test1 = new BigNumberImpl();
        BigNumber test2 = new BigNumberImpl();
        test1.shiftRight(5);
        assertEquals(test2, test1);

        test1 = new BigNumberImpl("147888");
        test2 = new BigNumberImpl("147");
        test1.shiftRight(3);
        assertEquals(test2, test1);

        test2 = new BigNumberImpl("14700000");
        test1.shiftRight(-5);
        assertEquals(test2, test1);

        test2 = new BigNumberImpl();
        test1.shiftRight(1000);
        assertEquals(test2, test1);

        test1 = new BigNumberImpl("1");
        test2 = new BigNumberImpl();
        test1.shiftRight(2);
        assertEquals(test2, test1);
    }

    @Test
    public void testGetDigitAt() {

        BigNumber test = new BigNumberImpl("1999");
        test.addDigit(1);
        assertEquals("2000", test.toString());

        test = new BigNumberImpl("5876");
        test.addDigit(9);
        assertEquals("5885", test.toString());
    }

    @Test
    public void testSetDigitAt() {

        BigNumber test = new BigNumberImpl("1999");
        test.setDigitAt(1, 1);
        assertEquals("1919", test.toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddDigitException() {

        BigNumber test = new BigNumberImpl("1999");
        test.addDigit(12);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetDigitAtException() {

        BigNumber test = new BigNumberImpl("2110000");
        test.getDigitAt(7);
    }

    @Test
    public void testCopy() {

        BigNumber test1 = new BigNumberImpl("123456789");
        BigNumber test2 = test1.copy();
        assertEquals(test1, test2);

        test1 = new BigNumberImpl();
        test2 = new BigNumberImpl();
        assertEquals(test1, test2);

        test1 = new BigNumberImpl("123");
        test2 = new BigNumberImpl("456");
        assertNotEquals(test1, test2);
    }

    @Test
    public void testAdd() {

        BigNumber test1 = new BigNumberImpl("99999");
        BigNumber test2 = new BigNumberImpl("1");
        BigNumber test3 = test1.add(test2);

        assertEquals("100000", test3.toString());

        test1 = new BigNumberImpl("146179");
        test2 = new BigNumberImpl("1740170310999");
        test3 = test1.add(test2);

        assertEquals("1740170457178", test3.toString());

        test1 = new BigNumberImpl("7502759287502846283");
        test2 = new BigNumberImpl("2871907985729758402");
        test3 = test1.add(test2);

        assertEquals("10374667273232604685", test3.toString());

        test1 = new BigNumberImpl("0");
        test2 = new BigNumberImpl("0");
        test3 = test1.add(test2);

        assertEquals("0", test3.toString());
    }

    @Test
    public void testGetDigitList() {

        BigNumber testBigNumber = new BigNumberImpl("913");
        MyList testList = new MyListImpl();
        testList.insertRear(3);
        testList.insertRear(1);
        testList.insertRear(9);

        assertEquals(testList, testBigNumber.getDigitList());
    }

    @Test
    public void testSetDigitList() {

        BigNumber testBigNumber = new BigNumberImpl();
        MyList testList = new MyListImpl();
        testList.insertRear(3);
        testList.insertRear(1);
        testList.insertRear(9);

        testBigNumber.setDigitList(testList);
        assertEquals("913", testBigNumber.toString());
    }

    @Test
    public void testCompareTo() {

        BigNumber test1 = new BigNumberImpl("1");
        BigNumber test2 = new BigNumberImpl("2");

        assertEquals(-1, test1.compareTo(test2));

        test1 = new BigNumberImpl("234567");
        test2 = new BigNumberImpl("234067");

        assertEquals(1, test1.compareTo(test2));
        assertEquals(-1, test2.compareTo(test1));

        test1 = new BigNumberImpl("999999999999999");
        test2 = new BigNumberImpl("999999999999999");

        assertEquals(0, test1.compareTo(test2));
    }

    @Test
    public void testEquals() {

        BigNumber test1 = new BigNumberImpl("14111");
        BigNumber test2 = new BigNumberImpl("13111");

        assertNotEquals(test1, test2);

        test1 = new BigNumberImpl("718461");
        test2 = new BigNumberImpl("718461");

        assertEquals(test1, test2);
    }

    @Test
    public void testToString() {

        BigNumber test1 = new BigNumberImpl("7502759287502846283");
        System.out.println(test1);

        BigNumber test2 = new BigNumberImpl();
        System.out.println(test2);
    }

}