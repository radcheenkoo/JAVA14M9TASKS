public class MyLinkedList<T> {
        private Node first;
        private Node second;
        private int size;

        private class Node  {
            T currentVal;
            Node prev;
            Node next;

            Node(T currentVal) {
                this.currentVal = currentVal;
                this.prev = null;
                this.next = null;
            }
        }

        public void add(T value) {
            Node newNode = new Node(value);

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

            Node nodeToRemove = getNodeAtIndex(index);

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

        public void clear() {
            first = null;
            second = null;
            size = 0;
        }

        public int size() {
            return size;
        }

        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of range: " + index);
            }

            Node node = getNodeAtIndex(index);

            return node.currentVal;
        }


        private Node getNodeAtIndex(int index) {
            Node currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }
    }

