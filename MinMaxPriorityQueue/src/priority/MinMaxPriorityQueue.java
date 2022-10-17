package priority;

public interface MinMaxPriorityQueue<T> {

    void add(T item, int priority);
    T minPriorityItem(); // remove and return item with min priority
    T maxPriorityItem(); // remove and return item with max priority
}
