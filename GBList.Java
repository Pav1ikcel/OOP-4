interface GBList<T> {
    void insertFirst(T value);
    void insertLast(T value);
    int size();
    T get(int index);
}

class LinkedList<T> implements GBList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void insertFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public void insertLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        GBList<String> linkedList = new LinkedList<>();

        linkedList.insertFirst("First");
        linkedList.insertLast("Second");
        linkedList.insertLast("Third");

        System.out.println("Size: " + linkedList.size());
        System.out.println("Element at index 0: " + linkedList.get(0));
        System.out.println("Element at index 1: " + linkedList.get(1));
        System.out.println("Element at index 2: " + linkedList.get(2));
    }
}
