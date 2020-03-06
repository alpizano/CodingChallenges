import java.util.Hashtable;

public class SubstringCalculator {

    public static int substringCalculator(String s ) {

        Hashtable<String, Integer> table = new Hashtable<>();

        int ptr1 = 0;
        int uniqueCount = 0;
        String memory = "";

        for(int i=0; i<s.length(); i++) {
            if (!memory.contains(Character.toString(s.charAt(ptr1)))) {
                uniqueCount++;
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
