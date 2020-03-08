import java.util.Hashtable;

public class SubstringCalculator {

    public static int substringCalculator(String s ) {

        Hashtable<String, Integer> table = new Hashtable<>();

        int ptr1 = 0;
        int uniqueCount = 0;
        String memory = "";

        for(int i=0; i<s.length(); i++) {

            if (!table.contains(Character.toString(s.charAt(i)))) {

            table.put(Character.toString(s.charAt(ptr1)),1);

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
