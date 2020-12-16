import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class SubstringCalculator {

    public static int substringCalculator(String s ) {

        Hashtable<List<String>, Integer> table = new Hashtable<>();
        List<String> list = new ArrayList<String>();


        // String s =  "abcdef"
        // iterate through a, then ab , abc

        for(int i=0; i<s.length(); i++) {
            // add char to List, so becomes ("A"), then ("A","B")
            list.add(Character.toString(s.charAt(i)));
            // sort before inserting into hash table
            Collections.sort(list);

            if(!table.containsKey(list)) {
                table.put(list, 1);
                System.out.println("adding to hashtable: " + list);
            }
            for(int k=i+1; k<s.length(); k++) {
                list.add(Character.toString(s.charAt(k)));
                Collections.sort(list);
                if (!table.containsKey(list)) {
                    table.put(list, 1);
                    System.out.println("adding to hashtable: " + list);

                }
            }
            list.clear();

        }

        return table.size();
    }

    // constrains
    // String s consists of chars in the range ascii[a-z]
    // 0 <= |s| <= 10^5
    public static void main(String[] args) {
        String s = "abcde";

        SubstringCalculator.substringCalculator(s);
        System.out.println(SubstringCalculator.substringCalculator(s));
    }
}
