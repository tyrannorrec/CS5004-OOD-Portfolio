package priority;

import java.util.ArrayList;

public class MinMaxPriorityQueueImpl<T> implements MinMaxPriorityQueue<T> {

    private ArrayList<MinMaxPriorityQueueNode<T>> list;
    private int size;

    public MinMaxPriorityQueueImpl() {
        this.list = new ArrayList<>();
        this.size = 0;
    }

    @Override
    public void add(T item, int priority) {

        MinMaxPriorityQueueNode<T> newNode = new MinMaxPriorityQueueNode<>(item, priority);

        int index = 0;
        while (index < this.size) {
            if (this.list.get(index).getPriority() > newNode.getPriority()) {
                break;
            }
            index++;
        }

        this.list.add(index, newNode);
        this.size++;
    }

    @Override
    public T minPriorityItem() {

        if (this.size == 0) {
            return null;
        }

        MinMaxPriorityQueueNode<T> minNode = this.list.remove(0);
        this.size--;
        return minNode.getData();
    }

    @Override
    public T maxPriorityItem() {

        if (this.size == 0) {
            return null;
        }

        MinMaxPriorityQueueNode<T> maxNode = this.list.remove(size - 1);
        this.size--;
        return maxNode.getData();
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s.concat("Node " + i + " -> [" + this.list.get(i).toString() + "]\n");
        }
        return s;
    }

}
