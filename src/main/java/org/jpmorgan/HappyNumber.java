import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyNumber {
    Map<Integer, Integer> map = new HashMap<>();

    public boolean isHappy(int n) {
        map.put(n, 1);
        // getSum on 19 = 82
        n = getSum(n);

        if (n == 1) {
            return true;
        } else if (map.containsKey(n)) {
            return false;
        } else {
            return isHappy(n);
        }
    }

    // Calculates power of 2 sum
    public int getSum(int n) {
        int sum = 0;

        while (n > 0) {
            int val = n % 10;

            // move decimal to left
            n = n / 10;
            sum = sum + (int) Math.pow(val, 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happy = new HappyNumber();

        System.out.println(happy.isHappy(19));
    }
}
