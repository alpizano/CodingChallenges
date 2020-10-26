import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> strList = new ArrayList<>();

        // if nums length is 0, return empty List
        if (nums.length == 0) {
            return new ArrayList();
        }
        // if nums length is 1, return same List back but as string
        else if (nums.length == 1) {
            strList.add(String.valueOf(nums[0]));
            return strList;
        } else {
            List<Integer> container = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                    container.add(nums[i]);
                    // container.add(nums[i+1]);
                } else {
                    container.add(nums[i]);
                    String start = String.valueOf(container.get(0));
                    String end = String.valueOf(container.get(container.size() - 1));
                    if (!start.equals(end)) {
                        strList.add(start + "->" + end);

                    } else {
                        strList.add(start);
                    }
                    container.clear();
                    // strList.add(String.valueOf(nums[i]));
                }
            }

        }

        return strList;

    }

    public void convertToList(int[] nums) {

    }

    public static void main(String[] args) {
        // Mutable
        List<String> strList = new ArrayList<>(Arrays.asList("1", "2", "3"));
        strList.add("4");

        // Immutable
        List<String> strList2 = Arrays.asList("1", "2", "3");
        // Won't work; fixed size array list
//        strList2.add("5");

        SummaryRanges test = new SummaryRanges();
//        System.out.println(test.summaryRanges(new int[0]));
//        System.out.println(test.summaryRanges(new int[]{0}));

        System.out.println(test.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));

        System.out.println(strList);
    }
}
