import com.sun.org.apache.xpath.internal.operations.Plus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int add = 1;

        int[] overflow = new int[digits.length+1];
        overflow[0] = 1;

        int i = digits.length-1;

        while(i >= 0) {
            if(digits[i] != 9) {
                digits[i] = digits[i] + add + carry;
                add = 0;
                carry = 0;
            }
            else if(digits[i] == 9) {
                int temp = digits[i] + add + carry;
                digits[i] = temp%10;
                add = 0;
                carry = temp/10;
            }
            i--;
        }

        if(carry == 1) {
            for(int j=1; j<overflow.length; j++) {
                overflow[j] = digits[j-1];
                return overflow;
            }
        }

        return digits;
    }

    public void print(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        list.add(0,69);
        System.out.println(list );

        int[] nums  = {9,8,7,6,5,4,3,2,1,0};
        int add = 0;
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] = nums[i] + 0);
        }
        int carry = 0;
        int index = nums.length-1;
        nums[8] = nums[8] + 1;
        nums[7] = nums[7] + carry;
        System.out.println();
        System.out.println(nums[8]);
        System.out.println(nums[7]);

        PlusOne test = new PlusOne();
        test.print(test.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0}));
    }
}
