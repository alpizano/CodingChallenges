import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static String addToGivenSum(int[] array, int target) {
        int[] answer = new int[0];
        // Key = num, Value = index. Problem is easier if number is set as Key
        Map<Integer, Integer> map = new HashMap<>();

        // Put nums in array into set
        for(int i=0; i<array.length; i++) {
            map.put(array[i],i);
        }

        for(Map.Entry entry : map.entrySet()) {
            int complement = target - (int)entry.getKey();
            // Need to get index of number, so need to have number as Key
            if(map.containsKey(complement) && (int)entry.getValue() != map.get(complement)) {
                answer = new int[2];
                answer[0] = (int)entry.getValue();
                answer[1] = map.get(complement);
                break;
            }
        }

        // Need to convert int[] array to String[] array using Java 8
        String[] strArrayAnswer = Arrays.stream(answer).mapToObj(String::valueOf).toArray(String[]::new);
        // Then join String[] array on delimeter (space) to form String
        String strAnswer = String.join(" ", strArrayAnswer);

        // Ternary operator
        return answer.length > 0 ? strAnswer : new String("");
    }
    public static void main(String[] args) {
        int[] array = new int[]{-12, 5, 4, 13};

        System.out.println(TwoSum.addToGivenSum(array,1));
    }
}

