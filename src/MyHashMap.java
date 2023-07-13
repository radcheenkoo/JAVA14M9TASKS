import static java.util.Objects.hash;

public class MyHashMap<T, E> {
    private Node[] arr;
    private int capacity;
    private int size = 0;

    public MyHashMap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.arr = new Node[capacity];
    }

    private int hash(T key) {
        return Math.abs(key.hashCode() % capacity);
    }
    public void put(T key, E value) {
        int index = hash(key);

        Node newNode = new Node( key, value);

        if (arr[index] == null) {
            arr[index] = newNode;
        } else {
            Node currentNode = arr[index];
            while (currentNode.getNext() != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    return;
                }
                currentNode = currentNode.getNext();
            }
            if (currentNode.getKey().equals(key)) {
                currentNode.setValue(value);
            } else {
                currentNode.setNext(newNode);
            }
        }
        size++;
    }
    public void remove(T key){
        int i = hash(key);

        if (arr[i] == null){
            return;
        }
        Node currentN = arr[i];
        Node prevN = null;

        while(currentN != null){
            if (currentN.getKey().equals(key)){
                if (prevN == null){
                    arr[i] = currentN.getNext();
                }
                else {
                    prevN.setNext(currentN.getNext());
                }
                size --;
                return;
            }
            prevN = currentN;
            currentN = currentN.getNext();
        }
    }
    public void clear(){
        arr = new Node[capacity];
        size = 0;
    }

    public int size(){
        return size;
    }
    public E get(T key){
        int i = hash(key);
        Node currentN = arr[i];

        while (currentN != null){
            if (currentN.getKey().equals(key)){
                return (E) currentN.getValue();
            }
            currentN = currentN.getNext();
        }
        return null;
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
