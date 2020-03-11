import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class SubstringCalculator {

    public static int substringCalculator(String s ) {

        Hashtable<List<String>, Integer> table = new Hashtable<>();
        List<String> list = new ArrayList<String>();

        int ptr1 = 0;
        int uniqueCount = 0;
        String memory = "";

        // String s =  "abcdef"
        // iterate through a, then ab , abc

        for(int i=0; i<s.length(); i++) {
            // add char to List, so becomes ("A"), then ("A","B")
            list.add(Character.toString(s.charAt(i)));
            // sort before inserting into hash table
            Collections.sort(list);
            table.put(list, 1);

            for(int k=1; k<s.length(); k++) {
                if (!table.contains(Character.toString(s.charAt(i)))) {

                    //table.put(Character.toString(s.charAt(ptr1)),1);
            }




            }
        }

        return 0;
    }

    // constrains
    // String s consists of chars in the range ascii[a-z]
    // 0 <= |s| <= 10^5
    public static void main(String[] args) {
        String s = "abcde";

        SubstringCalculator.substringCalculator(s);
    }
}
