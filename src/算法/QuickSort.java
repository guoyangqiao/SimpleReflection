package 算法;

import java.util.Arrays;

/**
 * 说明:
 * <p>
 * Created by guoyangqiao on 5/24/16.
 */
public class QuickSort {
    private static int[] INTS = getRandomInts();

    private static int[] getRandomInts() {
        int[] randomInts = new int[(int) (Math.random() * 1000)];
        for (int k = 0; k < randomInts.length; ++k) {
            randomInts[k] = (int) (Math.random() * 1000);
        }
        return randomInts;
    }

    private void exchangeTwoInt(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public void run(int[] array, int start, int end) {
        if (start == end) return;
        int i = start;
        int j = end - 1;
        int pivot = start;
        int key = array[pivot];
        while (i != j) {
            for (; j > i; --j) {
                if (array[j] < key) {
                    exchangeTwoInt(array, pivot, j);
                    pivot = j;
                    break;
                }
            }
            for (; i < j; ++i) {
                if (array[i] > key) {
                    exchangeTwoInt(array, pivot, i);
                    pivot = i;
                    break;
                }
            }
        }
        run(array, start, pivot);
        run(array, pivot + 1, end);
    }

    public static void main(String[] args) {
        new QuickSort().run(INTS, 0, INTS.length);
        System.out.println(Arrays.toString(QuickSort.INTS));
    }
}