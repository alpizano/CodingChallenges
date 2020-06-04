import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Scratch {
    public static void main(String[] args) {
        String test = "HelloWorld";
        Hashtable<List<String>,Integer> table = new Hashtable<>();
        List<String> strList = new ArrayList<>();
        List<String> strList2 = new ArrayList<>();
        List<String> control = new ArrayList<>();

        if(test.contains("h"))  {
            System.out.println("Yes it does");
        }

        String test2 = "ab";

        System.out.println(test2.contains("ba"));
        strList.add("A");
        strList.add("B");

        strList2.add("B");
        strList2.add("A");

        control.add("A");
        control.add("B");

        System.out.println(strList);
        System.out.println(strList.equals(strList2));

        // ignores order of list
        System.out.println(strList.containsAll(strList2));

        table.put(strList,1);
        table.put(control, 1);
       // table.put(strList2,1);

        System.out.println("Checking if table contains list (irrelevant order):");
        // see if Hashtable contains ("B", "A")
        System.out.println(table.contains(strList2));
        System.out.println(table.contains(control));
        // Seeing if Hashtable contains [A,B] list, which it does
        System.out.println(table.containsKey(control));
        // Seeing if Hashtable contains [B,A] list, which is doesn't , but we want it to ignore order
        System.out.println(table.containsKey(strList2));

    }
}
