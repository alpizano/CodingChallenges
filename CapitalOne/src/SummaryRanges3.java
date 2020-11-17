import java.util.ArrayList;
import java.util.List;

public class SummaryRanges3 {
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>(nums.length);

        if(nums.length == 0) {
            return new ArrayList<>();
        }

        String range = "";
        for(int i=0, j=0; j<nums.length; ++j) {
            if(j+1 < nums.length && nums[j+1] - nums[j] == 1) {
                continue;
            }
            else if(i == j) {
                answer.add(nums[i] + "");
            }
            else{
                answer.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return answer;
    }

    public void print(List<String> nums) {
        for(int i=0; i<nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        SummaryRanges3 test = new SummaryRanges3();

        test.print(test.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
