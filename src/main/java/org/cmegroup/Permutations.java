import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();

        String test = "abc";
        String test2 = "bac ";
        String test3 = "Bac";
        String test4 = "abcd";

        // Sanitize input
        test.trim();
        test2.trim();


        if(test.length() != test2.length()) {
            System.out.println("Not permutation");
        }
        for(int i=0; i<test.length(); i++) {
            set.add(test.charAt(i));
            set2.add(test2.charAt(i));
            set3.add(test3.charAt(i));
        }

        System.out.println(set.equals(set2));
        System.out.println(set.containsAll(set2));
        System.out.println(set.equals(set3));
        System.out.println(set.containsAll(set3));
        System.out.println(set2.equals(set3));
        System.out.println(set2.containsAll(set3));




    }
}
