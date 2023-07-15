import static java.util.Objects.hash;

public class MyHashMap<T,E> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node[] arr;
    private int size;
    public MyHashMap() {
        arr = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(T key, E value) {
        int index = hash(key) % arr.length;
        Node newNode = new Node(key, value);

        if (arr[index] == null) {
            arr[index] = newNode;
            size++;
        } else {
            Node currentNode = arr[index];
            Node prevNode = null;

            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }

                prevNode = currentNode;
                currentNode = currentNode.next;
            }

            prevNode.next = newNode;
            size++;
        }

        if ((double) size / arr.length >= LOAD_FACTOR) {
            resizeArray();
        }
    }

    public void remove(T key) {
        int index = hash(key) % arr.length;

        Node currentNode = arr[index];
        Node prevNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    arr[index] = currentNode.next;
                } else {
                    prevNode.next = currentNode.next;
                }
                size--;
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void clear() {
        arr = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(T key) {
        int index = hash(key) % arr.length;

        Node currentNode = arr[index];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return (E) currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    private int hash(T key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode());
    }

    private void resizeArray() {
        int newCapacity = arr.length * 2;
        Node[] newArr = new Node[newCapacity];

        for (Node node : arr) {
            Node currentNode = node;
            while (currentNode != null) {
                int newIndex = hash((T) currentNode.key) % newCapacity;
                Node nextNode = currentNode.next;

                currentNode.next = newArr[newIndex];
                newArr[newIndex] = currentNode;

                currentNode = nextNode;
            }
        }

        arr = newArr;
    }

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
class Node<T,E> {
    private T key;
    private E value;
    private Node next;

    public Node(T key, E value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public T getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
