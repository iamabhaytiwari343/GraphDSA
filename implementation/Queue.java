package implementation;

public class Queue {

    public LinkedList queue;
    public int size;

    public Queue() {
        this.queue = new LinkedList();
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(vertex data) {
        this.queue.addToTail(data);
        this.size++;
    }

    public vertex peek() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.queue.head.data;
        }
    }

    public vertex dequeue() {
        if (!this.isEmpty()) {
            vertex data = this.queue.removeHead();
            this.size--;
            return data;
        } else {
            throw new Error("LinearDataStructures.Queues.Queue is empty!");
        }
    }

}
