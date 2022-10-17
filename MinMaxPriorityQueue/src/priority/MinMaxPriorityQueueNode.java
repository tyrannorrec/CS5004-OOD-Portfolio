package priority;

public class MinMaxPriorityQueueNode<T> {

    private T data;
    private int priority;

    public MinMaxPriorityQueueNode(T inData, int inPriority) {
        this.data = inData;
        this.priority = inPriority;
    }

    public T getData() { return this.data; }

    public int getPriority() { return this.priority; }

    @Override
    public String toString() {
        return "data: " + this.data + ", priority: " + this.priority;
    }
}
