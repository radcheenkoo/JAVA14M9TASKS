import java.util.Arrays;

public class MyQueue<T> {
    private T[] array = (T[]) new Object[1];
    private int size = 0;

    public void add(T value){
        supportMethod(size + 1);
        array[size++] = value;
    }
    private void supportMethod(int minValue) {
        int currentLength = array.length;
        if (minValue > currentLength) {
            int newCapacity = Math.max(currentLength * 2, minValue);
            T[] newArray = Arrays.copyOf(array, newCapacity);
            array = newArray;
        }
    }
    public void clear(){
        size = 0;
    }

    public int size(){
        return size;
    }

    public T peek(){
        return array[0];
    }
    public T poll(){
        T value = array[0];
        for(int i = 0; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return value;
    }
}
