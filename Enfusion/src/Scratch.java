import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Scratch {
    public static void main(String[] args) {
        String test = "HelloWorld";
        Hashtable<List<String>,Integer> table = new Hashtable<>();
        List<String> strList = new ArrayList<>();
        List<String> strList2 = new ArrayList<>();
        List<String> control = new ArrayList<>();
        List<String> testSort = new ArrayList<>();

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

        testSort.add("C");
        testSort.add("B");
        testSort.add("A");

        System.out.println(strList);
        System.out.println(strList.equals(strList2));

        System.out.println(strList.containsAll(strList2));

        table.put(strList,1);
        //table.put(control, 1);
       // table.put(strList2,1);

        System.out.println("Checking if table contains list (irrelevant order):");
        System.out.println("If table with List ('A','B') contains ('B','A') should be false");
        System.out.println(table.contains(strList2));
        System.out.println("If table with List ('A','B') contains different object ('A','B') should be false");
        System.out.println(table.contains(control));
        System.out.println("If table with List ('A','B') contains same object ('A','B') should be true");
        System.out.println(table.contains(strList));
        System.out.println("If table contains the same List with the same contents (Different object)");
        System.out.println(table.containsKey(strList));
        System.out.println("If table contains a different List with the same contents (Different object)");
        System.out.println(table.containsKey(control));
        System.out.println("If table contains a different List with different contents (Different object)");
        System.out.println(table.containsKey(strList2));
        //System.out.println(table.containsKey(new ArrayList<String>("A","B")));


        System.out.println(testSort);
        Collections.sort(testSort);

        System.out.println(testSort);

    }
}
