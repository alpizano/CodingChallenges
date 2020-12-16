import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombosPhone {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        Map<String,String> map = new HashMap<String,String>() {{
            put("2","abc");
            put("3","def");
            put("4","ghi");
            put("5","jkl");
            put("6","mno");
            put("7","pqrs");
            put("8","tuv");
            put("9","wxyz");
        }};

        letterCombinations(digits,"",0, answer, map);
        return answer;
    }

    public void letterCombinations(String digits, String combo, int index, List<String> answer, Map<String,String> map) {
        if(index == digits.length()) {
            // causes StringIndexOutOfBoundsException for some input cases
        //if(combo.length() == 2) {
            answer.add(combo);
            return;
        }

        String letters = map.get(digits.charAt(index) + "");

        for(int i=0; i<letters.length(); i++) {
            letterCombinations(digits, combo + letters.charAt(i), index + 1, answer, map);
        }
    }


    public static void main(String[] args) {
        LetterCombosPhone test = new LetterCombosPhone();
        test.letterCombinations("23");
        String empty = "";
        String empty2 = null;
        System.out.println(empty2 == null);
    }
}
