import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CustomArray {
    public static int moves(List<Integer> arr) {
        int evenCount = arr.stream().filter(i -> i % 2 == 0).mapToInt(i -> 1).sum();
        return (int)IntStream.range(0,evenCount-1).map(i -> arr.get(i)).filter(i -> i % 2 != 0).count();
    }

    public List<Integer> swap(List<Integer> list, int i, int j) {
        int temp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, temp);
        return list;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(8,5,11,4,6));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,13,10,21,20));


        CustomArray test = new CustomArray();
        //test.swap(list, 0, 4);

        System.out.println(moves(list2));
    }
}
