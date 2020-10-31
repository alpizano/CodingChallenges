import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
//        Integer[] boxedArray = Arrays.stream(array) // IntStream
//                .boxed()                // Stream<Integer>
//                .toArray(i ->new Integer[i]);
//
//        List<Integer> list = new ArrayList<Integer>(Arrays.asList(boxedArray));
//
//        list.stream().forEach( );

        for(int i=0; i<array.length; i++) {
            for(int j=i+1; j<array.length; j++) {
                if(array[j] < array[i]) {
                   swap(array,i,j);
                }
            }
        }

        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

//    List<Integer> swap(List<Integer> array, int i, int j) {
//        Integer tmp = array.get(j);
//        array.set(j,array.get(i));
//        array.set(i,tmp);
//
//        return array;
//    }

    public static void print(int[] array) {
        for(int i: array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 2, 9, 5, 6, 3};
        BubbleSort test = new BubbleSort();

        print(test.bubbleSort(array));

    }
}
