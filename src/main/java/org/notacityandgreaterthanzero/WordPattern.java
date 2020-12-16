import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        boolean match = true;

        Map<String, String> map = new HashMap<>();
        String[] strArray = s.split(" ");

        if(pattern.length() != strArray.length) {
            return false;
        }

        for(int i=0, j=0; j<strArray.length; j++) {
            if(!map.containsKey(String.valueOf(pattern.charAt(i))) && !map.containsValue(strArray[j])) {
                map.put(String.valueOf(pattern.charAt(i)), strArray[j]);
            }
            else if(!map.containsKey(String.valueOf(pattern.charAt(i))) && map.containsValue(strArray[j])) {
                match = false;
            }
            else {
                String mappedValue = map.get(String.valueOf(pattern.charAt(i)));
                if(!strArray[j].equals(mappedValue)) {
                    match = false;
                }
            }
            i++;
        }


        return match;
    }
    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        test.wordPattern("abba", "dog cat cat dog");

        System.out.println(test.wordPattern("abba", "dog cat cat dog"));
        System.out.println(test.wordPattern("abba", "dog cat cat fish"));
        System.out.println(test.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(test.wordPattern("abba", "dog dog dog dog"));


    }
}
