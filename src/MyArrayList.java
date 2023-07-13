import java.util.Arrays;

public class MyArrayList<T> {
    private T[] arr = (T[]) new Object[1];
    private int size = 0;
    public void add(T value){
        supportMethod(size + 1);
        arr[size++] = value;
    }
    private void supportMethod(int minValue) {
        int currentLength = arr.length;
        if (minValue > currentLength) {
            int newCapacity = Math.max(currentLength * 2, minValue);
            T[] newArray = Arrays.copyOf(arr, newCapacity);
            arr = newArray;
        }
    }

    public void remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        for(int i = index; i < size - 1; i++){
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;

    }
    public void clear(){
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public T getValue(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return arr[index];
    }
}
