package implementation;

public class LinkedList {

    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(vertex data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(vertex data) {
        Node tail = this.head;
        if (tail == null) {
            this.head = new Node(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node(data));
        }
    }

    public vertex removeHead() {
        Node removedHead = this.head;
        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNextNode();
        return removedHead.data;
    }
}