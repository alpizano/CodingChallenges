import java.util.ArrayList;
import java.util.List;

public class SummaryRangesSolution1 {

    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; ++j) {
            // check if j + 1 extends the range [nums[i], nums[j]]
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            // put the range [nums[i], nums[j]] into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return summary;
    }

    public static void main(String[] args) {
        SummaryRangesSolution1 test = new SummaryRangesSolution1();
        System.out.println(test.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }
}

