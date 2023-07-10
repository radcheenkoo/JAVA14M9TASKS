public class MyStack<E> {
    private MyStack.Node first;
    private MyStack.Node second;
    private int size;
    private class Node  {
        E currentVal;
        MyStack.Node prev;
        MyStack.Node next;

        Node(E currentVal) {
            this.currentVal = currentVal;
            this.prev = null;
            this.next = null;
        }
    }
    public void push(E value) {
        MyStack<E>.Node newNode = new MyStack<E>.Node(value);

        if (first == null) {
            first = newNode;
            second = newNode;
        } else {
            newNode.prev = second;
            second.next = newNode;
            second = newNode;
        }

        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        MyStack.Node nodeToRemove = getNodeAtIndex(index);

        if (nodeToRemove == first) {
            first = first.next;
        } else if (nodeToRemove == second) {
            second = second.prev;
        } else {
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }

        size--;
    }
    public int size(){
        return size;
    }
    public E peek(){

        MyStack<E>.Node node = getNodeAtIndex(0);
        return node.currentVal;
    }
    public E pop(){
        MyStack<E>.Node node = getNodeAtIndex(0);

        E value = node.currentVal;
        if (node == first) {
            first = first.next;
        } else if (node == second) {
            second = second.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        size--;

        return value;
    }
    private MyStack<E>.Node getNodeAtIndex(int index) {
        MyStack<E>.Node currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}
