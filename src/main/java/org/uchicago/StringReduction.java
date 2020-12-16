import java.util.*;

public class StringReduction {

    public int stringReduction(String s) {
        StringBuilder sb = new StringBuilder(s);
        Map<Character,String> referenceMap = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        referenceMap.put('a',"");
        referenceMap.put('b',"");
        referenceMap.put('c',"");

        if(s.length() == 0 | s.length() == 1) {
            return s.length();
        }
        int threshold = 0;
        int i=0;

        while(i < sb.length()) {
            if(!set.contains(sb.charAt(i))) {
                set.add(sb.charAt(i));
            }
           else{
                threshold++;
            }

            // we got 2 unique values
            if (set.size() == 2) {
                Map<Character,String> temp = new HashMap<>(referenceMap);
                temp.keySet().removeAll(set);

                while (i >= threshold) {
                    sb.deleteCharAt(i);
                    i--;
                }

               sb.insert(threshold,temp.keySet().toArray()[0]);
               set.clear();
                i = 0;
                threshold = 0;
                continue;
            }

                i++;
        }

        return sb.length();
    }


    public static void main(String[] args) {
        StringReduction test = new StringReduction();

        System.out.println(test.stringReduction("aba")); // aba -> ca -> b
        // Test case 0
        System.out.println(test.stringReduction("cab")); // cab -> cc or cab -> bb
        System.out.println( test.stringReduction("bcab")); // bcab -> aab -> ac -> b
        System.out.println(test.stringReduction("ccccc"));
        System.out.println("----------------------");
        // Test case 1, 2 - 10
        System.out.println("1. "+ test.stringReduction("babcbbaabcbcbcbaabbccaacccbbbcaaacabbbbaaaccbcccacbbccaccbbaacaccbabcaaaacaccacbaacc"));
        System.out.println("2. "+ test.stringReduction("accbaacabbbaacabcbcaccaabcbccbacbcbaabacacababcaacbcccbaccacaabcbaaccbcabccbccbcbbcba"));
        System.out.println("3. "+ test.stringReduction( "ccaacbabbccbcca"));
        System.out.println("4. "+ test.stringReduction("cbcbabccaaaacbbbcccbbb"));
        System.out.println("5. "+ test.stringReduction("aaacacaacccbcbacccbacacbaabcc"));
        System.out.println("6. "+ test.stringReduction("acabcbbcbabbabcacbaaccb"));
        System.out.println("7. "+ test.stringReduction("ccaacaaccabccacabbcbabccbaabacbcccabcaaabaabaccbbaaccacaababbcbacbbcccaccababbccbac"));
        System.out.println("8. "+ test.stringReduction("accbacbbcccccaccaababcbccacabbbcbbbcbcbbcaabbbccbaaabbaaaaabcabbcaabacacaaccbbbaccbaacbbcaaba"));
        System.out.println("9. "+ test.stringReduction("aaccbccbccabbcc"));
        System.out.println("10. "+ test.stringReduction("acccabcccbcaaacbacbcbabbccacb"));
        System.out.println("----------------------");
        // Test case 1, 11 - 20
        System.out.println("11. " + test.stringReduction("ccaabacaacccaaaacaaaacacaabbcccaccbbaaabcababcbaacbbbcbabccaacbaccccaabbbbbcaabbcabcacabcccab"));
        System.out.println("12. " +test.stringReduction("aabaaabc"));
        System.out.println("13. " +test.stringReduction("caacbbaabbbbcbbbbbabaccbcaccbcbbabccacc"));
        System.out.println("14. " +test.stringReduction("bbbbaacbcbaaaabaabcaaacbab"));
        System.out.println("15. " +test.stringReduction("acbcbacaacaccbacabbacabcbccacbbaacacaccaccaccacccbabcbcabcabaccbcaacaaabaabcbacacacbcbcbaaabaccaaaac"));
        System.out.println("16. " +test.stringReduction("baccbcabacbbccaabcbaacaaabbacacbbcaacbbcbaaaacaabcabcbbccaacbaaaabaaacacaccabbbaabcacbacabcbbcccb"));
        System.out.println("17. " +test.stringReduction("abcbaaaaccbaccccacbabbbaabaabbbcabababbcbaacaabbaabbcbaaabbbaaabcacacccbaaab"));
        System.out.println("18. " +test.stringReduction("ccbacacabaaaacbaacaacabcaaabbbcacabbbcbaccaacbbcbccbabbabcccbbbaccbbbaccacccbbbabcccaacaa"));
        System.out.println("19. " + test.stringReduction("acbbccccbacacbcaabbcbccbcccaaaabccaabcccbccbacbcaacc"));
        System.out.println("20. " + test.stringReduction("bbabbaccbbcabaccccaccbbcbabbabcbaaccbbcc"));




    }
}
