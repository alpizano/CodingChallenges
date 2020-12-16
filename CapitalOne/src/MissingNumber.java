import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        if(nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        else if(nums[0] != 0) {
            return 0;
        }
        else {
            for(int i=0 ; i<nums.length; i++) {
                if(nums[i] + 1 !=  nums[i+1]) {
                    return nums[i] +1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MissingNumber test = new MissingNumber();
        test.missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
       // [0 1 3]
        System.out.println();
    }
}
