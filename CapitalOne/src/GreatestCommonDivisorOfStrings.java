import static java.lang.Math.abs;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int gcd = findGcd(str1.length()-str2.length(), str2.length());

        System.out.println("GCD: " + gcd);

        if(str1.length() > str2.length()) {
            return joiner(str1, str2, gcd);
        }
        else {
            return joiner(str2, str1, gcd);
        }

    }
    public String joiner(String s1, String s2, int gcd) {
        String concat = "";
        String answer ="";

        for(int i=0; i<s1.length(); i = i+gcd) {
            concat = concat + s2.substring(0,gcd);
        }

        if(concat.equals(s1) && concat.substring(0,s2.length()).equals(s2)) {
            answer = concat.substring(0,gcd);
        }

        return answer;

    }

    public int findGcd(int a, int b) {

        if(b == 0) {
            return a;
        }

        return findGcd(b, b % a);

        //return abs(findGcd(b % a, a));
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings test = new GreatestCommonDivisorOfStrings();
        System.out.println(test.gcdOfStrings("ABCABC","ABC"));
        System.out.println(test.gcdOfStrings("ABABAB","ABAB"));
        System.out.println(test.gcdOfStrings("LEET","CODE"));
        System.out.println(test.gcdOfStrings("ABCDEF","ABC"));
        System.out.println(test.gcdOfStrings("ABC","ABCDEF"));

    }
}
