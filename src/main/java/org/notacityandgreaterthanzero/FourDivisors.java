import java.util.ArrayList;
import java.util.List;

public class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        int divisorSum = 0;
        int divisorCount = 0;

        for(int i=0; i< nums.length; i++) {
            List<Integer> divisorsList = new ArrayList<>();
            int divisor =1;

            while(divisor <= Math.sqrt(nums[i])) {

                if(nums[i] % divisor == 0) {
                    divisorSum = divisorSum + divisor;
                    System.out.println("divisor sum is: " + divisorSum);
                    divisorCount++;
                    if(nums[i] / divisor != divisor) {
                        divisorSum = divisorSum + (nums[i]/divisor);
                        divisorCount++;

                    }
                }
                if(divisorCount > 4) {
                    break;
                }

                divisor++;
            }
            if(divisorCount == 4) {
                numsList.add(divisorSum);
            }
            divisorCount = 0;
            divisorSum = 0;
        }

        int sum = 0;

        for(int i=0; i < numsList.size(); i++) {
            sum = sum + numsList.get(i);
        }

        System.out.println(numsList);
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {21,4,7};
        FourDivisors test = new FourDivisors();
        System.out.println(test.sumFourDivisors(nums));
    }
}
