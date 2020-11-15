import java.util.ArrayList;
import java.util.List;

public class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        List<List<Integer>> numsList = new ArrayList<>();

        for(int i=0; i< nums.length; i++) {
            List<Integer> divisorsList = new ArrayList<>();
            int divisor =1;

            while(divisor <= nums[i]) {

                if(nums[i] % divisor == 0) {
                    divisorsList.add(divisor);
                }
                divisor++;
            }
            numsList.add(divisorsList);
        }

        int index = 0;
        int sum = 0;
        while(index < numsList.size()) {
            if(numsList.get(index).size() == 4) {
                for(int j=0; j< numsList.get(index).size(); j++) {
                    sum = sum + numsList.get(index).get(j);
                }
            }
            index++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {21,4,7};
        FourDivisors test = new FourDivisors();
        System.out.println(test.sumFourDivisors(nums));
    }
}
