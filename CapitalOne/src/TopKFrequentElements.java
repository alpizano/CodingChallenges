import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        int index = 0;
        while(k > 0) {
            int max = Collections.max(map.values());
            for(Map.Entry<Integer,Integer> entryPair : map.entrySet()) {
                if(max == entryPair.getValue()) {
                   answer[index] = entryPair.getKey();
                    index++;
                    map.remove(entryPair.getKey());
                    break;
                }
            }
            k--;
        }

        return answer;
    }
    public static void main(String[] args) {
        TopKFrequentElements test = new TopKFrequentElements();
        int[] answer = test.topKFrequent(new int[]{1,1,1,2,2,3},2);
        for(Integer i: answer) {
            System.out.print(i + " ");
        }
        //test.topKFrequent(new int[]{1},1);

    }
}
