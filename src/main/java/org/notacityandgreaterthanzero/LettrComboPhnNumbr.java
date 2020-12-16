import java.util.*;

public class LettrComboPhnNumbr {


        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            Map<Integer,String> mapping = new HashMap<Integer,String>() {{
                put(2,"abc");
                put(3,"def");
                put(4,"ghi");
                put(5,"jkl");
                put(6,"mno");
                put(7,"pqrs");
                put(8,"tuv");
                put(9,"wxyz");
            }};


        letterCombinations(result, digits, "" ,0, mapping);


        return result;
    }

    public void letterCombinations(List<String> result, String digits, String current, int index, Map<Integer,String> mapping) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = mapping.get(digits.charAt(index)- '0');
        for(int i=0; i < letters.length(); i++) {
            letterCombinations(result, digits, current + letters.charAt(i), index + 1, mapping);
        }

    }

    public static void main(String[] args) {
        LettrComboPhnNumbr test = new LettrComboPhnNumbr();
        test.letterCombinations("23");
        String str = "";
        if(str.isEmpty()) System.out.println("Its empty");

    }
}
