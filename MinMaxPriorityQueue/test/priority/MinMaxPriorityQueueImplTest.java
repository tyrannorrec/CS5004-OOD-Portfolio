package priority;

import static org.junit.Assert.*;
import org.junit.Test;

public class MinMaxPriorityQueueImplTest {

    MinMaxPriorityQueue<Integer> intTest;
    MinMaxPriorityQueue<String> strTest;

    @Test
    public void testConstructor() {
        intTest = new MinMaxPriorityQueueImpl<>();
        strTest = new MinMaxPriorityQueueImpl<>();
    }

    @Test
    public void testAdd() {
        intTest = new MinMaxPriorityQueueImpl<>();
        intTest.add(5, 8);
        intTest.add(8, 2);
        intTest.add(10, 10);
        intTest.add(2, 8);
        intTest.add(3, 1);
        System.out.println(intTest.toString());

        strTest = new MinMaxPriorityQueueImpl<>();
        strTest.add("Hello", 8);
        strTest.add("World", 2);
        strTest.add("Today", 3);
        strTest.add("Goodbye", 8);
        System.out.println(strTest.toString());
    }

    @Test
    public void testMinPriorityItem() {
        intTest = new MinMaxPriorityQueueImpl<>();
        intTest.add(5, 8);
        intTest.add(8, 2);
        intTest.add(10, 10);
        intTest.add(2, 8);
        intTest.add(3, 1);
        Integer minInt = intTest.minPriorityItem();
        assertEquals((Integer)3, minInt);

        strTest = new MinMaxPriorityQueueImpl<>();
        strTest.add("Hello", 8);
        strTest.add("World", 2);
        strTest.add("Today", 3);
        strTest.add("Goodbye", 8);
        String minStr = strTest.minPriorityItem();
        assertEquals("World", minStr);
    }

    @Test
    public void testMaxPriorityItem() {
        intTest = new MinMaxPriorityQueueImpl<>();
        intTest.add(5, 8);
        intTest.add(8, 2);
        intTest.add(10, 10);
        intTest.add(2, 8);
        intTest.add(3, 1);
        Integer maxInt = intTest.maxPriorityItem();
        assertEquals((Integer)10, maxInt);
        maxInt = intTest.maxPriorityItem();
        assertEquals((Integer)2, maxInt);

        strTest = new MinMaxPriorityQueueImpl<>();
        strTest.add("Hello", 8);
        strTest.add("World", 2);
        strTest.add("Today", 3);
        strTest.add("Goodbye", 8);
        String maxStr = strTest.maxPriorityItem();
        assertEquals("Goodbye", maxStr);
        maxStr = strTest.maxPriorityItem();
        assertEquals("Hello", maxStr);
    }

}