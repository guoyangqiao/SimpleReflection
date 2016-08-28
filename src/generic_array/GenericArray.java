package generic_array;

import java.lang.reflect.Array;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 4/21/16.
 */
public class GenericArray<T> {
    private T[] array;

    public GenericArray(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        this.array[index] = item;
    }

    public T get(int index) {
        return this.array[index];
    }

    public T[] rep() {
        return this.array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> integerGenericArray = new GenericArray<>(Integer.class, 10);
        Integer[] rep = integerGenericArray.rep();
    }
}