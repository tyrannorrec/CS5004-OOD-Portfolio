package bignumber.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyListImplTest {

    MyList testList;

    @Test
    public void testConstructor() {

        Node testHead = new Node(12);
        MyList testListFromHead = new MyListImpl(testHead);
        MyList testListNoNodes = new MyListImpl();
    }

    @Test
    public void testInsertRear() {

        testList = new MyListImpl();
        testList.insertRear(4);
        testList.insertRear(-5);
        testList.insertRear(100);

        assertEquals(4, testList.get(0));
        assertEquals(-5, testList.get(1));
        assertEquals(100, testList.get(2));
    }

    @Test
    public void testInsertFront() {

        testList = new MyListImpl();
        testList.insertFront(4);
        testList.insertFront(-5);
        testList.insertFront(100);

        assertEquals(100, testList.get(0));
        assertEquals(-5, testList.get(1));
        assertEquals(4, testList.get(2));
    }

    @Test
    public void testGet() {

        testList = new MyListImpl();
        testList.insertRear(4);
        testList.insertRear(-5);
        testList.insertRear(100);

        assertEquals(4, testList.get(0));
        assertEquals(-5, testList.get(1));
        assertEquals(100, testList.get(2));
    }

    @Test
    public void testSet() {

        testList = new MyListImpl();
        testList.insertRear(4);
        testList.insertRear(-5);
        testList.insertRear(100);

        testList.set(0, 100);
        testList.set(1, 200);
        testList.set(2, 300);

        assertEquals(100, testList.get(0));
        assertEquals(200, testList.get(1));
        assertEquals(300, testList.get(2));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetException() {

        testList = new MyListImpl();
        testList.insertRear(4);
        testList.insertRear(-5);
        testList.insertRear(100);

        testList.get(4);
    }

    @Test
    public void testRemove() {

        testList = new MyListImpl();                // {}
        testList.insertRear(5);                // {5}
        testList.remove(0);                   // {}
        testList.insertRear(2);                // {2}
        testList.insertRear(4);                // {2, 4}
        testList.insertRear(3);                // {2, 4, 3}
        testList.remove(2);                   // {2, 4}
        testList.insertRear(6);                // {2, 4, 6}
        testList.remove(1);                   // {2, 6}

        assertEquals(2, testList.get(0));
        assertEquals(6, testList.get(1));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexException() {

        testList = new MyListImpl();
        testList.insertRear(5);
        testList.remove(1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmptyList() {

        testList = new MyListImpl();
        testList.remove(1);
    }

    @Test
    public void testSize() {

        MyList testList = new MyListImpl();
        assertEquals(0, testList.size());

        testList.insertRear(10);
        assertEquals(1, testList.size());
        testList.insertRear(1);
        assertEquals(2, testList.size());
        testList.insertRear(5);
        assertEquals(3, testList.size());
    }

    @Test
    public void testSubList() {

        testList = new MyListImpl();
        testList.insertRear(2);
        testList.insertRear(4);
        testList.insertRear(3);
        testList.insertRear(6);
        testList.insertRear(14);

        assertEquals(testList, testList.subList(0, 4));

        MyList testListExpected = new MyListImpl();
        testListExpected.insertRear(4);

        assertEquals(testListExpected, testList.subList(1, 1));

        testListExpected.insertRear(3);
        testListExpected.insertRear(6);

        assertEquals(testListExpected, testList.subList(1, 3));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSubListIndexException() {

        testList = new MyListImpl();
        testList.insertRear(-5);
        testList.insertRear(12);

        testList.subList(1, 2);
    }

    @Test
    public void testEquals() {

        MyList testList1 = new MyListImpl();
        MyList testList2 = new MyListImpl();
        assertEquals(testList1, testList2);

        testList1.insertRear(2);
        assertNotEquals(testList1, testList2);

        testList2.insertRear(2);
        assertEquals(testList1, testList2);

        testList2.insertRear(10);
        assertNotEquals(testList1, testList2);

        testList1.insertRear(10);
        assertEquals(testList1, testList2);

        testList1.insertRear(15);
        testList2.insertRear(15);
        assertEquals(testList1, testList2);

        testList1.insertRear(7);
        testList2.insertRear(8);
        assertNotEquals(testList1, testList2);
    }

    @Test
    public void testToStringBigNumber() {

        testList = new MyListImpl();
        testList.insertRear(2);
        testList.insertRear(4);
        testList.insertRear(3);
        testList.insertRear(6);
        testList.insertRear(4);
        testList.insertRear(1);
        testList.insertRear(5);

        System.out.println(testList.getStrBigNumber());
    }

    @Test
    public void testToString() {

        testList = new MyListImpl();
        testList.insertRear(2);
        testList.insertRear(4);
        testList.insertRear(3);
        testList.insertRear(62);
        testList.insertRear(14);
        testList.insertRear(1);
        testList.insertRear(-15);

        System.out.println(testList);
    }
}